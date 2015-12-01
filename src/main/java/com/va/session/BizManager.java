package com.va.session;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.ejb.CreateException;
import javax.ejb.EJBObject;

import com.va.core.VAException;
import com.va.data.AccountAddressInfo;
import com.va.data.AccountExInfo;
import com.va.data.AccountInfo;
import com.va.data.AccountNoteInfo;
import com.va.data.AccountWWPInfo;
import com.va.data.AddressInfo;
import com.va.data.BasicAccount;
import com.va.data.CardOrderInfo;
import com.va.data.CodeMemberIdInfo;
import com.va.data.CreditCardInfo;
import com.va.data.DispositionInfo;
import com.va.data.GiftCardInfo;
import com.va.data.IdnycMemberIdInfo;
import com.va.data.LogInfo;
import com.va.data.MailInfo;
import com.va.data.MarketingPartnerInfo;
import com.va.data.OrderInfo;
import com.va.data.OrderItemInfo;
import com.va.data.PartnerInfo;
import com.va.data.PartnerUploadInfo;
import com.va.data.PaymentInfo;
import com.va.data.PaypalInfo;
import com.va.data.ProductInfo;
import com.va.data.ProductPriceInfo;
import com.va.data.ProductTypeInfo;
import com.va.data.PromocodeInfo;
import com.va.data.RegistrationInfo;
import com.va.data.RenewalInfo;
import com.va.data.SingleRegistrationInfo;
import com.va.data.TerminationFormBatchInfo;
import com.va.data.TerminationFormInfo;
import com.va.recurly.models.AccountR;
import com.va.recurly.models.AddressR;
import com.va.recurly.models.BillingR;
import com.va.recurly.models.VASubscription;
import com.va.reusable.cc.CCOrderInfo;
import com.va.reusable.cc.CCTransactionInfo;
import com.va.reusable.paypal.va.PaypalTransactionInfo;
import com.va.vo.AccountEventInfo;
import com.va.vo.AccountLoginInfo;
import com.va.vo.AccountSponsor;
import com.va.vo.BasicDispoVO;
import com.va.vo.ExpiredAccountVO;
import com.va.vo.LocAndRetry;

/**
 * <p>
 * BizManager is the main facade interface that should be used by all client
 * code to access the business layer methods.
 * </p>
 *
 * <p>
 * TODO: Add synopsis.
 * </p>
 *
 * @author unknown
 * @author alan
 *
 * @version $Id: BizManager.java,v 1.97 2009/06/15 09:49:20 jaizon Exp $
 *
 */
public interface BizManager extends EJBObject {
	
	/*public String createAccountAndBilling(AccountR account, AddressR address, BillingR billing) throws RemoteException, VAException;
	
	public String createSubscription(VASubscription vaSubs) throws RemoteException, VAException;*/
	
	public void sendEmail(MailInfo mailInfo, String filePath, Hashtable<String, String> vars) throws RemoteException, VAException;
		
	public String createCardOrder(String accountOid, String orderId, String orderItemOid) throws RemoteException, VAException;
	
	void createPaypalTransaction(com.va.data.PaypalTransactionInfo info) throws RemoteException, VAException;
	
	public boolean isMemberExist(String memberId) throws RemoteException, VAException;
	
	public boolean isMilVet(String memberId) throws RemoteException, VAException;
	 
	public abstract OrderItemInfo getLastPrimaryOrderItem(String memberId, String paymentStatus)
			throws RemoteException, VAException;

	public void createSingleRegistration(SingleRegistrationInfo singleRegistrationInfo) throws RemoteException,  VAException;
	public boolean isSingleRegistrationUUIDConsumed(String partner, String uuid) throws RemoteException,  VAException;
	public abstract void setSingleRegistrationUUIDConsumed(String partner, String uuid,
			String memberID) throws RemoteException,  VAException;

	
	
	public abstract OrderInfo getLastPrimaryOrder(String memberId, String paymentStatus) throws RemoteException,
			VAException;

	public boolean isPrimaryOrder(String orderId) throws RemoteException, VAException;

	// public abstract Boolean isLastPaidPrimaryOrderTrial(String memberId)
	// throws RemoteException, VAException;

	// public abstract void emailSharedCreditCard(String emailTo)throws
	// RemoteException,VAException;

	public abstract List<String> getUploadPartners() throws RemoteException, VAException;
	
