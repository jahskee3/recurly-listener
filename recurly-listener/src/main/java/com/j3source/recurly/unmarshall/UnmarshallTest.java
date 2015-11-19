package com.j3source.recurly.unmarshall;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.j3source.recurly.events.notifications.CanceledAccountNotification;



public class UnmarshallTest {

	public static void main(String[] args) throws JAXBException, JDOMException, IOException {
		String xmlData= "<?xml version='1.0' encoding='UTF-8'?><canceled_account_notification>  <account>    <account_code>1</account_code>    <username nil='true'>jahskee</username>    <email>verena@example.com</email>    <first_name>Verena</first_name>    <last_name>Example</last_name>    <company_name nil='true'></company_name>  </account></canceled_account_notification>";
				
		Class notificationClass = getNotificationClass(xmlData);
		
		JAXBContext jaxbContext = JAXBContext.newInstance(notificationClass);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		StringReader reader = new StringReader(xmlData);		
		Object event = (Object) unmarshaller.unmarshal(reader);
		
		
		if(event instanceof CanceledAccountNotification){
			System.out.println("Cancel account: "+event.toString());
		}
		//System.out.println("hello");
		//System.out.println(event.toString());
		
	}
	
	public static Class getNotificationClass(String xmlData) throws JDOMException, IOException{
		Class notificationClass = null;
		String rootElementName=getRootElementName(xmlData);
		if(rootElementName.equals("canceled_account_notification")){
			notificationClass=CanceledAccountNotification.class;
		}		
		return notificationClass;
	}
	
	public static String getRootElementName(String xmlData) throws JDOMException, IOException{
		SAXBuilder saxBuilder = new SAXBuilder();		
		Document doc = saxBuilder.build(new StringReader(xmlData));
		String notificationName = doc.getRootElement().getName();
		 return notificationName;
	}

}
