package com.va.vauser2.controller.recurlylistener.events.notifications;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.va.vauser2.controller.recurlylistener.events.models.AccountE;
import com.va.vauser2.controller.recurlylistener.events.models.SubscriptionE;


@XmlRootElement(name = "expired_subscription_notification")
public class ExpiredSubscriptionNotification {
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
		final StringBuilder sb = new StringBuilder("ExpiredSubscriptionNotification{");
		sb.append("account='").append(this.getAccount().toString());
		sb.append(", subscription='").append(this.getSubscription().toString());
		sb.append('}');
		return sb.toString();
	}	
}
