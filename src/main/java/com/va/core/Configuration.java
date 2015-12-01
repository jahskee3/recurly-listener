package com.va.core;

import java.util.Properties;

import com.va.reusable.config.ConfigurationEx;

/**
 * Load the properties file specified by -Dconfig.filename. Also loads a local
 * properties file if it exists which overrides the primary properties file. If
 * the properties file is named app.properties, the local properties file should
 * be named app.local.properties.
 * 
 * To use the safe. confgure the safe and use safe anchors as the value. For
 * example: config.safe=/opt/va/conf/safe.zip
 * root.user=config.safe#prod.va.root.user
 */
public class Configuration extends ConfigurationEx {	
	
	public static final boolean IS_PRODUCTION = Integer.parseInt(getProperty("isproduction"))==1?true:false;
	//public static final boolean RECEIVABLE_MODE = false && !IS_PRODUCTION;

	//public static final boolean RECEIVABLE_MODE = true;
	
	public static final String SITE_APPS_ROOT = getProperty("site.apps.root");
	public static final String SITE_WEB_ROOT = getProperty("site.web.root");
	public static final String SITE_WEB_ROOT2 = getProperty("site.web.root2");	
	public static final String SITE_ROOT = getProperty("site.root");
	public static final String SITE_BASE_URL=getProperty("vauser.webapp.host");

	public static final int VETERANSWEEKNYC2012_DAYS_VALID = 45;
	
	public static final String EMAIL_TEMPLATE_DIR = getProperty("email.template.dir");
	public static final String CCKEY = getProperty("card.key");

	//------[Google Affiliate Network Configuration]--------
	public static final String GAN_FTP_HOST = getProperty("gan.ftp.host");
	public static final String GAN_FTP_USER = getProperty("gan.ftp.user");
	public static final String GAN_FTP_PASS = getProperty("gan.ftp.pass");
	
	// -----[Mail Server Configuration]---------------------
	public static final String MAIL_SMTP_HOST = getProperty("mail.smtp.host");
	public static final String MAIL_SMTP_PORT = getProperty("mail.smtp.port");
	public static final String MAIL_SMTP_AUTH = getProperty("mail.smtp.auth");
	public static final String MAIL_SMTP_USER = getProperty("smtp.user");
	public static final String MAIL_SMTP_PASSWORD = getProperty("smtp.password");

	// -----[initparameters transferred from web.xml]--------
	public static final String SENDER_DOMAIN = getProperty("sender.domain");
	public static final String SENDER_NAME = getProperty("sender.name");
	public static final String SENDER_EMAIL = getProperty("sender.email");

	// ----[autodellemail config]------
	public static final String AUTO_DELL_EMAIL_TO = getProperty("email.autodellemail.to");
	public static final String AUTO_DELL_EMAIL_FROM = getProperty("email.autodellemail.from");
	
	// ---- [Postmark api key] --------
//	public static final String POSTMARK_API_KEY = getProperty("postmark.api.key");

	// ---- [WWP Result Email configuration] --------
	public static final String WWP_RESULTS_RECIPIENT_NAME = getProperty("wwp.results.recipient.name");
	public static final String WWP_RESULTS_EMAIL_ADD = getProperty("wwp.results.email.add");	
	public static final String WWP_RESULTS_EMAIL_ADD2 = getProperty("wwp.results.email.add2");
	public static final String WWP_RESULTS_EMAIL_FILE = getProperty("wwp.results.email.file");
	public static final String WWP_RESULTS_EMAIL_SUBJECT = getProperty("wwp.results.email.subject");
	

	/**
	 * WWP ACCOUNTS weekly email file
	 */
	public static final String WWPACCOUNTS_WEEKLY_EMAIL_FILE = getProperty("wwp.accounts.weekly.email.file");
	
	/**
	 * WWP ACCOUNTS weekly email subject
	 */
	public static final String WWPACCOUNTS_WEEKLY_EMAIL_SUBJECT = getProperty("wwp.accounts.weekly.email.subject");
	
	public static final String WWPACCOUNT_WEEKLY_EMAIL_ADD = getProperty("wwp.accounts.weekly.email.add");
	
	public static final String WWPACCOUNT_WEEKLY_EMAIL_ADD2 = getProperty("wwp.accounts.weekly.email.add2");
	
	/**
	 * Bear account properties
	 */
	public static final String BEAR_ACCOUNT_EMAIL_RECIPIENT_NAME = getProperty("bear.account.recipient.name");
	
