package com.va.reusable.cc;

public class Mod10Checker {
	static class CardProviderPrefixEntry {

		public String _providerName;
		public String _symbol;
		public String _prefix;
		public int _length;

		public CardProviderPrefixEntry(String providerName, String symbol, String prefix, int length) {
			_providerName = providerName;
			_symbol = symbol;
			_prefix = prefix;
			_length = length;
		}
	}

	public Mod10Checker() {
	}

	public static String getProviderName(String cardNumber) {
		if (cardNumber == null)
			return null;
		int i;
		for (i = 0; i < __cardPrefixList.length && !cardNumber.startsWith(__cardPrefixList[i]._prefix); i++)
			;
		if (i >= __cardPrefixList.length)
			return null;
		else
			return __cardPrefixList[i]._providerName;
	}

	public static String getProviderSymbol(String cardNumber) {
		if (cardNumber == null)
			return null;
		int i;
		for (i = 0; i < __cardPrefixList.length && !cardNumber.startsWith(__cardPrefixList[i]._prefix); i++)
			;
		if (i >= __cardPrefixList.length)
			return null;
		else
			return __cardPrefixList[i]._symbol;
	}

	public static boolean isValidProviderNumber(String inputCardNumber) {
		if (inputCardNumber == null)
			return false;
		if (!isCardNumberValid(inputCardNumber))
			return false;
		String cardNumber = stripDigits(inputCardNumber);
		int i;
		for (i = 0; i < __cardPrefixList.length
				&& (!cardNumber.startsWith(__cardPrefixList[i]._prefix) || cardNumber.length() != __cardPrefixList[i]._length); i++)
			;
		return i < __cardPrefixList.length;
	}

	public static boolean isValidFormat(String cardNumber) {
		if (cardNumber == null)
			return false;
		for (int i = 0; i < cardNumber.length(); i++) {
			char c = cardNumber.charAt(i);
			if (!Character.isDigit(c) && c != '-' && c != ' ')
				return false;
			i++;
		}

		return true;
	}

	public static String stripDigits(String cardNumber) {
		if (cardNumber == null)
			return null;
		StringBuffer tmp = new StringBuffer();
		for (int i = 0; i < cardNumber.length(); i++) {
			char c = cardNumber.charAt(i);
			if (Character.isDigit(c))
				tmp.append(c);
		}

		return tmp.toString();
	}

	private static boolean isCardNumberValid(String inputCardNumber) {
		if (!isValidFormat(inputCardNumber))
			return false;
		String cardNumber = stripDigits(inputCardNumber);
		if (cardNumber == null)
			return false;
		int numDigits = cardNumber.length();
		if (numDigits <= 1)
			return false;
		int sum = calcMod10Checksum(cardNumber, true);
		return sum % 10 == 0;
	}

	public static int getCheckDigit(String inputNumber) {
		int sum = getChecksum(inputNumber);
		if (sum < 0) {
			return sum;
		} else {
			int checkDigit = (10 - sum) % 10;
			return checkDigit;
		}
	}

	public static int getChecksum(String inputNumber) {
		int sum = calcMod10Checksum(inputNumber, false);
		if (sum < 0)
			return sum;
		else
			return sum % 10;
	}

	protected static int calcMod10Checksum(String inputNumber, boolean checkDigitPresent) {
		String cardNumber = stripDigits(inputNumber);
		if (cardNumber == null)
			return -1;
		int numDigits = cardNumber.length();
		boolean doubleThis = !checkDigitPresent;
		int sum = 0;
		for (int i = numDigits - 1; i >= 0; i--) {
			char c = cardNumber.charAt(i);
			int val = Character.digit(c, 10);
			if (doubleThis) {
				val *= 2;
				sum += val % 10;
				sum += val / 10;
			} else {
				sum += val;
			}
			doubleThis = !doubleThis;
		}

		return sum;
	}

	public static final CardProviderPrefixEntry __cardPrefixList[] = {
			new CardProviderPrefixEntry("Mastercard", "mc", "51", 16),
			new CardProviderPrefixEntry("Mastercard", "mc", "52", 16),
			new CardProviderPrefixEntry("Mastercard", "mc", "53", 16),
			new CardProviderPrefixEntry("Mastercard", "mc", "54", 16),
			new CardProviderPrefixEntry("Mastercard", "mc", "55", 16),
			new CardProviderPrefixEntry("Visa", "vs", "4", 13), new CardProviderPrefixEntry("Visa", "vs", "4", 16),
			new CardProviderPrefixEntry("American Express", "ax", "34", 15),
			new CardProviderPrefixEntry("American Express", "ax", "37", 15),
			new CardProviderPrefixEntry("Diners Club", "dc", "300", 14),
			new CardProviderPrefixEntry("Diners Club", "dc", "301", 14),
			new CardProviderPrefixEntry("Diners Club", "dc", "302", 14),
			new CardProviderPrefixEntry("Diners Club", "dc", "303", 14),
			new CardProviderPrefixEntry("Diners Club", "dc", "304", 14),
			new CardProviderPrefixEntry("Diners Club", "dc", "305", 14),
			new CardProviderPrefixEntry("Diners Club", "dc", "36", 14),
			new CardProviderPrefixEntry("Diners Club", "dc", "38", 14),
			new CardProviderPrefixEntry("Discover", "ds", "6011", 16) };

}
