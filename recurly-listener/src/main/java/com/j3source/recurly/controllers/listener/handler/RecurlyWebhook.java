package com.j3source.recurly.controllers.listener.handler;

import com.j3source.recurly.controllers.listener.events.notifications.BillingInfoUpdatedNotification;
import com.j3source.recurly.controllers.listener.events.notifications.CanceledAccountNotification;

public class RecurlyWebhook implements Webhook {

	public void billingInfoUpdateNotification(BillingInfoUpdatedNotification event) {
		System.out.println("Billing Info Updated: "+event.toString());
		
	}

	public void canceledAccountNotification(CanceledAccountNotification event) {
		System.out.println("Cancel account: "+event.toString());
		
		
	}

	public void canceledSubscriptionNotification() {
		// TODO Auto-generated method stub
		
	}

	public void closedInvoiceNotification() {
		// TODO Auto-generated method stub
		
	}

	public void expiredSubscriptionNotification() {
		// TODO Auto-generated method stub
		
	}

	public void failedPaymentNotification() {
		// TODO Auto-generated method stub
		
	}

	public void newAccountNotification() {
		// TODO Auto-generated method stub
		
	}

	public void newInvoiceNotification() {
		// TODO Auto-generated method stub
		
	}

	public void newSubscriptionNotification() {
		// TODO Auto-generated method stub
		
	}

	public void pastDueInvoiceNotification() {
		// TODO Auto-generated method stub
		
	}

	public void processingInvoiceNotification() {
		// TODO Auto-generated method stub
		
	}

	public void processingPaymentNotification() {
		// TODO Auto-generated method stub
		
	}

	public void reactivatedAccountNotification() {
		// TODO Auto-generated method stub
		
	}

	public void renewedSubscriptionNotification() {
		// TODO Auto-generated method stub
		
	}

	public void scheduledPaymentNotification() {
		// TODO Auto-generated method stub
		
	}

	public void successfulPaymentNotification() {
		// TODO Auto-generated method stub
		
	}

	public void successfulRefundNotification() {
		// TODO Auto-generated method stub
		
	}

	public void updatedSubscriptionNotification() {
		// TODO Auto-generated method stub
		
	}

	public void voidPaymentNotification() {
		// TODO Auto-generated method stub
		
	}

}
