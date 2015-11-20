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

public class UnmarshallUtil {


	public static void eventAction(String xmlData) throws JDOMException, IOException, JAXBException{
		Object event = getEvent(xmlData);		
		if(event instanceof CanceledAccountNotification){
			System.out.println("Cancel account: "+event.toString());
		}else if(event instanceof NewAccountNotification){
			System.out.println("New account: "+event.toString());
		}else if(event instanceof BillingInfoUpdatedNotification){
			System.out.println("Billing info updated: "+event.toString());
		}else if(event instanceof ReactivatedAccountNotification){
			System.out.println("Reactivated Account: "+event.toString());
		}else if(event instanceof NewInvoiceNotification){
			System.out.println("New Invoice : "+event.toString());
		}else if(event instanceof ProcessingInvoiceNotification){
			System.out.println("Processing Invoice : "+event.toString());
		}else if(event instanceof ClosedInvoiceNotification){
			System.out.println("Closed Invoice : "+event.toString());
		}else if(event instanceof PastDueInvoiceNotification){
			System.out.println("Past Due Invoice : "+event.toString());
		}else if(event instanceof NewSubscriptionNotification){
			System.out.println("New Subscription : "+event.toString());
		}else if(event instanceof UpdatedSubscriptionNotification){
			System.out.println("Updated Subscription : "+event.toString());
		}else if(event instanceof CanceledSubscriptionNotification){
			System.out.println("Canceled Subscription : "+event.toString());
		}else if(event instanceof ExpiredSubscriptionNotification){
			System.out.println("Expired Subscription : "+event.toString());
		}else if(event instanceof RenewedSubscriptionNotification){
			System.out.println("Renewed Subscription : "+event.toString());
		}else if(event instanceof SuccessfulPaymentNotification){
			System.out.println("Successful Payment : "+event.toString());
		}else if(event instanceof ScheduledPaymentNotification){
			System.out.println("Scheduled Payment : "+event.toString());
		}else if(event instanceof ProcessingPaymentNotification){
			System.out.println("Processing Payment : "+event.toString());
		}else if(event instanceof FailedPaymentNotification){
			System.out.println("Failed Payment : "+event.toString());
		}else if(event instanceof SuccessfulRefundNotification){
			System.out.println("Successful Refund : "+event.toString());
		}else if(event instanceof VoidPaymentNotification){
			System.out.println("Void Payment : "+event.toString());
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
