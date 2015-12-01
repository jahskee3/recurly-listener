
// Source File Name:   IdnycMemberIdInfo.java

package com.va.data;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

public class CodeMemberIdInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1600705362625649253L;

	public String _oid;
	public String _code;
	public String _memberid; 	
	
	public CodeMemberIdInfo() {
	}

	public String get_memberid() {
		if(_memberid==null)return "";
		return StringUtils.trimToEmpty(_memberid);
	}
}
