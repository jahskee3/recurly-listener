package com.va.data;

import java.io.Serializable;
import java.io.Writer;
import java.sql.Date;
import java.sql.Timestamp;

import com.va.util.Debug;

public class RenewalInfo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1554147571583958243L;

	public RenewalInfo() {
	}

	public void dump(Writer writer) {
		Debug.objectDump(this, writer, "");
	}

	public String _memberID;
	public String _amtrakID;
	public String _name;
	public String _lastName;
	public String _partnerDir;
	public String _expiryDate;
	

	public String get_memberID() {
		if(_memberID==null)_memberID="";
		return _memberID;
	}

	public String get_amtrakID() {
		return _amtrakID;
	}

	public String get_name() {
		if(_name==null)_name="";
		return _name;
	}

	public String get_lastName() {
		if(_lastName==null)_lastName="";
		return _lastName;
	}

	public String get_partnerDir() {
		if(_partnerDir==null)_partnerDir="";
		return _partnerDir;
	}	
	
}
