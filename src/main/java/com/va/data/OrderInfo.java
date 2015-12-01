package com.va.data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import com.va.core.Constants;

/**
 * <p>
 * OrderInfo appears to be a value object for an OrderBean object which
 * represents and order.
 * </p>
 *
 * <p>
 * No validation is performed in this value object.
 * </p>
 *
 * <p>
 * This class is not designed for subclassing.
 * </p>
 *
 * @author unknown, alan
 *
 */
public class OrderInfo implements Serializable {
	private static final long serialVersionUID = -1475245188885981174L;

	/**
	 * The following 14 attribute fields map to the OrderBean fields. These
	 * values will be persisted if given to an OrderBean object to update.
	 */

	/** The unique id of the order */
	public String _oid;
	/** The id of the account that owns this order */
	public String _accountid;
	/** The id of the order. This is different thatn oid; unknown why. */
	public String _orderid;
	/** The sum of all the order items for this order */
	public Float _value;
	/** The datetime when this order was created */
	public Timestamp _created;
	/** TODO Unknown what this is used for */
	public Date _holdToDate;
	/** TODO Unknown what this is used for */
	public String _promocode;
	/**
	 * The status of the order. Currently they are 'Pending', 'Complete',
	 * 'Cancelled', 'Refunded', 'Failed' and 'Held'
	 */
	public String _status;
	/**
	 * Defines how the order was created. Currently they are 'System', 'Web',
	 * 'Call' and 'Auto'.
	 */
	public String _source;
	/** The id of the linkshare affiliate, if any, that referred this order. */
	public String _paymentID;
	/** The id of the linkshare affiliate, if any, that referred this order. */
	public String _affiliateSiteID;
	/** The datetime this order was referred to the site by the affiliate */
	public Timestamp _affiliateRefTime;
	/** Unknow what this is used for. TODO Investigate usage. */
	public Timestamp _lastModified;
	/** Unknow what this is used for. TODO Investigate usage. */
	public String _partnerID;

	/* FIXME: Unknown to what database table the following fields map to. */
	/*
	 * XXX: 7/21/2006 - discovered that these fields were added to acommodate a
	 * big sql join in the FindOrder transaction class.
	 */
	public Timestamp _createdFrom;
	public Timestamp _createdTo;
	public boolean _verifyPayment;
	public String _salesType;
	public String _salesSubType;
	public String _memberid;
	public String _name;
	public String _lastname;
	public String _email;
	public String _acstatus;
	public String _city;
	public String _phone;
	public String _cardType;
	public Timestamp _paymentDate;

	public String _notes;
	public String _cctransid;

	/** Hold the value for primary order; 1 is primary and 0 is not */
	public Integer _primaryOrder;
	public Integer _retry;
	public String _browser;
	public Integer _isGan;
	
	public String _billingAgreementId;
	/**
	 * </p>Constructor for the OrderInfo value object. Default values are
	 * assigned.</p>
	 *
	 */
	public OrderInfo() {
		// Set the default settings for an OrderInfo item.

		/*
		 * The following attributes map to columns in the 'custorder' table in
		 * the database.
		 */
		_oid = null;
		_accountid = null;
		_orderid = null;
		_value = new Float(0.0F);
		_created = null;
		_holdToDate = null;
		_promocode = null;
		_status = Constants.ORDER_STATUS_PENDING;
		_source = "System";
		_paymentID = null;
		_affiliateSiteID = null;
		_affiliateRefTime = null;
		_lastModified = null;
		_partnerID = null;
		/* End 'custorder' table mapping */

		/* FIXME: Unknown to what datbase table the following fields map to. */
		_createdFrom = null;
		_createdTo = null;
		_verifyPayment = false;
		_salesType = null;
		_salesSubType = null;
		_memberid = null;
		_name = null;
		_lastname = null;
		_email = null;
		_acstatus = null;
		_city = null;
		_phone = null;

		_notes = null;
		_cctransid = null;
		_primaryOrder = null;
		_retry = null;		
		_isGan = null;
	}

	public void clear() {
		_source = null;
		_status = null;
		_value = null;
		_created = null;
	}

	//======= Getters and Setters =======
	public String get_oid() {
		return _oid;
	}

	public void set_oid(String _oid) {
		this._oid = _oid;
	}

	public String get_accountid() {
		return _accountid;
	}

	public void set_accountid(String _accountid) {
		this._accountid = _accountid;
	}

	public String get_orderid() {
		return _orderid;
	}

	public void set_orderid(String _orderid) {
		this._orderid = _orderid;
	}

	public Float get_value() {
		return _value;
	}

	public void set_value(Float _value) {
		this._value = _value;
	}

