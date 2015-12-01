package com.va.data;

import java.io.Serializable;
import java.util.Date;

public class AccountAddressInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1067075679031985916L;
	private String accountOid;
	private String memberID;
	private String amtrakId;
	private String password;
	private String firstName;
	private String middleInitial;
	private String lastName;
	private String email;
	private String status;
	private Date created;
	private Date currentRegStart;
	private Date currentRegEnd;
	private Date nextRegEnd;
	private String street;
	private String street2;
	private String city;
	private String state;
	private String postal;
	private String homephone;
	private String workphone;
	private String cardNumber;
	private Integer promoAcStatus;

	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getCurrentRegEnd() {
		return currentRegEnd;
	}

	public void setCurrentRegEnd(Date currentRegEnd) {
		this.currentRegEnd = currentRegEnd;
	}

	public Date getCurrentRegStart() {
		return currentRegStart;
	}

	public void setCurrentRegStart(Date currentRegStart) {
		this.currentRegStart = currentRegStart;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomephone() {
		return homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	
	public String getAmtrakId() {		
		return amtrakId;
	}

	public void setAmtrakId(String amtrakId) {
		this.amtrakId = amtrakId;
	}

	public Date getNextRegEnd() {
		return nextRegEnd;
	}

	public void setNextRegEnd(Date nextRegEnd) {
		this.nextRegEnd = nextRegEnd;
	}

	public String getAccountOid() {
		return accountOid;
	}

	public void setAccountOid(String accountOid) {
		this.accountOid = accountOid;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getWorkphone() {
		return workphone;
	}

	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setPromoAcStatus(Integer promoAcStatus) {
		this.promoAcStatus = promoAcStatus;
	}

	public Integer getPromoAcStatus() {
		return promoAcStatus;
	}
}
