package com.va.client.recurly.handler;

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


public interface Webhook {
	public void billingInfoUpdateNotification(BillingInfoUpdatedNotification event, String xmlData) throws VAException;
	public void canceledAccountNotification(CanceledAccountNotification event, String xmlData) throws VAException;
	public void canceledSubscriptionNotification(CanceledSubscriptionNotification event, String xmlData) throws VAException;
	public void closedInvoiceNotification(ClosedInvoiceNotification event, String xmlData) throws VAException;
	public void expiredSubscriptionNotification(ExpiredSubscriptionNotification event, String xmlData) throws VAException;
	public void failedPaymentNotification(FailedPaymentNotification event, String xmlData) throws VAException;
	public void newAccountNotification(NewAccountNotification event, String xmlData) throws VAException;
	public void newInvoiceNotification(NewInvoiceNotification event, String xmlData) throws VAException;
	public void newSubscriptionNotification(NewSubscriptionNotification event, String xmlData) throws VAException;
	public void pastDueInvoiceNotification(PastDueInvoiceNotification event, String xmlData) throws VAException;
	public void processingInvoiceNotification(ProcessingInvoiceNotification event, String xmlData) throws VAException;
	public void processingPaymentNotification(ProcessingPaymentNotification event, String xmlData) throws VAException;
	public void reactivatedAccountNotification(ReactivatedAccountNotification event, String xmlData) throws VAException;
	public void renewedSubscriptionNotification(RenewedSubscriptionNotification event, String xmlData) throws VAException;
	public void scheduledPaymentNotification(ScheduledPaymentNotification event, String xmlData) throws VAException;
	public void successfulPaymentNotification(SuccessfulPaymentNotification event, String xmlData) throws VAException;
	public void successfulRefundNotification(SuccessfulRefundNotification event, String xmlData) throws VAException;
	public void updatedSubscriptionNotification(UpdatedSubscriptionNotification event, String xmlData) throws VAException;
	public void voidPaymentNotification(VoidPaymentNotification event, String xmlData) throws VAException;
}
