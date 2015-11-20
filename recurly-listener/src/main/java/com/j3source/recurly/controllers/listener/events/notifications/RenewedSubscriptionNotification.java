package com.j3source.recurly.controllers.listener.events.notifications;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.j3source.recurly.controllers.listener.events.models.AccountE;
import com.j3source.recurly.controllers.listener.events.models.SubscriptionE;

@XmlRootElement(name = "renewed_subscription_notification")
public class RenewedSubscriptionNotification {
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
		final StringBuilder sb = new StringBuilder("RenewedSubscriptionNotification{");
		sb.append("account='").append(this.getAccount().toString());
		sb.append(", subscription='").append(this.getSubscription().toString());
		sb.append('}');
		return sb.toString();
	}	
}