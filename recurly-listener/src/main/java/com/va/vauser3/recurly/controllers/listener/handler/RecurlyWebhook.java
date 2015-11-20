package com.va.vauser3.recurly.controllers.listener.handler;

import com.va.vauser3.recurly.controllers.listener.events.notifications.BillingInfoUpdatedNotification;
import com.va.vauser3.recurly.controllers.listener.events.notifications.CanceledAccountNotification;
import com.va.vauser3.recurly.controllers.listener.events.notifications.CanceledSubscriptionNotification;
import com.va.vauser3.recurly.controllers.listener.events.notifications.ClosedInvoiceNotification;
import com.va.vauser3.recurly.controllers.listener.events.notifications.ExpiredSubscriptionNotification;
import com.va.vauser3.recurly.controllers.listener.events.notifications.FailedPaymentNotification;
import com.va.vauser3.recurly.controllers.listener.events.notifications.NewAccountNotification;
import com.va.vauser3.recurly.controllers.listener.events.notifications.NewInvoiceNotification;
import com.va.vauser3.recurly.controllers.listener.events.notifications.NewSubscriptionNotification;
import com.va.vauser3.recurly.controllers.listener.events.notifications.PastDueInvoiceNotification;
import com.va.vauser3.recurly.controllers.listener.events.notifications.ProcessingInvoiceNotification;
import com.va.vauser3.recurly.controllers.listener.events.notifications.ProcessingPaymentNotification;
import com.va.vauser3.recurly.controllers.listener.events.notifications.ReactivatedAccountNotification;
import com.va.vauser3.recurly.controllers.listener.events.notifications.RenewedSubscriptionNotification;
import com.va.vauser3.recurly.controllers.listener.events.notifications.ScheduledPaymentNotification;
import com.va.vauser3.recurly.controllers.listener.events.notifications.SuccessfulPaymentNotification;
import com.va.vauser3.recurly.controllers.listener.events.notifications.SuccessfulRefundNotification;
import com.va.vauser3.recurly.controllers.listener.events.notifications.UpdatedSubscriptionNotification;
import com.va.vauser3.recurly.controllers.listener.events.notifications.VoidPaymentNotification;

public class RecurlyWebhook implements Webhook {

	public void billingInfoUpdateNotification(BillingInfoUpdatedNotification event) {
		System.out.println("Billing Info Updated: "+event.toString());
	}

	public void canceledAccountNotification(CanceledAccountNotification event) {
		System.out.println("Cancel account: "+event.toString());
	}

	public void canceledSubscriptionNotification(CanceledSubscriptionNotification event) {
		System.out.println("Cancel subscription: "+event.toString());
		
	}

	public void closedInvoiceNotification(ClosedInvoiceNotification event) {
		System.out.println("Closed invoice notification: "+event.toString());
		
	}

	public void expiredSubscriptionNotification(ExpiredSubscriptionNotification event) {
		System.out.println("Expired subscription notification: "+event.toString());
		
	}

	public void failedPaymentNotification(FailedPaymentNotification event) {
		System.out.println("Failed payment: "+event.toString());
		
	}

	public void newAccountNotification(NewAccountNotification event) {
		System.out.println("New account: "+event.toString());		
	}

	public void newInvoiceNotification(NewInvoiceNotification event) {
		System.out.println("New invoice: "+event.toString());			
	}

	public void newSubscriptionNotification(NewSubscriptionNotification event) {
		System.out.println("New subscription: "+event.toString());	
	}

	public void pastDueInvoiceNotification(PastDueInvoiceNotification event) {
		System.out.println("Past due invoice: "+event.toString());		
	}

	public void processingInvoiceNotification(ProcessingInvoiceNotification event) {
		System.out.println("Processing invoice: "+event.toString());
	}

	public void processingPaymentNotification(ProcessingPaymentNotification event) {
		System.out.println("Processing payment: "+event.toString());
	}

	public void reactivatedAccountNotification(ReactivatedAccountNotification event) {
		System.out.println("Reactivated account: "+event.toString());
	}

	public void renewedSubscriptionNotification(RenewedSubscriptionNotification event) {
		System.out.println("Renewed subscription: "+event.toString());
	}

	public void scheduledPaymentNotification(ScheduledPaymentNotification event) {
		System.out.println("Scheduled payment: "+event.toString());		
	}

	public void successfulPaymentNotification(SuccessfulPaymentNotification event) {
		System.out.println("Successful payment: "+event.toString());
	}

	public void successfulRefundNotification(SuccessfulRefundNotification event) {
		System.out.println("Successful refund: "+event.toString());
	}

	public void updatedSubscriptionNotification(UpdatedSubscriptionNotification event) {
		System.out.println("Updated subscription: "+event.toString());
	}

	public void voidPaymentNotification(VoidPaymentNotification event) {
		System.out.println("Void payment notification: "+event.toString());
	}	

}
