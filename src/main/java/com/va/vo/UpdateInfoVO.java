package com.va.vo;

import java.io.Serializable;

public class UpdateInfoVO extends BasicDispoVO implements Serializable {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 7039629131315648968L;
	
	private String firstName;
	private String lastName;
	
	public String email;
	public String password;
	 
	public String ccName;
	public String ccCardNo;	
    public String ccType;
	public String ccMonth;
	public String ccYear;
	public String ccUpdateCheck;
	
	//billing address
	public String ccStreet1;
	public String ccStreet2;
	public String ccCity;
	public String ccZipCode;
	public String ccState;
	public String ccCountry;	

	 //shiping address
	public String shAddressOid;
	public String shStreet1;
	public String shStreet2;
	public String shCity;
	public String shZipCode;
	
	public String shState;
	public String shCountry;
	public String shHomePhone;
	public String shWorkPhone;

	public String getFirstName() {
		if(firstName==null)firstName="";
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		if(lastName==null)lastName="";
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getEmail() {
		if(email==null)email="";
		return email;
	}
	public String getPassword() {
		if(password==null)password="";
		return password;
	}
	public String getCcName() {
		if(ccName==null)ccName="";
		return ccName;
	}
	public String getCcCardNo() {
		if(ccCardNo==null)ccCardNo="";
		return ccCardNo.trim();
	}
	public String getCcType() {
		if(ccType==null)ccType="";
		return ccType;
	}
	public String getCcMonth() {
		if(ccMonth==null)ccMonth="0";
		return ccMonth;
	}
	public String getCcYear() {
		if(ccYear==null)ccYear="0";
		return ccYear;
	}
	public String getCcUpdateCheck() {
		return ccUpdateCheck;
	}
	public String getCcStreet1() {
		if(ccStreet1==null)ccStreet1="";
		return ccStreet1;
	}
	public String getCcStreet2() {
		if(ccStreet2==null)ccStreet2="";
		return ccStreet2;
	}
	public String getCcCity() {
		if(ccCity==null)ccCity="";
		return ccCity;
	}
	public String getCcZipCode() {
		if(ccZipCode==null)ccZipCode="";
		return ccZipCode;
	}
	public String getCcState() {
		if(ccState==null)ccState="";
		return ccState;
	}
	public String getCcCountry() {
		if(ccCountry==null)ccCountry="";
		return ccCountry;
	}
	public String getShAddressOid() {
		return shAddressOid;
	}
	public String getShStreet1() {
		if(shStreet1==null)shStreet1="";
		return shStreet1;
	}
	public String getShStreet2() {
		if(shStreet2==null)shStreet2="";
		return shStreet2;
	}
	public String getShCity() {
		if(shCity==null)shCity="";
		return shCity;
	}
	public String getShZipCode() {
		if(shZipCode==null)shZipCode="";
		return shZipCode;
	}
	public String getShState() {
		if(shState==null)shState="";
		return shState;
	}
	public String getShCountry() {
		if(shCountry==null)shCountry="";
		return shCountry;
	}
	public String getShHomePhone() {
		if(shHomePhone==null)shHomePhone="";
		return shHomePhone;
	}
	public String getShWorkPhone() {
		if(shWorkPhone==null)shWorkPhone="";
		return shWorkPhone;
	}

	
}
