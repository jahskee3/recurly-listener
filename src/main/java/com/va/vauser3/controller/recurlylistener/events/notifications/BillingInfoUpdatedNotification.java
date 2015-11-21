package com.va.vauser3.controller.recurlylistener.events.notifications;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.va.vauser3.controller.recurlylistener.events.models.AccountE;

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