	public static final String BEAR_ACCOUNT_EMAIL_RECIPIENT_NAME2 = getProperty("bear.account.recipient.name2");

	public static final String BEAR_ACCOUNT_EMAIL_ADD = getProperty("bear.account.email.add");
	
	public static final String BEAR_ACCOUNT_EMAIL_ADD2 = getProperty("bear.account.email.add2");
	
	public static final String BEAR_ACCOUNT_EMAIL_SUBJECT = getProperty("bear.account.email.subject");
	
	public static final String BEAR_ACCOUNT_EMAIL_FILE = getProperty("bear.account.email.file");

	/**
	 * WWP automated export properties
	 */
	public static final String WWP_EXPORT_EMAIL_RECIPIENT_NAME = getProperty("wwp.export.recipient.name");
	
	public static final String WWP_EXPORT_EMAIL_RECIPIENT_NAME2 = getProperty("wwp.export.recipient.name2");

	public static final String WWP_EXPORT_EMAIL_ADD = getProperty("wwp.export.email.add");
	
	public static final String WWP_EXPORT_EMAIL_ADD2 = getProperty("wwp.export.email.add2");
	
	public static final String WWP_EXPORT_EMAIL_SUBJECT = getProperty("wwp.export.email.subject");
	
	public static final String WWP_EXPORT_EMAIL_FILE = getProperty("wwp.export.email.file");	

	/**
	 * 50 states cash registers properties
	 */
	public static final String STATE_REGISTERS_EMAIL_RECIPIENT_NAME = getProperty("state.registers.recipient.name");
	
	public static final String STATE_REGISTERS_EMAIL_RECIPIENT_NAME2 = getProperty("state.registers.recipient.name2");

	public static final String STATE_REGISTERS_EMAIL_ADD = getProperty("state.registers.email.add");
	
	public static final String STATE_REGISTERS_EMAIL_ADD2 = getProperty("state.registers.email.add2");
	
	public static final String STATE_REGISTERS_EMAIL_SUBJECT = getProperty("state.registers.email.subject");
	
	public static final String STATE_REGISTERS_EMAIL_FILE = getProperty("state.registers.email.file");	
	
	/**
	 * Special Offer Response Email
	 */
	public static final String SPECIAL_OFFER_EMAIL = getProperty("special.offer.email");	
	
	public static final String YESMAIL_FTP_HOST_NAME = getProperty("yesmail.ftp.host.name");
	public static final String YESMAIL_FTP_USER_NAME = getProperty("yesmail.ftp.user.name");
	public static final String YESMAIL_FTP_PASSWORD = getProperty("yesmail.ftp.password");
	public static final String YESMAIL_FTP_UPLOAD_DIR = getProperty("yesmail.ftp.upload.dir");
	
	public static final String EXACTTARGET_FTP_HOST_NAME = getProperty("exacttarget.ftp.host.name");
	public static final String EXACTTARGET_FTP_USER_NAME = getProperty("exacttarget.ftp.user.name");
	public static final String EXACTTARGET_FTP_PASSWORD = getProperty("exacttarget.ftp.password");
	public static final String EXACTTARGET_FTP_UPLOAD_DIR = getProperty("exacttarget.ftp.upload.dir");

	/**
	 * Plum Voice Account
	 */
	
//	public static final String PLUM_VOICE_LOGIN = getProperty("plum.voice.login");
 	 
//	public static final String PLUM_VOICE_PIN = getProperty("plum.voice.pin");
	
//	public static final String PLUM_VOICE_TEL_NO = getProperty("plum.voice.tel.no");
	
//	public static final String PLUM_VOICE_EXT_NO = getProperty("plum.voice.ext.no");
	 
//	public static final String PLUM_VOICE_OUTBOUND_URL = getProperty("plum.voice.outbound.url");

//	public static final String PLUM_VOICE_XML_TEMPLATE = getProperty("plum.voice.xml.template");
	
//	public static final String PLUM_VOICE_XML_FILENAME = getProperty("plum.voice.xml.filename");
	
	/**
	 * <p>
	 * The url of the user web app.
	 * </p>
	 */
	public static final String USER_WEBAPP_URL = getProperty("vauser.webapp.host");

	/**
	 * <p>
	 * The web root of the public web application.
	 * </p>
	 */
	public static final String USER_WEBAPP_ROOT = "/alt";

	/**
	 * <p>
	 * The web root of the admin web application.
	 * </p>
	 */
	public static final String ADMIN_WEBAPP_ROOT = "/admin";

