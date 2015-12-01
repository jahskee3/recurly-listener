package com.va.vo;

import java.io.Serializable;
import java.sql.Date;

public class AccountLoginInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	private String memberId;
	private String partnerCode;
	private String status;
	private Date lastLoginDate;
	private Integer isEmailUpToDate;
	private Integer promoAcStatus;
	private String autoRenewStatus;
	private Date currentRegEnd;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {		
		this.memberId = memberId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public Integer getIsEmailUpToDate() {
		return isEmailUpToDate;
	}
	public void setIsEmailUpToDate(Integer isEmailUpToDate) {
		this.isEmailUpToDate = isEmailUpToDate;
	}
	public Integer getPromoAcStatus() {
		if(promoAcStatus==null)promoAcStatus=0;
		return promoAcStatus;
	}
	public void setPromoAcStatus(Integer promoAcStatus) {
		this.promoAcStatus = promoAcStatus;
	}
	public String getAutoRenewStatus() {
		if(autoRenewStatus==null)autoRenewStatus="";
		return autoRenewStatus;
	}
	public void setAutoRenewStatus(String autoRenewStatus) {
		this.autoRenewStatus = autoRenewStatus;
	}
	public Date getCurrentRegEnd() {
		return currentRegEnd;
	}
	public void setCurrentRegEnd(Date currentRegEnd) {
		this.currentRegEnd = currentRegEnd;
	}
	public String getPartnerCode() {
		if(partnerCode==null)partnerCode="";
		return partnerCode;
	}
	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

}
