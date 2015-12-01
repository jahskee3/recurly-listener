package com.va.data;

import java.io.Serializable;

public class MarketingPartnerInfo implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -7807960708454148782L;

	public MarketingPartnerInfo() {
		this(null);
	}

	public MarketingPartnerInfo(MarketingPartnerInfo info) {
		_id = 0L;
		_name = null;
		_displayName = null;
		_contentDir = null;
		
		_trialProduct = null;
		_trialProductDep = null;
		_primaryProduct = null;
		_depProduct = null;

		_trialProduct3Year = null;
		_trialProductDep3Year = null;
		_primaryProduct3Year = null;
		_depProduct3Year = null;

		_trialProduct5Year = null;
		_trialProductDep5Year = null;
		_primaryProduct5Year = null;
		_depProduct5Year = null;
		
		_sponsoredProduct = null;
		_sponsoredProduct2 = null;
		_sponsoredProduct3 = null;
		_sponsoredProduct4 = null;
		
		_free = 0;
		_convertedLeads = 0;

		if (info != null) {
			_id = info._id;
			_name = info._name;
			_displayName = info._displayName;
			_contentDir = info._contentDir;
			
			_trialProduct = info._trialProduct;
			_trialProductDep = info._trialProductDep;
			
			_primaryProduct = info._primaryProduct;
			_depProduct = info._depProduct;

			_trialProduct3Year = info._trialProduct3Year;
			_trialProductDep3Year = info._trialProductDep3Year;
			
			_primaryProduct3Year = info._primaryProduct3Year;
			_depProduct3Year = info._depProduct3Year;

			_trialProduct5Year = info._trialProduct5Year;
			_trialProductDep5Year = info._trialProduct5Year;
			
			_primaryProduct5Year = info._primaryProduct5Year;
			_depProduct5Year = info._depProduct5Year;
			_sponsoredProduct = info._sponsoredProduct;
			_sponsoredProduct2 = info._sponsoredProduct2;
			_sponsoredProduct3 = info._sponsoredProduct3;
			_sponsoredProduct4 = info._sponsoredProduct4;
			
			_free = info._free;
			_convertedLeads = info._convertedLeads;
		}
	}

	public long _id;
	public String _name;
	public String _displayName;
	public String _contentDir;
	
	public String _trialProduct;
	public String _trialProductDep;
	
	public String _primaryProduct;	
	public String _depProduct;
	
	public String _trialProduct3Year;	
	public String _trialProductDep3Year;
	
	public String _primaryProduct3Year;
	public String _depProduct3Year;
	
	public String _trialProduct5Year;
	public String _trialProductDep5Year;
	
	public String _primaryProduct5Year;
	public String _depProduct5Year;
	
	public String _sponsoredProduct;
	public String _sponsoredProduct2;
	public String _sponsoredProduct3;
	public String _sponsoredProduct4;
	
	public String _isUploadPartner;
	public String _emailNotification;
	public String _renewalProduct;
	public String _depRenewalProduct;
	public Integer _free;
	public Integer _convertedLeads;
}
