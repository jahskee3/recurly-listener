package com.va.data;

import java.io.Serializable;
import java.io.Writer;
import java.sql.Date;
import java.sql.Timestamp;

import com.va.util.Debug;

public class AccountInfo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1554147571583958243L;

	public AccountInfo() {
	}

	public void dump(Writer writer) {
		Debug.objectDump(this, writer, "");
	}

	public String _oid;
	public String _status;
	public String _memberID;
	public String _amtrakID;
	public String _name;
	public String _initial;
	public String _lastName;
	public String _email;
	public String _password;
	public Boolean _optin;
	//public Boolean _optinRenewal;
	//public Boolean _optinPartner;
	public Boolean _htmlMail;
	public Timestamp _created;
	public String _gender;
	public Date _currentRegStart;
	public Date _currentRegEnd;
	public Date _nextRegEnd;
	public String _familyMember;
	public String _unit;
	public String _rank;
	public Integer _serviceFrom;
	public Integer _serviceTo;
	public String _serviceNumber;
	public String _veteranName;
	public Integer _pointsBalance;
	public Integer _nSuppCards;
	public String _first1;
	public String _last1;
	public String _first2;
	public String _last2;
	public String _first3;
	public String _last3;
	public String _first4;
	public String _last4;
	public Integer _promoAcStatus;
	public Integer _isAutoRenew;
	public String _currentOrderOID;
	public String _creditCardOID;
	public Date _dob;
	public Date _serviceDOB;
	public Float _planYears;
	public Boolean _isNewMember;
	public String _currentRegOID;
	public String _adminStatus;
	public String _autoRenewStatus;
	public String _autoRenewError;
	public String _autoRenewErrorMessage;
	public Timestamp _autoRenewDate;
	public Integer _processed;
	public Integer _campaignID;
	public Date _dateCancelled;
	public String _verifyStatus;
	public Date _verifyDate;
	public String _partnerCode;
	public Boolean _heardRecording;
	public String _agentID;
	public String _affiliateID;
	public String _channel;
	public String _customID;
	public Timestamp _expiryDate;
	public String _expiryReason;
	public Integer _gift;
	public Date _partnerUploadDate;
	public Integer _renewalLast;
	public String _ipAddress;
	public String _branch;
	public String _serviceEra;
	public Integer _isAffidavit;	
	public Integer _isDeadEmail;
	public Integer _isFreeMember;
	public Integer _duplicate;
	public String _ganClickId;
	public Date _lastLoginDate;
	public Integer _isEmailUpToDate;
	public Date _renewDate;
	public Date _receivablesDate;
	public String _preferredPaymentMethod;
	public Timestamp _modified_on;
	public String _rank_title;
	public String _passwordChangeCode;
	public String _family_member_firstname;
	public String _family_member_lastname;


	public String get_oid() {
		return _oid;
	}

	public String get_status() {
		if(_status==null)_status="";
		return _status;
	}

	public String get_memberID() {
		if(_memberID==null)_memberID="";
		return _memberID;
	}

	public String get_amtrakID() {
		if(_amtrakID==null)_amtrakID="";
		return _amtrakID;
	}

	public String get_name() {
		if(_name==null)_name="";
		return _name;
	}

	public String get_initial() {
		if(_initial==null)_initial="";
		return _initial;
	}

	public String get_lastName() {
		if(_lastName==null)_lastName="";
		return _lastName;
	}

	public String get_email() {
		if(_email==null)_email="";
		return _email;
	}

	public String get_password() {
		if(_password==null)_password="";
		return _password;
	}

	public Boolean get_optin() {
		return _optin;
	}

	public Boolean get_htmlMail() {
		return _htmlMail;
	}

	public Timestamp get_created() {
		return _created;
	}

	public String get_gender() {
		return _gender;
	}

	public Date get_currentRegStart() {
		return _currentRegStart;
	}

	public Date get_currentRegEnd() {
		return _currentRegEnd;
	}

	public Date get_nextRegEnd() {
		return _nextRegEnd;
	}

	public String get_familyMember() {
		if(_familyMember==null)_familyMember="";
		return _familyMember;
	}

	public String get_unit() {
		return _unit;
	}

	public String get_rank() {
		return _rank;
	}

	public Integer get_serviceFrom() {
		return _serviceFrom;
	}

	public Integer get_serviceTo() {
		return _serviceTo;
	}

	public String get_serviceNumber() {
		return _serviceNumber;
	}

	public String get_veteranName() {
		return _veteranName;
	}

	public Integer get_pointsBalance() {
		return _pointsBalance;
	}

	public Integer get_nSuppCards() {
		return _nSuppCards;
	}

	public String get_first1() {
		if(_first1==null)_first1="";
		return _first1;
	}

	public String get_last1() {
		if(_last1==null)_last1="";
		return _last1;
	}

	public String get_first2() {
		if(_first2==null)_first2="";
		return _first2;
	}

	public String get_last2() {
		if(_last2==null)_last2="";
		return _last2;
	}

	public String get_first3() {
		if(_first3==null)_first3="";
		return _first3;
	}

	public String get_last3() {
		if(_last3==null)_last3="";
		return _last3;
	}

	public String get_first4() {
		if(_first4==null)_first4="";
		return _first4;
	}

	public String get_last4() {
		if(_last4==null)_last4="";
		return _last4;
	}

	public Integer get_promoAcStatus() {
		return _promoAcStatus;
	}

	public Integer get_isAutoRenew() {
		return _isAutoRenew;
	}

	public String get_currentOrderOID() {
		return _currentOrderOID;
	}

	public String get_creditCardOID() {
		return _creditCardOID;
	}

	public Date get_dob() {
		return _dob;
	}

	public Date get_serviceDOB() {
		return _serviceDOB;
	}

	public Float get_planYears() {
		return _planYears;
	}

	public Boolean get_isNewMember() {
		return _isNewMember;
	}

	public String get_currentRegOID() {
		return _currentRegOID;
	}

	public String get_adminStatus() {
		return _adminStatus;
	}

	public String get_autoRenewStatus() {
		return _autoRenewStatus;
	}

	public String get_autoRenewError() {
		return _autoRenewError;
	}

	public String get_autoRenewErrorMessage() {
		return _autoRenewErrorMessage;
	}

	public Timestamp get_autoRenewDate() {
		return _autoRenewDate;
	}

	public Integer get_processed() {
		return _processed;
	}

	public Integer get_campaignID() {
		return _campaignID;
	}

	public Date get_dateCancelled() {
		return _dateCancelled;
	}

	public String get_verifyStatus() {
		return _verifyStatus;
	}

	public Date get_verifyDate() {
		return _verifyDate;
	}

	public String get_partnerCode() {
		if(_partnerCode==null)_partnerCode="";
		return _partnerCode;
	}

	public Boolean get_heardRecording() {
		return _heardRecording;
	}

	public String get_agentID() {
		return _agentID;
	}

	public String get_affiliateID() {
		return _affiliateID;
	}

	public String get_channel() {
		return _channel;
	}

	public String get_customID() {
		return _customID;
	}

	public Timestamp get_expiryDate() {
		return _expiryDate;
	}

	public String get_expiryReason() {
		return _expiryReason;
	}

	public Integer get_gift() {
		return _gift;
	}

	public Date get_partnerUploadDate() {
		return _partnerUploadDate;
	}

	public Integer get_renewalLast() {
		if(_renewalLast==null)_renewalLast=0;
		return _renewalLast;
	}

	public String get_ipAddress() {
		return _ipAddress;
	}

	public String get_branch() {
		return _branch;
	}

	public String get_serviceEra() {
		return _serviceEra;
	}

	public Integer get_isAffidavit() {
		return _isAffidavit;
	}

	public Integer get_isDeadEmail() {
		return _isDeadEmail;
	}
	
	public Integer get_isFreeMember() {
		if(_isFreeMember==null)_isFreeMember=0;
		return _isFreeMember;
	}

	public void set_isFreeMember(Integer _isFreeMember) {
		this._isFreeMember = _isFreeMember;
	}

	public Integer get_duplicate() {
		return _duplicate;
	}

	public void set_duplicate(Integer _duplicate) {
		this._duplicate = _duplicate;
	}	
	
	public String get_ganClickId() {
		return _ganClickId;
	}

	public void set_ganClickId(String _ganClickId) {
		this._ganClickId = _ganClickId;
	}

	public Date get_lastLoginDate() {
	    return _lastLoginDate;
	}

	public void set_lastLoginDate(Date _lastLoginDate) {
	    this._lastLoginDate = _lastLoginDate;
	}

	public Integer get_isEmailUpToDate() {
	    return _isEmailUpToDate;
	}

	public void set_isEmailUpToDate(Integer _isEmailUpToDate) {
	    this._isEmailUpToDate = _isEmailUpToDate;
	}

	public Date get_renewDate() {
		return _renewDate;
	}

	public void set_renewDate(Date _renewDate) {
	    this._renewDate= _renewDate;
	}
	
	public Date get_receivablesDate() {
		return _receivablesDate;
	}
	
	public void set_receivablesDate(Date _receivablesDate){
		this._receivablesDate = _receivablesDate;
	}

	public String get_PreferredPaymentMethod() {
		if (_preferredPaymentMethod == null || ("").equals(_preferredPaymentMethod)) {
			return "CreditCard";
		}
		return _preferredPaymentMethod;
	}

	public void set_PreferredPaymentMethod(String _preferredPaymentMethod) {
		this._preferredPaymentMethod = _preferredPaymentMethod;
	}

	public Timestamp get_modified_on() {
		return _modified_on;
	}

	public String get_rank_title() {
		return _rank_title;
	}
	
	public String get_passwordChangeCode(){
		return _passwordChangeCode;
	}
	
	public void set_passwordChangeCode(String code){
		this._passwordChangeCode = code;
	}

	public String get_family_member_firstname() {
		if(_family_member_firstname==null)_family_member_firstname="";
		return _family_member_firstname;
	}

	public String get_family_member_lastname() {
		if(_family_member_lastname==null)_family_member_lastname="";
		return _family_member_lastname;
	}

}
