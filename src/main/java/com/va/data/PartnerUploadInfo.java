package com.va.data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * <p>
 * PartnerUploadInfo is a value object for an PartnerUploadBean object
 * representing an order uploaded by a partner using the Partner Upload process.
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
 */
public class PartnerUploadInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * The following attribute fields map to the PartnerUploadBean fields. These
	 * values will be persisted if given to an PartnerUploadBean object to
	 * update.
	 */

	/** generated key of the partnerupload record */
	public String _oid;
	/** The run date of this Partner Upload process */
	public Date _rundate;
	/** The Partner Create Date and Partner Create Time in timestamp format */
	public Timestamp _partnerCreateTimestamp;
	/** generated Account member ID */
	public String _memberID;
	/** generated CustOrder OID */
	public String _custOrderOID;
	/** generated CustOrder ID */
	public String _custOrderID;
	/** generated CustOrder ID for sponsored cards */
	public String _sponsoredOrderID;
	/** product code set during partner upload process */
	public String _productCode;
	/** value of the order set during partner upload process */
	public Float _orderValue;
	/** value of the sponsored orders set during partner upload process */
	public Float _sponsoredOrderValue;
	/** whether this record had an invalid card number with all zeros */
	public Integer _cardNumberZeroError;
	/**
	 * whether this record had an invalid card number containing alpha
	 * characters
	 */
	public Integer _cardNumberAlphaError;
	/** whether this record had an invalid card number with another error type */
	public Integer _cardNumberOtherError;
	/** whether this record processed successfully */
	public Integer _processed;
	/** whether this record encountered a processing error */
	public Integer _processingError;
	/**
	 * status of member card processing 0 = "Member Credit Card not submitted."
	 * 1 = "Member Credit Trans Succeeded." 2 = "Member Credit Card declined." 3
	 * = "Member Credit submission failed." 4 = "Member Credit Trans failed."
	 */
	public Integer _memberCardStatusError;
	/**
	 * status of sponsored card processing 0 =
	 * "Sponsored Credit Trans not submitted."; 1 =
	 * "Sponsored Credit Trans Succeeded."; 2 =
	 * "Sponsored Credit Card declined."; 3 =
	 * "Sponsored Credit submission failed."; 4 =
	 * "Sponsored Credit Trans failed.";
	 */
	public Integer _sponsoredCardStatusError;
	/** Initial status set when this order is processed */
	public Integer _promoAcStatus;
	/** partner name from partnerupload node in XML file */
	public String _partnerName;
	/** creation date from partnerupload node in XML file */
	public String _partnerCreateDate;
	/** creation time from partnerupload node in XML file */
	public String _partnerCreateTime;
	/** path and file name of the upload XML file */
	public String _importFileName;
	/**
	 * Create date from account node in XML file. Represents an optional
	 * creation date to use for the account.
	 */
	public String _createDate;
	/**
	 * Create time from account node in XML file. Represents an optional
	 * creation time to use for the account.
	 */
	public String _createTime;
	/** member first name from account node in XML file */
	public String _name;
	/** member initial from account node in XML file */
	public String _initial;
	/** member last name from account node in XML file */
	public String _lastName;
	/**
	 * password from account node in XML file. This is normally generated but
	 * optionally the password can be passed in the xml file.
	 */
	public String _password;
	/**
	 * gender of member from account node in XML file. This can be male, female,
	 * or unknown.
	 */
	public String _gender;
	/** isVeteran flag from account node in XML file */
	public String _isVeteran;
	/** name of family member, who is the veteran, from account node in XML file */
	public String _veteranName;
	/** from account node in XML file */
	public String _familyMember;
	/**
	 * branch of military. from account node in XML file. of the family member
	 * who served in the military. This is only applicable for the Veterans
	 * Advantage site.
	 */
	public String _branch;
	/**
	 * unit of military. from account node in XML file. of the family member who
	 * served in the military. This is only applicable for the Veterans
	 * Advantage site.
	 */
	public String _unit;
	/**
	 * year of start of military service. from account node in XML file. of the
	 * family member who served in the military. This is only applicable for the
	 * Veterans Advantage site.
	 */
	public String _serviceFrom;
	/**
	 * year of end of military service. from account node in XML file. of the
	 * family member who served in the military. This is only applicable for the
	 * Veterans Advantage site.
	 */
	public String _serviceTo;
	/**
	 * service number. from account node in XML file. of the family member who
	 * served in the military. This is only applicable for the Veterans
	 * Advantage site.
	 */
	public String _serviceNumber;
	/** email address from account node in XML file */
	public String _email;
	/** date of birth from account node in XML file */
	public String _dob;
	/** optin flag from account node in XML file */
	public String _optin;
	/** html mail flag from account node in XML file */
	public String _htmlMail;
	/** points balance from account node in XML file */
	public String _pointsBalance;
	/** street address from address node in XML file */
	public String _street;
	/** street address part 2 from address node in XML file */
	public String _street2;
	/** city from address node in XML file */
	public String _city;
	/** state abbreviation from address node in XML file */
	public String _state;
	/** zip / postal code from address node in XML file */
	public String _postal;
	/** country abbreviation from address node in XML file */
	public String _country;
	/** home phone from address node in XML file */
	public String _homephone;
	/** number of sponsored cards from order node in XML file */
	public String _numSponsoredCards;
	/** future promotional code from promocode node in XML file */
	public String _promoCode;
	/** source */
	public String _source;
	/** card name from payment node in XML file */
	public String _paymentCardName;
	/** card street from payment node in XML file */
	public String _paymentCardStreet;
	/** card street part 2 from payment node in XML file */
	public String _paymentCardStreet2;
	/** card city from payment node in XML file */
	public String _paymentCardCity;
	/** card sate code from payment node in XML file */
	public String _paymentCardState;
	/** card zip / postal code from payment node in XML file */
	public String _paymentCardPostal;
	/** card country code from payment node in XML file */
	public String _paymentCardCountry;
	/** card phone number from payment node in XML file */
	public String _paymentCardPhone;
	/**
	 * card type such as Visa, etc. from payment node in XML file. This is not
	 * validated until the payment is processed/
	 */
	public String _paymentCardType;
	/** card number (no dashes) from payment node in XML file */
	public String _paymentCardNumber;
	/** two digit expiration month of credit card from payment node in XML file */
	public String _paymentCardExpiryMonth;
	/** four digit expiration year of credit card from payment node in XML file */
	public String _paymentCardExpiryYear;
	/**
	 * Type of card order from cardorder node in XML file. Valid values are
	 * Veteran or Family, however the current process does not even use the
	 * cardorder nodes. This was meant for the VA site where members can add
	 * family memberships.
	 * 
	 * Potentially on the VA site there can be 0 - 5 cardorder nodes in the XML
	 * file. The one marked with a cardType of Veteran is the main membership.
	 * There can be 0 - 4 cardorder nodes that marked with a Family cardType for
	 * family memberships.
	 */
	public String _cardType1;
	/** first name of the member from the cardorder node in the XML file */
	public String _cardName1;
	/** last name of the member from the cardorder node in the XML file */
	public String _cardLastName1;
	/** card type of another member from the cardorder node in the XML file */
	public String _cardType2;
	/** first name of another member from the cardorder node in the XML file */
	public String _cardName2;
	/** last name of another member from the cardorder node in the XML file */
	public String _cardLastName2;
	/** card type of another member from the cardorder node in the XML file */
	public String _cardType3;
	/** first name of another member from the cardorder node in the XML file */
	public String _cardName3;
	/** last name of another member from the cardorder node in the XML file */
	public String _cardLastName3;
	/** card type of another member from the cardorder node in the XML file */
	public String _cardType4;
	/** first name of another member from the cardorder node in the XML file */
	public String _cardName4;
	/** last name of another member from the cardorder node in the XML file */
	public String _cardLastName4;
	/** card type of another member from the cardorder node in the XML file */
	public String _cardType5;
	/** first name of another member from the cardorder node in the XML file */
	public String _cardName5;
	/** last name of another member from the cardorder node in the XML file */
	public String _cardLastName5;

	/**
	 * sets whether this is a trial membership from the order node in the XML
	 * file
	 */
	public String _isTrial;
	/** membership length from the order node in the XML file */
	public String _membershipLength;
	/** product from the order node in the XML file */
	public String _product;

	/**
	 * Optional user defined field. This is not currently included in the XML
	 * file.
	 */
	public String _userdefined;
	/**
	 * Second optional user defined field. This is not currently included in the
	 * XML file.
	 */
	public String _userdefined2;

	/**
	 * Whether or not a recording was heard.
	 */
	public String _heardRecording;

	/**
	 * Identifies the Agent within the Sales Center who is responsible
	 */
	public String _agentID;

	/**
	 * Identifies the referring organization which generated the transaction
	 */
	public String _affiliateID;

	/**
	 * Identifies the way in which the consumer completed the purchase
	 */
	public String _channel;

	/**
	 * Custom identifier that can function as the third partiy's memberID
	 */
	public String _customID;

	/**
	 * </p>Constructor for the PartnerUploadInfo value object. Default values
	 * are assigned.</p>
	 * 
	 */
	public PartnerUploadInfo() {

		/*
		 * The following attributes map to columns in the 'partnerupload' table
		 * in the database.
		 */
		_oid = null;
		_rundate = null;
		_partnerCreateTimestamp = null;
		_memberID = null;
		_custOrderOID = null;
		_custOrderID = null;
		_sponsoredOrderID = null;
		_productCode = null;
		_orderValue = new Float(0.0F);
		_sponsoredOrderValue = new Float(0.0F);
		_cardNumberZeroError = null;
		_cardNumberAlphaError = null;
		_cardNumberOtherError = null;
		_processed = null;
		_processingError = null;
		_memberCardStatusError = null;
		_sponsoredCardStatusError = null;
		_promoAcStatus = null;
		_partnerName = null;
		_partnerCreateDate = null;
		_partnerCreateTime = null;
		_importFileName = null;
		_createDate = null;
		_createTime = null;
		_name = null;
		_initial = null;
		_lastName = null;
		_password = null;
		_gender = null;
		_isVeteran = null;
		_veteranName = null;
		_familyMember = null;
		_branch = null;
		_unit = null;
		_serviceFrom = null;
		_serviceTo = null;
		_serviceNumber = null;
		_email = null;
		_dob = null;
		_optin = null;
		_htmlMail = null;
		_pointsBalance = null;
		_street = null;
		_street2 = null;
		_city = null;
		_state = null;
		_postal = null;
		_country = null;
		_homephone = null;
		_numSponsoredCards = null;
		_promoCode = null;
		_source = null;
		_paymentCardName = null;
		_paymentCardStreet = null;
		_paymentCardStreet2 = null;
		_paymentCardCity = null;
		_paymentCardState = null;
		_paymentCardPostal = null;
		_paymentCardCountry = null;
		_paymentCardPhone = null;
		_paymentCardType = null;
		_paymentCardNumber = null;
		_paymentCardExpiryMonth = null;
		_paymentCardExpiryYear = null;
		_cardType1 = null;
		_cardName1 = null;
		_cardLastName1 = null;
		_cardType2 = null;
		_cardName2 = null;
		_cardLastName2 = null;
		_cardType3 = null;
		_cardName3 = null;
		_cardLastName3 = null;
		_cardType4 = null;
		_cardName4 = null;
		_cardLastName4 = null;
		_cardType5 = null;
		_cardName5 = null;
		_cardLastName5 = null;
		_isTrial = null;
		_membershipLength = null;
		_product = null;
		_userdefined = null;
		_userdefined2 = null;
		_heardRecording = "0";
		_agentID = null;
		_affiliateID = null;
		_channel = null;
		_customID = null;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("_oid" + _oid);
		buffer.append("_rundate" + _rundate);
		buffer.append("_partnerCreateTimestamp" + _partnerCreateTimestamp.toString());
		buffer.append("_memberID" + _memberID);
		buffer.append("_custOrderOID" + _custOrderOID);
		buffer.append("_custOrderID" + _custOrderID);
		buffer.append("_sponsoredOrderID" + _sponsoredOrderID);
		buffer.append("_productCode" + _productCode);
		buffer.append("_orderValue" + _orderValue.toString());
		buffer.append("_sponsoredOrderValue" + _sponsoredOrderValue.toString());
		buffer.append("_cardNumberZeroError" + _cardNumberZeroError);
		buffer.append("_cardNumberAlphaError" + _cardNumberAlphaError);
		buffer.append("_cardNumberOtherError" + _cardNumberOtherError);
		buffer.append("_processed" + _processed);
		buffer.append("_processingError" + _processingError);
		buffer.append("_memberCardStatusError" + _memberCardStatusError);
		buffer.append("_sponsoredCardStatusError" + _sponsoredCardStatusError);
		buffer.append("_promoAcStatus" + _promoAcStatus);
		buffer.append("_partnerName" + _partnerName);
		buffer.append("_partnerCreateDate" + _partnerCreateDate.toString());
		buffer.append("_partnerCreateTime" + _partnerCreateTime.toString());
		buffer.append("_importFileName" + _importFileName);
		buffer.append("_createDate" + _createDate);
		buffer.append("_createTime" + _createTime);
		buffer.append("_name" + _name);
		buffer.append("_initial" + _initial);
		buffer.append("_lastName" + _lastName);
		buffer.append("_password" + _password);
		buffer.append("_gender" + _gender);
		buffer.append("_isVeteran" + _isVeteran);
		buffer.append("_veteranName" + _veteranName);
		buffer.append("_familyMember" + _familyMember);
		buffer.append("_branch" + _branch);
		buffer.append("_unit" + _unit);
		buffer.append("_serviceFrom" + _serviceFrom);
		buffer.append("_serviceTo" + _serviceTo);
		buffer.append("_serviceNumber" + _serviceNumber);
		buffer.append("_email" + _email);
		buffer.append("_dob" + _dob);
		buffer.append("_optin" + _optin);
		buffer.append("_htmlMail" + _htmlMail);
		buffer.append("_pointsBalance" + _pointsBalance);
		buffer.append("_street" + _street);
		buffer.append("_street2" + _street2);
		buffer.append("_city" + _city);
		buffer.append("_state" + _state);
		buffer.append("_postal" + _postal);
		buffer.append("_country" + _country);
		buffer.append("_homephone" + _homephone);
		buffer.append("_numSponsoredCards" + _numSponsoredCards);
		buffer.append("_promoCode" + _promoCode);
		buffer.append("_source" + _source);
		buffer.append("_paymentCardName" + _paymentCardName);
		buffer.append("_paymentCardStreet" + _paymentCardStreet);
		buffer.append("_paymentCardStreet2" + _paymentCardStreet2);
		buffer.append("_paymentCardCity" + _paymentCardCity);
		buffer.append("_paymentCardState" + _paymentCardState);
		buffer.append("_paymentCardPostal" + _paymentCardPostal);
		buffer.append("_paymentCardCountry" + _paymentCardCountry);
		buffer.append("_paymentCardPhone" + _paymentCardPhone);
		buffer.append("_paymentCardType" + _paymentCardType);
		buffer.append("_paymentCardNumber" + _paymentCardNumber);
		buffer.append("_paymentCardExpiryMonth" + _paymentCardExpiryMonth);
		buffer.append("_paymentCardExpiryYear" + _paymentCardExpiryYear);
		buffer.append("_cardType1" + _cardType1);
		buffer.append("_cardName1" + _cardName1);
		buffer.append("_cardLastName1" + _cardLastName1);
		buffer.append("_cardType2" + _cardType2);
		buffer.append("_cardName2" + _cardName2);
		buffer.append("_cardLastName2" + _cardLastName2);
		buffer.append("_cardType3" + _cardType3);
		buffer.append("_cardName3" + _cardName3);
		buffer.append("_cardLastName3" + _cardLastName3);
		buffer.append("_cardType4" + _cardType4);
		buffer.append("_cardName4" + _cardName4);
		buffer.append("_cardLastName4" + _cardLastName4);
		buffer.append("_cardType5" + _cardType5);
		buffer.append("_cardName5" + _cardName5);
		buffer.append("_cardLastName5" + _cardLastName5);
		buffer.append("_isTrial" + _isTrial);
		buffer.append("_membershipLength" + _membershipLength);
		buffer.append("_product" + _product);
		buffer.append("_userdefined" + _userdefined);
		buffer.append("_userdefined2" + _userdefined2);
		buffer.append("_heardRecording" + _heardRecording);
		buffer.append("_agentID" + _agentID);
		buffer.append("_affiliateID" + _affiliateID);
		buffer.append("_channel" + _channel);
		buffer.append("_customID" + _customID);

		return buffer.toString();
	}
}
