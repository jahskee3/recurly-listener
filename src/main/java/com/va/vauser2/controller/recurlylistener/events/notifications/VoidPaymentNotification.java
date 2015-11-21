package com.va.vauser2.controller.recurlylistener.events.notifications;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.va.vauser2.controller.recurlylistener.events.models.AccountE;
import com.va.vauser2.controller.recurlylistener.events.models.TransactionE;


@XmlRootElement(name = "void_payment_notification")
public class VoidPaymentNotification {
	
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
		final StringBuilder sb = new StringBuilder("VoidPaymentNotification{");
		sb.append("account='").append(this.getAccount().toString()).append('\'');
		sb.append(", transaction='").append(this.getTransaction().toString()).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
