package com.j3source.recurly.controllers.listener.events.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;

@XmlRootElement(name = "subscription")
public class SubscriptionE {
	
	@XmlElement(name = "plan")
	private PlanE plan;
	
	@XmlElement(name = "uuid")
	private String uuid;
	
	@XmlElement(name = "state")
	private String state;
	
	@XmlElement(name = "quantity")
	private Integer quantity;
	
	@XmlElement(name = "total_amount_in_cents")
	private Integer totalAmountInCents;
	
	@XmlElement(name = "activated_at")
	private DateTime activatedAt;
	
	@XmlElement(name = "canceled_at")
	private DateTime canceledAt;
	
	@XmlElement(name = "expires_at")
	private DateTime expiresAt;
	
	@XmlElement(name = "current_period_started_at")
	private DateTime currentPeriodStartedAt;
	
	@XmlElement(name = "current_period_ends_at")
	private DateTime currentPeriodEnds;
	
	@XmlElement(name = "trial_started_at")
	private DateTime trialStartedAt;
	
	@XmlElement(name = "trial_ends_at")
	private DateTime trialEndsAt;
	
	@XmlElement(name = "collection_method")
	private String collectionMethod;

	public PlanE getPlan() {
		return plan;
	}

	public String getUuid() {
		return uuid;
	}

	public String getState() {
		return state;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Integer getTotalAmountInCents() {
		return totalAmountInCents;
	}

	public DateTime getActivatedAt() {
		return activatedAt;
	}

	public DateTime getCanceledAt() {
		return canceledAt;
	}

	public DateTime getExpiresAt() {
		return expiresAt;
	}

	public DateTime getCurrentPeriodStartedAt() {
		return currentPeriodStartedAt;
	}

	public DateTime getCurrentPeriodEnds() {
		return currentPeriodEnds;
	}

	public DateTime getTrialStartedAt() {
		return trialStartedAt;
	}

	public DateTime getTrialEndsAt() {
		return trialEndsAt;
	}

	public String getCollectionMethod() {
		return collectionMethod;
	}	

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("AccountE{");
		sb.append("plan='").append(this.getPlan().toString()).append('\'');
		sb.append(", uuid='").append(this.getUuid()).append('\'');
		sb.append(", state='").append(this.getState()).append('\'');
		sb.append(", quantity='").append(this.getQuantity()).append('\'');
		sb.append(", totalAmountInCents='").append(this.getTotalAmountInCents()).append('\'');
		sb.append(", activatedAt='").append(this.getActivatedAt()).append('\'');
		sb.append(", canceledAt='").append(this.getCanceledAt()).append('\'');
		sb.append(", expiresAt='").append(this.getExpiresAt()).append('\'');
		sb.append(", currentPeriodStartedAt='").append(this.getCurrentPeriodStartedAt()).append('\'');
		sb.append(", currentPeriodEndsAt='").append(this.getCurrentPeriodEnds()).append('\'');
		sb.append(", trialStartedAt='").append(this.getTrialStartedAt()).append('\'');
		sb.append(", trialEndsAt='").append(this.getTrialEndsAt()).append('\'');
		sb.append(", collectionMethod='").append(this.getCollectionMethod()).append('\'');		
		sb.append('}');
		return sb.toString();
	}
	
}
