package com.va.data;

import java.io.Serializable;

/**
 * 
 * ProductTypeInfo represents an object from the ProductType table
 * 
 */
public class ProductTypeInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4894222235779131313L;

	public ProductTypeInfo() {
	}

	public String _oid;
	public String _productType;
	public String _billingDescriptor;
	public Integer _lengthOfMembership;
}
