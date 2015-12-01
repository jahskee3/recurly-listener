package com.va.data;

import java.io.Serializable;

public class PaypalInfo implements Serializable {

	
	private static final long serialVersionUID = -2232848002980153842L;

	public PaypalInfo() {
		_oid = null;
		_accountid = null;
		_name = null;
		_street = null;
		_city = null;
		_zipcode = null;
		_state = null;
		_country = null;
		_paypalemail = null;
		_billingAgreementId = null;
		_payerid = null;
	}

	public String _oid;
	public String _accountid;
	public String _name;
	public String _street;
	public String _city;
	public String _zipcode;
	public String _state;
	public String _country;
	public String _paypalemail;
	public String _payerid;
	public String _billingAgreementId;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String get_oid() {
		return _oid;
	}
	public String get_accountid() {
		return _accountid;
	}
	public String get_name() {
		if(_name==null)return "";
		return _name;
	}
	public String get_street() {
		if(_street==null)return "";
		return _street;
	}
	public String get_city() {
		if(_city==null) return "";
		return _city;
	}
	public String get_zipcode() {
		if(_zipcode==null) return "";
		return _zipcode;
	}
	public String get_state() {
		if(_state==null) return "";
		return _state;
	}
	public String get_country() {
		if(_country==null) return "";
		return _country;
	}
	public String get_paypalemail() {
		if(_paypalemail==null) return "";
		return _paypalemail;
	}
	public String get_payerid() {
		if(_payerid==null)return "";
		return _payerid.trim();
	}
	public String get_billingAgreementId() {
		if (_billingAgreementId==null) return "";
		return _billingAgreementId;
	}
}
