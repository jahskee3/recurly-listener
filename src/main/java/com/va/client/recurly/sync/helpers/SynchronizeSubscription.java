package com.va.client.recurly.sync.helpers;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;

import com.ning.billing.recurly.RecurlyClient;
import com.ning.billing.recurly.model.Subscription;
import com.va.core.VAException;
import com.va.data.Account;
import com.va.data.AccountInfo;
import com.va.session.BizManager;

public class SynchronizeSubscription {
	
	public static void synchronizeSubscription(String memberId, BizManager bizManager, RecurlyClient client) throws VAException, RemoteException{
		
		//1. get values in recurly and compare it to values in db
		com.ning.billing.recurly.model.Subscriptions subRs = client.getAccountSubscriptions(memberId, "active");
     	if(null!=subRs){
     		//active subscription found
     		
     	}else{
     		//active subscription found check difference in db if difference is true update/synchronize
     		
     		//get the first active subscription it is the latest
     		Subscription subR = subRs.get(0);
     		//now check data from database
     		AccountInfo account = bizManager.viewAccount(memberId);
     		
     		//check for difference in status, regStart and regEnd
     		if(isChanged(account, subR)){
     			//update data in account and create new order
     			account._status = (subR.getState().equals("active")?"Current":account._status);   
     			account._currentRegStart = jodaToSQLDate(subR.getCurrentPeriodStartedAt());
     			account._currentRegEnd = jodaToSQLDate(subR.getCurrentPeriodEndsAt());
     			bizManager.editAccount(memberId,account, null, "Synchorize data with recurly.");
     		}     			
     	}
	}
	
	public static boolean isChanged(AccountInfo account, com.ning.billing.recurly.model.Subscription subR){
		boolean isChanged=true;
		
		boolean isStatusEqual =  subR.getState().equalsIgnoreCase("active")	&& account.get_status().equalsIgnoreCase(Account.STATUS_CURRENT);
		
		SimpleDateFormat df =  new SimpleDateFormat("yyyy-MM-dd");		
	 		
 		String dateStart1 = df.format(jodaToSQLDate(subR.getCurrentPeriodStartedAt()));
 		String dateStart2 = df.format(account._currentRegStart);		
 		boolean isRegStartEqual = dateStart1.equals(dateStart2);

 				
 		String dateEnd1 = df.format(jodaToSQLDate(subR.getCurrentPeriodEndsAt()));
 		String dateEnd2 = df.format(account._currentRegEnd);		
 		boolean isRegEndEqual = dateEnd1.equals(dateEnd2); 		
 				
 		if(isStatusEqual && isRegStartEqual && isRegEndEqual){
 			isChanged = false;
 		}
 		
 		return isChanged;
	}
	
	 public static java.sql.Date jodaToSQLDate(org.joda.time.DateTime dateTime) {		
		    return new java.sql.Date(dateTime.getMillis());
     }

}
