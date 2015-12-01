package com.va.client.recurly.unmarshall;

import java.io.IOException;
import java.io.StringReader;
import java.sql.SQLException;

import javax.ejb.CreateException;
import javax.naming.NamingException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.ning.billing.recurly.RecurlyClient;
import com.ning.billing.recurly.model.Subscription;
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
import com.va.client.recurly.handler.Webhook;
import com.va.client.recurly.handler.WebhookImpl;
import com.va.core.VAException;
import com.va.recurly.utils.VARecurlyConfig;
import com.va.session.BizManager;
import com.va.session.BizManagerUtil;


public class UnmarshallUtil {


	
	
	public static void eventAction(String xmlData) throws JDOMException, IOException, JAXBException, SQLException, NamingException, CreateException, VAException{
		BizManager bizManager = BizManagerUtil.createBizManager();
		
		//String partnerPlanCode=vaSubs.getPartnerCode()+"-"+vaSubs.getPrimaryPlanCode();
		VARecurlyConfig config = new VARecurlyConfig();
		
		RecurlyClient recurlyClient = new RecurlyClient(config.getApiKey(), config.getSubDomain());
		recurlyClient.open();
		
		Webhook webhook = new WebhookImpl(bizManager, recurlyClient);
		
		Object event = getEvent(xmlData);
		
	
		// execute insert SQL stetement

		try{
	
			if(event instanceof CanceledAccountNotification){
				webhook.canceledAccountNotification((CanceledAccountNotification) event, xmlData);
				
			}else if(event instanceof NewAccountNotification){
				webhook.newAccountNotification((NewAccountNotification) event, xmlData);
				
			}else if(event instanceof BillingInfoUpdatedNotification){
				webhook.billingInfoUpdateNotification((BillingInfoUpdatedNotification) event, xmlData);
				
			}else if(event instanceof ReactivatedAccountNotification){
				webhook.reactivatedAccountNotification((ReactivatedAccountNotification) event, xmlData);
				
			}else if(event instanceof NewInvoiceNotification){
				webhook.newInvoiceNotification((NewInvoiceNotification)event, xmlData);
				
			}else if(event instanceof ProcessingInvoiceNotification){
				webhook.processingInvoiceNotification((ProcessingInvoiceNotification)event, xmlData);
				
			}else if(event instanceof ClosedInvoiceNotification){
				webhook.closedInvoiceNotification((ClosedInvoiceNotification) event, xmlData);
				
			}else if(event instanceof PastDueInvoiceNotification){
				webhook.pastDueInvoiceNotification((PastDueInvoiceNotification) event, xmlData);
				
			}else if(event instanceof NewSubscriptionNotification){
				webhook.newSubscriptionNotification((NewSubscriptionNotification) event, xmlData);			
				
			}else if(event instanceof UpdatedSubscriptionNotification){
				webhook.updatedSubscriptionNotification((UpdatedSubscriptionNotification) event, xmlData);
				
			}else if(event instanceof CanceledSubscriptionNotification){
				webhook.canceledSubscriptionNotification((CanceledSubscriptionNotification) event, xmlData);
				
			}else if(event instanceof ExpiredSubscriptionNotification){
				webhook.expiredSubscriptionNotification((ExpiredSubscriptionNotification) event, xmlData);
					
			}else if(event instanceof RenewedSubscriptionNotification){
				webhook.renewedSubscriptionNotification((RenewedSubscriptionNotification) event, xmlData);
				
			}else if(event instanceof SuccessfulPaymentNotification){
				webhook.successfulPaymentNotification((SuccessfulPaymentNotification) event, xmlData);
				
			}else if(event instanceof ScheduledPaymentNotification){
				webhook.scheduledPaymentNotification((ScheduledPaymentNotification) event, xmlData);
				
			}else if(event instanceof ProcessingPaymentNotification){
				webhook.processingPaymentNotification((ProcessingPaymentNotification) event, xmlData);
				
			}else if(event instanceof FailedPaymentNotification){
				webhook.failedPaymentNotification((FailedPaymentNotification) event, xmlData);
				
			}else if(event instanceof SuccessfulRefundNotification){
				webhook.successfulRefundNotification((SuccessfulRefundNotification) event, xmlData);
				
			}else if(event instanceof VoidPaymentNotification){
				webhook.voidPaymentNotification((VoidPaymentNotification) event, xmlData);			
			}		
		
		
		}catch(Exception e){
			throw new VAException(e);
		}finally{
			recurlyClient.close();			
		}
	}

	

	private static Class getNotificationClass(String xmlData) throws JDOMException, IOException{
		Class notificationClass = null;
		String rootElementName=getRootElementName(xmlData);
		if(rootElementName.equals("canceled_account_nrivateotification")){
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
	
	public static Object getEvent(String xmlData) throws JDOMException, IOException, JAXBException{
		Class notificationClass = getNotificationClass(xmlData);		
		JAXBContext jaxbContext = JAXBContext.newInstance(notificationClass);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		StringReader reader = new StringReader(xmlData);		
		Object event = (Object) unmarshaller.unmarshal(reader);
		return event;
	}	
	
	public static String getRootElementName(String xmlData) throws JDOMException, IOException{
		SAXBuilder saxBuilder = new SAXBuilder();		
		Document doc = saxBuilder.build(new StringReader(xmlData));
		String notificationName = doc.getRootElement().getName();
		 return notificationName;
	}
	

}
