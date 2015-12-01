package com.va.reusable.cc;

public class BillingDescriptorInfo {
	private String prefix;
	private String display;
	private int asteriskIdx;

	public BillingDescriptorInfo(String display) {
		assert display.length() <= 7;

		this.prefix = "VA ";
		this.asteriskIdx = 3;
		this.display = display;
	}

	public int getAsteriskIdx() {
		return asteriskIdx;
	}

	public String getDisplay() {
		return display;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
