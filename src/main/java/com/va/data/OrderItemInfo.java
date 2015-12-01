package com.va.data;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public class OrderItemInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3853106115049359330L;

	public OrderItemInfo() {
		_oid = null;
		_orderid = null;
		_product = null;
		_quantity = null;
		_linkOID = null;
		_name = null;
		_lastName = null;
		_value = new Float(0.0F);
//		_unpaid = null;
	}

	public String _oid;
	public String _orderid;
	public String _product;
	public Integer _quantity;
	public String _linkOID;
	public String _name;
	public String _lastName;
	public Float _value;
//	public Boolean _unpaid;

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
