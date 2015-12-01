package com.va.data;

import java.io.Serializable;
import java.sql.Timestamp;

public class TerminationFormInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5324713279852666357L;
	public String _oid;
	public String _accountid;
	public Timestamp _created;
	public Integer _batchnumber;
}
