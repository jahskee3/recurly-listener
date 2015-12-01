
// Source File Name:   CCTransactionInfo.java

package com.va.reusable.cc;

import java.io.Serializable;

public class CCTransactionInfo implements Serializable, CCConstants {

	/**
	 *
	 */
	private static final long serialVersionUID = 3727828762811190793L;

	public CCTransactionInfo() {
		_state = 0;
		_amount = 0.0F;
		_currency = "usd";
	}

	/* Order */
	public String _orderID;
	public float _amount;
	public String _currency;

	/* Billing Address */
	public String _cardName;
	public String _cardStreet;
	public String _cardStreet2;
	public String _cardCity;
	public String _cardState;
	public String _cardCountry;

	public String _phone;
	public String _cardBillingPhone;
	public String _email;

	/* Credit Card */
	public String _cardType;
	public String _cardNumber;
	public int _expiryMonth;
	public int _expiryYear;
	public boolean _expiryDateChanged;
	public String _billingDescriptor;
	public String _reportingGroup;

	/* Transaction Data */
	public int _state;
	public String _userParam;
	public String _status;
	public String _reason;
	public int _errorCode;
	public String _cardZip;
	public boolean _hardDecline;
	// public long _transactionId;
	public String _transactionId;

	/* Multi-charges */
	public float _total;

	/* credit card Manager */
	public String _gateway;

	/* Source */
	public String _source;
}
