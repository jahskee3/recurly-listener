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
		sb.append("accountCode='").append(accountCode).append('\'');
		sb.append(", username='").append(username).append('\'');
		sb.append(", email='").append(email).append('\'');
		sb.append(", firstName='").append(firstName).append('\'');
		sb.append(", lastName='").append(lastName).append('\'');
		sb.append(", companyName='").append(companyName).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
