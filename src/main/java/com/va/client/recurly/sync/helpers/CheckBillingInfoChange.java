package com.va.client.recurly.sync.helpers;

import java.rmi.RemoteException;

import com.ning.billing.recurly.RecurlyClient;
import com.va.core.VAException;
import com.va.data.AccountInfo;
import com.va.data.AddressInfo;
import com.va.data.CreditCardInfo;
import com.va.session.BizManager;

public class CheckBillingInfoChange {
	
	public static boolean checkBillingInfoChange(String memberId, BizManager bizManager, RecurlyClient client) throws VAException, RemoteException{
		boolean isChanged=false;
		com.ning.billing.recurly.model.BillingInfo billingR = client.getBillingInfo(memberId);
		if(billingR==null){
			throw new VAException("Billing Info for "+memberId+" does not exist in Recurly");
		}		
	
		AccountInfo accountInfo = bizManager.viewAccount(memberId);
		CreditCardInfo ccInfo = bizManager.viewCreditCard(memberId);
		
		String fullNameR = billingR.getFirstName()+" "+billingR.getLastName();
		if(
		
			!ccInfo._name.equalsIgnoreCase(fullNameR) ||
			!ccInfo.get_cardNumber().equalsIgnoreCase(billingR.getNumber()) ||
			 ccInfo.get_expMonth()!=(billingR.getMonth()) ||
			 ccInfo.get_expYear()!=(billingR.getYear()) ||
			 ccInfo.get_street().equalsIgnoreCase(billingR.getAddress1()) ||
			 ccInfo.get_street2().equalsIgnoreCase(billingR.getAddress2()) ||
			 ccInfo.get_city().equalsIgnoreCase(billingR.getCity()) ||
			 ccInfo.get_state().equalsIgnoreCase(billingR.getState()) ||
			 ccInfo.get_zipcode().equalsIgnoreCase(billingR.getZip()) 
		
		){isChanged=true;}
		
		
		return isChanged;
	}

}
