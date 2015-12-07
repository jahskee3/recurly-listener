package com.va.client.recurly.sync;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.ejb.CreateException;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.ning.billing.recurly.RecurlyClient;
import com.ning.billing.recurly.model.Subscription;
import com.va.core.Configuration;
import com.va.core.VAException;
import com.va.data.Account;
import com.va.data.AccountInfo;
import com.va.data.AddressInfo;
import com.va.data.CreditCardInfo;
import com.va.recurly.utils.VARecurlyConfig;
import com.va.reusable.db.DbUtil;
import com.va.session.BizManager;
import com.va.session.BizManagerUtil;

public class SynchronizeAccount {
	
	private static final Logger log = Logger.getLogger(SynchronizeAccount.class);
	
	//this thread checks recurlysync table for accounts to be synchronized with Recurly.
	public static void main(String[] args) throws RemoteException, NamingException, CreateException, VAException, SQLException{
		
	     BizManager bizManager = BizManagerUtil.createBizManager();
		
		//String partnerPlanCode=vaSubs.getPartnerCode()+"-"+vaSubs.getPrimaryPlanCode();
		VARecurlyConfig config = new VARecurlyConfig();
		
		RecurlyClient rClient = new RecurlyClient(config.getApiKey(), config.getSubDomain());
		rClient.open();
		
		Connection dbConn=null;
		PreparedStatement preparedStatement = null;
		try{
			
			dbConn = DbUtil.getTempConnection(Configuration.DB_NAME, Configuration.DB_USER, Configuration.DB_PASSWORD);
			String selectSQL = "SELECT memberid FROM recurlysync where issync=0;";
			preparedStatement = dbConn.prepareStatement(selectSQL);		
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				try{
					String memberId=rs.getString("memberId");
					SynchronizeAccount.synchronizeAccount(bizManager, rClient, memberId);
					
					String sqlUpdate = "update recurlysync set issync=1 where memberId=?;";
					PreparedStatement ps = dbConn.prepareStatement(sqlUpdate);
					ps.setString(1,memberId);
					ps.executeUpdate();
					log.info("Account "+memberId+" synched with recurly");
					
				}catch(Exception e){
					continue;
				}
		
			}
		}catch(Exception e){		
			
			throw new SQLException(e);
		}finally{
			rClient.close();
			if(dbConn!=null){
				dbConn.close();
			}
		}
	}
	
		
	public static void synchronizeAccount(BizManager bizManager, RecurlyClient rClient, String memberId) throws RemoteException, VAException{
		
		com.ning.billing.recurly.model.Account accountR = rClient.getAccount(memberId);
		if(null==accountR){
			throw new VAException("Recurly account for "+memberId+" not found.");
		}
		com.ning.billing.recurly.model.Address addressR = accountR.getAddress();
		if(null==addressR){
			throw new VAException("Recurly address for "+memberId+" not found, please review");
		}
		
		AccountInfo account = bizManager.viewAccount(memberId);
		AddressInfo address=bizManager.viewAddress(memberId);
		//account in recurly exist now compare it with account in database
		if(account==null){
			//create account
			createNewAccount(bizManager, account, accountR);				
			//if billing info exist in recurly create it
			com.ning.billing.recurly.model.BillingInfo billingR = rClient.getBillingInfo(memberId);
			if(billingR!=null){
				createNewBillingInfo(bizManager, account, billingR);	
			}
			
			//refetch account from db after creation
     		account = bizManager.viewAccount(memberId);
     		address = bizManager.viewAddress(memberId);
		}		
		
		//1. if it exist check for changes on firstname,lastname, email
		boolean isAccountChanged = isAccountChanged(account, accountR);
		boolean isAddressChanged = isAddressChanged(address, addressR);
		
		if(isAccountChanged || isAddressChanged){
			account._name = accountR.getFirstName();
			account._lastName = accountR.getLastName();
			account._email = accountR.getEmail();					

			address._street = addressR.getAddress1();
			address._street2 = addressR.getAddress2();
			address._city = addressR.getCity();
			address._postal = addressR.getZip();
			address._state = addressR.getState();
			address._country = addressR.getCountry();
			address._mobilephone = addressR.getPhone();
			
			bizManager.editAccount(memberId, account, address, "Synchronize account and address to Recurly");
		}
			
		
		//3. check if subscription exist,  sync with recurly
		com.ning.billing.recurly.model.Subscriptions subRs = rClient.getAccountSubscriptions(memberId, "active");
		if(subRs!=null){
			if(subRs.size()>1){
     			log.warn("multiple subscriptions found for memberId "+memberId);
     		}
     		Subscription subR = subRs.get(0);
     		//check for difference in status, regStart and regEnd
     	
     		if(isSubscriptionChanged(account, subR)){
     			//update data in account and create new order
     			account._status = (subR.getState().equals("active")?"Current":account._status);   
     			account._currentRegStart = jodaToSQLDate(subR.getCurrentPeriodStartedAt());
     			account._currentRegEnd = jodaToSQLDate(subR.getCurrentPeriodEndsAt());
     			bizManager.editAccount(memberId,account, null, "Synchorize data with recurly.");
     		}     			
		}		
	}	
	
	public static void createNewAccount(BizManager bizManager, AccountInfo account, com.ning.billing.recurly.model.Account accountR) throws RemoteException, VAException{
		String memberId=accountR.getAccountCode();
		com.ning.billing.recurly.model.Address addressR = accountR.getAddress();

		AccountInfo accountInfo = null;
		if(accountR!=null){
			accountInfo=new AccountInfo();
			accountInfo._memberID = accountR.getAccountCode();
			accountInfo._name = accountR.getFirstName();
			accountInfo._lastName = accountR.getLastName();
			accountInfo._initial = "";
			accountInfo._email = accountR.getEmail();
			accountInfo._optin = true;
			accountInfo._partnerCode="about";
			accountInfo._status = Account.STATUS_NEWSLETTER;
			accountInfo._renewalLast=0;
			accountInfo._ipAddress = "";
			accountInfo._ganClickId ="";
		}			
		
		AddressInfo addressInfo=null;
		if(addressR!=null){
			addressInfo = new AddressInfo();
			addressInfo._street = addressR.getAddress1();
			addressInfo._street2 = addressR.getAddress2();
			addressInfo._postal = addressR.getZip();
			addressInfo._city = addressR.getCity();
			addressInfo._state = addressR.getState();
			addressInfo._country = addressR.getCountry();
		}
		
		bizManager.createAccount(accountInfo, addressInfo);
		System.out.println("Account "+memberId+" successfully created");
		
	}

	public static void createNewBillingInfo(BizManager bizManager, AccountInfo account, com.ning.billing.recurly.model.BillingInfo billingR) throws RemoteException, VAException{
		
		String memberId = account._memberID;		

		System.out.println("Test "+billingR.getAddress1());
		System.out.println("Test "+billingR.getNumber());
		CreditCardInfo ccInfo =null;
		
		if(billingR!=null){
			ccInfo = new CreditCardInfo();
			ccInfo._name = billingR.getFirstName()+" "+billingR.getLastName();
			ccInfo._cardNumber = billingR.getNumber();
			ccInfo._cardType = getCardType(billingR.getCardType());
			ccInfo._expMonth = billingR.getMonth();
			ccInfo._expYear = billingR.getYear();
			ccInfo._street = billingR.getAddress1();
			ccInfo._street2 = billingR.getAddress2();
			ccInfo._state = billingR.getState();
			ccInfo._zipcode = billingR.getZip();			
			ccInfo._city = billingR.getCity();
			ccInfo._country = billingR.getCountry();
			ccInfo._billingPhone = billingR.getPhone();
			bizManager.setCreditCard(memberId, ccInfo);
			
			System.out.println("Credit card info for "+memberId+" created");		
		}else{
			throw new VAException("Recurly billing information for "+memberId+" does not exist");
		}
		
		
	}
	
	private static String getCardType(String recurlyCardType){
		String cardType=recurlyCardType;
		if(recurlyCardType.equalsIgnoreCase("visa")){
			cardType="vs";						
		}else if(recurlyCardType.startsWith("master".toLowerCase())){
			cardType="mc";						
		}
		
		return cardType;

	}

	
	public static boolean isAddressChanged(AddressInfo address, com.ning.billing.recurly.model.Address addressR){
		boolean isChanged=false;
		
		boolean isStreet1Changed = !address._street.equalsIgnoreCase(addressR.getAddress1()); 
		boolean isStreet2Changed= !address._street2.equalsIgnoreCase(addressR.getAddress2());
		boolean isCityChanged = !address._city.equalsIgnoreCase(addressR.getCity());		
		boolean isStateChanged = !address._state.equalsIgnoreCase(addressR.getState());
		boolean isPostalChanged = !address._postal.equalsIgnoreCase(addressR.getZip());		
		
		if(isStreet1Changed || isStreet2Changed || isCityChanged || isStateChanged || isPostalChanged){
			isChanged=true;
		}
		return isChanged;
	}
	
	public static boolean isAccountChanged(AccountInfo account, com.ning.billing.recurly.model.Account accountR){
		boolean isChanged=false;

		boolean isFNameChanged=!accountR.getFirstName().trim().equalsIgnoreCase(account._name.trim());
		boolean isLNameChanged=!accountR.getLastName().trim().equalsIgnoreCase(account._lastName.trim());
		boolean isEmailChanged = !accountR.getEmail().trim().equalsIgnoreCase(account._email.trim());
		
		if(isFNameChanged || isLNameChanged || isEmailChanged){
			isChanged=true;
		}
		
		return isChanged;
	}
	
	public static boolean isSubscriptionChanged(AccountInfo account, com.ning.billing.recurly.model.Subscription subR){
		boolean isChanged=false;
		
		boolean isStatusChanged =  !(subR.getState().equalsIgnoreCase("active")	&& account.get_status().equalsIgnoreCase(Account.STATUS_CURRENT));
		
		SimpleDateFormat df =  new SimpleDateFormat("yyyy-MM-dd");		
	 		
 		String dateStart1 = df.format(jodaToSQLDate(subR.getCurrentPeriodStartedAt()));
 		String dateStart2 = df.format(account._currentRegStart);		
 		boolean isRegStartChanged = !dateStart1.equals(dateStart2);

 				
 		String dateEnd1 = df.format(jodaToSQLDate(subR.getCurrentPeriodEndsAt()));
 		String dateEnd2 = df.format(account._currentRegEnd);		
 		boolean isRegEndChanged = !dateEnd1.equals(dateEnd2); 		
 				
 		if(isStatusChanged || isRegStartChanged || isRegEndChanged){
 			isChanged = true;
 		}
 		
 		return isChanged;
	}
	
	 public static java.sql.Date jodaToSQLDate(org.joda.time.DateTime dateTime) {		
		    return new java.sql.Date(dateTime.getMillis());
     }

}
