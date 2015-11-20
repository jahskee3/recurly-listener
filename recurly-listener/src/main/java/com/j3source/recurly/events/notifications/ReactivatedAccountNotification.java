package com.j3source.recurly.events.notifications;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.j3source.recurly.events.models.AccountE;
import com.j3source.recurly.events.models.SubscriptionE;

@XmlRootElement(name = "reactivated_account_notification")
public class ReactivatedAccountNotification {
	
	@XmlElement(name = "account")
	private AccountE account;
	
	@XmlElement(name = "subscription")
	private SubscriptionE subscription;
	
	public AccountE getAccount() {
		return account;
	}

	public SubscriptionE getSubscription() {
		return subscription;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("NewAccountNotification{");
		sb.append(", account='").append(this.getAccount().toString());
		sb.append(", subscription='").append(this.getSubscription().toString());
		sb.append('}');
		return sb.toString();
	}
}
