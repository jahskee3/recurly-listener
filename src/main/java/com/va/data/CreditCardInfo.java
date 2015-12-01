package com.va.data;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.va.reusable.cc.CreditCardUtil;

public class CreditCardInfo implements Serializable {

	
	private static final long serialVersionUID = -2232848002980153842L;

	public CreditCardInfo() {
		_oid = null;
		_accountid = null;
		_name = null;
		_street = null;
		_street2 = null;
		_city = null;
		_zipcode = null;
		_state = null;
		_country = null;
		_cardType = null;
		_cardNumber = null;
		_expMonth = null;
		_expYear = null;
		_billingPhone = null;
	}

	public String _oid;
	public String _accountid;
	public String _name;
	public String _street;
	public String _street2;
	public String _city;
	public String _zipcode;
	public String _state;
	public String _country;
	public String _cardType;
	public String _cardNumber;
	public Integer _expMonth;
	public Integer _expYear;
	public String _billingPhone;

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
	public String get_street2() {
		if(_street2==null) return "";
		return _street2;
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
	public String get_billingPhone() {
		if(_billingPhone==null) return "";
		return _billingPhone;
	}
	public String get_cardType() {
		if(_cardType==null) return "";
		return _cardType;
	}
	public String get_cardNumber() {
		if(_cardNumber==null)return "";
		return _cardNumber.trim();
	}
	public Integer get_expMonth() {
		if(_expMonth==null)_expMonth=0;
		return _expMonth;
	}
	public Integer get_expYear() {
		if(_expYear==null)_expYear=0;
		return _expYear;
	}
	
	public String getObscuredCardNumber() {
		// Although the original method passed in the characters to use to mask
		// and the length, this is no longer necessary
		if ( this._cardNumber== null)
			return null;
		
		return CreditCardUtil.crossOutCardNumber(this._cardNumber);
	}	
	
	public String get4DigitCardNumber(){
		if (StringUtils.isBlank(this._cardNumber))
			return "";
		
		return CreditCardUtil.get4DigitsCardNumber(this._cardNumber);
	}
	
	
}
