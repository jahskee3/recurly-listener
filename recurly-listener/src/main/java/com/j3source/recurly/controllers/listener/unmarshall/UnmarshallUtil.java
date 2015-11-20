package com.j3source.recurly.controllers.listener.unmarshall;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.j3source.recurly.controllers.listener.events.notifications.BillingInfoUpdatedNotification;
import com.j3source.recurly.controllers.listener.events.notifications.CanceledAccountNotification;
import com.j3source.recurly.controllers.listener.events.notifications.CanceledSubscriptionNotification;
import com.j3source.recurly.controllers.listener.events.notifications.ClosedInvoiceNotification;
import com.j3source.recurly.controllers.listener.events.notifications.ExpiredSubscriptionNotification;
import com.j3source.recurly.controllers.listener.events.notifications.FailedPaymentNotification;
import com.j3source.recurly.controllers.listener.events.notifications.NewAccountNotification;
import com.j3source.recurly.controllers.listener.events.notifications.NewInvoiceNotification;
import com.j3source.recurly.controllers.listener.events.notifications.NewSubscriptionNotification;
import com.j3source.recurly.controllers.listener.events.notifications.PastDueInvoiceNotification;
import com.j3source.recurly.controllers.listener.events.notifications.ProcessingInvoiceNotification;
import com.j3source.recurly.controllers.listener.events.notifications.ProcessingPaymentNotification;
import com.j3source.recurly.controllers.listener.events.notifications.ReactivatedAccountNotification;
import com.j3source.recurly.controllers.listener.events.notifications.RenewedSubscriptionNotification;
import com.j3source.recurly.controllers.listener.events.notifications.ScheduledPaymentNotification;
import com.j3source.recurly.controllers.listener.events.notifications.SuccessfulPaymentNotification;
import com.j3source.recurly.controllers.listener.events.notifications.SuccessfulRefundNotification;
import com.j3source.recurly.controllers.listener.events.notifications.UpdatedSubscriptionNotification;
import com.j3source.recurly.controllers.listener.events.notifications.VoidPaymentNotification;
import com.j3source.recurly.controllers.listener.handler.RecurlyWebhook;
import com.j3source.recurly.controllers.listener.handler.Webhook;

public class UnmarshallUtil {


	public static void eventAction(String xmlData) throws JDOMException, IOException, JAXBException{
		Webhook webhook = new RecurlyWebhook();
		
		Object event = getEvent(xmlData);		
		if(event instanceof CanceledAccountNotification){
			webhook.canceledAccountNotification((CanceledAccountNotification) event);
			
		}else if(event instanceof NewAccountNotification){
			webhook.newAccountNotification((NewAccountNotification) event);
			
		}else if(event instanceof BillingInfoUpdatedNotification){
			webhook.billingInfoUpdateNotification((BillingInfoUpdatedNotification) event);
			
		}else if(event instanceof ReactivatedAccountNotification){
			webhook.reactivatedAccountNotification((ReactivatedAccountNotification) event);
			
		}else if(event instanceof NewInvoiceNotification){
			webhook.newInvoiceNotification((NewInvoiceNotification)event);
			
		}else if(event instanceof ProcessingInvoiceNotification){
			webhook.processingInvoiceNotification((ProcessingInvoiceNotification)event);
			
		}else if(event instanceof ClosedInvoiceNotification){
			webhook.closedInvoiceNotification((ClosedInvoiceNotification) event);
			
		}else if(event instanceof PastDueInvoiceNotification){
			webhook.pastDueInvoiceNotification((PastDueInvoiceNotification) event);
			
		}else if(event instanceof NewSubscriptionNotification){
			webhook.newSubscriptionNotification((NewSubscriptionNotification) event);			
			
		}else if(event instanceof UpdatedSubscriptionNotification){
			webhook.updatedSubscriptionNotification((UpdatedSubscriptionNotification) event);
			
		}else if(event instanceof CanceledSubscriptionNotification){
			webhook.canceledSubscriptionNotification((CanceledSubscriptionNotification) event);
			
		}else if(event instanceof ExpiredSubscriptionNotification){
			webhook.expiredSubscriptionNotification((ExpiredSubscriptionNotification) event);
				
		}else if(event instanceof RenewedSubscriptionNotification){
			webhook.renewedSubscriptionNotification((RenewedSubscriptionNotification) event);
			
		}else if(event instanceof SuccessfulPaymentNotification){
			webhook.successfulPaymentNotification((SuccessfulPaymentNotification) event);
			
		}else if(event instanceof ScheduledPaymentNotification){
			webhook.scheduledPaymentNotification((ScheduledPaymentNotification) event);
			
		}else if(event instanceof ProcessingPaymentNotification){
			webhook.processingPaymentNotification((ProcessingPaymentNotification) event);
			
		}else if(event instanceof FailedPaymentNotification){
			webhook.failedPaymentNotification((FailedPaymentNotification) event);
			
		}else if(event instanceof SuccessfulRefundNotification){
			webhook.successfulRefundNotification((SuccessfulRefundNotification) event);
			
		}else if(event instanceof VoidPaymentNotification){
			webhook.voidPaymentNotification((VoidPaymentNotification) event);			
		}		
	}
	
