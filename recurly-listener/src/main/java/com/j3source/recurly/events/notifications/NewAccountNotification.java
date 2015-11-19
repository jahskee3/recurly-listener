package com.j3source.recurly.events.notifications;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.j3source.recurly.events.models.AccountE;

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
		sb.append(", account='").append(account.toString());
		sb.append('}');
		return sb.toString();
	}
}
