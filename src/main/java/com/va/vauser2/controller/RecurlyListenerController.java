package com.va.vauser2.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.jdom2.JDOMException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.va.client.recurly.events.models.AccountE;
import com.va.client.recurly.events.notifications.BaseNotification;
import com.va.client.recurly.unmarshall.UnmarshallUtil;
import com.va.client.recurly.unmarshall.VAXmlUtil;
import com.va.core.Configuration;
import com.va.reusable.db.DbUtil;
import com.va.reusable.util.DateUtil;



@Controller
public class RecurlyListenerController {
	
	private static final Logger log = Logger.getLogger(RecurlyListenerController.class);
	
	public static void main(String[] args) throws JDOMException, IOException, JAXBException, SQLException{
		
		String xmlData = "<?xml version=\"1.0\" encoding='UTF-8'?> <new_account_notification> <account> <account_code>2</account_code> <username nil=\"true\"></username> <email>verena@example.com</email> <first_name>Verena</first_name> <last_name>Example</last_name> <company_name nil='true'></company_name> </account> </new_account_notification>";
		xmlData=sanitizeXmlChars(xmlData).replaceAll("\\<\\?xml(.+?)\\?\\>", "").trim().replaceAll("\"", "'");
		
		System.out.println(xmlData);
		//saveNotificationToDB(xmlData);
	}

    @RequestMapping(value = "/recurly/listener", method = RequestMethod.POST)
    public String listenerPost(ModelMap model, HttpServletRequest request) throws IOException, JDOMException, JAXBException, SQLException {
    	long lStartTime = new Date().getTime();
    	InputStream xml = request.getInputStream();    	
    	StringWriter writer = new StringWriter();
    	IOUtils.copy(xml, writer, "UTF-8");
    	String xmlData = writer.toString();
    	xmlData=sanitizeXmlChars(xmlData).replaceAll("\\<\\?xml(.+?)\\?\\>", "").trim().replaceAll("\"", "'");    	
    	saveNotificationToDB(xmlData);
    	long lEndTime = new Date().getTime();
    	long difference = lEndTime - lStartTime;
    	log.info("RecurlyListeneter execution time in milliseconds: " + difference);
    	System.out.println("RecurlyListeneter execution time in milliseconds: " + difference);
    	return "listener";
        
    }
    
    //for testing purpose
	@RequestMapping(value = "/recurly/listener", method = RequestMethod.GET)
	   public String listener(ModelMap model, HttpServletRequest request) throws IOException, JDOMException, JAXBException, SQLException {
		log.info("Hello world");
		model.addAttribute("msg", "Testing Recurly webhook listener!");
        return "listener";
    }
	
	private static void saveNotificationToDB(String xmlData) throws JDOMException, IOException, JAXBException, SQLException{
		Object event = UnmarshallUtil.getEvent(xmlData);
		BaseNotification notification = (BaseNotification) event;
		
		String notificationRootElement = VAXmlUtil.getRootElementName(xmlData);
		
		AccountE account = notification.getAccount();		
		Connection dbConn=null;
		try{
			dbConn = DbUtil.getTempConnection("VAData","root", "rootpass");
		
			//dbConn = DbUtil.getTempConnection(Configuration.DB_NAME, Configuration.DB_USER, Configuration.DB_PASSWORD);
			
			if(!isDuplicateMsg(dbConn, account.getAccountCode(), xmlData)){  //filter out duplicate message
				PreparedStatement preparedStatement = null;				
				
				String insertTableSQL = "insert into recurlymsg(memberId, created, notification, priority, isdelete) values(?,?,?,?,?)";		
				preparedStatement = dbConn.prepareStatement(insertTableSQL);
		
				preparedStatement.setString(1, account.getAccountCode());
				preparedStatement.setTimestamp(2, DateUtil.getCurrentSqlTimestamp());
				preparedStatement.setString(3, notificationRootElement);
				
				int msgPriority=getNotificationPriority(dbConn, xmlData);
				preparedStatement.setInt(4,msgPriority); //priority
				preparedStatement.setInt(5,0); //isprocessed
				preparedStatement.execute();				
			}else{
				log.info("ignore, duplicate recurly message found for "+account.getAccountCode());
			}
			
		}catch(SQLException e){
			throw new SQLException(e);
		}finally{
			if(dbConn!=null){
				dbConn.close();
			}
		}
	}
	
	private static boolean isDuplicateMsg(Connection dbConn, String memberId, String xmlData) throws SQLException{
		boolean isDuplicateMsg = false;
		PreparedStatement preparedStatement = null;
		String selectSQL = "select memberid from recurlymsg where memberId=? and notification=? and isdelete=0";

		preparedStatement = dbConn.prepareStatement(selectSQL);
		preparedStatement.setString(1, memberId);
		preparedStatement.setString(2, xmlData);
		
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			isDuplicateMsg =true;
			break;
		}
		
		
		
		return isDuplicateMsg;
	}
	
	private static int getNotificationPriority(Connection dbConn, String xmlData) throws JDOMException, IOException, SQLException{
		int priority=20; //default last priority
		
		String notification= VAXmlUtil.getRootElementName(xmlData);		
		
		PreparedStatement preparedStatement = null;
		String selectSQL = "select priority from recurlypriority where notification=?";

		preparedStatement = dbConn.prepareStatement(selectSQL);
		preparedStatement.setString(1, notification);

		// execute select SQL stetement
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			priority = rs.getInt("priority");
		}
		System.out.println("priority is "+priority);
		return priority;
	}
	
	public static String sanitizeXmlChars(String in) {
	    StringBuilder out = new StringBuilder();
	    char current;

	    if (in == null || ("".equals(in))) return "";
	    for (int i = 0; i < in.length(); i++) {
	        current = in.charAt(i);
	        if ((current == 0x9) ||
	            (current == 0xA) ||
	            (current == 0xD) ||
	            ((current >= 0x20) && (current <= 0xD7FF)) ||
	            ((current >= 0xE000) && (current <= 0xFFFD)) ||
	            ((current >= 0x10000) && (current <= 0x10FFFF)))
	            out.append(current);
	    }
	    return out.toString();
	  }
	
}
