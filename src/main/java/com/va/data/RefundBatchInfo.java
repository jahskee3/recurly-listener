package com.va.data;

import java.io.Serializable;
import java.sql.Timestamp;

public class RefundBatchInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 223553119736085514L;
	public String _oid;
	public String _accountid;
	public String _orderid;
	public Timestamp _created;
	public Float _value;
	public Integer _batchnumber;
	public String _cardNumber;

	public String _memberID;
	public String _name;
	public String _lastName;

	public String _street;
	public String _street2;
	public String _city;
	public String _state;
	public String _postal;
	public String _country;
	public String _homephone;
	public String _workphone;
}
