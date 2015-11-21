package com.va.vauser2.controller.recurlylistener.events.notifications;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.va.vauser2.controller.recurlylistener.events.models.AccountE;


@XmlRootElement(name = "new_account_notification")
public class NewAccountNotification {
	@XmlElement(name = "account")
	private AccountE account;

	public AccountE getAccount() {
		return account;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("NewAccountNotification{");
		sb.append("account='").append(account.toString());
		sb.append('}');
		return sb.toString();
	}
}
