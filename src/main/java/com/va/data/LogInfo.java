
// Source File Name:   LogInfo.java

package com.va.data;

import java.io.Serializable;
import java.sql.Timestamp;

public class LogInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4532784655954981668L;

	public LogInfo() {
	}

	public String _oid;
	public String _accountoid;
	public Timestamp _timestamp;
	public String _action;
	public int _rc;
	public String _errorString;
}
