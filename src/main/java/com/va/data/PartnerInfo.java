package com.va.data;

import java.io.Serializable;
import java.io.Writer;

import com.va.util.Debug;

public class PartnerInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public PartnerInfo() {
	}

	public void dump(Writer writer) {
		Debug.objectDump(this, writer, "");
	}
	
	public Integer _id;	
	public String _name;
	public String _displayname;
	public String _contentdir;
	public String _primaryproduct;
	public String _depproduct;
	public String _primaryproduct3;
	public String _depproduct3;
	public String _sponsoredproduct;
	public String _sponsoredproduct2;
	public String _sponsoredproduct3;
	public String _sponsoredproduct4;
	public String _primaryproduct5; 
	public String _depproduct5;
	public String _trialproduct;
	public String _trialproduct3;
	public String _trialproduct5;
	public String _isuploadpartner;
	public String _emailnotification;
	public String _renewalproduct;
	public String _deprenewalproduct;
	public Integer _free;
	public String _conversionproduct;
	public String _trialproductdep;
	public String _trialproductdep3;
	public String _trialproductdep5;
	public Integer _abTest;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer get_id() {
		return _id;
	}

	public String get_name() {
		return _name;
	}

	public String get_displayname() {
		return _displayname;
	}

	public String get_contentdir() {
		return _contentdir;
	}

	public String get_primaryproduct() {
		return _primaryproduct;
	}

	public String get_depproduct() {
		return _depproduct;
	}

	public String get_primaryproduct3() {
		return _primaryproduct3;
	}

	public String get_depproduct3() {
		return _depproduct3;
	}

	public String get_sponsoredproduct() {
		return _sponsoredproduct;
	}
	
	public String get_sponsoredproduct2() {
		return _sponsoredproduct2;
	}
	
	public String get_sponsoredproduct3() {
		return _sponsoredproduct3;
	}

	public String get_sponsoredproduct4() {
		return _sponsoredproduct4;
	}

	public String get_primaryproduct5() {
		return _primaryproduct5;
	}

	public String get_depproduct5() {
		return _depproduct5;
	}

	public String get_trialproduct() {
		return _trialproduct;
	}

	public String get_trialproduct3() {
		return _trialproduct3;
	}

	public String get_trialproduct5() {
		return _trialproduct5;
	}

	public String get_isuploadpartner() {
		return _isuploadpartner;
	}

	public String get_emailnotification() {
		return _emailnotification;
	}

	public String get_renewalproduct() {
		return _renewalproduct;
	}

	public String get_deprenewalproduct() {
		return _deprenewalproduct;
	}

	public Integer get_free() {
		return _free;
	}

	public String get_conversionproduct() {
		return _conversionproduct;
	}
	
	public String get_trialproductdep() {
		return _trialproductdep;
	}

	public String get_trialproductdep3() {
		return _trialproductdep3;
	}

	public String get_trialproductdep5() {
		return _trialproductdep5;
	}

	public Integer get_abTest() {
		return _abTest;
	}

	
}
