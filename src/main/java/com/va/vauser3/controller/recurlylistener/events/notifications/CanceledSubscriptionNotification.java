package com.va.vauser3.controller.recurlylistener.events.notifications;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.va.vauser3.controller.recurlylistener.events.models.AccountE;
import com.va.vauser3.controller.recurlylistener.events.models.SubscriptionE;



@XmlRootElement(name = "canceled_subscription_notification")
public class CanceledSubscriptionNotification {
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
		final StringBuilder sb = new StringBuilder("CanceledSubscriptionNotification{");
		sb.append("account='").append(this.getAccount().toString());
		sb.append(", subscription='").append(this.getSubscription().toString());
		sb.append('}');
		return sb.toString();
	}	
}