	public abstract List<String> getPartnerList() throws RemoteException, VAException;

	public abstract void partnerSetup(String partnerName, String emailNotification)
			throws RemoteException, VAException;

	// public abstract void updateAccountExpireReason(String memberId,boolean
	// isCurrentDate)throws RemoteException,VAException;

	// public abstract List<String> getMemberIdsByStatus(String status)throws
	// RemoteException,VAException;

	public abstract void sendDellEmail() throws RemoteException, VAException;

	// public abstract void processUndeliverablesCsvFile(String fileName,String
	// outputFile)throws RemoteException,VAException;

	/**
	 * <p>
	 * Auto renew a member identified by their member id.
	 * </p>
	 *
	 * @param memberID
	 *            - the member id of the account to renew.
	 * @return an OrderInfo value object containing the details of the renewal
	 *         order.
	 * @throws RemoteException
	 *             if there is a problem with the ejb server.
	 * @throws VAException
	 *             if there is a problem processing the renewal order.
	 */
	public abstract CCTransactionInfo autoRenewMember(String memberID, String productCodeOverride, String familyProductCodeOverride, boolean retryYear, String paymentMethod)
			throws RemoteException, VAException;
	
	public abstract void createForAutoCardOrder(BasicAccount basicAccount)
			throws RemoteException, VAException;

	public abstract int serverStatus() throws RemoteException, VAException;

	// public abstract String idgen()
	// throws RemoteException, VAException;

	public abstract LogInfo[] scanLog(String s) throws RemoteException, VAException;

	public abstract boolean verifyPassword(String s, String s1) throws RemoteException, VAException;

	public abstract String getPassword(String s) throws RemoteException, VAException;

	public abstract void setPassword(String s, String s1) throws RemoteException, VAException;

	public abstract void addAccountNotes(String memberID, String notes) throws RemoteException, VAException;

	public abstract void addOrderNotes(String orderID, String notes) throws RemoteException, VAException;

	public abstract String createAccount(AccountInfo accountinfo, AddressInfo addressinfo) throws RemoteException,
			VAException;
	
	public abstract String createAccountEx(AccountExInfo accountexinfo) throws RemoteException,
	VAException;

	// public abstract void cancelAccount(String memberID, String refund, Float
	// amount, String reason, String notes)
	// throws RemoteException, VAException;

	public abstract void batchCancelAccount(String memberId) throws RemoteException, VAException;

	public abstract boolean cancelAccountByOrderId(String orderID, String notes) throws RemoteException, VAException;

	public abstract boolean cancelAccountByMemberId(String memberID, String notes) throws RemoteException, VAException;

	// public abstract void saveAccountByGiftCard(String memberID, Float amount,
	// String type, String notes) throws RemoteException, VAException;

	public abstract void createTerminationForm(TerminationFormInfo info) throws RemoteException, VAException;

	// public abstract void createRefund(RefundInfo info)
	// throws RemoteException, VAException;
	public abstract String createNewsletterAccount(String s, String s1, String s2, AddressInfo address) throws RemoteException, VAException;	
	public abstract String createNewsletterAccount(String s, String s1, String s2, AddressInfo address, boolean isOptIn) throws RemoteException, VAException;

	// public abstract void destroyAccount(String memberID)
	// throws RemoteException, VAException;

	public abstract void destroyAccountByOID(String oid) throws RemoteException, VAException;
	
	public abstract void destroyAccountByMemberId(String memberId) throws RemoteException, VAException;
	
	public abstract void editAccount(String memberID, AccountInfo accountinfo, AddressInfo addressinfo,
			String eventNotes) throws RemoteException, VAException;

	public abstract AccountInfo viewAccount(String memberID) throws RemoteException, VAException;

	public abstract PartnerInfo viewPartner(String partnerName) throws RemoteException, VAException;
	
	public abstract AccountInfo viewAccountByOID(String oid) throws RemoteException, VAException;

	public abstract AddressInfo viewAddress(String memberID) throws RemoteException, VAException;

	// public abstract AddressInfo[] viewAddresses(AddressInfo anAddressInfo)
	// throws RemoteException, VAException;

	public abstract AddressInfo viewAddressByOID(String s) throws RemoteException, VAException;

