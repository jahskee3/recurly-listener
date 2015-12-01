package com.va.data;

import java.io.Serializable;
import java.util.Date;

public class ProductInfo implements Serializable {

	private static final long serialVersionUID = -1465680435714647567L;
	
	public String _oid;
	public String _displayName;
	public String _productCode;
	public String _productTypeID;
	public Float _price;
	public Float _shipPrice;
	public Date _start;
	public Date _end;
	public Integer _retry;

	public String _handlerClass;
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String get_oid() {
		return _oid;
	}

	public void set_oid(String _oid) {
		this._oid = _oid;
	}

	public String get_displayName() {
		return _displayName;
	}

	public void set_displayName(String _displayName) {
		this._displayName = _displayName;
	}

	public String get_productCode() {
		return _productCode;
	}

	public void set_productCode(String _productCode) {
		this._productCode = _productCode;
	}

	public String get_productTypeID() {
		return _productTypeID;
	}

	public void set_productTypeID(String _productTypeID) {
		this._productTypeID = _productTypeID;
	}

	public Float get_price() {
		return _price;
	}

	public void set_price(Float _price) {
		this._price = _price;
	}

	public Float get_shipPrice() {
		return _shipPrice;
	}

	public void set_shipPrice(Float _shipPrice) {
		this._shipPrice = _shipPrice;
	}

	public Date get_start() {
		return _start;
	}

	public void set_start(Date _start) {
		this._start = _start;
	}

	public Date get_end() {
		return _end;
	}

	public void set_end(Date _end) {
		this._end = _end;
	}

	public Integer get_retry() {
		return _retry;
	}

	public void set_retry(Integer _retry) {
		this._retry = _retry;
	}

	public String get_handlerClass() {
		return _handlerClass;
	}

	public void set_handlerClass(String _handlerClass) {
		this._handlerClass = _handlerClass;
	}

	public ProductInfo() {
	}

}
