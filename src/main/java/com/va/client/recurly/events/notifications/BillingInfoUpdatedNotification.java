package com.va.client.recurly.events.notifications;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "billing_info_updated_notification")
public class BillingInfoUpdatedNotification extends BaseNotification{

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("BillingInfoUpdatedNotification{");
		sb.append("account='").append(this.getAccount().toString());
		sb.append('}');
		return sb.toString();
	}
}