	// public abstract AccountInfo[] findAccount(AccountInfo accountinfo, Date
	// startDate, Date endDate, int limit)
	// throws RemoteException, VAException;
	//
	public abstract AccountInfo[] findAccount(AccountInfo accountinfo) throws RemoteException, VAException;
	public abstract RenewalInfo findRenewalInfo(String memberID) throws RemoteException, VAException;
	
	public abstract AccountAddressInfo[] selectAccounts(AccountInfo accountParams, AddressInfo addressParams,
			CreditCardInfo creditCardParams, Date start, Date end, int limit) throws RemoteException, VAException;

	// public abstract AccountAddressInfo[] selectAccounts(AccountInfo
	// accountParams)
	// throws RemoteException, VAException;

	public abstract AccountEventInfo[] findAccountEvents(String memberID) throws RemoteException, VAException;

	public abstract void setCreditCard(String s, CreditCardInfo creditcardinfo) throws RemoteException, VAException;

	public abstract void updateCreditCard(String memberID, CreditCardInfo ccinfo) throws RemoteException, VAException;

	public abstract CreditCardInfo viewCreditCard(String memberID) throws RemoteException, VAException;
	
	public abstract PaypalInfo viewPaypal(String memberID) throws RemoteException, VAException;

	public abstract void setPaypal(String s, PaypalInfo paypalInfo) throws RemoteException, VAException;
	
	public abstract String[] getBillingDescriptor(String productCode)
			throws RemoteException, VAException;

	public abstract void setAutoRenew(String s, boolean flag) throws RemoteException, VAException;

	// public abstract String createProduct(ProductInfo productinfo)
	// throws RemoteException, VAException;

	// public abstract String createGeneratedProduct(ProductInfo info)
	// throws RemoteException, VAException;

	// public abstract void destroyProduct(String s)
	// throws RemoteException, VAException;

	// public abstract void editProduct(String s, ProductInfo productinfo)
	// throws RemoteException, VAException;
	//
	// public abstract void editProductByOID(String oid, ProductInfo info)
	// throws RemoteException, VAException;

	public abstract ProductInfo viewProduct(String productCode) throws RemoteException, VAException;
	
	public abstract ProductTypeInfo viewProductType(String productTypeId) throws RemoteException, VAException; 

	// public abstract ProductInfo viewProductByOID(String s)
	// throws RemoteException, VAException;

	// public abstract Collection viewProductByType(String s)
	// throws RemoteException, VAException;

	public abstract ProductInfo[] findProduct(ProductInfo productinfo) throws RemoteException, VAException;

	public abstract ProductTypeInfo[] findProductType(ProductTypeInfo searchParams) throws RemoteException, VAException;

	public abstract ProductTypeInfo findProductTypeByProductCode(String productCode) throws RemoteException,
			VAException;

	/**
	 * Creates a new product type which corresponds to the product type table.
	 *
	 * @param info
	 *            object containing the description to use for the product type
	 * @return the generated key
	 * @throws RemoteException
	 * @throws VAException
	 */
	// 03-01-2006 kohara added as part of product price change
	// public abstract String createProductType(ProductTypeInfo info)
	// throws RemoteException, VAException;
	/**
	 * View a product type which corresponds to the product type table.
	 *
	 * @param info
	 *            object containing the description to use for the product type
	 * @return object containing the data for the requested product type
	 * @throws RemoteException
	 * @throws VAException
	 */
	// public abstract ProductTypeInfo viewProductType(String s)
	// throws RemoteException, VAException;
	public abstract String createPromocode(PromocodeInfo promocodeinfo) throws RemoteException, VAException;

	// public abstract void destroyPromocode(String s)
	// throws RemoteException, VAException;
	//
	// public abstract void editPromocode(String s, PromocodeInfo promocodeinfo)
	// throws RemoteException, VAException;

	public abstract PromocodeInfo viewPromocode(String s) throws RemoteException, VAException;

	// public abstract PromocodeInfo viewPromocodeByOID(String s)
	// throws RemoteException, VAException;

	// public abstract PromocodeInfo[] findPromocode(PromocodeInfo
	// promocodeinfo)
	// throws RemoteException, VAException;

	public abstract String createOrder(String memberId, OrderInfo orderInfo, OrderItemInfo orderItemInfo[])
			throws RemoteException, VAException;

	public abstract void destroyOrder(String orderID) throws RemoteException, VAException;

