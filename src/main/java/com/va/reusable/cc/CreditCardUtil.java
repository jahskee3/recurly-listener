package com.va.reusable.cc;

import java.security.GeneralSecurityException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.CreditCardValidator;
import org.apache.log4j.Logger;

import com.va.core.Configuration;
import com.va.reusable.crypto.EncryptUtil;

public class CreditCardUtil {
	private static final Logger logger = Logger.getLogger(CreditCardUtil.class);

	public final static String MAGIC_NUMBER_OLD  = "0000000000000000";
	public final static String MAGIC_NUMBER_NEW = "4716424557854915";

	public static boolean isCardValid(String card) {
		CreditCardValidator validator = new CreditCardValidator();

		boolean isValid = false;
		if(card==null)card="";
		
		if (card.equals(MAGIC_NUMBER_OLD) ) {
			isValid = false;
		} else if(card.equals(MAGIC_NUMBER_NEW)){
			isValid = true;
		}else if (validator.isValid(card)) {
		 
			isValid = true;
		}

		return isValid;
	}
	
	public static boolean isCardValid(String card, String transactionType) {
		CreditCardValidator validator = new CreditCardValidator();

		boolean isValid = false;
		if(card==null)card="";
		
		if (card.equals(MAGIC_NUMBER_OLD) && transactionType.equals("autorenew") ) {
			isValid = true;
		} else if(card.equals(MAGIC_NUMBER_NEW)){
			isValid = true;
		}else if (validator.isValid(card)) {
		 
			isValid = true;
		}

		return isValid;
	}

	public static String crossOutCardNumber(String cardNumber) {
		String result = cardNumber;
		if (StringUtils.isNotBlank(cardNumber)) {
			// card numbers shorter or longer than standard still can only
			// display the first 6 and last 4 numbers
			int length = StringUtils.trimToEmpty(cardNumber).length();
			String mask = StringUtils.substring("XXXXXXXXXXXXX", 0, length - 10);
			result = StringUtils.overlay(cardNumber, mask, 6, length - 4);
		}

		return result;
	}

	public static String getLast4Digits(String cardNumber) {
		return StringUtils.right(cardNumber, 4);
	}
	
	public static String get4DigitsCardNumber(String cardNumber) {
		if(StringUtils.isBlank(cardNumber))return "";
		
		String last4Digit = StringUtils.right(cardNumber, 4);
		return "************"+last4Digit;
	}

	public static String getBIN(String cardNumber) {
		return StringUtils.left(cardNumber, 6);
	}

	public static String get4DigitExpDate(int m, int y) {
		if (m > 12) { // fix invalid months
			m = 12;
		}

		String month = String.valueOf(m);
		month = StringUtils.leftPad(month, 2, '0');
		String year = String.valueOf(y);
		year = StringUtils.leftPad(year, 2, '0');
		return StringUtils.right(month, 2) + StringUtils.right(year, 2);
	}

	public static String cleanCardNumber(String cardNumber) {
		if (cardNumber != null) {
			cardNumber = StringUtils.remove(cardNumber, " ");
			cardNumber = StringUtils.remove(cardNumber, "-");
		}
		return cardNumber;
	}

	public static String getKey() {
		return KEY;
	}

	private static String KEY = Configuration.CCKEY;

	public static String decrypt(byte[] bytes) {
		String data = null;
		try {
			data = EncryptUtil.decrypt(KEY, bytes);
		} catch (GeneralSecurityException e) {
			logger.error("bytes=" + bytes + " " + e.getMessage(), e);
		}
		return data;
	}

	public static byte[] encrypt(String data) {
		byte[] bytes = null;
		try {
			bytes = EncryptUtil.encrypt(KEY, data);
		} catch (GeneralSecurityException e) {
			logger.error("data=" + data + " " + e.getMessage(), e);
		}
		return bytes;
	}
}