	public Timestamp get_created() {
		return _created;
	}

	public void set_created(Timestamp _created) {
		this._created = _created;
	}

	public Date get_holdToDate() {
		return _holdToDate;
	}

	public void set_holdToDate(Date _holdToDate) {
		this._holdToDate = _holdToDate;
	}

	public String get_promocode() {
		return _promocode;
	}

	public void set_promocode(String _promocode) {
		this._promocode = _promocode;
	}

	public String get_status() {
		return _status;
	}

	public void set_status(String _status) {
		this._status = _status;
	}

	public String get_source() {
		return _source;
	}

	public void set_source(String _source) {
		this._source = _source;
	}

	public String get_paymentID() {
		return _paymentID;
	}

	public void set_paymentID(String _paymentID) {
		this._paymentID = _paymentID;
	}

	public String get_affiliateSiteID() {
		return _affiliateSiteID;
	}

	public void set_affiliateSiteID(String _affiliateSiteID) {
		this._affiliateSiteID = _affiliateSiteID;
	}

	public Timestamp get_affiliateRefTime() {
		return _affiliateRefTime;
	}

	public void set_affiliateRefTime(Timestamp _affiliateRefTime) {
		this._affiliateRefTime = _affiliateRefTime;
	}

	public Timestamp get_lastModified() {
		return _lastModified;
	}

	public void set_lastModified(Timestamp _lastModified) {
		this._lastModified = _lastModified;
	}

	public String get_partnerID() {
		return _partnerID;
	}

	public void set_partnerID(String _partnerID) {
		this._partnerID = _partnerID;
	}

	public Timestamp get_createdFrom() {
		return _createdFrom;
	}

	public void set_createdFrom(Timestamp _createdFrom) {
		this._createdFrom = _createdFrom;
	}

	public Timestamp get_createdTo() {
		return _createdTo;
	}

	public void set_createdTo(Timestamp _createdTo) {
		this._createdTo = _createdTo;
	}

	public boolean is_verifyPayment() {
		return _verifyPayment;
	}

	public void set_verifyPayment(boolean _verifyPayment) {
		this._verifyPayment = _verifyPayment;
	}

	public String get_salesType() {
		return _salesType;
	}

	public void set_salesType(String _salesType) {
		this._salesType = _salesType;
	}

	public String get_salesSubType() {
		return _salesSubType;
	}

	public void set_salesSubType(String _salesSubType) {
		this._salesSubType = _salesSubType;
	}

	public String get_memberid() {
		return _memberid;
	}

	public void set_memberid(String _memberid) {
		this._memberid = _memberid;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String get_lastname() {
		return _lastname;
	}

	public void set_lastname(String _lastname) {
		this._lastname = _lastname;
	}

	public String get_email() {
		return _email;
	}

	public void set_email(String _email) {
		this._email = _email;
	}

	public String get_acstatus() {
		return _acstatus;
	}

	public void set_acstatus(String _acstatus) {
		this._acstatus = _acstatus;
	}

	public String get_city() {
		return _city;
	}

	public void set_city(String _city) {
		this._city = _city;
	}

	public String get_phone() {
		return _phone;
	}

	public void set_phone(String _phone) {
		this._phone = _phone;
	}

	public String get_cardType() {
		return _cardType;
	}

	public void set_cardType(String _cardType) {
		this._cardType = _cardType;
	}

	public Timestamp get_paymentDate() {
		return _paymentDate;
	}

	public void set_paymentDate(Timestamp _paymentDate) {
		this._paymentDate = _paymentDate;
	}

	public String get_notes() {
		return _notes;
	}

	public void set_notes(String _notes) {
		this._notes = _notes;
	}

	public String get_cctransid() {
		return _cctransid;
	}

	public void set_cctransid(String _cctransid) {
		this._cctransid = _cctransid;
	}

	public Integer get_primaryOrder() {
		return _primaryOrder;
	}

	public void set_primaryOrder(Integer _primaryOrder) {
		this._primaryOrder = _primaryOrder;
	}

	public Integer get_retry() {
		return _retry;
	}

	public void set_retry(Integer _retry) {
		this._retry = _retry;
	}

	public String get_browser() {
		return _browser;
	}

	public void set_browser(String _browser) {
		this._browser = _browser;
	}

	public Integer get_isGan() {
		if(this._isGan==null)this._isGan=0;
		return this._isGan;
	}

	public void set_isGan(Integer _isGan) {
		this._isGan = _isGan;
	}
	
	public void set_billingAgreementId(String _billingAgreementId) {
		this._billingAgreementId = _billingAgreementId;
	}
	
	public String get_billingAgreementId() {
		return this._billingAgreementId;
	}
	
}