	public abstract void editOrder(String orderID, OrderInfo orderinfo) throws RemoteException, VAException;

	public abstract OrderInfo viewOrder(String orderID) throws RemoteException, VAException;

	public abstract OrderInfo viewOrderByOID(String s) throws RemoteException, VAException;

	public abstract OrderItemInfo[] viewOrderItems(String orderID) throws RemoteException, VAException;

	public abstract OrderInfo[] findOrder(OrderInfo orderinfo, java.sql.Date startDate, java.sql.Date endDate, int limit)
			throws RemoteException, VAException;

	public abstract OrderInfo[] findOrder(OrderInfo searchParams) throws RemoteException, VAException;

	// public abstract OrderInfo[] findOrder(OrderInfo orderinfo, String
	// creditCardNumber, java.sql.Date startDate, java.sql.Date endDate, int
	// limit)
	// throws RemoteException, VAException;

	// public abstract OrderInfo[] findRefund(Date start, Date end)
	// throws RemoteException, VAException;

	public abstract String createOrderItem(String s, OrderItemInfo orderiteminfo) throws RemoteException, VAException;

	public abstract void destroyOrderItemByOID(String orderItemOID) throws RemoteException, VAException;

	// public abstract String createExternalOrder(ExternalOrderInfo
	// externalorderinfo)
	// throws RemoteException, VAException;
	//
	// public abstract void destroyExternalOrder(String s)
	// throws RemoteException, VAException;
	//
	// public abstract void editExternalOrder(String s, ExternalOrderInfo
	// externalorderinfo)
	// throws RemoteException, VAException;
	//
	// public abstract ExternalOrderInfo viewExternalOrder(String s)
	// throws RemoteException, VAException;
	//
	// public abstract ExternalOrderInfo viewExternalOrderByOID(String s)
	// throws RemoteException, VAException;
	//
	// public abstract ExternalOrderInfo[] findExternalOrder(ExternalOrderInfo
	// externalorderinfo, Date date, Date date1, int i)
	// throws RemoteException, VAException;
	//
	// public abstract String runExternalOrder(String s)
	// throws RemoteException, VAException;
	//
	// public abstract String runExternalRenewalOrder(String s)
	// throws RemoteException, VAException;

	public abstract CCTransactionInfo payOrderByCreditCard(String memberId, String orderID, CCTransactionInfo ccinfo, String partner, boolean isRecurlyRun)
			throws RemoteException, VAException;
	
	public abstract CCTransactionInfo payOrderByCreditCard(String memberId, String orderID, CCTransactionInfo ccinfo, String partner, boolean isRecurlyRun, 
			boolean retryYear) throws RemoteException, VAException;
	
	public abstract PaypalTransactionInfo payOrderByPaypal(String orderID, PaypalTransactionInfo ccinfo, String partner)
			throws RemoteException, VAException;

	public abstract PaypalTransactionInfo payOrderByPaypal(String orderID, PaypalTransactionInfo ccinfo, String partner, 
			boolean retryYear) throws RemoteException, VAException;

	// public abstract CCTransactionInfo verifyOrderByCreditCard(String orderID,
	// CCTransactionInfo ccinfo, MerchantDefinedFields mdf)
	// throws RemoteException, VAException;

	// public abstract void refundOrderToCreditCard(String s, CCTransactionInfo
	// ccInfo)
	// throws RemoteException, VAException;

	public abstract CCTransactionInfo refundOrderToCreditCard2(String orderID, String notes) throws RemoteException,
			VAException;

	public abstract CCTransactionInfo[] refundOrdersToCreditCard(String orderID, String notes) throws RemoteException,
			VAException;
	
	public abstract PaypalTransactionInfo refundOrderToPaypal(String orderID, String notes) throws RemoteException, VAException;


	public abstract void payOrderByCheck(String s, String s1) throws RemoteException, VAException;

	public abstract void refundOrderToCheck(String s, String s1) throws RemoteException, VAException;

	public abstract void payOrderInternal(String s) throws RemoteException, VAException;

	public abstract void refundOrderInternal(String orderID, String notes) throws RemoteException, VAException;

	public abstract void cancelOrder(String s) throws RemoteException, VAException;

	// public abstract String createPayment(PaymentInfo paymentinfo)
	// throws RemoteException, VAException;

	public abstract void destroyPayment(String paymentID) throws RemoteException, VAException;

