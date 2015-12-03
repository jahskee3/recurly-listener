package com.va.client.recurly.handler;


import org.apache.log4j.Logger;

import com.ning.billing.recurly.RecurlyClient;
import com.va.client.recurly.events.notifications.BillingInfoUpdatedNotification;
import com.va.client.recurly.events.notifications.CanceledAccountNotification;
import com.va.client.recurly.events.notifications.CanceledSubscriptionNotification;
import com.va.client.recurly.events.notifications.ClosedInvoiceNotification;
import com.va.client.recurly.events.notifications.ExpiredSubscriptionNotification;
import com.va.client.recurly.events.notifications.FailedPaymentNotification;
import com.va.client.recurly.events.notifications.NewAccountNotification;
import com.va.client.recurly.events.notifications.NewInvoiceNotification;
import com.va.client.recurly.events.notifications.NewSubscriptionNotification;
import com.va.client.recurly.events.notifications.PastDueInvoiceNotification;
import com.va.client.recurly.events.notifications.ProcessingInvoiceNotification;
import com.va.client.recurly.events.notifications.ProcessingPaymentNotification;
import com.va.client.recurly.events.notifications.ReactivatedAccountNotification;
import com.va.client.recurly.events.notifications.RenewedSubscriptionNotification;
import com.va.client.recurly.events.notifications.ScheduledPaymentNotification;
import com.va.client.recurly.events.notifications.SuccessfulPaymentNotification;
import com.va.client.recurly.events.notifications.SuccessfulRefundNotification;
import com.va.client.recurly.events.notifications.UpdatedSubscriptionNotification;
import com.va.client.recurly.events.notifications.VoidPaymentNotification;
import com.va.core.VAException;
import com.va.data.Account;
import com.va.data.AccountInfo;
import com.va.data.AddressInfo;
import com.va.recurly.models.AccountR;
import com.va.recurly.models.AddressR;
import com.va.session.BizManager;


/** Recurly Webhook Implementation
 * @author Jaizon Lubaton
 *
 */
public class WebhookImpl implements Webhook {
	private static final Logger log = Logger.getLogger(WebhookImpl.class);
	private BizManager bizManager=null;
	private RecurlyClient recurlyClient;
	
	public WebhookImpl(BizManager bizManager, RecurlyClient recurlyClient){
		this.bizManager = bizManager;
		this.recurlyClient = recurlyClient;
	}

	public static void main(String[] args){
		
	}
	
	
	
	/** This method creates account in USP/VA system in response to Recurly NewAccount notification, if account does not exist yet
	 * @see com.va.client.recurly.handler.Webhook#newAccountNotification(com.va.client.recurly.events.notifications.NewAccountNotification, java.lang.String)
	 * testing
	 */
	public void newAccountNotification(NewAccountNotification event, String xmlData) throws VAException {
		String memberId=event.getAccount().getAccountCode();
		try {
			
			boolean isExist = bizManager.isMemberExist(memberId);
			
			if(!isExist){ //if account does not exist in VA/USP system create it.
	
				AccountR accountR = (AccountR) recurlyClient.getAccount(memberId);
				AddressR addressR = (AddressR) accountR.getAddress();
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
				
				bizManager.createAccount(accountInfo,null);
				
				//address
				AddressInfo addressInfo = new AddressInfo();
			//	addressInfo._accountid
				
				
//				account._name = register.getFirstName();
//				account._initial = register.getInitials();
//				account._lastName = register.getLastName();
//				account._email = register.getEmail();
//				account._optin = new Boolean(true);
//				account._partnerCode = register.getPartner();
//				account._status = Constants.ACCOUNT_STATUS_NEWSLETTER;
//				account._renewalLast = Constants.RENEWAL_LAST_ON;
//				account._ipAddress = register.getIpAddress();
//				account._ganClickId = register.getClickId(); // GAN ClickId
				
				
			}
			String message =xmlData;
			log.info("New account: "+event.toString());	
			
		} catch (Exception e) {
			throw new VAException(e);
		}
		
	}
	
	public void billingInfoUpdateNotification(BillingInfoUpdatedNotification event, String xmlData) throws VAException {	
		
		
		log.info("Billing Info Updated: "+event.toString());
	}

	public void canceledAccountNotification(CanceledAccountNotification event, String xmlData)  throws VAException{
		log.info("Cancel account: "+event.toString());
	}

	public void canceledSubscriptionNotification(CanceledSubscriptionNotification event, String xmlData)  throws VAException{
		log.info("Cancel subscription: "+event.toString());
		
	}

	public void closedInvoiceNotification(ClosedInvoiceNotification event, String xmlData) {
		log.info("Closed invoice notification: "+event.toString());
		
	}

	public void expiredSubscriptionNotification(ExpiredSubscriptionNotification event, String xmlData) {
		log.info("Expired subscription notification: "+event.toString());
		
	}

	public void failedPaymentNotification(FailedPaymentNotification event, String xmlData) {
		log.info("Failed payment: "+event.toString());
		
	}

	public void newInvoiceNotification(NewInvoiceNotification event, String xmlData) {
		log.info("New invoice: "+event.toString());			
	}

	public void newSubscriptionNotification(NewSubscriptionNotification event, String xmlData) {
		log.info("New subscription: "+event.toString());	
	}

	public void pastDueInvoiceNotification(PastDueInvoiceNotification event, String xmlData) {
		log.info("Past due invoice: "+event.toString());		
	}

	public void processingInvoiceNotification(ProcessingInvoiceNotification event, String xmlData) {
		log.info("Processing invoice: "+event.toString());
	}

	public void processingPaymentNotification(ProcessingPaymentNotification event, String xmlData) {
		log.info("Processing payment: "+event.toString());
	}

	public void reactivatedAccountNotification(ReactivatedAccountNotification event, String xmlData) {
		log.info("Reactivated account: "+event.toString());
	}

	public void renewedSubscriptionNotification(RenewedSubscriptionNotification event, String xmlData) {
		log.info("Renewed subscription: "+event.toString());
	}

	public void scheduledPaymentNotification(ScheduledPaymentNotification event, String xmlData) {
		log.info("Scheduled payment: "+event.toString());		
	}

	public void successfulPaymentNotification(SuccessfulPaymentNotification event, String xmlData) {
		log.info("Successful payment: "+event.toString());
	}

	public void successfulRefundNotification(SuccessfulRefundNotification event, String xmlData) {
		log.info("Successful refund: "+event.toString());
	}

	public void updatedSubscriptionNotification(UpdatedSubscriptionNotification event, String xmlData) {
		log.info("Updated subscription: "+event.toString());
	}

	public void voidPaymentNotification(VoidPaymentNotification event, String xmlData) {
		log.info("Void payment notification: "+event.toString());
	}	

}
