
// Source File Name:   AccountExInfo.java

package com.va.data;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

public class AccountExInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1600705362625649253L;

	public AccountExInfo() {
	}
	public String _oid;
	public String _account_oid;
	public String _document_filename; 	
	
	public String get_document_filename() {
		if(_document_filename==null)return "";
		return StringUtils.trimToEmpty(_document_filename);
	}
}
