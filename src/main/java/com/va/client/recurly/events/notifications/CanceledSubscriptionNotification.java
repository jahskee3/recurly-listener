package com.va.client.recurly.events.notifications;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.va.client.recurly.events.models.SubscriptionE;




@XmlRootElement(name = "canceled_subscription_notification")
public class CanceledSubscriptionNotification extends BaseNotification{

	@XmlElement(name = "subscription")
	private SubscriptionE subscription;
	

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
