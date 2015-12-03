package com.va.client.recurly.sync;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.naming.NamingException;

import com.ning.billing.recurly.RecurlyClient;
import com.va.core.VAException;
import com.va.recurly.utils.VARecurlyConfig;
import com.va.session.BizManager;
import com.va.session.BizManagerUtil;
import com.va.client.recurly.sync.helpers.*;
import com.va.data.CreditCardInfo;
public class SynchronizeFromRecurly {
	
	public static void main(String[] args) throws RemoteException, NamingException, CreateException{
		
	     BizManager bizManager = BizManagerUtil.createBizManager();
		
		//String partnerPlanCode=vaSubs.getPartnerCode()+"-"+vaSubs.getPrimaryPlanCode();
		VARecurlyConfig config = new VARecurlyConfig();
		
		RecurlyClient recurlyClient = new RecurlyClient(config.getApiKey(), config.getSubDomain());
		recurlyClient.open();
		
		
		recurlyClient.close();
		
		
	}
	
	public static void SynchronizeAll(String memberId, BizManager bizManager, RecurlyClient client) throws RemoteException, VAException{
				
		SynchronizeAccountAddress(memberId, bizManager, client);
		SynchronizeBillingInfo(memberId, bizManager, client);
		
	}
	
	public static void SynchronizeBillingInfo(String memberId, BizManager bizManager, RecurlyClient client) throws RemoteException, VAException{
		com.ning.billing.recurly.model.BillingInfo billingR = client.getBillingInfo(memberId);		
		if(billingR==null){
			throw new VAException("BillingInfo "+memberId+" does not exist in Recurly");
		}
		
		CreditCardInfo ccInfo = bizManager.viewCreditCard(memberId);
		if(ccInfo==null){
			
		}
		
	}

	public static void SynchronizeAccountAddress(String memberId, BizManager bizManager, RecurlyClient client) throws RemoteException, VAException{
		com.ning.billing.recurly.model.Account accountR = client.getAccount(memberId);		
		if(accountR==null){
			throw new VAException("Account "+memberId+" Does not exist in Recurly");
		}else{
			com.ning.billing.recurly.model.Address addressR = accountR.getAddress();
		}
		
		boolean isExist = bizManager.isMemberExist(memberId);
		if(!isExist){
			CreateNewAccount.createNewAccount(memberId, bizManager, client);
		}else{
			boolean isAccountAddressChanged = CheckAccountAddressChange.checkAccountAddressChange(memberId, bizManager, client);
			if(isAccountAddressChanged){
				UpdateAccountAddress.updateAccountAddress(memberId, bizManager, client);
			}
		}
		
	}

}