	private static Class getNotificationClass(String xmlData) throws JDOMException, IOException{
		Class notificationClass = null;
		String rootElementName=getRootElementName(xmlData);
		if(rootElementName.equals("canceled_account_notification")){
			notificationClass=CanceledAccountNotification.class;
		}else if(rootElementName.equals("new_account_notification")){
			notificationClass=NewAccountNotification.class;
		}else if(rootElementName.equals("billing_info_updated_notification")){
			notificationClass=BillingInfoUpdatedNotification.class;
		}else if(rootElementName.equals("reactivated_account_notification")){
			notificationClass=ReactivatedAccountNotification.class;
		}else if(rootElementName.equals("new_invoice_notification")){
			notificationClass=NewInvoiceNotification.class;
		}else if(rootElementName.equals("processing_invoice_notification")){
			notificationClass=ProcessingInvoiceNotification.class;
		}else if(rootElementName.equals("closed_invoice_notification")){
			notificationClass=ClosedInvoiceNotification.class;
		}else if(rootElementName.equals("past_due_invoice_notification")){
			notificationClass=PastDueInvoiceNotification.class;
		}else if(rootElementName.equals("new_subscription_notification")){
			notificationClass=NewSubscriptionNotification.class;
		}else if(rootElementName.equals("updated_subscription_notification")){
			notificationClass=UpdatedSubscriptionNotification.class;
		}else if(rootElementName.equals("canceled_subscription_notification")){
			notificationClass=CanceledSubscriptionNotification.class;
		}else if(rootElementName.equals("expired_subscription_notification")){
			notificationClass=ExpiredSubscriptionNotification.class;
		}else if(rootElementName.equals("renewed_subscription_notification")){
			notificationClass=RenewedSubscriptionNotification.class;
		}else if(rootElementName.equals("successful_payment_notification")){
			notificationClass=SuccessfulPaymentNotification.class;
		}else if(rootElementName.equals("scheduled_payment_notification")){
			notificationClass=ScheduledPaymentNotification.class;
		}else if(rootElementName.equals("processing_payment_notification")){
			notificationClass=ProcessingPaymentNotification.class;
		}else if(rootElementName.equals("failed_payment_notification")){
			notificationClass=FailedPaymentNotification.class;
		}else if(rootElementName.equals("successful_refund_notification")){
			notificationClass=SuccessfulRefundNotification.class;
		}else if(rootElementName.equals("void_payment_notification")){
			notificationClass=VoidPaymentNotification.class;
		}		
		return notificationClass;
	}
	
	private static Object getEvent(String xmlData) throws JDOMException, IOException, JAXBException{
		Class notificationClass = getNotificationClass(xmlData);		
		JAXBContext jaxbContext = JAXBContext.newInstance(notificationClass);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		StringReader reader = new StringReader(xmlData);		
		Object event = (Object) unmarshaller.unmarshal(reader);
		return event;
	}	
	
	private static String getRootElementName(String xmlData) throws JDOMException, IOException{
		SAXBuilder saxBuilder = new SAXBuilder();		
		Document doc = saxBuilder.build(new StringReader(xmlData));
		String notificationName = doc.getRootElement().getName();
		 return notificationName;
	}

}
