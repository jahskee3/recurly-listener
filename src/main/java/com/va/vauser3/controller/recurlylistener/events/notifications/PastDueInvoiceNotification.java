package com.va.vauser3.controller.recurlylistener.events.notifications;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.va.vauser3.controller.recurlylistener.events.models.AccountE;
import com.va.vauser3.controller.recurlylistener.events.models.InvoiceE;


@XmlRootElement(name = "past_due_invoice_notification")
public class PastDueInvoiceNotification {
	
	@XmlElement(name = "account")
	private AccountE account;
	
	@XmlElement(name = "invoice")
	private InvoiceE invoice;
	
	public AccountE getAccount() {
		return account;
	}
	public InvoiceE getInvoice() {
		return invoice;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("PastDueInvoiceNotification{");
		sb.append("account='").append(this.getAccount().toString());
		sb.append(", invoice='").append(this.getInvoice().toString());
		sb.append('}');
		return sb.toString();
	}
	
}
