
// Source File Name:   AddressInfo.java

package com.va.data;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

public class AddressInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8968326693193239186L;

	public AddressInfo() {
	}
	public String _oid;
	public String _accountid;
	public String _street;
	public String _street2;
	public String _city;
	public String _state;
	public String _postal;
	public String _country;
	public String _homephone;
	public String _workphone;
	public String _mobilephone;
	public Timestamp _modified_on; 	
	
	public String get_street() {
		if(_street==null)return "";
		return StringUtils.trimToEmpty(_street);
	}
	public String get_street2() {
		if(_street2==null)return "";
		return StringUtils.trimToEmpty(_street2);
	}
	public String get_city() {
		if(_city==null)return "";
		return StringUtils.trimToEmpty(_city);
	}
	public String get_state() {
		if(_state==null)return "";
		return StringUtils.trimToEmpty(_state);
	}
	public String get_postal() {
		if(_postal==null)return "";
		return StringUtils.trimToEmpty(_postal);
	}
	public String get_country() {
		if(_country==null)return "";
		return StringUtils.trimToEmpty(_country);
	}
	public String get_homephone() {
		if(_homephone==null)return "";
		return StringUtils.trimToEmpty(_homephone);
	}
	public String get_workphone() {
		if(_workphone==null)return "";
		return StringUtils.trimToEmpty(_workphone);
	}
	public String get_mobilephone() {
		if(_mobilephone==null)return "";
		return StringUtils.trimToEmpty(_mobilephone);
	}	
	public Timestamp get_modified_on() {
		return _modified_on;
	}
}
