
// Source File Name:   AccountEventInfo.java

package com.va.vo;

import java.io.Serializable;
import java.util.Date;

public class AccountEventInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -843901820677731256L;

	public AccountEventInfo() {
	}

	public long _id;
	public String _accountID;
	public String _event;
	public int _status;
	public Date _created;
	public String _notes;
	public String _user;
}
