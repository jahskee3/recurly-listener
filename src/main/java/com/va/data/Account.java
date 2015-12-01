package com.va.data;

import javax.ejb.EJBLocalObject;

import com.va.core.VAException;

public interface Account extends EJBLocalObject {
	
	public AccountInfo getInfo() throws VAException;

	public void setInfo(AccountInfo accountinfo) throws VAException;
	
	public static final String STATUS_CURRENT="Current";
	public static final String STATUS_CANCELLED="Cancelled";
	public static final String STATUS_EXPIRED="Expired";
	public static final String STATUS_NEWSLETTER="Newsletter";
	public static final String STATUS_RECEIVABLES="Receivables";
	public static final String STATUS_PENDING="Pending";
	public static final String STATUS_PURGED="Purged";
	public static final String STATUS_RECREATED="Recreated";
	
	public static final String STATUS_ER="ER"; //expired receivable
	
	public static final String AUTORENEW_STATUS_COMPLETE = "Complete";
	public static final String AUTORENEW_STATUS_RETRY = "RETRY";
	public static final String AUTORENEW_STATUS_FAILED = "Failed";

}
