package com.va.client.recurly.events.notifications;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "new_account_notification")
public class NewAccountNotification extends BaseNotification{
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("NewAccountNotification{");
		sb.append("account='").append(this.getAccount().toString());
		sb.append('}');
		return sb.toString();
	}
}
