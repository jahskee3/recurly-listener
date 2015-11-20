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
