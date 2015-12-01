
// Source File Name:   CardOrderInfo.java

package com.va.data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class CardOrderInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7662509210810904467L;

	public CardOrderInfo() {
		_oid = null;
		_accountid = null;
		_cardorderid = null;
		_status = null;
		_cardType = null;
		_payTime = null;
		_printTime = null;
		_shipaddress = null;
		_batchnumber = null;
		_name = null;
		_lastName = null;
		_memberID = null;
		_amtrakID = null;
		_start = null;
		_end = null;
		_initial = null;
		_isRenewal = null;
		_source = null;
	}

	public String _oid;
	public String _accountid;
	public String _cardorderid;
	public String _status;
	public String _cardType;
	public Timestamp _payTime;
	public Timestamp _printTime;
	public String _shipaddress;
	public Integer _batchnumber;
	public String _name;
	public String _lastName;
	public String _memberID;
	public String _amtrakID;
	public Date _start;
	public Date _end;
	public String _initial;
	public Boolean _isRenewal;
	public String _source;
}