	/**
	 * <p>
	 * The web root of the admin static assets.
	 * </p>
	 */
	
	public static final String ADMIN_STATIC_WEB_ROOT = "/static-admin";
	
	public static final String CLOUDFRONT_URL = "https://d26yigxxs6gued.cloudfront.net";

	/**
	 * <p>
	 * The descriptive name of the admin webapp.
	 * </p>
	 */
	public static final String ADMIN_LONG_NAME = getProperty("admin.webapp.longname");

	/**
	 * <p>
	 * The descriptive name of the public site webapp.
	 * </p>
	 */
	public static final String USER_WEBAPP_LONG_NAME = getProperty("vauser.webapp.longname");

	/**
	 * <p>
	 * Name of the url parameter for error messages.
	 * </p>
	 */
	public static final String ERR_MSG_PARAM = "errMsg";

	/**
	 * <p>
	 * A value for ERR_MSG_PARAM parameter.
	 * </p>
	 */
	public static final String INVALID_LOGIN_KEY = "invalid";

	/**
	 * <p>
	 * A value for ERR_MSG_PARAM parameter
	 * </p>
	 * Purpose: For Invalid Messages During Username and Password Error
	 * 
	 * @Author Christopher Gabijan
	 */
	public static final String INVALID_LOGIN_KEY_UNAME_PWD = "invalidUP";
	
	public static final String INVALID_LOGIN_EXPIRED_ACCOUNT = "expiredAccount";
	
	public static final String INVALID_LOGIN_PASSED_EXPIRATION_DATE = "passedExpirationDate";
	
	public static final String ONETIME_REGISTRATION_CONSUMED = "onetime_registration_consumed";

	public static final String SITE_CODE = getProperty("site.code");

	/**
	 * The address of the JNDI server.
	 */
	public static final String JNDI_SERVER = getProperty("jndi.server");

	/**
     *
     */
	public static final String JNDI_LOCATION_PROPERTY = getProperty("jndi.location.prop");

	/**
	 * JNDI Prefix
	 */
	//public static final String JNDI_PREFIX = getProperty("jndi.prefix");

	/**
	 * The jdbc driver class
	 */
	public static final String DB_DRIVER_CLASS = getProperty("db.driver");

	/**
	 * Options to pass the database driver.
	 */
	public static final String DB_URL_OPTS = getProperty("db.url.opts");

	/**
	 * Name of the database.
	 */
	public static final String DB_NAME = getProperty("db.name");

	/**
	 * The host url of the database.
	 */
	public static final String DB_URL = getProperty("db.url") + Configuration.DB_NAME+ Configuration.DB_URL_OPTS;

	/**
	 * Database user.
	 */
	public static final String DB_USER = getProperty("db.user");

	/**
	 * Database password.
	 */
	public static final String DB_PASSWORD = getProperty("db.password");

	/**
	 * The database datasource name.
	 */
	public static final String DB_SOURCE_NAME = "java:/" + Configuration.DB_NAME;

	/**
	 * Data source name.
	 */
	public static final String DATA_SOURCE = getProperty("data.source");

	/**
	 * The number of seconds that a DataSource will remain active until it times
	 * out.
	 */
	public static final int DATA_SOURCE_TIMEOUT = Integer.parseInt(getProperty("data.source.timeout"));

	/**
	 * The number of search results to use by default.
	 */
	public static final int SEARCH_RESULTS_COUNT_DEFAULT = Integer.parseInt(getProperty("search.results.count.default"));

	/**
	 * The file containing the welcome email text.
	 */
	public static final String WELCOME_EMAIL_FILE = getProperty("email.welcome.file");

	/**
	 * The email subject line for the welcome email.
	 */
	public static final String WELCOME_EMAIL_SUBJECT = getProperty("email.welcome.subject");
	
	/**
	 * The file containing the temporary card email text.
	 */
	public static final String DISPOSITION_TEMPCARD_EMAIL_FILE = getProperty("email.dispotempcard.file");

	/**
	 * The email subject line for the temporary card email.
	 */
	public static final String DISPOSITION_TEMPCARD_EMAIL_SUBJECT = getProperty("email.dispotempcard.subject");
	
	
	public static final String EMAIL_VERIFICATION_SUBJECT = getProperty("email.verification.subject");
	
	/**
	 * The file containing the newsletter email text.
	 */
	public static final String NEWSLETTER_EMAIL_FILE = getProperty("email.newsletter.file");

