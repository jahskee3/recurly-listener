package com.va.client.recurly.handler.action;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.naming.NamingException;
import javax.xml.bind.JAXBException;

import org.jdom2.JDOMException;

import com.ning.billing.recurly.RecurlyClient;
import com.va.client.recurly.events.notifications.NewAccountNotification;
import com.va.client.recurly.unmarshall.UnmarshallUtil;
import com.va.core.VAException;
import com.va.data.Account;
import com.va.data.AccountInfo;
import com.va.data.AddressInfo;
import com.va.recurly.models.AccountR;
import com.va.recurly.models.AddressR;
import com.va.recurly.utils.VARecurlyConfig;
import com.va.session.BizManager;
import com.va.session.BizManagerUtil;

public class NewAccountAction {

	public static void main(String[] args) throws NamingException, CreateException, VAException, JDOMException, IOException, JAXBException {
		BizManager bizManager = BizManagerUtil.createBizManager();
		
		//String partnerPlanCode=vaSubs.getPartnerCode()+"-"+vaSubs.getPrimaryPlanCode();
		VARecurlyConfig config = new VARecurlyConfig();
		
		RecurlyClient recurlyClient = new RecurlyClient(config.getApiKey(), config.getSubDomain());
		recurlyClient.open();
		
		
		String xmlData="<?xml version='1.0' encoding='UTF-8'?> <new_account_notification> <account> <account_code>test112344</account_code> <username>test1</username> <email>test@y.com</email> <first_name>test1</first_name> <last_name>test1</last_name> <company_name>test111</company_name> </account> </new_account_notification>";
		
		NewAccountNotification event = (NewAccountNotification) UnmarshallUtil.getEvent(xmlData);
		NewAccountAction.action(event, xmlData, bizManager, recurlyClient);
	
		

	}
	
	public static void action(NewAccountNotification event, String xmlData, BizManager bizManager, RecurlyClient rclient) throws RemoteException, VAException{
		
		String memberId=event.getAccount().getAccountCode();
		
		System.out.println(memberId);	
		
		Object obj=rclient.getAccount(memberId);
		if(obj==null){
			throw new VAException("Account "+memberId+" Does not exist in Recurly");
		}
		
		com.ning.billing.recurly.model.Account accountR = rclient.getAccount(memberId);
		com.ning.billing.recurly.model.Address addressR = accountR.getAddress();
		
		System.out.println(addressR.getAddress1());
		AccountInfo accountInfo = new AccountInfo();
		
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
		
		AddressInfo addressInfo = new AddressInfo();
		addressInfo._street = addressR.getAddress1();
		addressInfo._street2 = addressR.getAddress2();
		addressInfo._postal = addressR.getZip();
		addressInfo._city = addressR.getCity();
		addressInfo._state = addressR.getState();
		addressInfo._country = addressR.getCountry();
		
		AccountInfo result=null;
		try{
			result=bizManager.viewAccount(accountInfo._memberID);
		}catch(Exception e){/*do nothing */}
		if(result==null){
			//attempt create account
			memberId = bizManager.createAccount(accountInfo, addressInfo);
			System.out.println("Account successfully created");
			//result=bizManager.viewAccount(accountInfo._memberID);
			
			//attempt create address
			
			
		}else{
			System.out.println("Cannot create new account "+memberId+" already exist.");
		}
		
		
		
	}

}
