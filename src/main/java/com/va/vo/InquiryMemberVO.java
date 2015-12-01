package com.va.vo;

import java.io.Serializable;

public class InquiryMemberVO extends BasicDispoVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		if(type==null)type="";
		this.type = type;
	}
	
  	
}
