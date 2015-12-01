package com.va.data;

import java.io.Serializable;
import java.sql.Date;

public class AccountWWPInfo implements Serializable{
	private static final long serialVersionUID = -1L;
	
	public AccountWWPInfo(){
	}
	
	public String _oid;
	public String _accountid;
	public String _rank;
	public Date _serviceStartDate;
	public Date _serviceEndDate;
	public String _serviceStatus;
	public String _dischargeType;
	public Date _injuryDate;
	public Boolean _estimatedDate;
	public String _injuryLocation;
	public String _injuryLocationOther;
	public Boolean _amputee;
	public Boolean _burn; 
	public Boolean _sci;
	public Boolean _tbi;
	public Boolean _blind;
	public Boolean _ptsd;
	public Boolean _sfw;
	public Boolean _other;
	public String _otherInjuryDescription;
	public Boolean _vaCompensation;
	public String _vaRating;
	public Boolean _vaBenefits;
	public Boolean _vaPendingClaim;
	public Boolean _vaClaimOnAppeal;
	public String _managingClaim;
	public Boolean _receivingVRE;
	public Boolean _appliedForVRE;
	public String _vreApplication;
	public Long _batchNumber;
}