	/**
	 * The email subject line for the newsletter email.
	 */
	public static final String NEWSLETTER_EMAIL_SUBJECT = getProperty("email.newsletter.subject");

	/**
	 * The file containing the recipient email text
	 */
	public static final String RECIPIENT_EMAIL_FILE = getProperty("email.recipient.file");

	/**
	 * The email subject line for recipient email.
	 */
	public static final String RECIPIENT_EMAIL_SUBJECT = getProperty("email.recipient.subject");

	/**
	 * The file containing the giver email text
	 */
	public static final String GIVER_EMAIL_FILE = getProperty("email.giver.file");

	/**
	 * The email subject line for giver email.
	 */
	public static final String GIVER_EMAIL_SUBJECT = getProperty("email.giver.subject");

	/**
	 * The file containing the giver email text
	 */
	public static final String GIVER_INFO_EMAIL_FILE = getProperty("email.giver.info.file");

	/**
	 * The email subject line for giver email.
	 */
	public static final String GIVER_INFO_EMAIL_SUBJECT = getProperty("email.giver.info.subject");

	
	/**
	 * The file containing the giver email for administer
	 */
	public static final String GIVER_ADMINISTER_EMAIL_FILE = getProperty("email.giver.administer.file");
	
	/**
	 * The email subject line for giver email for administer
	 */
	public static final String GIVER_ADMINISTER_EMAIL_SUBJECT = getProperty("email.giver.administer.subject");
	
	/**
	 * The file containing the pending email text.
	 */
	public static final String PENDING_EMAIL_FILE = getProperty("email.pending.file");

	/**
	 * The email subject line for the pending email.
	 */
	public static final String PENDING_EMAIL_SUBJECT = getProperty("email.pending.subject");

	/**
	 * The file containing the renewal email text.
	 */
	public static final String RENEWAL_EMAIL_FILE = getProperty("email.renewal.file");

	/**
	 * The email subject line for the renewal email.
	 */
	public static final String RENEWAL_EMAIL_SUBJECT = getProperty("email.renewal.subject");
	
	/**
	 * The file containing the renewal email text.
	 */
	public static final String UPGRADE_EMAIL_FILE = getProperty("email.upgrade.file");

	/**
	 * The email subject line for the renewal email.
	 */
	public static final String UPGRADE_EMAIL_SUBJECT = getProperty("email.upgrade.subject");

	/**
	 * The file containing the email registration email text.
	 */
	public static final String EMAIL_REGISTER_EMAIL_FILE = getProperty("email.emailregister.file");

	/**
	 * The email subject line for the USP email registration.
	 */
	public static final String EMAIL_REGISTER_EMAIL_SUBJECT = getProperty("email.emailregister.subject");
	
	/**
	 * The file containing the medevac email text.
	 */
	public static final String MEDEVAC_EMAIL_FILE = getProperty("email.medevac.file");
	
	/**
	 * The email subject line for medevac.
	 */
	public static final String MEDEVAC_EMAIL_SUBJECT = getProperty("email.medevac.subject");

	/**
	 * The file containing the email registration email text.
	 */
	public static final String THANK_TROOPS_EMAIL_FILE = getProperty("email.thanktroops.file");

	/**
	 * The email subject line for the USP email registration.
	 */
	public static final String THANK_TROOPS_EMAIL_SUBJECT = getProperty("email.thanktroops.subject");

	/**
	 * The email subject for the disposition
	 */
	public static final String DISPOSITION_EMAIL_SUBJECT = getProperty("email.disposition.subject");

	/**
	 * This is the email sender on disposition
	 */
	public static final String DISPOSITION_EMAIL_TO = getProperty("email.disposition.to");

	/**
	 * This is the email recipient on the disposition
	 */
	public static final String DISPOSITION_EMAIL_FROM = getProperty("email.disposition.from");

	/**
	 * This the bodytext file for the last renewal attempt
	 */
	public static final String LAST_RENEWAL_EMAIL_FILE = getProperty("email.renewal.last.file");

	/**
	 * This is the default subject for this mail
	 */
	public static final String LAST_RENEWAL_EMAIL_SUBJECT = getProperty("email.renewal.last.subject");

	/**
	 * This file is the content of Last Conversion Mailer
	 */
	public static final String LAST_CONVERSION_EMAIL_FILE = getProperty("email.conversion.last.file");

	/**
	 * This file is the subject of Last Conversion Mailer
	 */
	public static final String LAST_CONVERSION_EMAIL_SUBJECT = getProperty("email.conversion.last.subject");