	public abstract CCTransactionInfo voidPayment(String paymentID) throws RemoteException, VAException;
	
	public abstract CCTransactionInfo voidPayment(String paymentID, String orderID) throws RemoteException, VAException;

	public abstract PaymentInfo viewPayment(String paymentID) throws RemoteException, VAException;

	// public abstract PaymentInfo viewPaymentByOID(String s)
	// throws RemoteException, VAException;

	public abstract PaymentInfo[] findPayment(PaymentInfo paymentinfo) throws RemoteException, VAException;

	// public abstract OrderInfo[] findOrderByCreditCardWithChargeback(String
	// creditCardNumber, String chargeDate)
	// throws RemoteException, VAException;

	// public abstract String createCardOrder(String s, CardOrderInfo
	// cardorderinfo)
	// throws RemoteException, VAException;

	public abstract void destroyCardOrder(String cardOrderId) throws RemoteException, VAException;

	public abstract void destroyCardOrderByOID(String oid) throws RemoteException, VAException;

	public abstract void editCardOrder(String s, CardOrderInfo cardorderinfo) throws RemoteException, VAException;

	public abstract CardOrderInfo viewCardOrder(String cardOrderID) throws RemoteException, VAException;

	public abstract CardOrderInfo viewCardOrderByOID(String s) throws RemoteException, VAException;

	// public abstract CardOrderInfo[] findCardOrder(CardOrderInfo
	// cardorderinfo)
	// throws RemoteException, VAException;

	public abstract CardOrderInfo[] runCardBatch(String partner) throws RemoteException, VAException;

	// public abstract CardOrderInfo[] runAutoCardBatch()
	// throws RemoteException, VAException;
	//
	public abstract TerminationFormBatchInfo[] runTerminationFormBatch() throws RemoteException, VAException;

	// public abstract RefundBatchInfo[] runRefundBatch()
	// throws RemoteException, VAException;

	// public abstract BatchCancelInfo[] runBatchCancelBatch()
	// throws RemoteException, VAException;

	public abstract GiftCardInfo[] runGiftCardBatch() throws RemoteException, VAException;

	public abstract CardOrderInfo[] viewCardBatch(int batchNum) throws RemoteException, VAException;

	public abstract TerminationFormBatchInfo[] viewTerminationFormBatch(int batchNumber) throws RemoteException,
			VAException;

	// public abstract RefundBatchInfo[] viewRefundBatch(int batchNumber)
	// throws RemoteException, VAException;

	// public abstract BatchCancelInfo[] viewBatchCancelBatch(int batchNumber)
	// throws RemoteException, VAException;

	public abstract GiftCardInfo[] viewGiftCardBatch(int batchNumber) throws RemoteException, VAException;

	// ========= EMAILS
	public abstract boolean sendGiverOrRecipientMail(String[] emailData) throws RemoteException, VAException;

	public abstract boolean sendWWPResultsMail(String filename) throws RemoteException, VAException;
	
	public abstract boolean sentWWPAccountsWeeklyMail(String fileName) throws RemoteException, VAException;

	public abstract boolean sendNewsletterAndPendingMail(String memberID) throws RemoteException, VAException;

	public abstract boolean sendWelcomeMail(String memberID, String emailFile) throws RemoteException, VAException;

	public abstract boolean sendWelcomeMail(String memberID) throws RemoteException, VAException;
	
	public abstract boolean sendWelcomeMail(String memberID, String emailFile, boolean isFullReg) throws RemoteException, VAException;

	public abstract boolean sendWelcomeMail(String memberID, String emailFile, String password) throws RemoteException, VAException;
	
	public abstract boolean sendRenewalMail(String memberID) throws RemoteException, VAException;
	
	public abstract boolean sendUpgradeMail(String memberID) throws RemoteException, VAException;

	public abstract void sendLastConversionMail(AccountInfo accountVO) throws RemoteException, VAException;

	public abstract void sendLastRenewalMail(AccountInfo accountVO) throws RemoteException, VAException;

	public abstract boolean sendEmailRegisterMail(String memberID) throws RemoteException, VAException;

	public abstract boolean sendThankTroopsMail(String memberID) throws RemoteException, VAException;

	// public abstract boolean sendGenericMail(String memberID, String bodyFile,
	// String subject)
	// throws RemoteException, VAException;

