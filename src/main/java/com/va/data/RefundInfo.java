package com.va.data;

import java.io.Serializable;
import java.sql.Timestamp;

public class RefundInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4135758534082767577L;
	public String _oid;
	public String _accountid;
	public String _orderid;
	public Timestamp _created;
	public Float _value;
	public Integer _batchnumber;
}
