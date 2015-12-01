package com.va.data;

import java.io.Serializable;

public class AccountNoteInfo implements Serializable {
	
	private static final long serialVersionUID = -1L;
	
	public AccountNoteInfo(){
	}
	
	public Integer _oid;
	public String _accountid;
	public String _date;
	public String _notes;
	public String _user;
}
