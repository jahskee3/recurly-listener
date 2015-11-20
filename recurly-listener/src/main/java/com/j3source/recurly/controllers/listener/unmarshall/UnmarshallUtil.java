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
import com.j3source.recurly.controllers.listener.events.notifications.NewAccountNotification;
import com.j3source.recurly.controllers.listener.events.notifications.NewInvoiceNotification;
import com.j3source.recurly.controllers.listener.events.notifications.NewSubscriptionNotification;
import com.j3source.recurly.controllers.listener.events.notifications.PastDueInvoiceNotification;
import com.j3source.recurly.controllers.listener.events.notifications.ProcessingInvoiceNotification;
import com.j3source.recurly.controllers.listener.events.notifications.ReactivatedAccountNotification;
import com.j3source.recurly.controllers.listener.events.notifications.RenewedSubscriptionNotification;
import com.j3source.recurly.controllers.listener.events.notifications.SuccessfulPaymentNotification;
import com.j3source.recurly.controllers.listener.events.notifications.UpdatedSubscriptionNotification;

public class UnmarshallUtil {

	public static void main(String[] args) throws JAXBException, JDOMException, IOException {
		String cancelAccountNotificationData="<?xml version='1.0' encoding='UTF-8'?><canceled_account_notification><account><account_code>1</account_code><username nil='true'>test</username><email>verena@example.com</email><first_name>Verena</first_name><last_name>Example</last_name><company_name nil='true'></company_name></account></canceled_account_notification>";
		UnmarshallUtil.eventAction(cancelAccountNotificationData);

		String newAccountNotificationData= "<?xml version='1.0' encoding='UTF-8'?><new_account_notification>  <account>    <account_code>1</account_code>    <username nil='true'>jahskee</username>    <email>verena@example.com</email>    <first_name>Verena</first_name>    <last_name>Example</last_name>    <company_name nil='true'></company_name>  </account></new_account_notification>";
		UnmarshallUtil.eventAction(newAccountNotificationData);
	
		String billingInfoUpdatedNotificationData="<?xml version='1.0' encoding='UTF-8'?><billing_info_updated_notification><account><account_code>1</account_code><username nil='true'>test12</username><email>verena@example.com</email><first_name>Verena</first_name><last_name>Example</last_name><company_name nil='true'></company_name></account></billing_info_updated_notification>";
		UnmarshallUtil.eventAction(billingInfoUpdatedNotificationData);
		
		String reactivatedAccountNotificationData="<?xml version='1.0' encoding='UTF-8'?> <reactivated_account_notification><account><account_code>1</account_code><username nil='true'></username><email>verena@example.com</email><first_name>Verena</first_name><last_name>Example</last_name><company_name nil='true'></company_name></account><subscription><plan><plan_code>bootstrap</plan_code><name>Bootstrap</name></plan><uuid>6ab458a887d38070807ebb3bed7ac1e5</uuid><state>active</state><quantity type='integer'>1</quantity><total_amount_in_cents type='integer'>9900</total_amount_in_cents><activated_at type='datetime'>2010-07-22T20:42:05Z</activated_at> <canceled_at nil='true' type='datetime'></canceled_at> <expires_at nil='true' type='datetime'></expires_at> <current_period_started_at type='datetime'>2010-09-22T20:42:05Z</current_period_started_at> <current_period_ends_at type='datetime'>2010-10-22T20:42:05Z</current_period_ends_at> <trial_started_at nil='true' type='datetime'></trial_started_at> <trial_ends_at nil='true' type='datetime'></trial_ends_at> <collection_method>automatic</collection_method> </subscription> </reactivated_account_notification>";
		UnmarshallUtil.eventAction(reactivatedAccountNotificationData);
		
		String newInvoiceNotificationData="<?xml version='1.0' encoding='UTF-8'?> <new_invoice_notification> <account> <account_code>1</account_code> <username nil='true'></username> <email>verena@example.com</email> <first_name>Verana</first_name> <last_name>Example</last_name> <company_name nil='true'></company_name> </account> <invoice> <uuid>ffc64d71d4b5404e93f13aac9c63b007</uuid> <subscription_id nil='true'></subscription_id> <state>open</state> <invoice_number_prefix></invoice_number_prefix> <invoice_number type='integer'>1000</invoice_number> <po_number></po_number> <vat_number></vat_number> <total_in_cents type='integer'>1000</total_in_cents> <currency>USD</currency> <date type='datetime'>2014-01-01T20:21:44Z</date> <closed_at type='datetime' nil='true'></closed_at> </invoice> </new_invoice_notification>";
		UnmarshallUtil.eventAction(newInvoiceNotificationData);
		
		String processingInvoiceNotificationData="<?xml version='1.0' encoding='UTF-8'?> <processing_invoice_notification> <account> <account_code>1</account_code> <username nil='true'></username> <email>verena@example.com</email> <first_name>Verana</first_name> <last_name>Example</last_name> <company_name nil='true'></company_name> </account> <invoice> <uuid>ffc64d71d4b5404e93f13aac9c63b007</uuid> <subscription_id nil='true'></subscription_id> <state>processing</state> <invoice_number_prefix></invoice_number_prefix> <invoice_number type='integer'>1000</invoice_number> <po_number></po_number> <vat_number></vat_number> <total_in_cents type='integer'>1000</total_in_cents> <currency>USD</currency> <date type='datetime'>2014-01-01T20:21:44Z</date> <closed_at type='datetime' nil='true'></closed_at> <net_terms type='integer'>0</net_terms> <collection_method>automatic</collection_method> </invoice> </processing_invoice_notification>";
		UnmarshallUtil.eventAction(processingInvoiceNotificationData);	
		
		String closedInvoiceNotificationData="<?xml version='1.0' encoding='UTF-8'?> <closed_invoice_notification> <account> <account_code>1</account_code> <username nil='true'></username> <email>verena@example.com</email> <first_name>Verana</first_name> <last_name>Example</last_name> <company_name nil='true'></company_name> </account> <invoice> <uuid>ffc64d71d4b5404e93f13aac9c63b007</uuid> <subscription_id nil='true'></subscription_id> <state>collected</state> <invoice_number_prefix></invoice_number_prefix> <invoice_number type='integer'>1000</invoice_number> <po_number></po_number> <vat_number></vat_number> <total_in_cents type='integer'>1100</total_in_cents> <currency>USD</currency> <date type='datetime'>2014-01-01T20:20:29Z</date> <closed_at type='datetime'>2014-01-01T20:24:02Z</closed_at> </invoice> </closed_invoice_notification>";
		UnmarshallUtil.eventAction(closedInvoiceNotificationData);
		
		String pastDueInvoiceNotificationData="<?xml version='1.0' encoding='UTF-8'?> <past_due_invoice_notification> <account> <account_code>1</account_code> <username nil='true'></username> <email>verena@example.com</email> <first_name>Verana</first_name> <last_name>Example</last_name> <company_name nil='true'></company_name> </account> <invoice> <uuid>ffc64d71d4b5404e93f13aac9c63b007</uuid> <subscription_id nil='true'></subscription_id> <state>collected</state> <invoice_number_prefix></invoice_number_prefix> <invoice_number type='integer'>1000</invoice_number> <po_number></po_number> <vat_number></vat_number> <total_in_cents type='integer'>1100</total_in_cents> <currency>USD</currency> <date type='datetime'>2014-01-01T20:20:29Z</date> <closed_at type='datetime'>2014-01-01T20:24:02Z</closed_at> </invoice> </past_due_invoice_notification>";
		UnmarshallUtil.eventAction(pastDueInvoiceNotificationData);
		
		String newSubscriptionNotificationData="<?xml version='1.0' encoding='UTF-8'?> <new_subscription_notification> <account> <account_code>1</account_code> <username nil='true'>verena</username> <email>verena@example.com</email> <first_name>Verena</first_name> <last_name>Example</last_name> <company_name nil='true'>Company, Inc.</company_name> </account> <subscription> <plan> <plan_code>bronze</plan_code> <name>Bronze Plan</name> <version type='integer'>2</version> </plan> <uuid>8047cb4fd5f874b14d713d785436ebd3</uuid> <state>active</state> <quantity type='integer'>2</quantity> <total_amount_in_cents type='integer'>2000</total_amount_in_cents> <activated_at type='datetime'>2009-11-22T13:10:38Z</activated_at> <canceled_at type='datetime'></canceled_at> <expires_at type='datetime'></expires_at> <current_period_started_at type='datetime'>2009-11-22T13:10:38Z</current_period_started_at> <current_period_ends_at type='datetime'>2009-11-29T13:10:38Z</current_period_ends_at> <trial_started_at type='datetime'>2009-11-22T13:10:38Z</trial_started_at> <trial_ends_at type='datetime'>2009-11-29T13:10:38Z</trial_ends_at> <collection_method>automatic</collection_method> </subscription> </new_subscription_notification>";
		UnmarshallUtil.eventAction(newSubscriptionNotificationData);

		String updatedSubscriptionNotificationData="<?xml version='1.0' encoding='UTF-8'?> <updated_subscription_notification> <account> <account_code>1</account_code> <username nil='true'></username> <email>verena@example.com</email> <first_name>Verena</first_name> <last_name>Example</last_name> <company_name nil='true'></company_name> </account> <subscription> <plan> <plan_code>1dpt</plan_code> <name>Subscription One</name> </plan> <uuid>292332928954ca62fa48048be5ac98ec</uuid> <state>active</state> <quantity type='integer'>1</quantity> <total_amount_in_cents type='integer'>200</total_amount_in_cents> <activated_at type='datetime'>2010-09-23T22:12:39Z</activated_at> <canceled_at nil='true' type='datetime'></canceled_at> <expires_at nil='true' type='datetime'></expires_at> <current_period_started_at type='datetime'>2010-09-23T22:03:30Z</current_period_started_at> <current_period_ends_at type='datetime'>2010-09-24T22:03:30Z</current_period_ends_at> <trial_started_at nil='true' type='datetime'> </trial_started_at> <trial_ends_at nil='true' type='datetime'> </trial_ends_at> <collection_method>automatic</collection_method> </subscription> </updated_subscription_notification>";
		UnmarshallUtil.eventAction(updatedSubscriptionNotificationData);
		
		String canceledSubscriptionNotificationData="<?xml version='1.0' encoding='UTF-8'?> <canceled_subscription_notification> <account> <account_code>1</account_code> <username nil='true'></username> <email>verena@example.com</email> <first_name>Verena</first_name> <last_name>Example</last_name> <company_name nil='true'></company_name> </account> <subscription> <plan> <plan_code>1dpt</plan_code> <name>Subscription One</name> </plan> <uuid>292332928954ca62fa48048be5ac98ec</uuid> <state>active</state> <quantity type='integer'>1</quantity> <total_amount_in_cents type='integer'>200</total_amount_in_cents> <activated_at type='datetime'>2010-09-23T22:12:39Z</activated_at> <canceled_at nil='true' type='datetime'></canceled_at> <expires_at nil='true' type='datetime'></expires_at> <current_period_started_at type='datetime'>2010-09-23T22:03:30Z</current_period_started_at> <current_period_ends_at type='datetime'>2010-09-24T22:03:30Z</current_period_ends_at> <trial_started_at nil='true' type='datetime'> </trial_started_at> <trial_ends_at nil='true' type='datetime'> </trial_ends_at> <collection_method>automatic</collection_method> </subscription> </canceled_subscription_notification>";
		UnmarshallUtil.eventAction(canceledSubscriptionNotificationData);
		
		String expiredSubscriptionNotificationData="<?xml version='1.0' encoding='UTF-8'?> <expired_subscription_notification> <account> <account_code>1</account_code> <username nil='true'></username> <email>verena@example.com</email> <first_name>Verena</first_name> <last_name>Example</last_name> <company_name nil='true'></company_name> </account> <subscription> <plan> <plan_code>1dpt</plan_code> <name>Subscription One</name> </plan> <uuid>292332928954ca62fa48048be5ac98ec</uuid> <state>active</state> <quantity type='integer'>1</quantity> <total_amount_in_cents type='integer'>200</total_amount_in_cents> <activated_at type='datetime'>2010-09-23T22:12:39Z</activated_at> <canceled_at nil='true' type='datetime'></canceled_at> <expires_at nil='true' type='datetime'></expires_at> <current_period_started_at type='datetime'>2010-09-23T22:03:30Z</current_period_started_at> <current_period_ends_at type='datetime'>2010-09-24T22:03:30Z</current_period_ends_at> <trial_started_at nil='true' type='datetime'> </trial_started_at> <trial_ends_at nil='true' type='datetime'> </trial_ends_at> <collection_method>automatic</collection_method> </subscription> </expired_subscription_notification>";
		UnmarshallUtil.eventAction(expiredSubscriptionNotificationData);
		
		String renewedSubscriptionNotificationData="<?xml version='1.0' encoding='UTF-8'?> <renewed_subscription_notification> <account> <account_code>1</account_code> <username nil='true'></username> <email>verena@example.com</email> <first_name>Verena</first_name> <last_name>Example</last_name> <company_name nil='true'></company_name> </account> <subscription> <plan> <plan_code>1dpt</plan_code> <name>Subscription One</name> </plan> <uuid>292332928954ca62fa48048be5ac98ec</uuid> <state>active</state> <quantity type='integer'>1</quantity> <total_amount_in_cents type='integer'>200</total_amount_in_cents> <activated_at type='datetime'>2010-09-23T22:12:39Z</activated_at> <canceled_at nil='true' type='datetime'></canceled_at> <expires_at nil='true' type='datetime'></expires_at> <current_period_started_at type='datetime'>2010-09-23T22:03:30Z</current_period_started_at> <current_period_ends_at type='datetime'>2010-09-24T22:03:30Z</current_period_ends_at> <trial_started_at nil='true' type='datetime'> </trial_started_at> <trial_ends_at nil='true' type='datetime'> </trial_ends_at> <collection_method>automatic</collection_method> </subscription> </renewed_subscription_notification>";
		UnmarshallUtil.eventAction(renewedSubscriptionNotificationData);
		
		String successfulPaymentNotificationData="<?xml version='1.0' encoding='UTF-8'?> <successful_payment_notification> <account> <account_code>1</account_code> <username nil='true'>verena</username> <email>verena@example.com</email> <first_name>Verena</first_name> <last_name>Example</last_name> <company_name nil='true'>Company, Inc.</company_name> </account> <transaction> <id>a5143c1d3a6f4a8287d0e2cc1d4c0427</id> <invoice_id>1974a09kj90s0789dsf099798326881c</invoice_id> <invoice_number type='integer'>2059</invoice_number> <subscription_id>1974a098jhlkjasdfljkha898326881c</subscription_id> <action>purchase</action> <date type='datetime'>2009-11-22T13:10:38Z</date> <amount_in_cents type='integer'>1000</amount_in_cents> <status>success</status> <message>Bogus Gateway: Forced success</message> <reference></reference> <source>subscription</source> <cvv_result code=''></cvv_result> <avs_result code=''></avs_result> <avs_result_street></avs_result_street> <avs_result_postal></avs_result_postal> <test type='boolean'>true</test> <voidable type='boolean'>true</voidable> <refundable type='boolean'>true</refundable> <manually_entered type='boolean'>true</manually_entered> <payment_method>credit_card</payment_method> </transaction> </successful_payment_notification>";
		UnmarshallUtil.eventAction(successfulPaymentNotificationData);
	}
	
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
