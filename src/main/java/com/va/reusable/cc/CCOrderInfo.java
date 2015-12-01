package com.va.reusable.cc;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;

public class CCOrderInfo implements Serializable, CCConstants {
	private static final long serialVersionUID = -6834728798279174707L;

	public CCOrderInfo() {
		_state = 0;
		_amount = 0.0F;
		_currency = "usd";
	}

	/*
	 * public void dumpInfo(Writer writer) { try {
	 * writer.write("Status:         " + _state + "\n");
	 * writer.write("OrderID:        " + _orderID + "\n");
	 * writer.write("User param:     " + _userParam + "\n");
	 * writer.write("Card type:      " + _cardType + "\n");
	 * writer.write("Card number:    " + _cardNumber + "\n");
	 * writer.write("Expiry month:   " + _expiryMonth + "\n");
	 * writer.write("Expiry year:    " + _expiryYear + "\n");
	 * writer.write("Amount:         " + _amount + "\n");
	 * writer.write("Currency:       " + _currency + "\n");
	 * writer.write("Card name:      " + _cardName + "\n");
	 * writer.write("Card street:    " + _cardStreet + "\n");
	 * writer.write("Card street2:   " + _cardStreet2 + "\n");
	 * writer.write("Card city:      " + _cardCity + "\n");
	 * writer.write("Card state:     " + _cardState + "\n");
	 * writer.write("Card zipcode:   " + _cardPostal + "\n");
	 * writer.write("Card country:   " + _cardCountry + "\n");
	 * writer.write("Txn ID:         " + _txnID + "\n");
	 * writer.write("Action code:    " + _actionCode + "\n");
	 * writer.write("Txn ID:         " + _txnID + "\n");
	 * writer.write("Auth code:      " + _authCode + "\n");
	 * writer.write("AVS code:       " + _avsCode + "\n");
	 * writer.write("Ref code:       " + _refCode + "\n");
	 * writer.write("Error message:  " + _errorMessage + "\n"); writer.flush();
	 * } catch(IOException ioexception) {
	 * System.out.println("IOException when dumping order info: " +
	 * ioexception.getMessage()); ioexception.printStackTrace(); } }
	 */
	public String _accountId;
	public int _state;
	public String _orderID;
	public String _userParam;
	public String _cardType;
	public String _cardNumber;
	public int _expiryMonth;
	public int _expiryYear;
	public float _amount;
	public float _originalAmount;
	public String _currency;
	public String _cardName;
	public String _cardStreet;
	public String _cardStreet2;
	public String _cardCity;
	public String _cardState;
	public String _cardPostal;
	public String _cardCountry;
	public String _phone;
	public String _email;
	public String _txnID;
	public String _actionCode;
	public String _authCode;
	public String _avsCode;
	public String _refCode;
	public String _errorMessage;
	public String _cardValidation;
	public String _billingDescriptor;
	public String _reportingGroup;
	public String _source;
	public String _gateway;

	/*
	 * transaction type refund
	 */
	public String _transactionType;

	public String toString() {
		String result = ToStringBuilder.reflectionToString(this);
		String cardNumber = CreditCardUtil.crossOutCardNumber(_cardNumber);
		return StringUtils.replace(result, _cardNumber, cardNumber);
	}
}
