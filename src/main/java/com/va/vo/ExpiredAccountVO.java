package com.va.vo;

import java.io.Serializable;

public class ExpiredAccountVO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String[] memberIds;
	private String queryInfo;

	public String[] getMemberIds() {
		return memberIds;
	}
	public void setMemberIds(String[] memberIds) {
		this.memberIds = memberIds;
	}
	public String getQueryInfo() {
		return queryInfo;
	}
	public void setQueryInfo(String queryInfo) {
		this.queryInfo = queryInfo;
	}
}
