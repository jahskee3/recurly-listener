package com.va.core;


import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class BusinessLogic {

	private static final Logger log = Logger.getLogger(BusinessLogic.class);

	private final static String APP_SITE = System.getProperty("app.site");

	private final static String SITE_VA = "VA";
	private final static String SITE_VAT = "VAT";
	private final static String SITE_USP = "USP";
	private final static String SITE_LFP = "LFP";
	private final static String SITE_MILVETID="MILVETID";
	
	private final static String PARTNER_OFFER1 = "offer1";
	private final static String PARTNER_OFFER82 = "offer82";
	private final static String PARTNER_OFFER85 = "offer85";
	private final static String PARTNER_OFFER92 = "offer92";
	private final static String PARTNER_OFFER56 = "offer56";

	public static boolean isMonthlyRenewals() {
		return (isUSP() || isLFP());
	}

	public static boolean isYearlyRenewals() {
		return (isVA() || isVAT());
	}

	public static boolean hasRenewalShipping() {
		return (isVA() || isVAT());
	}

	public static boolean hasInitialCardOrder() {
		return (isVA() || isVAT() || isUSP() || isLFP());
	}

	public static boolean hasInitialFullPayCardOrder() {
		return (isVA() || isVAT() || isUSP() || isLFP());
	}

	public static boolean hasConversionCardOrder() {
		return false;
	}

	public static boolean hasConversionExtension() {
		return (isUSP() || isLFP());
	}

	public static boolean hasRenewalShipCardOrder() {
		return (isVA() || isVAT());
	}

	public static boolean hasRenewalCardOrder() {
		return false;
	}

	public static boolean hasManualRenewalCardOrder() {
		return (isVA() || isVAT());
	}

	public static boolean hasExtendedCardExpirationDate() {
		return (isUSP() || isLFP());
	}

	public static boolean supportDiscover() {
		return true;
	}

	public static boolean isVA() {		
		return SITE_VA.equals(getSite());
	}

	public static boolean isMILVETID(){
		return SITE_MILVETID.equals(getSite());
	}
	
	public static boolean isVAT() {
		return SITE_VAT.equals(getSite());
	}

	public static boolean isUSP() {
		return SITE_USP.equals(getSite());
	}

	public static boolean isLFP() {
		return SITE_LFP.equals(getSite());
	}

	public static String getSite() {
		if (StringUtils.isBlank(APP_SITE)) {
			throw new IllegalArgumentException("-Dapp.site is blank");
		}

		return APP_SITE;
	}

	public static boolean isBuyOneGetTwoFree(String partner) {
		return (PARTNER_OFFER1.equalsIgnoreCase(partner) || PARTNER_OFFER82.equalsIgnoreCase(partner) 
				|| PARTNER_OFFER56.equalsIgnoreCase(partner) || PARTNER_OFFER92.equalsIgnoreCase(partner)
				|| PARTNER_OFFER85.equalsIgnoreCase(partner));
	}

	public static String getDomain() {
		String merchantId = null;
		if (BusinessLogic.isVA() || BusinessLogic.isMILVETID()) {
			merchantId = "www.veteransadvantage.com";
		} else if (BusinessLogic.isVAT()) {
			merchantId = "www.vatravelcard.com";
		} else if (BusinessLogic.isUSP()) {
			merchantId = "www.uspatriotcard.com";
		} else if (BusinessLogic.isLFP()) {
			merchantId = "www.libertyfunpass.com";
		} else {
			throw new IllegalArgumentException("unknown merchantId");
		}
		return merchantId;
	}

	public static boolean cannotManuallyRenew(String partner) {
		if (BusinessLogic.isWWP(partner)
				|| BusinessLogic.isVeteransWeek(partner)
				|| BusinessLogic.isGeVeteransWeekNYC2012(partner)
				|| BusinessLogic.isVeteransWeekNYC2012(partner)
				|| BusinessLogic.isGeVeterans(partner)) {
			return true;
		}

		return false;
	}

	public static boolean canUpdateBilling(String partner) {
		if (BusinessLogic.isPartnerContainsWWP(partner)) {
			return false;
		}
		return true;
	}

	public static boolean isPartnerContainsWWP(String partner) {
		if(partner==null)return false;
		return (partner.contains("wwp"));
	}

	public static boolean isVip(String partner) {
		if (StringUtils.isBlank(partner))
			return false;
		return ("vip".equals(partner));
	}

	public static boolean isWWP(String partner) {
		if (StringUtils.isBlank(partner))
			return false;
		return ("wwp".equals(partner));
	}

	private static boolean isSyracuse(String partner) {
		if (StringUtils.isBlank(partner))
			return false;
		return ("syracuse".equals(partner));
	}

	public static boolean hasVetWeekHardCodedDates(String partner) {
		if (BusinessLogic.isVeteransWeek(partner)
				||BusinessLogic.isGeVeteransWeekNYC2012(partner)
				|| BusinessLogic.isVeteransWeekNYC2012(partner)) {
			return true;
		}
		return false;
	}

	public static boolean hasAutoRenewOff(String partner) {
		if (BusinessLogic.isSyracuse(partner)
				|| BusinessLogic.isVeteransWeek(partner)
				|| BusinessLogic.isGeVeteransWeekNYC2012(partner)				
				|| BusinessLogic.isVeteransWeekNYC2012(partner)
				|| BusinessLogic.isWWP(partner)
				|| BusinessLogic.isIdNycD(partner)
				|| BusinessLogic.isIdNycWV(partner)
				|| BusinessLogic.isGeVeterans(partner)
				|| BusinessLogic.isPartnerContainsWWP(partner)
				|| BusinessLogic.isPartnerContainsMilvet(partner)) {
			return true;
		}
		return false;
	}

	private static boolean isGeVeterans(String partner) {
		if (StringUtils.isBlank(partner))
			return false;
		return ("geveterans".equals(partner));

	}

	private static boolean isGeVeteransWeekNYC2012(String partner) {
		if (StringUtils.isBlank(partner))
			return false;
		return ("geveteransweeknyc2012".equals(partner));
	}
	
	private static boolean isIdNycD(String partner) {
		if (StringUtils.isBlank(partner))
			return false;
		return ("idnyc-d".equals(partner));
	}
	
	private static boolean isIdNycWV(String partner) {
		if (StringUtils.isBlank(partner))
			return false;
		return ("idnyc-wv".equals(partner));
	}
	
	private static boolean isVeteransWeekNYC2012(String partner) {
		if (StringUtils.isBlank(partner))
			return false;

		boolean isvetweekfree = ( "veteransweeknyc2012".equals(partner)
				|| "cuny".equals(partner) || "citi".equals(partner));

		return isvetweekfree;

	}
	
	private static boolean isVeteransWeek(String partner) {
		if (StringUtils.isBlank(partner))
			return false;
		return "veteransweek".equals(partner);		
	}

	public static boolean isMilvetJobs(String partner) {
		if (StringUtils.isBlank(partner))
			return false;
		return "milvet-jobs".equalsIgnoreCase(partner);		
	}
	
	public static boolean isMilvet(String partner) {
		if (StringUtils.isBlank(partner))
			return false;
		return "milvet".equals(partner);		
	}

	public static boolean isMilvetCvs(String partner) {
		if (StringUtils.isBlank(partner))
			return false;
		return "milvet-cvs".equals(partner);		
	}

	public static boolean isPartnerContainsMilvet(String partner) {
		if (StringUtils.isBlank(partner))
			return false;
		boolean isContainsMilvet = (BusinessLogic.isMilvet(partner)|| BusinessLogic.isMilvetCvs(partner));
		return isContainsMilvet;		
	}
	
	
	public static boolean isSendWelcomeEmail(String partner) {
		if(partner==null)return true;
		partner = partner.trim();
		if (BusinessLogic.isGeVeteransWeekNYC2012(partner)
				|| BusinessLogic.isVeteransWeekNYC2012(partner)
				|| BusinessLogic.isGeVeterans(partner)
				|| BusinessLogic.isWWP(partner)
				|| BusinessLogic.isSyracuse(partner)			
				|| BusinessLogic.isMilvet(partner)
			    || BusinessLogic.isMilvetJobs(partner)) 
		{

			return false;
		}

		return true;
	}

	public static boolean isMinimalPartner(String partner) {
		if ("bear".equalsIgnoreCase(partner)) {
			return true;
		}
		return false;
	}

	public static boolean hasEmailOptional(String partner) {
		if (BusinessLogic.isGeVeteransWeekNYC2012(partner)
				|| BusinessLogic.isGeVeterans(partner)) {
			return true;
		}
		return false;
	}

	public static boolean hasNoMedevacAccess(String partner) {
		if ("offer32".equalsIgnoreCase(partner)) {
			return true;
		}
		return false;
	}

	public static boolean isSendAbandonEmail(String partner) {
		if (partner.contains("veteransweek") || partner.contains("milvet")) {
			log.warn("Session expired, abandon email not sent, member partnerCode contains 'vetaransweek' or 'milvet'.");
			return false;
		}
		return true;
	}

	public static boolean hasNoBilling(String partner) {
		if (BusinessLogic.isGeVeteransWeekNYC2012(partner)
				|| BusinessLogic.isVeteransWeekNYC2012(partner)
				|| BusinessLogic.isGeVeterans(partner)) {
			return true;
		}
		return false;
	}

	public static boolean hasPhoneOptional(String partner) {
		if (BusinessLogic.isVeteransWeekNYC2012(partner)
				|| BusinessLogic.isGeVeteransWeekNYC2012(partner)
				|| BusinessLogic.isGeVeterans(partner)) {
			return true;
		}
		return false;
	}

	public static boolean usePartnerProduct(String partner) {
		if ("offer34".equalsIgnoreCase(partner)) {
			return true;
		}
		return false;
	}
	
	public static boolean hasWwpResultFile(String partner){
		if(BusinessLogic.isWWP(partner)){
			return true;
		}
		return false;
	}

	public static boolean isAtLeastOnePhoneRequired(String partner){
		if (StringUtils.isBlank(partner)) {
			return false;
		}
		
		return ("dev".equals(partner)
				|| "promotion".equals(partner)
				|| "about".equals(partner)
				|| "united".equals(partner)
				|| "greyhound".equals(partner)
				|| "footlocker".equals(partner)
				|| "amtrak".equals(partner)
				|| "cvs".equals(partner)
				|| "offer44".equals(partner)
				|| "offer45".equals(partner)
				|| "lufthansa".equals(partner)
				
				|| "offer1".equals(partner)
				|| "offer82".equals(partner)
				|| "offer10".equals(partner)
				|| "offer11".equals(partner)
				|| "offer15".equals(partner)
				|| "offer16".equals(partner)
				|| "offer25".equals(partner)
				|| "offer26".equals(partner)
				|| "offer27".equals(partner)
				|| "offer28".equals(partner)
				
				|| "linkshare".equals(partner)
				|| "offer3".equals(partner)
				|| "offer36".equals(partner)
				
				|| "offer23".equals(partner)
				|| "offer74".equals(partner)
				|| "offer91".equals(partner)
				|| "offer92".equals(partner)
				|| "offer93".equals(partner)
				|| "offer94".equals(partner)
				|| "offer95".equals(partner)
				|| "offer96".equals(partner)
				
				|| "dell".equals(partner)
				|| "champssports".equals(partner) 
				|| "footaction".equals(partner) 
				|| "kidsfootlocker".equals(partner)
				|| "ladyfootlocker".equals(partner) 
				|| "eastbay".equals(partner) 
				|| "offer6".equals(partner) 
				|| "offer17".equals(partner) 
				|| "offer39".equals(partner) 
				|| "offer35".equals(partner) 
				|| "offer40".equals(partner) 
				|| "offer43".equals(partner) 
				|| "vaoffer1".equals(partner) 
				|| "offer32".equals(partner) 
				|| "offer34".equals(partner)
				|| "offer55".equals(partner)
				
				|| "tamu".equals(partner)
				
				|| "offer62".equals(partner)
				|| "offer63".equals(partner)
				);
	}
	
	public static boolean isSendReceivableEmail(){		
		if(BusinessLogic.isVA() || BusinessLogic.isMILVETID()){
			return true;
		}
		
		return false;
	}
	
	
	public static boolean isSendMilitaryVerificationEmail(String partner){
		boolean isSendMilitaryVerificationEmail=true;
		if(partner.equalsIgnoreCase("vetforce")){
			isSendMilitaryVerificationEmail = false;
		}
		return isSendMilitaryVerificationEmail;
	}	
	public static boolean isRegMilitaryVerification(String partner){
		Boolean isRegVerification = false;
		if(!StringUtils.isBlank(partner)){
			if(partner.equalsIgnoreCase("milvet-cvs") || partner.equalsIgnoreCase("milvet")){
				isRegVerification = true;
			}
		}		
		return isRegVerification;
	}

	public static boolean isExcludedFromCardBatch(String partner){
		Boolean isExcludedFromCardBatch = false;
		
		if(!StringUtils.isBlank(partner)){
			if(partner.equalsIgnoreCase("idnyc-d")
					|| partner.equalsIgnoreCase("semperfidelis-d")){
				isExcludedFromCardBatch = true;
			}
		}		
		return isExcludedFromCardBatch;		
	}
	
	public static boolean isRefreshPartnerPricing(String partner){
		Boolean isRefreshPricing = false;
		
		if(!StringUtils.isBlank(partner)){
			if(partner.startsWith("idnyc")
					|| partner.startsWith("semperfidelis")){
				isRefreshPricing = true;
			}
		}		
		return isRefreshPricing;	
	}
	
	public static boolean isBillingOff(String partner){
		Boolean isBillingOff = false;
		
		if(!StringUtils.isBlank(partner)){
			if(partner.equalsIgnoreCase("idnyc-d")
					|| partner.equalsIgnoreCase("idnyc-wv")
					|| partner.equalsIgnoreCase("semperfidelis-d")
					|| partner.equalsIgnoreCase("semperfidelis-wv")){
				isBillingOff = true;
			}
		}		
		return isBillingOff;	
	}
	
	public static boolean isCardOrderOff(String partner){
		Boolean isCardOrderOff = false;
		
		if(!StringUtils.isBlank(partner)){
			if("milvet-jobs".equalsIgnoreCase(partner)){
				isCardOrderOff = true;
			}
		}		
		return isCardOrderOff;	
	}	

	public static boolean isSpecialPartner(String partner){
		Boolean isSpecialPartner = false;
		
		if(!StringUtils.isBlank(partner)){
			if(partner.startsWith("idnyc")
					|| partner.startsWith("semperfidelis")){
				isSpecialPartner = true;
			} else {
				isSpecialPartner = false;
			}
		}		
		return isSpecialPartner;	
	}	

	public static boolean isCardOrderOffByProductDisplayName(String productDisplayName){
		Boolean isCardOrderOff = false;
		
		if(!StringUtils.isBlank(productDisplayName)){
			if(productDisplayName.contains("IDNYC Digital")
					|| productDisplayName.contains("Semper Fidelis Digital")){
				isCardOrderOff = true;
			}
		}		
		return isCardOrderOff;	
	}
	
	public static boolean useCodePartner(String partner) {
		if ("mutual".equalsIgnoreCase(partner)) {
			return true;
		}
		return false;
	}
	
	public static boolean isRecurlyOn(){
		boolean isRecurlyOn=false;
		if(BusinessLogic.isUSP() || BusinessLogic.isVA()){
			isRecurlyOn=true;
		}
		return isRecurlyOn;
	}
	
	public static boolean isSwitchToPartner(String partner){
		Boolean isSwitchToPartner = false;
		
		if(!StringUtils.isBlank(partner)){
			if(partner.startsWith("idnyc-")
					|| partner.startsWith("semperfidelis-")){
				isSwitchToPartner = true;
			}
		}		
		return isSwitchToPartner;		
	}
	
	public static boolean isValidPlanForSpecialPartner(String partner){
		Boolean isValidPlanForSpecialPartner = false;
		
		if(!StringUtils.isBlank(partner)){
			if(partner.equals("idnyc-50")
					|| partner.equals("idnyc-wv")
					|| partner.equals("idnyc-d")
					|| partner.equals("semperfidelis-50")
					|| partner.equals("semperfidelis-wv")
					|| partner.equals("semperfidelis-d")){
				isValidPlanForSpecialPartner = true;
			}
		}		
		return isValidPlanForSpecialPartner;		
	}
}