	// public abstract boolean sendDispositionMail(String memberID,String
	// emailBodyTxt)
	// throws RemoteException,VAException;

	public abstract void sendPartnerUploadNotificationMail(String partner, String uploadFilename)
			throws RemoteException, VAException;

	// public abstract AccountInfo[] selectMailingList()
	// throws RemoteException, VAException;
	//
	// public abstract String[] selectMailingList2()
	// throws RemoteException, VAException;

	// public abstract AccountInfo[] selectRenewalTargets(java.sql.Date date,
	// java.sql.Date date1)
	// throws RemoteException, VAException;

	// public abstract AccountInfo[] selectAutoRenewTargets(java.sql.Date date,
	// java.sql.Date date1)
	// throws RemoteException, VAException;

	// public abstract AccountInfo[] selectPartnerMailingList()
	// throws RemoteException, VAException;

	public abstract String expireAccount(String memberID) throws RemoteException, VAException;

	public abstract ExpiredAccountVO getExpiredAccounts(int graceDays) throws RemoteException, VAException;

	public abstract ExpiredAccountVO getExpiredTrialAccounts(int graceDays) throws RemoteException, VAException;

	public abstract String expireTrialAccount(String memberID) throws RemoteException, VAException;

	// public abstract AccountInfo duplicateAccount(String s)
	// throws RemoteException, VAException;

	// public abstract String reissueAccount(String s)
	// throws RemoteException, VAException;

	// public abstract CreditCardInfo initStoredCCInfo(String s)
	// throws RemoteException, VAException;

	// public abstract int prepareAutoRenewTargets(java.sql.Date date,
	// java.sql.Date date1)
	// throws RemoteException, VAException;

	// public abstract AccountInfo[] selectPendingAutoRenewals()
	// throws RemoteException, VAException;

	// public abstract OrderInfo createAutoRenewOrder(String s)
	// throws RemoteException, VAException;

	// public abstract OrderInfo processAutoRenewOrder(String s)
	// throws RemoteException, VAException;

	public abstract void logDBAction(String s, String s1) throws RemoteException;

	public abstract MarketingPartnerInfo viewMarketingPartner(String s) throws RemoteException, VAException;

	/**
	 * Create an account event record for an account.
	 *
	 * @param accountid
	 *            - the account id to record the event for.
	 * @param event
	 *            - the event to log.
	 * @param status
	 *            - the status FIXME: what is this for?
	 * @param notes
	 *            - notes about the account event
	 * @param user
	 *            - the user creating the account event
	 * @throws RemoteException
	 *             if there is a problem connecting to the ejb bean
	 * @throws VAException
	 *             unknown when this is thrown
	 */
	// public abstract long createAccountEvent(String accountid, String event,
	// int status, String notes, String user)
	// throws RemoteException, VAException;
	public abstract BasicAccount[] getMembers(String as[], String as1[]) throws RemoteException, VAException;

	public abstract AccountAddressInfo[] getInvoiceExport(Date expiryStart, Date expiryDate) throws RemoteException,
			VAException;

	public abstract List<ProductPriceInfo> getCurrentProductList() throws RemoteException, VAException;

	// public abstract RegistrationInfo viewRegistration(final String memberID)
	// throws RemoteException, VAException;

	public abstract RegistrationInfo[] viewRegistrations(String memberID) throws RemoteException, VAException;

	// public void editRegistration(RegistrationInfo info)
	// throws RemoteException, VAException;

	/**
	 * Allows finding a product code using its product code and effective date.
	 *
	 * @param s
	 *            product code of the product to find
	 * @param d
	 *            date that must fall after the products start date and before
	 *            the products end date
	 * @return an object representing the product price info
	 * @throws RemoteException
	 * @throws VAException
	 */
	// 03-01-2006 kohara added as part of product price change
	public abstract ProductPriceInfo findProductByProductCodeAndDate(String productCode, Date originalDate)
			throws RemoteException, VAException;

	public abstract Object[] runSql(String sql, int type) throws RemoteException, VAException;

	public abstract Map<String, String> getTrialProductMap() throws RemoteException, VAException;

	public abstract Map<String, String> getRenewalProductMap() throws RemoteException, VAException;

	public abstract CCTransactionInfo refundOrder(CCOrderInfo orderInfo) throws RemoteException, VAException;

