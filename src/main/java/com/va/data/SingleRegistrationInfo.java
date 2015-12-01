package com.va.data;

import java.io.Serializable;
import java.sql.Timestamp;

public class SingleRegistrationInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -51198998213412336L;

	public SingleRegistrationInfo() {

	}

	public SingleRegistrationInfo(String oid, String partner, String memberID, String vauser) {
		this._oid = oid;
		this._partner = partner;
		this._memberID = memberID;
		this._vauser = vauser;
	}

	public String _oid;
	public String _partner;
	public String _memberID;
	public String _vauser;

}
