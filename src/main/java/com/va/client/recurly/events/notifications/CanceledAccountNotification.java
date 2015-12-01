package com.va.client.recurly.events.notifications;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "canceled_account_notification")
public class CanceledAccountNotification extends BaseNotification{

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("CanceledAccountNotification{");
		sb.append("account='").append(this.getAccount().toString());
		sb.append('}');
		return sb.toString();
	}

}
