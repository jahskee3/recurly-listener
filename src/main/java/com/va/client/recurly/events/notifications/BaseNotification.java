package com.va.client.recurly.events.notifications;

import javax.xml.bind.annotation.XmlElement;

import com.va.client.recurly.events.models.AccountE;



public class BaseNotification {

	@XmlElement(name = "account")
	private AccountE account;

	public AccountE getAccount() {
		return account;
	}
}
