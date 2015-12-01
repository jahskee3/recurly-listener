package com.va.recurly.models;

import com.va.data.OrderItemInfo;

public class PaymentR {	
	
	private String accountCode;
	private OrderItemInfo[] orderItems;
	private String partner;

	public OrderItemInfo[] getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(OrderItemInfo[] orderItems) {
		this.orderItems = orderItems;
	}
	public String getPartner() {
		if(partner==null)partner="";
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	
}