	public abstract CCTransactionInfo processSales(CCOrderInfo orderInfo, String partner) throws RemoteException,
			VAException;

	// public abstract void destroyAddressByOID(String oid)
	// throws RemoteException, VAException;

	public abstract void destroyCreditCardByOID(String oid) throws RemoteException, VAException;

	public abstract void destroyPaypalByOID(String oid) throws RemoteException, VAException;
	
	public abstract void destroyRegistrationByOID(String oid) throws RemoteException, VAException;

	/**
	 * <p>
	 * create a record from the partner upload
	 * </p>
	 *
	 * @param info
	 *            partner data
	 *
	 * @param return the key
	 */
	public abstract String createPartnerUpload(PartnerUploadInfo info) throws RemoteException, VAException;

	/**
	 * <p>
	 * find records from the partner upload filtered by the given criteria
	 * </p>
	 *
	 * @param info
	 *            criteria to limit the search
	 * @param limit
	 *            maximum number of rows to return from the search
	 *
	 * @param return array of results
	 */
	public abstract PartnerUploadInfo[] findPartnerUpload(PartnerUploadInfo info, int limit) throws RemoteException,
			VAException;

	/**
	 * <p>
	 * view record from the partner upload with the given oid
	 * </p>
	 *
	 * @param oid
	 *            key of the record to display
	 *
	 * @param return record to view
	 */
	public abstract PartnerUploadInfo viewPartnerUploadByOID(String oid) throws RemoteException, VAException;

	public abstract String createDisposition(DispositionInfo dispositionInfo, BasicDispoVO dispoTypeVO)
			throws RemoteException, VAException;

	public abstract List<DispositionInfo> findDisposition(DispositionInfo DispositionInfo, Date start, Date end)
			throws RemoteException, VAException;

	public abstract List<DispositionInfo> findNonMemberDisposition(DispositionInfo DispositionInfo, Date start, Date end)
			throws RemoteException, VAException;
	
	
	public abstract String getLevelOfContinuity(String memberId, String productCode) throws RemoteException,
			VAException;

	public abstract LocAndRetry getLevelOfContinuityByOrderId(String memberId, String orderId) throws RemoteException,
			VAException;

	public abstract HashMap<String, HashSet<String>> selectBadBinPartners() throws RemoteException, VAException;

	/**
	 * Monitoring
	 */
	public abstract boolean ping() throws RemoteException;

	/**
	 * Monitoring
	 */
	public abstract boolean select1() throws RemoteException, VAException;

	// public abstract boolean isMailServiceUp()
	// throws RemoteException, VAException;

	/***
	 * GENERIC CRUD Finder Methods faster Development and Testing
	 ***/
	public abstract Object create(Object obj) throws RemoteException, VAException,CreateException;
	
	public void update(Object obj) throws RemoteException, VAException;
	
	public abstract List<Object> findMany(Class type, String fieldName, String searchKey) throws RemoteException,
			VAException;
	
	public abstract Object findOne(Class type, String fieldName, String searchKey) throws RemoteException, VAException;

	public abstract Object findFirst(Class type, String fieldName, String searchKey) throws RemoteException, VAException;	
	
	public abstract Object findLast(Class type, String fieldName, String searchKey) throws RemoteException, VAException;

	public abstract String[] getAllExpiredAccounts() throws RemoteException, VAException;
	
	public abstract String[] getAllCancelledAccounts() throws RemoteException, VAException;

	public abstract void createAccountNotes(AccountNoteInfo info) throws RemoteException, VAException;

	public abstract void createAccountNotes(AccountNoteInfo info, String eventNotes) throws RemoteException, VAException;

	public abstract void createAccountNotes(AccountInfo info, String eventNotes, String user) throws RemoteException, VAException;

	public abstract String getNotesByAccountId(String accountId) throws RemoteException, VAException;

	public abstract AccountNoteInfo[] findAccountNotes(String accountId) throws RemoteException, VAException;

	public abstract OrderInfo[] getRetryOrders() throws RemoteException, VAException;
	
	public abstract String createAccountWWP(AccountWWPInfo info) throws RemoteException, VAException;
	
	public abstract void editAccountWWP(String Id, AccountWWPInfo info) throws RemoteException, VAException;
	
	public abstract AccountWWPInfo getAccountWWPByAccountId(String accountid) throws RemoteException, VAException;
	
