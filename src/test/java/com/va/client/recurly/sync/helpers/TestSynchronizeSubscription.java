package com.va.client.recurly.sync.helpers;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.ejb.CreateException;
import javax.naming.NamingException;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import com.ning.billing.recurly.RecurlyClient;
import com.ning.billing.recurly.model.Subscription;
import com.va.core.VAException;
import com.va.data.AccountInfo;
import com.va.data.AddressInfo;
import com.va.recurly.utils.VARecurlyConfig;
import com.va.reusable.db.DbUtil;
import com.va.session.BizManager;
import com.va.session.BizManagerUtil;

public class TestSynchronizeSubscription {
	static BizManager bizManager;
	static RecurlyClient client;
	
	static com.ning.billing.recurly.model.Account accountR;
	static com.ning.billing.recurly.model.Address addressR; 
	static com.ning.billing.recurly.model.Subscriptions  subs;
	static com.ning.billing.recurly.model.Subscription  sub;
	
	static Connection dbConn;
	static String memberId;
	
	@BeforeClass
	public static void oneTimeSetup() throws RemoteException, NamingException, CreateException, SQLException, VAException{
		
			memberId="TES1312835"; //make sure memberId have
	        bizManager = BizManagerUtil.createBizManager();	        
			
			//String partnerPlanCode=vaSubs.getPartnerCode()+"-"+vaSubs.getPrimaryPlanCode();
			VARecurlyConfig config = new VARecurlyConfig();
				
			client = new RecurlyClient(config.getApiKey(), config.getSubDomain());
			client.open();
	
			
			accountR = client.getAccount(memberId);
			
			addressR = accountR.getAddress();			
			subs = client.getAccountSubscriptions(memberId, "active");				
			sub = subs.get(0);
			
			//create account in db
			AccountInfo account = new AccountInfo();			
			account._memberID = accountR.getAccountCode();
			String acctState = (sub.getState().equals("active")?"Current":"Expired");
			
			account._status = acctState;
			account._name = accountR.getFirstName();
			account._lastName = accountR.getLastName();
			account._email = accountR.getEmail();
			account._branch = accountR.getCompanyName();
			
			account._currentRegStart = jodaToSQLDate(sub.getCurrentPeriodStartedAt());
			account._currentRegEnd = jodaToSQLDate(sub.getCurrentPeriodEndsAt());
			
		
			AddressInfo address = new AddressInfo();
			address._street =addressR.getAddress1();
			address._street2 = addressR.getAddress2();
			address._city = addressR.getCity();
			address._state = addressR.getState();
			address._postal = addressR.getZip();
			address._country = addressR.getCountry();
			address._homephone = addressR.getPhone();			
			
			bizManager.createAccount(account, address);
		
			dbConn = DbUtil.getTempConnection("VAData", "root", "rootpass");
	}
	
	@Test
	public void testIsSubscriptChanged() throws RemoteException, VAException{
		
		AccountInfo account = bizManager.viewAccount(memberId);

		boolean isChanged=SynchronizeSubscription.isChanged(account, sub);		
		Assert.assertFalse(isChanged);

		account._currentRegStart =java.sql.Date.valueOf( "2010-01-01");		
		isChanged=SynchronizeSubscription.isChanged(account, sub);		
		Assert.assertTrue(isChanged);

	}

		
	//the 0 index entry is the latest subscription
	@Test
	public void testSubscriptionFetchOrder() throws RemoteException, VAException {
		
		
		System.out.println(subs.size());
		Assert.assertTrue(subs.size()==2);
		
		//
		Subscription sub = subs.get(0);	
		Assert.assertTrue(sub.getPlan().getPlanCode().equalsIgnoreCase("5-year-member-full-renew"));
		
		//
		sub = subs.get(subs.size()-1);	
		Assert.assertTrue(sub.getPlan().getPlanCode().equalsIgnoreCase("1-year-primary-96"));
		
	}
	
	

	@AfterClass
	public static void oneTimeTearDown() throws SQLException, RemoteException, VAException{
		System.out.println("@AfterClass - oneTimeTearDown");
		bizManager.destroyAccountByMemberId(memberId);
		
			
		client.close();
		dbConn.close();
		
	}
	
	@Before
	public void setup() throws RemoteException, VAException{
		System.out.println("@Before - setUp");		
	}
	
	@After
	public void tearDown() throws SQLException, RemoteException, VAException{
		System.out.println("@After - tearDown");
		
	}
	
	 public static java.sql.Date jodaToSQLDate(org.joda.time.DateTime dateTime) {	
		    return new java.sql.Date(dateTime.getMillis());
     }
		 


}
