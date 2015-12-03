package com.va.client.recurly.sync.helpers;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.CreateException;
import javax.naming.NamingException;

import com.ning.billing.recurly.RecurlyClient;
import com.va.client.recurly.unmarshall.UnmarshallUtil;
import com.va.core.Configuration;
import com.va.core.VAException;
import com.va.data.AccountInfo;
import com.va.data.CreditCardInfo;
import com.va.recurly.utils.VARecurlyConfig;
import com.va.reusable.db.DbUtil;
import com.va.session.BizManager;
import com.va.session.BizManagerUtil;

public class CreateNewBillingInfo {
	
	
	public static void main(String[] args) throws RemoteException, NamingException, CreateException {
	     BizManager bizManager = BizManagerUtil.createBizManager();
			
		//String partnerPlanCode=vaSubs.getPartnerCode()+"-"+vaSubs.getPrimaryPlanCode();
		VARecurlyConfig config = new VARecurlyConfig();
			
		RecurlyClient recurlyClient = new RecurlyClient(config.getApiKey(), config.getSubDomain());
		recurlyClient.open();
			
		
		
		recurlyClient.close();
			

	}
	
	public static void createNewAccount(String memberId, BizManager bizManager, RecurlyClient client) throws RemoteException, VAException{
		
		com.ning.billing.recurly.model.BillingInfo billingR = client.getBillingInfo(memberId);

		CreditCardInfo ccInfo =null;
		AccountInfo accountInfo = null;
		if(billingR!=null){
			ccInfo = new CreditCardInfo();
			ccInfo._name = billingR.getFirstName()+" "+billingR.getLastName();
			ccInfo._cardNumber = billingR.getNumber();
			ccInfo._cardType = billingR.getCardType();
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


}
