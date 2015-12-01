package com.va.data;

import java.io.Serializable;
import java.sql.Timestamp;

public class DispositionInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -51198998213412335L;

	public DispositionInfo() {

	}

	public DispositionInfo(String memberId, String disposition, String notes, String user, String refund,
			String reason, Float amount,String type) {
		this._memberID = memberId;
		this._disposition = disposition;
		this._notes = notes;
		this._vauser = user;
		this._reason = reason;
		this._refund = refund;
		this._amount = amount;
		this._batchno = null;
		this._type = type;
	}
	
	

	public String _oid;
	public String _memberID;
	public String _disposition;
	public String _notes;
	public Timestamp _created;
	public String _vauser;
	public String _status;
	public String _refund;
	public Float _amount;
	public String _reason;
	public Timestamp _lastCharge;
	public Integer _batchno;
	public String _type;
	
	public String _email;
	public String _firstName;
	public String _lastName;
	public boolean _optin;
	
	// future variables
	// public string type;
	// public float amount;
	public String getMemberID() {
		if(_memberID==null)return "";
		return _memberID;
	}

	public String getDisposition() {
		if(_disposition==null)return "";
		return _disposition;
	}

	public String getNotes() {
		if(_notes==null)return "";
		return _notes;
	}

	public Timestamp getCreated() {
		return _created;
	}

	public String getVauser() {
		if(_vauser==null)return "";
		return _vauser;
	}

	public String getStatus() {
		if(_status==null)return "";
		return _status;
	}

	public Timestamp getLastCharge() {
		return _lastCharge;
	}
	
	public Integer getBatchNo() {
		return _batchno;
	}

	public String getType() {
		return _type;
	}

	public String getOid() {
		return _oid;
	}

	public void setOid(String oid) {
		this._oid = oid;
	}

	public String getRefund() {
		return _refund;
	}

	public void setRefund(String refund) {
		this._refund = refund;
	}

	public Float getAmount() {
		return _amount;
	}

	public void setAmount(Float amount) {
		this._amount = amount;
	}

	public String getReason() {
		return _reason;
	}

	public void setReason(String reason) {
		this._reason = reason;
	}

	public Integer getBatchno() {
		return _batchno;
	}

	public void setBatchno(Integer batchno) {
		this._batchno = batchno;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setMemberID(String memberID) {
		this._memberID = memberID;
	}

	public void setDisposition(String disposition) {
		this._disposition = disposition;
	}

	public void setNotes(String notes) {
		this._notes = notes;
	}

	public void setCreated(Timestamp created) {
		this._created = created;
	}

	public void setVauser(String vauser) {
		this._vauser = vauser;
	}

	public void setStatus(String status) {
		this._status = status;
	}

	public void setLastCharge(Timestamp lastCharge) {
		this._lastCharge = lastCharge;
	}

	public void setType(String type) {
		this._type = type;
	}	
	//========== custom accessors =============
	public String getCreatedStr(){
		if(this.getCreated()==null){
			return "";
		}
		return this.getCreated().toString();
	}	
	
	public String getLastChargeStr(){
        if(this.getLastCharge()==null){
        	return "";
        }
		return this.getLastCharge().toString();
	}


	
	//non member disposition 
	
	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		this._email = email;
	}
	
	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		this._firstName = firstName;
	}
	
	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		this._lastName = lastName;
	}

	public boolean isOptin() {
		return _optin;
	}

	public void setOptin(boolean optin) {
		this._optin = optin;
	}
}

