package com.va.core;

import java.sql.Date;
import java.sql.Timestamp;

public class Constants {
	public static final String AUTORENEW_PERIOD = "ARPeriod";
	public static final String PROMO_PERIOD = "ARPromoPeriod";

	public static final String TXN_TYPE_REFUND = "refund";
	public static final String TXN_TYPE_VOID = "void";

	public static final String BADBIN_GIFTCARD = "giftcard";

	public static final String TXN_SOURCE_UPLOAD = "upload";
	public static final String TXN_SOURCE_CONVERSION = "conversion";
	public static final String TXN_SOURCE_AUTORENEW = "autorenew:";
	public static final String TXN_SOURCE_WEB = "web";
	public static final String TXN_SOURCE_ADMIN = "admin";
	public static final String TXN_SOURCE_IVR = "ivr";
	public static final String TXN_SOURCE_SYSTEM = "system";
	public static final String TXN_SOURCE_RETRY = "retry";

	public static final String ORDER_SOURCE_WEB = "Web";
	public static final String ORDER_SOURCE_IVR = TXN_SOURCE_IVR;
	public static final String ORDER_SOURCE_RETRY = TXN_SOURCE_RETRY;

	public static final String GATEWAY_VERIFI = "V";
	public static final String GATEWAY_MAGIC = "M";
	public static final String GATEWAY_BLOCK = "B";
	public static final String GATEWAY_CHARGEBACK = "C";
	public static final String GATEWAY_ACCEPT = "A";
	public static final String GATEWAY_DECLINE = "D";

	public static final int CC_ERROR_DECLINE_GATEWAY = 994;
	// public static final int CC_ERROR_NO_REFUNDS_GATEWAY = 995;
	public static final int CC_ERROR_DUPLICATE_NAME_ADDRESS = 996;
	public static final int CC_ERROR_DUPLICATE = 997;
	public static final int CC_ERROR_CHARGEBACK = 998;
	public static final int CC_ERROR_BLOCK = 999;

	public static final String CC_MSG_DECLINE_GATEWAY = "decline gateway";
	// public static final String CC_MSG_NO_REFUNDS_GATEWAY =
	// "no refunds gateway";
	public static final String CC_MSG_DUPLICATE_NAME_ADDRESS = "duplicate name/address";
	public static final String CC_MSG_DUPLICATE = "duplicate";
	public static final String CC_MSG_CHARGEBACK = "chargeback";
	public static final String CC_MSG_BLOCKED = "blocked";

	public static final int PROMO_YES = 1;
	public static final int PROMO_NO = 0;

	// make sure these trial constants are in synch with processPromo
	// configuration in build.properties till we set this value dynamically
	// public static final int TRIAL_PERIOD_YEAR = 30;
	// public static final int TRIAL_PERIOD_MONTHLY_USP = 18;
	// public static final int TRIAL_PERIOD_MONTHLY_LFP = 22;

	public static final String AR_STATUS_RETRY = "RETRY";
	public static final String AR_STATUS_COMPLETE = "Complete";
	public static final String AR_STATUS_FAILED = "Failed";

	public static final String ORDER_STATUS_COMPLETE = "Complete";
	public static final String ORDER_STATUS_CANCELLED = "Cancelled";
	public static final String ORDER_STATUS_PENDING = "Pending";

	public static final String PAYMENT_STATUS_COMPLETE = "Complete";

	public static final String ACCOUNT_STATUS_CURRENT = "Current";
	public static final String ACCOUNT_STATUS_PENDING = "Pending";
	public static final String ACCOUNT_STATUS_NEWSLETTER = "Newsletter";
	public static final String ACCOUNT_STATUS_CANCELLED = "Cancelled";
	public static final String ACCOUNT_STATUS_FRIEND = "Friend";
	public static final String ACCOUNT_STATUS_EXPIRED = "Expired";
	public static final String ACCOUNT_STATUS_RECREATED = "Recreated";
	public static final String ACCOUNT_STATUS_RECEIVABLES = "Receivables";

	/* Since we cannot set dates to null in the Account EJB, use this instead */
	public static final Date DATE_NULL = new Date(0);
	public static final Timestamp TIMESTAMP_NULL = new Timestamp(0);
	public static final String LOC_TRIAL = "0";
	public static final String LOC_CONVERSION = "1";

	public static final Integer AUTO_RENEW_ON = new Integer(1);
	public static final Integer AUTO_RENEW_OFF = new Integer(0);

	public static final Integer RENEWAL_LAST_ON = new Integer(1);

	public static final Integer ORDER_RETRY_ON = new Integer(1);
	public static final Integer ORDER_RETRY_OFF = new Integer(0);
	public static final Integer PRODUCT_RETRY_ON = ORDER_RETRY_ON;
	public static final Integer PRODUCT_RETRY_OFF = ORDER_RETRY_OFF;

	public static final String ACCOUNT_MEMBER_SELF = "self";

	public static final Integer ACCOUNT_SET_PROCESSED = new Integer(2);
	public static final Integer ACCOUNT_PROCESSED = new Integer(1);
	public static final Integer ACCOUNT_NOT_PROCESSED = new Integer(0);

	public static final String PARTNER_BEAR = "bear";
	
	public static final String PARTNERS_DIR = "/www/include/partners/";
	public static final String WELCOME_MAIL = "/welcomemail.html";
	public static final String WELCOME_MAIL_FILE = "welcomemail.html";
	public static final String VOICEXML_TEMPLATE_DIR = "/voicexml/";
	public static final String EMAIL_VERIFICATION_DIR = "/www/data/";

	//PE = Process Expire
	public static final String PE_STATUS_EXPIRED="status-expired";
	public static final String PE_STATUS_RENEWED="status-renewed";
	public static final String PE_STATUS_RECEIVABLES="status-receivables";
	
	//Receivables Email test
	public static final String TEST_RCV_MEMBERID="TEST0001";
	public static final String TEST_RCV_EMAIL="jlubaton@veteransadvantage.com";
	
	
	//Milvet partner
	public static final String MILVET_PARTNER = "milvet-jobs";
}
