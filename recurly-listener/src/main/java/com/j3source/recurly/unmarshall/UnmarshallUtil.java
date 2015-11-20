package com.j3source.recurly.unmarshall;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.j3source.recurly.events.notifications.BillingInfoUpdatedNotification;
import com.j3source.recurly.events.notifications.CanceledAccountNotification;
import com.j3source.recurly.events.notifications.NewAccountNotification;
import com.j3source.recurly.events.notifications.ReactivatedAccountNotification;



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
		}
	}
	
	private static Object getEvent(String xmlData) throws JDOMException, IOException, JAXBException{
		Class notificationClass = getNotificationClass(xmlData);
		
		JAXBContext jaxbContext = JAXBContext.newInstance(notificationClass);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		StringReader reader = new StringReader(xmlData);		
		Object event = (Object) unmarshaller.unmarshal(reader);
		return event;
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
		}
		
		return notificationClass;
	}
	
	private static String getRootElementName(String xmlData) throws JDOMException, IOException{
		SAXBuilder saxBuilder = new SAXBuilder();		
		Document doc = saxBuilder.build(new StringReader(xmlData));
		String notificationName = doc.getRootElement().getName();
		 return notificationName;
	}

}
