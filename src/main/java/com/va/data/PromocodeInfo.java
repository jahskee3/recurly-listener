
// Source File Name:   PromocodeInfo.java

package com.va.data;

import java.io.Serializable;
import java.sql.Date;

public class PromocodeInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2360749623263159113L;

	public PromocodeInfo() {
	}

	public String _oid;
	public String _code;
	public String _displayName;
	public Integer _percentCustomerDiscount;
	public Integer _percentAffiliateBonus;
	public Float _dollarCustomerDiscount;
	public Float _dollarAffiliateBonus;
	public Integer _bonusMonths;
	public Date _expiry;
}
