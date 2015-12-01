package com.va.recurly.models;

import java.io.Serializable;
import java.util.List;

import com.va.data.OrderItemInfo;

public class VASubscription implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String accountCode;
	private String partnerCode;
	private String primaryPlanCode;
	private double primaryAmount;
	private int months;
	private int orderCount;
	
	private List<OrderItemInfo> familyOrderItems;
	
	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	public String getPartnerCode() {
		return partnerCode;
	}
	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}
	public String getPrimaryPlanCode() {
		return primaryPlanCode;
	}
	public void setPrimaryPlanCode(String primaryPlanCode) {
		this.primaryPlanCode = primaryPlanCode;
	}
	public double getPrimaryAmount() {
		return primaryAmount;
	}
	public void setPrimaryAmount(double primaryAmount) {
		this.primaryAmount = primaryAmount;
	}
	public int getSuppCount() {
		return suppCount;
	}
	public void setSuppCount(int suppCount) {
		this.suppCount = suppCount;
	}
	public int getMonths() {
		return months;
	}
	public void setMonths(int months) {
		this.months = months;
	}
	private int suppCount;
	
	
	public List<OrderItemInfo> getFamilyOrderItems() {
		return familyOrderItems;
	}
	public void setFamilyOrderItems(List<OrderItemInfo> familyOrderItems) {
		this.familyOrderItems = familyOrderItems;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}


}
