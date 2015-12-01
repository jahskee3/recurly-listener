package com.va.data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * BasicAccount is a value object that represents an account with basic
 * information.
 * </p>
 * 
 * <p>
 * This class is not designed for subclassing.
 * </p>
 * 
 * @author unknown
 * @author alan
 * 
 * @version $Id: BasicAccount.java,v 1.6 2008/04/18 21:10:43 bdavid Exp $
 * 
 */
public final class BasicAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	private String memberid;
	private String oid;
	private String email;
	private String name;
	private String lastname;
	private int product;
	private long currentRegTime;
	private String partnerCode;
	private String agentId;
	private String affiliateId;
	private String channel;
	private int isNewMember;
	private String preferredPaymentMethod;
	private int nSuppCards;
 
	/**
	 * BasicAccount constructor. [03-01-2006 kohara] add currentRegStart since
	 * it will now be required to figure out what product to upgrade to for a
	 * trial membership
	 * 
	 * @param memberID
	 *            the member's id
	 * @param objectID
	 *            the account object id
	 * @param email
	 *            the member's email address
	 * @param firstName
	 *            - the member's first name
	 * @param lastName
	 *            - the member's last name
	 * @param currentRegStart
	 *            - the date the current registration started
	 */
	public BasicAccount(final String memberID, final String objectID, final String email, final String firstName,
			final String lastName, final Date currentRegStart, final String partnerCode, final String agentId,
			final String affiliateId, final String channel,final int isNewMember, final String preferredPaymentMethod,
			final int nSuppCards) {
		this.memberid = memberID;
		this.oid = objectID;
		this.email = email;
		this.name = firstName;
		this.lastname = lastName;
		setCurrentRegStart(currentRegStart);
		this.partnerCode = partnerCode;
		this.agentId = agentId;
		this.affiliateId = affiliateId;
		this.channel = channel;
		this.preferredPaymentMethod = (preferredPaymentMethod == null || "".equals(preferredPaymentMethod)) ? 
				"CreditCard" : preferredPaymentMethod;
		this.nSuppCards = nSuppCards;
	 
	}

	public BasicAccount() {
	}

	/**
	 * Getter method for member id
	 * 
	 * @return memberID the member's id
	 */
	public String getMemberID() {
		return memberid;
	}

	/**
	 * Getter method for the account object's id.
	 * 
	 * @return oid - the account object's id
	 */
	public String getOID() {
		return oid;
	}

	/**
	 * Getter method for the account's email address
	 * 
	 * @return email - A string containing the email address of this account.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Getter method for the member's first name
	 * 
	 * @return firstName - A string containing the first name of the account's
	 *         owner.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter method for the member's last name.
	 * 
	 * @return lastName - A String containing the last name of the account's
	 *         owner.
	 */
	public String getLastName() {
		return lastname;
	}

	/**
	 * Getter method for the account's registration product id.
	 * 
	 * @return productID - An int representing the id of the registration
	 *         product used by this account.
	 */
	public int getProduct() {
		return product;
	}

	/**
	 * Setter method for the account's registration product id.
	 * 
	 * @param productID
	 *            - the id of the product that this account has set as its
	 *            registration product (membership).
	 */
	public void setProduct(final int productID) {
		this.product = productID;
	}

	/**
	 * Getter method for the date the current registration began.
	 * 
	 * @return currentRegStart - A Date object containing the date that this
	 *         account's current registration started.
	 */
	public Date getCurrentRegStart() {
		return new Date(currentRegTime);
	}
	
	public String getPreferredPaymentMethod() {
		return preferredPaymentMethod;
	}

	/**
	 * Setter method for the date the current registration began.
	 * 
	 * @param currentRegStart
	 *            - A Date object containing the date the account's current
	 *            registration began.
	 */
	public void setCurrentRegStart(final Date currentRegStart) {
		// Make a defensive copy of the Date parameter as a long value.
		if (currentRegStart != null) {
			this.currentRegTime = currentRegStart.getTime();
		}
	}

	public String getPartnerCode() {
		return partnerCode;
	}

	public String getAffiliateId() {
		return affiliateId;
	}

	public String getAgentId() {
		return agentId;
	}

	public String getChannel() {
		return channel;
	}

	public void setMemberId(String memberId) {
		this.memberid = memberId;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

	public int getIsNewMember() {
		return isNewMember;
	}

	public void setIsNewMember(int isNewMember) {
		this.isNewMember = isNewMember;
	}
	
	public void setPreferredPaymentMethod(String preferredPaymentMethod) {
		this.preferredPaymentMethod = preferredPaymentMethod;
	}

	 
	public int getnSuppCards() {
		return nSuppCards;
	}

	 
	public void setnSuppCards(int nSuppCards) {
		this.nSuppCards = nSuppCards;
	}

	
}
