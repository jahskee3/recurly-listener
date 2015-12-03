package com.va.client.recurly.sync.helpers;

import java.rmi.RemoteException;

import com.ning.billing.recurly.RecurlyClient;
import com.va.core.VAException;
import com.va.data.Account;
import com.va.data.AccountInfo;
import com.va.data.AddressInfo;
import com.va.session.BizManager;

public class CreateNewAccount {
	
	
	public static void createNewAccount(String memberId, BizManager bizManager, RecurlyClient client) throws RemoteException, VAException{
		
		com.ning.billing.recurly.model.Account accountR = client.getAccount(memberId);
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


}
