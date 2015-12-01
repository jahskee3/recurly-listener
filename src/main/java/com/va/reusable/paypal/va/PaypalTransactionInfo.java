
// Source File Name:   CCTransactionInfo.java

package com.va.reusable.paypal.va;

import java.io.Serializable;

public class PaypalTransactionInfo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 3727828762811190793L;

	public PaypalTransactionInfo() {
		_state = 0;
		_amount = 0.0F;
		_currency = "usd";
	}

	/* Order */
	public String _orderID;
	public float _amount;
	public String _currency;
	public String _billingAgreementId;
	public String _paypalTokenId;

	/* Billing Address */
	public String _paypalname;
	public String _paypalstreet;
	public String _paypalcity;
	public String _paypalstate;
	public String _paypalcountry;
	public String _paypalzip;

	public String _paypalEmail;
	public String _payerId;
	
	public String _transactionId;
	public int _state;
	public String _userParam;
	public String _status;
	public String _reason;
	public int _errorCode;
	public String _billingDescriptor;
	public String _source;
	public String _reportingGroup;
	public String _gateway;
	
	
}
