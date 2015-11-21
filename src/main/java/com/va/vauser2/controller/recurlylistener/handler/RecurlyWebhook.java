package com.va.vauser2.controller.recurlylistener.handler;

import org.apache.log4j.Logger;
import com.va.vauser2.controller.recurlylistener.events.notifications.*;

public class RecurlyWebhook implements Webhook {

	private static final Logger log = Logger.getLogger(RecurlyWebhook.class);
	
	public void billingInfoUpdateNotification(BillingInfoUpdatedNotification event) {
		log.info("Billing Info Updated: "+event.toString());
	}

	public void canceledAccountNotification(CanceledAccountNotification event) {
		log.info("Cancel account: "+event.toString());
	}

	public void canceledSubscriptionNotification(CanceledSubscriptionNotification event) {
		log.info("Cancel subscription: "+event.toString());
		
	}

	public void closedInvoiceNotification(ClosedInvoiceNotification event) {
		log.info("Closed invoice notification: "+event.toString());
		
	}

	public void expiredSubscriptionNotification(ExpiredSubscriptionNotification event) {
		log.info("Expired subscription notification: "+event.toString());
		
	}

	public void failedPaymentNotification(FailedPaymentNotification event) {
		log.info("Failed payment: "+event.toString());
		
	}

	public void newAccountNotification(NewAccountNotification event) {
		log.info("New account: "+event.toString());		
	}

	public void newInvoiceNotification(NewInvoiceNotification event) {
		log.info("New invoice: "+event.toString());			
	}

	public void newSubscriptionNotification(NewSubscriptionNotification event) {
		log.info("New subscription: "+event.toString());	
	}

	public void pastDueInvoiceNotification(PastDueInvoiceNotification event) {
		log.info("Past due invoice: "+event.toString());		
	}

	public void processingInvoiceNotification(ProcessingInvoiceNotification event) {
		log.info("Processing invoice: "+event.toString());
	}

	public void processingPaymentNotification(ProcessingPaymentNotification event) {
		log.info("Processing payment: "+event.toString());
	}

	public void reactivatedAccountNotification(ReactivatedAccountNotification event) {
		log.info("Reactivated account: "+event.toString());
	}

	public void renewedSubscriptionNotification(RenewedSubscriptionNotification event) {
		log.info("Renewed subscription: "+event.toString());
	}

	public void scheduledPaymentNotification(ScheduledPaymentNotification event) {
		log.info("Scheduled payment: "+event.toString());		
	}

	public void successfulPaymentNotification(SuccessfulPaymentNotification event) {
		log.info("Successful payment: "+event.toString());
	}

	public void successfulRefundNotification(SuccessfulRefundNotification event) {
		log.info("Successful refund: "+event.toString());
	}

	public void updatedSubscriptionNotification(UpdatedSubscriptionNotification event) {
		log.info("Updated subscription: "+event.toString());
	}

	public void voidPaymentNotification(VoidPaymentNotification event) {
		log.info("Void payment notification: "+event.toString());
	}	

}
