package com.va.recurly.utils;


import org.apache.commons.lang.StringUtils;

import com.ning.billing.recurly.model.RecurlyUnitCurrency;

public class VARecurlyUtil {

	public static Integer getAmountInCents(double amount) {		
		Integer amountInCents = new Double(amount*100).intValue();
		return amountInCents;
	}

	public static RecurlyUnitCurrency createPrice(int amount) {
		final RecurlyUnitCurrency price = new RecurlyUnitCurrency();
		/*
		 * price.setUnitAmountEUR(LifecycleTest.randomInteger(10));
		 * price.setUnitAmountGBP(LifecycleTest.randomInteger(10));
		 * price.setUnitAmountUSD(LifecycleTest.randomInteger(10));
		 * price.setUnitAmountSEK(LifecycleTest.randomInteger(10));
		 */
		price.setUnitAmountUSD(amount);

		return price;
	}

	public static String getFirstName(String fullName) {
		String[] tokens = fullName.split(" ");
		String firstName = "";
		if (tokens.length > 0) {
			for (int i = 0; i != tokens.length - 1; i++) {
				firstName = firstName + " " + tokens[i];
			}
		}
		return StringUtils.trim(firstName);

	}

	public static String getLastName(String fullName) {
		String[] tokens = fullName.split(" ");
		String lastName = "";
		if (tokens.length > 0) {
			lastName = tokens[tokens.length - 1];
		}
		return lastName;
	}

	public static String getMiddleName(String[] middleName) {
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i < middleName.length - 1; i++) {
			builder.append(middleName[i] + " ");
		}

		return builder.toString();
	}
}
