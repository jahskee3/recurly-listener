
// Source File Name:   RegistrationInfo.java

package com.va.data;

import java.io.Serializable;
import java.util.Date;

public class RegistrationInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5881055494110821875L;

	public RegistrationInfo() {
		_oid = null;
		_accountid = null;
		_start = null;
		_end = null;
		_status = null;
		_planYears = null;
	}

	public String _oid;
	public String _accountid;
	public Date _start;
	public Date _end;
	public String _status;
	public Float _planYears;
}
