
// Source File Name:   AccountEventInfo.java

package com.va.vo;

import java.io.Serializable;
import java.util.Date;

public class AccountSponsor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -843901820677731256L;

	public AccountSponsor() {
	}

	public String _accountOID;
	public Date _start;
	public Date _end;
	public int _quantity;
}
