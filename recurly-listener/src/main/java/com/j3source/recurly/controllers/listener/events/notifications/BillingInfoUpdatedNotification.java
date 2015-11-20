package com.j3source.recurly.controllers.listener.events.notifications;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.j3source.recurly.controllers.listener.events.models.AccountE;

@XmlRootElement(name = "billing_info_updated_notification")
public class BillingInfoUpdatedNotification {
	@XmlElement(name = "account")
	private AccountE account;

	public AccountE getAccount() {
		return account;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("BillingInfoUpdatedNotification{");
		sb.append("account='").append(account.toString());
		sb.append('}');
		return sb.toString();
	}
}