	public abstract AccountWWPInfo[] getAccountWWPForWeeklyEmail() throws RemoteException, VAException;
	
	public abstract long getLastAccountWWPBatchNumber() throws RemoteException, VAException;
	
	public abstract void createCardOrderForWWPAccount(String memberId) throws RemoteException, VAException;
	
	public abstract AccountInfo[] getBearAccounts() throws RemoteException, VAException;
	
	public abstract AccountInfo[] getAccountWWPAutoExport() throws RemoteException, VAException;
	
	public abstract MarketingPartnerInfo[] getHitsStateCashRegisters() throws RemoteException, VAException;
	
	public abstract void sendBearAccountMail(String fileName) throws RemoteException, VAException;
	
	public abstract void sendWWPAutoExportMail(String fileName) throws RemoteException, VAException;
	
	public abstract void sendStateCashRegistersMail(String fileName) throws RemoteException, VAException;
	
	public abstract Map<String,String> getUploadPartnersMap() throws RemoteException, VAException;
	
	public abstract String getMemberIDByCustomID(String customId) throws RemoteException, VAException;
	
	public abstract boolean sendAlertEmail(String source) throws RemoteException, VAException;
	
	public abstract boolean sendDuplicateMonitoringEmail(String message) throws RemoteException, VAException;
	
	//public abstract String call(String phoneNumber, String extensionNumber, String message) throws RemoteException, VAException;
	
	public abstract String[] getMembersForEmailVerification() throws RemoteException, VAException;
	
	public abstract boolean sendEmailVerification(String memberId) throws RemoteException, VAException;
	
	public abstract boolean sendVerificationInfo(String memberId) throws RemoteException, VAException;
	
	public abstract String[] getMemberIdsByEmail(String email) throws RemoteException, VAException;
	
	public void sendMail(MailInfo mailInfo) throws RemoteException, VAException;
	
	public boolean saveAccountSponsor(String memberID, Integer numSponsors) throws RemoteException, VAException;
	
	public boolean isMemberValid(String lastName, String memberID) throws RemoteException, VAException;
	
	public void destroyAccountSponsor(String oid) throws RemoteException, VAException;
	
	public AccountSponsor[] findAccountSponsor(String oid) throws RemoteException, VAException;
	
	public boolean unsubscribeEmail(String email) throws RemoteException, VAException;
	
	public boolean sendMedevacMail(String memberID) throws RemoteException, VAException;
	
	public OrderInfo[] findOrderForSalesReport(OrderInfo searchParams, java.sql.Date startDate, java.sql.Date endDate, int limit) throws RemoteException, VAException;

	//public CCTransactionInfo autoRenewMemberUnpaid(final String memberID, boolean retryYear) throws RemoteException, VAException;
	
	public boolean sendMemberIDMail(String email, String name, String lastName, String memberID) throws RemoteException, VAException;
	
	public AccountInfo findAccountByEmail(String email) throws RemoteException, VAException;
	/*
	public int getCvsFlag(String memberId) throws RemoteException,VAException;
	
	public void setCvsFlag(String memberId, int printed) throws RemoteException,CreateException, FinderException, VAException;
    */	
	public String getTempCardExpiryDate(AccountInfo accountInfo) throws RemoteException;
	
	public AccountLoginInfo getLoginInfo(String memberId, String password) throws RemoteException, VAException;
	
	public void setWWPCcToZeroes(String[] ids)throws RemoteException, VAException;
	
	public Map<String,String> authNetSettings(String param, String value)throws RemoteException,VAException;
	
	public void updateLastLoginDate(AccountLoginInfo loginInfo) throws RemoteException, VAException;
	
	public boolean isPartnerExist(String partner) throws RemoteException, VAException;

	String getMemberIdFromAccountByPaypalBillingAgreement(String billingAgreementId) throws RemoteException, VAException;
	
	public void sendNonMemberDispostionEmail(MailInfo mailInfo) throws RemoteException, VAException;

	boolean isIDNYCExist(String idnyc) throws RemoteException, VAException;
	
	boolean isIDNYCInUsed(String idnyc) throws RemoteException, VAException;
	
	abstract String createIdnycMemberId(IdnycMemberIdInfo idnycMemberIdinfo) throws RemoteException, VAException;
	
	abstract String createCodeMemberId(CodeMemberIdInfo codeMemberIdInfo) throws RemoteException, VAException;
}
