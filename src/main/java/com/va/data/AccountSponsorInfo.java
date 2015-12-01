package com.va.data;

import java.io.Serializable;
import java.sql.Timestamp;





public class AccountSponsorInfo implements Serializable{
	
	public AccountSponsorInfo(){}
	
	public String _accountOID;
	public Timestamp _start;
	public Timestamp _end;
	public int _quantity;
	
}
