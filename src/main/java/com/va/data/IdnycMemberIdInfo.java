
// Source File Name:   IdnycMemberIdInfo.java

package com.va.data;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

public class IdnycMemberIdInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1600705362625649253L;

	public IdnycMemberIdInfo() {
	}
	public String _oid;
	public String _idnyc;
	public String _memberid; 	
	
	public String get_memberid() {
		if(_memberid==null)return "";
		return StringUtils.trimToEmpty(_memberid);
	}
}
