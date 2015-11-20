package com.j3source.recurly.controllers.listener.events.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;

@XmlRootElement(name = "transaction")
public class TransactionE {

	@XmlElement(name = "id")
	private String id;
	
	@XmlElement(name = "invoice_id")
	private String invoiceId;
	
	@XmlElement(name = "invoice_number")
	private Integer invoiceNumber;
	
	@XmlElement(name = "subscription_id")
	private String subscriptionId;
	
	@XmlElement(name = "action")
	private String action;
	
	@XmlElement(name = "date")
	private DateTime date;
	
	@XmlElement(name = "amount_in_cents")
	private Integer amountInCents;
	
	@XmlElement(name = "status")
	private String status;
	
	@XmlElement(name = "message")
	private String message;
	
	@XmlElement(name = "reference")
	private String reference;
	
	@XmlElement(name = "source")
	private String source;
	
	@XmlElement(name = "cvv_result")
	private String cvvResult;
	
	@XmlElement(name = "avs_result")
	private String avsResult;
	
	@XmlElement(name = "avs_result_street")
	private String avsResultStreet;
	
	@XmlElement(name = "avs_result_postal")
	private String avsResultPostal;
	
	@XmlElement(name = "test")
	private Boolean test;
	
	@XmlElement(name = "voidable")
	private Boolean voidable;
	
	@XmlElement(name = "refundable")
	private Boolean refundable;
	
	@XmlElement(name = "manually_entered")
	private Boolean manuallyEntered;
	
	@XmlElement(name = "payment_method")
	private String paymentMethod;
	
	public String getId() {
		return id;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public Integer getInvoiceNumber() {
		return invoiceNumber;
	}

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public String getAction() {
		return action;
	}

	public DateTime getDate() {
		return date;
	}

	public Integer getAmountInCents() {
		return amountInCents;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public String getReference() {
		return reference;
	}

	public String getSource() {
		return source;
	}

	public String getCvvResult() {
		return cvvResult;
	}

	public String getAvsResult() {
		return avsResult;
	}

	public String getAvsResultStreet() {
		return avsResultStreet;
	}

	public String getAvsResultPostal() {
		return avsResultPostal;
	}

	public Boolean getTest() {
		return test;
	}

	public Boolean getVoidable() {
		return voidable;
	}

	public Boolean getRefundable() {
		return refundable;
	}

	public Boolean getManuallyEntered() {
		return manuallyEntered;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("TransactionE{");
		sb.append("id='").append(this.getId()).append('\'');
		sb.append("invoiceId='").append(this.getInvoiceId()).append('\'');
		sb.append("invoiceNumber='").append(this.getInvoiceNumber()).append('\'');
		sb.append("subscriptionId='").append(this.getSubscriptionId()).append('\'');
		sb.append("action='").append(this.getAction()).append('\'');
		sb.append("date='").append(this.getDate()).append('\'');
		sb.append("amountInCents='").append(this.getAmountInCents()).append('\'');
		sb.append("status='").append(this.getStatus()).append('\'');
		sb.append("message='").append(this.getMessage()).append('\'');
		sb.append("reference='").append(this.getReference()).append('\'');
		sb.append("subscription='").append(this.getSubscriptionId()).append('\'');
		sb.append("cvvResult='").append(this.getCvvResult()).append('\'');
		sb.append("avsResult='").append(this.getAvsResult()).append('\'');
		sb.append("avsResultStreet='").append(this.getAvsResultStreet()).append('\'');
		sb.append("avsResultPostal='").append(this.getAvsResultPostal()).append('\'');
		sb.append("test='").append(this.getTest()).append('\'');
		sb.append("voidable='").append(this.getVoidable()).append('\'');
		sb.append("refundable='").append(this.getRefundable()).append('\'');
		sb.append("manuallyEntered='").append(this.getManuallyEntered()).append('\'');
		sb.append("paymentMethod='").append(this.getPaymentMethod()).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
