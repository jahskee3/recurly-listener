package com.va.client.recurly.sync.helpers;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ejb.CreateException;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ning.billing.recurly.RecurlyClient;
import com.va.core.VAException;
import com.va.data.AccountInfo;
import com.va.data.AddressInfo;
import com.va.data.CreditCardInfo;
import com.va.recurly.utils.VARecurlyConfig;
import com.va.reusable.db.DbUtil;
import com.va.session.BizManager;
import com.va.session.BizManagerUtil;

public class CreateNewAccountTest {
	static BizManager bizManager;
	static RecurlyClient client;
	static com.ning.billing.recurly.model.Account accountR;
	static com.ning.billing.recurly.model.Address addressR; 
	static Connection dbConn;
	static String memberId;
	
	@BeforeClass
	public static void oneTimeSetup() throws RemoteException, NamingException, CreateException, SQLException{
		System.out.println("@BeforeClass - oneTimeSetUp");
			
	        bizManager = BizManagerUtil.createBizManager();
	        
			
			//String partnerPlanCode=vaSubs.getPartnerCode()+"-"+vaSubs.getPrimaryPlanCode();
			VARecurlyConfig config = new VARecurlyConfig();
				
			client = new RecurlyClient(config.getApiKey(), config.getSubDomain());
			client.open();
				
			memberId="TES1312835";
			accountR = client.getAccount(memberId);
			addressR = accountR.getAddress();			
						
			dbConn = DbUtil.getTempConnection("VAData", "root", "rootpass");
	}
	
	@Test
	public void testCreateNewAccount() throws RemoteException, VAException {
		
		CreateNewAccount.createNewAccount(memberId, bizManager, client);
		AccountInfo account = bizManager.viewAccount(memberId);
		assertEquals(account._name,"test1");
		assertEquals(account._lastName,"test2");

		
		AddressInfo addressInfo = bizManager.viewAddress(memberId);
		assertEquals(addressInfo._city, "Mt Pleasant");
	
		CreateNewBillingInfo.createNewBillingInfo(memberId, bizManager, client);
		CreditCardInfo ccInfo = bizManager.viewCreditCard(memberId);
		assertEquals(ccInfo._street,"1061 Johnnie Dodds Blvd, Apt E-8");
		assertEquals("vs",ccInfo._cardType);
	
	}
	

	
	
	
	@AfterClass
	public static void oneTimeTearDown() throws SQLException{
		System.out.println("@AfterClass - oneTimeTearDown");
		
			
		client.close();
		dbConn.close();
		
	}
	
	@Before
	public void setup(){
		
		System.out.println("@Before - setUp");
	}
	
	@After
	public void tearDown() throws SQLException, RemoteException, VAException{
		System.out.println("@After - tearDown");
		bizManager.destroyAccountByMemberId(memberId);
	
		
		
		
	}
	


}