	/**
	 * The email address emails are sent from.
	 */
	public static final String FROM_EMAIL = getProperty("email.from");

	public static final String SUPPORT_EMAIL = getProperty("email.support");
	
	public static final String EMAIL_PARTNER_UPLOAD_VALIDATION_ERRROR_TITLE = getProperty("email.partner.upload.validation.error.title");
	
	public static final String EMAIL_PARTNER_UPLOAD_VALIDATION_ERRROR_MSG = getProperty("email.partner.upload.validation.error.msg");
	
	public static final String VERIFICATION_EMAIL = getProperty("email.verification");
	
	public static final String EMAIL_ALERT_TO = getProperty("email.alert.to");
	
	public static final String EMAIL_ALERT_FROM = getProperty("email.alert.from");

	/**
	 * The email address emails are sent to during development.
	 */
	public static final String TO_EMAIL = getProperty("email.to");
	
	/**
	 * The email address where the duplicate monitoring log send to.
	 */
	public static final String DUPLICATE_MONITORING_EMAIL = getProperty("duplicate.monitoring.email");

	/**
	 * The partner upload report location.
	 */
	public static final String PARTNER_REPORT_PATH = getProperty("partner.report.path");

	/**
	 * Always use the product from partner table for trial memberships.
	 */
	public static final boolean PARTNER_TRIAL_USEPARTNER = new Boolean(getProperty("partner.trial.usepartner")).booleanValue();

	/**
	 * Public phone number for orders.
	 */
	public static final String CONTACT_PHONE = getProperty("phone.number.orders");

	/**
	 * Public phone number for customer service.
	 */
	public static final String CS_PHONE = getProperty("phone.number.cs");

	/**
	 * Setting to define if primary membership is billed on a monthly cycle.
	 */
	public static final boolean FEATURE_MEMBERSHIP_MONTHLY = new Boolean(getProperty("feature.membership.monthly")).booleanValue();

	/**
	 * Setting to enable or disable family cards.
	 */
	public static final boolean FEATURE_FAMILYCARDS = new Boolean(getProperty("feature.familycards"))
			.booleanValue();

	/**
	 * Setting to enable or disable choice of trials.
	 */
	public static final boolean FEATURE_TRIAL_CHOICE = new Boolean(getProperty("feature.trialchoice"))
			.booleanValue();

	/**
	 * Setting to enable or disable immediate pay option.
	 */
	public static final boolean FEATURE_IMMEDIATE_PAY = new Boolean(getProperty("feature.immediatepay"))
			.booleanValue();

	/**
	 * Setting to enable displaying expiration date on temp card.
	 */
	public static final boolean FEATURE_TMP_CARD_EXP_DATE = new Boolean(getProperty("feature.tmpcard.expdate")).booleanValue();

	/**
	 * Setting to enable or disable collection of service information.
	 */
	public static final boolean FEATURE_SERVICE_INFO = new Boolean(getProperty("feature.serviceinfo"))
			.booleanValue();

	/**
	 * Location for exporting member lists.
	 */
	public static final String MEMBER_FILE_DIR = getProperty("member.file.dir");

	/**
	 * Prefix for the member list export files.d
	 */
	public static final String MEMBER_FILE_DIR_LOCAL = getProperty("member.file.dir.local");

	public static final String FORM_MAILER_VALID_DOMAINS = getProperty("vaformmailer.valid.rcpt.domain");

	public static final String FORM_MAILER_VALID_EMAILS = getProperty("vaformmailer.valid.rcpt.specific");

	/**
	 * Indicator whether to use secure cookies for linkshare
	 */
	public static final boolean SECURE_COOKIES_LINKSHARE = new Boolean(getProperty("secure.cookies.linkshare")).booleanValue();

	/**
	 * Indicator whether to use secure cookies for authorization
	 */
	public static final boolean SECURE_COOKIES_AUTH = new Boolean(getProperty("secure.cookies.auth"))
			.booleanValue();

	/**
	 * Indicator whether to use secure cookies for target
	 */
	public static final boolean SECURE_COOKIES_TARGET = new Boolean(getProperty("secure.cookies.target"))
			.booleanValue();

