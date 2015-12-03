package com.va.client.recurly.sync.helpers;

import java.rmi.RemoteException;
import com.ning.billing.recurly.RecurlyClient;

import com.va.core.VAException;
import com.va.data.AccountInfo;
import com.va.data.CreditCardInfo;
import com.va.session.BizManager;

public class CreateNewBillingInfo {
	
	public static void createNewBillingInfo(String memberId, BizManager bizManager, RecurlyClient client) throws RemoteException, VAException{
		
		com.ning.billing.recurly.model.BillingInfo billingR = client.getBillingInfo(memberId);
		System.out.println("Test "+billingR.getAddress1());
		System.out.println("Test "+billingR.getNumber());
		CreditCardInfo ccInfo =null;
		AccountInfo accountInfo = null;
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


}
