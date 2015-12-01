package com.va.vo;

import java.io.Serializable;

public class SavePercentOffVO extends BasicDispoVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String percentOff;
  	
	public String getPercentOff() {		
		if(percentOff==null)percentOff="";
		return percentOff;
	}
	public void setPercentOff(String percentOff) {
		this.percentOff = percentOff;
	}
}
