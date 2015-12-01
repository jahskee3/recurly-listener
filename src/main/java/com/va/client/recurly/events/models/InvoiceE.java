package com.va.client.recurly.events.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;

@XmlRootElement(name = "invoice")
public class InvoiceE {

	@XmlElement(name = "uuid")
	private String uuid;
	
	@XmlElement(name = "subscription_id")
	private String subscriptionId;
	
	@XmlElement(name = "state")
	private String state;
	
	@XmlElement(name = "invoice_number_prefix")
	private String invoiceNumberPrefix;
	
	@XmlElement(name = "invoice_number")
	private Integer invoiceNumber;

	@XmlElement(name = "po_number")
	private String poNumber;
	
	@XmlElement(name = "vat_number")
	private String vatNumber;
	
	@XmlElement(name = "total_in_cents")
	private Integer totalInCents;
	
	@XmlElement(name = "currency")
	private String currency;
	
	@XmlElement(name = "date")
	private DateTime date;
	
	@XmlElement(name = "closed_at")
	private DateTime closedAt;
	 
	@XmlElement(name = "net_terms_type")
	private Integer netTerms;	
	
	@XmlElement(name = "collection_method")
	private String collectionMethod;
	    
	    
	public String getUuid() {
		return uuid;
	}

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public String getState() {
		return state;
	}

	public String getInvoiceNumberPrefix() {
		return invoiceNumberPrefix;
	}

	public Integer getInvoiceNumber() {
		return invoiceNumber;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public Integer getTotalInCents() {
		return totalInCents;
	}

	public String getCurrency() {
		return currency;
	}

	public DateTime getDate() {
		return date;
	}

	public DateTime getClosedAt() {
		return closedAt;
	}
	
	public Integer getNetTerms() {
		return netTerms;
	}

	public String getCollectionMethod() {
		return collectionMethod;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("InvoiceE{");
		sb.append("uuid='").append(this.getUuid()).append('\'');
		sb.append("subscriptionId='").append(this.getSubscriptionId()).append('\'');
		sb.append("state='").append(this.getState()).append('\'');
		sb.append("invoiceNumberPrefix='").append(this.getInvoiceNumberPrefix()).append('\'');
		sb.append("invoiceNumber='").append(this.getInvoiceNumber()).append('\'');
		sb.append("poNumber='").append(this.getPoNumber()).append('\'');
		sb.append("vatNumber='").append(this.getVatNumber()).append('\'');
		sb.append("totalInCents='").append(this.getTotalInCents()).append('\'');
		sb.append("currency='").append(this.getCurrency()).append('\'');
		sb.append("date='").append(this.getDate()).append('\'');
		sb.append("closedAt='").append(this.getClosedAt()).append('\'');
		sb.append("netTerms='").append(this.getNetTerms()).append('\'');
		sb.append("collectionMethod='").append(this.getCollectionMethod()).append('\'');
		sb.append('}');
		return sb.toString();
	}
	
}
