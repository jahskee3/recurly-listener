package com.j3source.recurly.controllers.listener.handler;

import com.j3source.recurly.controllers.listener.events.notifications.BillingInfoUpdatedNotification;
import com.j3source.recurly.controllers.listener.events.notifications.CanceledAccountNotification;

public interface Webhook {
	public void billingInfoUpdateNotification(BillingInfoUpdatedNotification event);
	public void canceledAccountNotification(CanceledAccountNotification event);
	public void canceledSubscriptionNotification();
	public void closedInvoiceNotification();
	public void expiredSubscriptionNotification();
	public void failedPaymentNotification();
	public void newAccountNotification();
	public void newInvoiceNotification();
	public void newSubscriptionNotification();
	public void pastDueInvoiceNotification();
	public void processingInvoiceNotification();
	public void processingPaymentNotification();
	public void reactivatedAccountNotification();
	public void renewedSubscriptionNotification();
	public void scheduledPaymentNotification();
	public void successfulPaymentNotification();
	public void successfulRefundNotification();
	public void updatedSubscriptionNotification();
	public void voidPaymentNotification();
}
