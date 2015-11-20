package com.j3source.recurly.controllers.listener.events.notifications;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.j3source.recurly.controllers.listener.events.models.AccountE;
import com.j3source.recurly.controllers.listener.events.models.TransactionE;

@XmlRootElement(name = "scheduled_payment_notification")
public class ScheduledPaymentNotification {
	
	@XmlElement(name = "account")
	private AccountE account;
	
	@XmlElement(name = "transaction")
	private TransactionE transaction;

	public AccountE getAccount() {
		return account;
	}

	public TransactionE getTransaction() {
		return transaction;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("ScheduledPaymentNotification{");
		sb.append("account='").append(this.getAccount().toString()).append('\'');
		sb.append(", transaction='").append(this.getTransaction().toString()).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
