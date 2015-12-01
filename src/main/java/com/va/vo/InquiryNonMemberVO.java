package com.va.vo;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

public class InquiryNonMemberVO extends BasicDispoVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String source;

	private String street;
	private String street2;
	private String city;
	private String postal;
	private String state;
	private String country;
	
	private String isOptin;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = StringUtils.trim(firstName);
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = StringUtils.trim(lastName);
	}
	public String getEmail() {
		if(email==null)email="";
		return email;
	}
	public void setEmail(String email) {
		this.email = StringUtils.trim(email);
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = StringUtils.trim(phone);
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = StringUtils.trim(source);
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getIsOptin() {
		return isOptin;
	}
	public void setIsOptin(String isOptin) {
		this.isOptin = isOptin;
	}  	
}
