package com.va.data;

import java.io.Serializable;
import java.util.Date;

/**
 * Used to hold product pricing data. It is similar to ProductInfo except that
 * the fields do not correspond exactly to the Product table. kohara - this is a
 * new class for product price changes.
 */

public class ProductPriceInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6008787623108621852L;

	public ProductPriceInfo() {
	}

	public String _oid;
	public String _displayName;
	public String _productCode;
	public Float _price;
	public String _handlerClass;
	public Float _shipPrice;
	public String _productType;
	public Date _start;
	public Date _end;

}
