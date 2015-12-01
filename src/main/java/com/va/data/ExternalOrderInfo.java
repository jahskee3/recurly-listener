
// Source File Name:   ExternalOrderInfo.java

package com.va.data;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.sql.Timestamp;

import com.va.reusable.cc.CreditCardUtil;

public class ExternalOrderInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -246603260143634088L;

	public ExternalOrderInfo() {
		_oid = null;
		_extRef = null;
		_status = null;
		_created = null;
		_action = null;
		_referral = null;
		_name = null;
		_lastName = null;
		_street = null;
		_street2 = null;
		_city = null;
		_state = null;
		_postal = null;
		_contactPhone = null;
		_email = null;
		_optin = null;
		_paymentMethod = null;
		_cardType = null;
		_cardNumber = null;
		_expiryDate = null;
		_cardName = null;
		_cardStreet = null;
		_gender = null;
		_familyMember = null;
		_vetRelative = null;
		_branch = null;
		_unit = null;
		_serviceFrom = null;
		_serviceTo = null;
		_serviceNumber = null;
		_nSuppCards = null;
		_first1 = null;
		_last1 = null;
		_first2 = null;
		_last2 = null;
		_first3 = null;
		_last3 = null;
		_first4 = null;
		_last4 = null;
		_notes = null;
		_promoCode = null;
		_password = null;
		_dob = null;
		_ssn = null;
		_memberID = null;
		_renewalYears = null;
	}

	public void dump(Writer w) {
		try {
			w.write("OID:              " + print(_oid) + "\n");
			w.write("ExtRef:           " + print(_extRef) + "\n");
			w.write("Status:           " + print(_status) + "\n");
			w.write("Created:          " + print(_created) + "\n");
			w.write("Action:           " + print(_action) + "\n");
			w.write("Referral:         " + print(_referral) + "\n");
			w.write("Name:             " + print(_name) + "\n");
			w.write("Last name:        " + print(_name) + "\n");
			w.write("Street:           " + print(_street) + "\n");
			w.write("Street2:          " + print(_street2) + "\n");
			w.write("City:             " + print(_city) + "\n");
			w.write("State:            " + print(_state) + "\n");
			w.write("Postal:           " + print(_postal) + "\n");
			w.write("Contact phone:    " + print(_contactPhone) + "\n");
			w.write("Email:            " + print(_email) + "\n");
			w.write("Optin:            " + print(_optin) + "\n");
			w.write("Payment method:   " + print(_paymentMethod) + "\n");
			w.write("Card type:        " + print(_cardType) + "\n");
			w.write("Card number:      " + print(CreditCardUtil.crossOutCardNumber(_cardNumber)) + "\n");
			w.write("Expiry date:      " + print(_expiryDate) + "\n");
			w.write("Card name:        " + print(_cardName) + "\n");
			w.write("Card street:      " + print(_cardStreet) + "\n");
			w.write("Gender:           " + print(_gender) + "\n");
			w.write("Family member:    " + print(_familyMember) + "\n");
			w.write("VetRelative:      " + print(_vetRelative) + "\n");
			w.write("Branch:           " + print(_branch) + "\n");
			w.write("Unit:             " + print(_unit) + "\n");
			w.write("Service from:     " + print(_serviceFrom) + "\n");
			w.write("Service to:       " + print(_serviceTo) + "\n");
			w.write("Service number:   " + print(_serviceNumber) + "\n");
			w.write("Num supp cards:   " + print(_nSuppCards) + "\n");
			w.write("First1:           " + print(_first1) + "\n");
			w.write("Last1:            " + print(_last1) + "\n");
			w.write("First2:           " + print(_first2) + "\n");
			w.write("Last2:            " + print(_last2) + "\n");
			w.write("First3:           " + print(_first3) + "\n");
			w.write("Last3:            " + print(_last3) + "\n");
			w.write("First4:           " + print(_first4) + "\n");
			w.write("Last4:            " + print(_last4) + "\n");
			w.write("Notes:            " + print(_notes) + "\n");
			w.write("Promocode:        " + print(_promoCode) + "\n");
			w.write("Password:         " + print(_password) + "\n");
			w.write("DOB:              " + print(_dob) + "\n");
			w.write("SSN:              " + print(_ssn) + "\n");
			w.write("MemberID:         " + print(_memberID) + "\n");
			w.write("RenewalYears:     " + print(_renewalYears) + "\n");
			w.flush();
		} catch (IOException ioe) {
			System.out.println("IOException dumping ExternalOrderInfo: " + ioe.getMessage());
		}
	}

	String print(Object o) {
		if (o == null)
			return "(null)";
		else
			return o.toString();
	}

	public String _oid;
	public String _extRef;
	public String _status;
	public Timestamp _created;
	public String _action;
	public String _referral;
	public String _name;
	public String _lastName;
	public String _street;
	public String _street2;
	public String _city;
	public String _state;
	public String _postal;
	public String _contactPhone;
	public String _email;
	public Integer _optin;
	public String _paymentMethod;
	public String _cardType;
	public String _cardNumber;
	public String _expiryDate;
	public String _cardName;
	public String _cardStreet;
	public String _gender;
	public String _familyMember;
	public String _vetRelative;
	public String _branch;
	public String _unit;
	public String _serviceFrom;
	public String _serviceTo;
	public String _serviceNumber;
	public Integer _nSuppCards;
	public String _first1;
	public String _last1;
	public String _first2;
	public String _last2;
	public String _first3;
	public String _last3;
	public String _first4;
	public String _last4;
	public String _notes;
	public String _promoCode;
	public String _password;
	public String _dob;
	public String _ssn;
	public String _memberID;
	public Integer _renewalYears;
}
