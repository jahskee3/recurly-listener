
// Source File Name:   PaymentInfo.java

package com.va.data;

import java.io.Serializable;
import java.sql.Timestamp;

public class PaymentInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6782868428999787214L;

	public PaymentInfo() {
		_oid = null;
		_orderid = null;
		_paymentID = null;
		_transactionDate = null;
		_paymentMethod = null;
		_amount = null;
		_currency = null;
		_status = null;
		_cctransid = null;
		_checkNumber = null;
		_errorMessage = null;
		_cardType = null;
		_cardNumber = null;
		_cardExpiry = null;
		_cardName = null;
		_cardStreet = null;
		_cardStatus = null;
		_gateway = null;
	}

	public String _oid;
	public String _orderid;
	public String _paymentID;
	public Timestamp _transactionDate;
	public String _paymentMethod;
	public Float _amount;
	public String _currency;
	public String _status;
	public String _cctransid;
	public String _checkNumber;
	public String _errorMessage;
	public String _cardType;
	public String _cardNumber;
	public String _cardExpiry;
	public String _cardName;
	public String _cardStreet;
	public String _cardStatus;
	public String _gateway;
}
