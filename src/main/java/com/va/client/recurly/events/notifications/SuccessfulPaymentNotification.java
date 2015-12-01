package com.va.client.recurly.events.notifications;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.va.client.recurly.events.models.TransactionE;



@XmlRootElement(name = "successful_payment_notification")
public class SuccessfulPaymentNotification extends BaseNotification{

	@XmlElement(name = "transaction")
	private TransactionE transaction;

	public TransactionE getTransaction() {
		return transaction;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("SuccessfulPaymentNotification{");
		sb.append("account='").append(this.getAccount().toString()).append('\'');
		sb.append(", transaction='").append(this.getTransaction().toString()).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
