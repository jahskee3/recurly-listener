package com.va.vauser3.controller.recurlylistener.handler;

import com.va.vauser3.controller.recurlylistener.events.notifications.*;


public interface Webhook {
	public void billingInfoUpdateNotification(BillingInfoUpdatedNotification event);
	public void canceledAccountNotification(CanceledAccountNotification event);
	public void canceledSubscriptionNotification(CanceledSubscriptionNotification event);
	public void closedInvoiceNotification(ClosedInvoiceNotification event);
	public void expiredSubscriptionNotification(ExpiredSubscriptionNotification event);
	public void failedPaymentNotification(FailedPaymentNotification event);
	public void newAccountNotification(NewAccountNotification event);
	public void newInvoiceNotification(NewInvoiceNotification event);
	public void newSubscriptionNotification(NewSubscriptionNotification event);
	public void pastDueInvoiceNotification(PastDueInvoiceNotification event);
	public void processingInvoiceNotification(ProcessingInvoiceNotification event);
	public void processingPaymentNotification(ProcessingPaymentNotification event);
	public void reactivatedAccountNotification(ReactivatedAccountNotification event);
	public void renewedSubscriptionNotification(RenewedSubscriptionNotification event);
	public void scheduledPaymentNotification(ScheduledPaymentNotification event);
	public void successfulPaymentNotification(SuccessfulPaymentNotification event);
	public void successfulRefundNotification(SuccessfulRefundNotification event);
	public void updatedSubscriptionNotification(UpdatedSubscriptionNotification event);
	public void voidPaymentNotification(VoidPaymentNotification event);
}
