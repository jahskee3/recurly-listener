package com.va.data;

import java.io.Serializable;
import java.sql.Timestamp;

public class PaypalTransactionInfo implements Serializable {

	private static final long serialVersionUID = 2611840702354233622L;

	public PaypalTransactionInfo() {
		_oid = null;
		_transactionType = null;
		_billingAgreementId = null;	//mp_id = billing Id
		_residenceCountry = null;
		_billingStatus = null;
		_verifySign = null;
		_payerId = null;
		_firstname = null;
		_mpCustom = null;
		_payerEmail = null;
		_mpCycleStart = null;
		_notifyVersion = null;
		_payerStatus = null;
		_lastname = null;
		_transactionDate = null;
		_other = null;
	}
	
	public String _oid;
	public String _transactionType;
	public String _billingAgreementId;	//mp_id = billing Id
	public String _residenceCountry;
	public String _billingStatus;
	public String _verifySign;
	public String _payerId;
	public String _firstname;
	public String _mpCustom;
	public String _payerEmail;
	public String _mpCycleStart;
	public String _notifyVersion;
	public String _payerStatus;
	public String _lastname;
	public Timestamp _transactionDate;
	public String _other;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String get_oid() {
		return _oid;
	}
	
	public String get_transactionType() {
		return _transactionType;
	}
	
	public String get_billingAgreementId() {
		return _billingAgreementId;
	}
	
	public String get_residenceCountry() {
		return _residenceCountry;
	}
	
	public String get_billingStatus() {
		return _billingStatus;
	}
	
	public String get_verifySign() {
		return _verifySign;
	}
	
	public String get_payerId() {
		return _payerId;
	}
	
	public String get_firstname() {
		return _firstname;
	}
	
	public String get_mpCustom() {
		return _mpCustom;
	}
	
	public String get_payerEmail() {
		return _payerEmail;
	}
	
	public String get_mpCycleStart() {
		return _mpCycleStart;
	}
	
	public String get_notifyVersion() {
		return _notifyVersion;
	}
	
	public String get_payerStatus() {
		return _payerStatus;
	}
	
	public String get_lastname() {
		return _lastname;
	}
	
	public Timestamp get_transactionDate() {
		return _transactionDate;
	}
	
	public String get_other() {
		return _other;
	}
}
