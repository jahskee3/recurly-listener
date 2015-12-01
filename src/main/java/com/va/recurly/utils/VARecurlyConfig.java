package com.va.recurly.utils;

import com.va.core.BusinessLogic;

public class VARecurlyConfig {
	private String recurlyPageSize = "20";
	//private String VA_APIKEY = "33e494d9284f4bef8c68555ca5c2d3ee";
	private String apiKey = "61bdb18cd5344f7e8f105a3595671e14";
	//private String VA_SUBDOMAIN = "veteransadvantage";
	private String subDomain = "uspatriotcard";
	private String currency = "USD";
	
	
	public String getRecurlyPageSize() {
		return recurlyPageSize;
	}
	public String getApiKey() {
		
	/*	String apiKey="";
		if(BusinessLogic.isVA()){
			apiKey="33e494d9284f4bef8c68555ca5c2d3ee";
		}else if(BusinessLogic.isUSP()){
			apiKey="61bdb18cd5344f7e8f105a3595671e14";
		}*/
		apiKey="61bdb18cd5344f7e8f105a3595671e14";
		return apiKey;
	}
	
	
	public String getSubDomain() {
		String subDomain="";
/*		if(BusinessLogic.isVA()){
			subDomain="veteransadvantage";
		}else if(BusinessLogic.isUSP()){
			subDomain="uspatriotcard";
		}
*/		subDomain="uspatriotcard";
		return subDomain;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	
	
}
