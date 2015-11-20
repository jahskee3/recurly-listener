package com.j3source.recurly.events.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "account")
public class AccountE {

	@XmlElement(name = "account_code")
	private String accountCode;

	@XmlElement(name = "username")
	private String username;

	@XmlElement(name = "email")
	private String email;

	@XmlElement(name = "first_name")
	private String firstName;

	@XmlElement(name = "last_name")
	private String lastName;

	@XmlElement(name = "company_name")
	private String companyName;

	public String getAccountCode() {
		return accountCode;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("AccountE{");
		sb.append("accountCode='").append(this.getAccountCode()).append('\'');
		sb.append(", username='").append(this.getUsername()).append('\'');
		sb.append(", email='").append(this.getEmail()).append('\'');
		sb.append(", firstName='").append(this.getFirstName()).append('\'');
		sb.append(", lastName='").append(this.getLastName()).append('\'');
		sb.append(", companyName='").append(this.getCompanyName()).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
