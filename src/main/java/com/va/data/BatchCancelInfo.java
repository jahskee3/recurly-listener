package com.va.data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class BatchCancelInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7183240750003379753L;
	public Timestamp _created;
	public String _oid;
	public String _name;
	public String _lastName;
	public String _memberID;
	public String _email;
	public String _homephone;
	public String _workphone;
	public String _refundType;
	public Integer _batchnumber;
	public Date _cancellationDate;
	public String _zipCode;

}
