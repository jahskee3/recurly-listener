package com.va.client.recurly.sync.helpers;

import java.rmi.RemoteException;

import com.ning.billing.recurly.RecurlyClient;
import com.va.core.VAException;
import com.va.data.AccountInfo;
import com.va.data.AddressInfo;
import com.va.session.BizManager;

public class CheckAccountAddressChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean checkAccountAddressChange(String memberId, BizManager bizManager, RecurlyClient client) throws VAException, RemoteException{
		boolean isChanged=false;
		com.ning.billing.recurly.model.Account accountR = client.getAccount(memberId);
		com.ning.billing.recurly.model.Address addressR =null;
		if(accountR==null){
			throw new VAException("Account "+memberId+" Does not exist in Recurly");
		}else{
			addressR= accountR.getAddress();
		}		
	
		AccountInfo accountInfo = bizManager.viewAccount(memberId);
		
		if(!accountInfo._name.equalsIgnoreCase(accountR.getFirstName())){isChanged=true;} 
		if(!accountInfo._lastName.equalsIgnoreCase(accountR.getLastName())){isChanged=true;} 
		if(!accountInfo._email.equalsIgnoreCase(accountR.getEmail())){isChanged=true;}
		
		AddressInfo addressInfo=bizManager.viewAddress(memberId);
		if(addressInfo==null && addressR==null){
			isChanged=false;
		}else{
			
	/*		if(!addressInfo._street.equalsIgnoreCase(addressR.getAddress1())){isChanged=true;} 
			if(!addressInfo._street2.equalsIgnoreCase(addressR.getAddress2())){isChanged=true;} 
			if(!addressInfo._city.equalsIgnoreCase(addressR.getCity())){isChanged=true;}
			if(!addressInfo._state.equalsIgnoreCase(addressR.getState())){isChanged=true;}
			if(!addressInfo._postal.equalsIgnoreCase(addressR.getZip())){isChanged=true;}*/
			isChanged=true;
		}		
		
		return isChanged;
	}	
	
}