	/**
	 * Autorenewal / Conversion / Expiry Periods
	 */
	public static final int EXPIRY_PERIOD = Integer.parseInt(getProperty("autorenew.conversions.expiry.grace.period"));
	public static final int PROMO_PERIOD = Integer.parseInt(getProperty("autorenew.conversions.period"));
	public static final int RENEWAL_PERIOD = Integer.parseInt(getProperty("autorenew.renewals.period"));
	/**
	 * The JNDI Properties
	 */
	public static final String[][] JNDIProperties = {
			{ "java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory" },
			{ "java.naming.provider.url", JNDI_SERVER },
			{ "java.naming.factry.url.pkgs", "org.jboss.naming:org.jnp.interfaces" } };

	public static Properties getJNDIProperties() {
		Properties env = new Properties();
		String[][] propertyList = Configuration.JNDIProperties;
		for (int i = 0; i < propertyList.length; i++) {
			env.put(propertyList[i][0], propertyList[i][1]);
		}
		return env;
	}

	/**
	 * Master password
	 */
	public static final String MASTER_PASSWORD = getProperty("master.password");
	
	public static int AUTHNET_ALLOW_ZERO_CC=0; 
	public static int AUTHNET_GATEWAYID=0; //defaults to random gateway
	
	/**
	 * USPS Address Validation Configurables
	 * "http://production.shippingapis.com/ShippingAPITest.dll?API=Verify&XML="
	 */
	public static final String USPS_WEBAPI_ENABLED = getProperty("usps.webapi.enabled");
	public static final String USPS_WEBAPI_PREFIX_URL = getProperty("usps.webapi.url.prefix");
	
	public static final Boolean USPS_WEBAPI_REPLACE_WITH_VALIDATED_ADDRESS = new Boolean(getProperty("usps.webapi.use.validated.address"))
	.booleanValue();
	
	public static final String USPS_WEBAPI_ACCESS_KEY = getProperty("usps.webapi.accesskey");
	
	public static final String PAYPAL_USERNAME = getProperty("paypal.username");
	public static final String PAYPAL_PASSWORD = getProperty("paypal.password");
	public static final String PAYPAL_SIGNATURE = getProperty("paypal.signature");
	public static final String PAYPAL_ENVIRONMENT = getProperty("paypal.environment");
	public static final String PAYPAL_CHECKOUT_URL = getProperty("paypal.url.checkout");
	public static final String PAYPAL_REGISTER_SUCCESS_URL = getProperty("paypal.register.url.success");
	public static final String PAYPAL_REGISTER_FAILED_URL = getProperty("paypal.register.url.failed");
	public static final String PAYPAL_RENEWAL_URL = getProperty("paypal.renewal.url");
	public static final String PAYPAL_ORDER_DESCRIPTION = getProperty("paypal.order.description");
	public static final String PAYPAL_FAMILYCARD_DESCRIPTION = getProperty("paypal.familycard.url");
	public static final String PAYPAL_CARDREPLACEMENT_DESCRIPTION = getProperty("paypal.cardreplacement.url");
	public static final String PAYPAL_UPDATEBILLING_DESCRIPTION = getProperty("paypal.editbilling.url");	
	
	
	//non member disposition email to 
	public static final String NON_MEMBER_EMAIL_TO1 = getProperty("nonmember.email.to1");
	public static final String NON_MEMBER_EMAIL_TO2 = getProperty("nonmember.email.to2");
	public static final String NON_MEMBER_EMAIL_TO3 = getProperty("nonmember.email.to3");
	
	
	//Exact Target API
	public static final String ET_API_CLIENTID = getProperty("etapi.clientid");
	public static final String ET_API_CLIENTSECRET = getProperty("etapi.clientsecret");
	public static final String ET_API_EMAIL_NEWSLETTER = getProperty("etapi.email.newsletter.key");
	public static final String ET_API_EMAIL_PENDING = getProperty("etapi.email.pending.key");
	
	// IDNYC upload path
	public static final String IDNYC_UPLOAD_PATH = getProperty("idnyc.upload.path");
	
	//Google Tracking ID
	public static final String GOOGLE_TRACKING_ID = getProperty("google.tracking.id");
	
	
	//IDNYC sftp server
	public static final String IDNYC_SFTP_SERVER = getProperty("idnyc.sftpServer");
	public static final String IDNYC_SFTP_PORT = getProperty("idnyc.sftpPort");
	public static final String IDNYC_SFTP_USERID = getProperty("idnyc.sftpUserId");
	public static final String IDNYC_SFTP_PASSWORD = getProperty("idnyc.sftPassword");
 	public static final String IDNYC_SFTP_REMOTEDIR = getProperty("idnyc.remoteDirectory");
	public static final String IDNYC_SFTP_LOCALDIR = getProperty("idnyc.localDirectory");
	
  
	
}
