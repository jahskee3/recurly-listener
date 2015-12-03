package com.va.vauser2.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
import com.va.reusable.db.DbUtil;


@Controller
public class RecurlyListenerController {
	
	private static final Logger log = Logger.getLogger(RecurlyListenerController.class);

	//for testing purpose
    //actual url is https://76.26.204.56/recurly-listener/recurly/listener.va
    @RequestMapping(value = "/recurly/listener", method = RequestMethod.POST)
    public String listenerPost(ModelMap model, HttpServletRequest request) throws IOException, JDOMException, JAXBException, SQLException {
    
    	InputStream xml = request.getInputStream();    	
    	StringWriter writer = new StringWriter();
    	IOUtils.copy(xml, writer, "UTF-8");
    	String xmlData = writer.toString();
    	xmlData=sanitizeXmlChars(xmlData).replaceAll("\\<\\?xml(.+?)\\?\\>", "").trim().replaceAll("\"", "'");  
    	
    	setForSynchronization(xmlData);    	
    
    	return "listener";
        
    }
    
    //for testing purpose
    //actual url is https://76.26.204.56/recurly-listener/recurly/listener.va
	@RequestMapping(value = "/recurly/listener", method = RequestMethod.GET)
	   public String listener(ModelMap model, HttpServletRequest request) throws IOException, JDOMException, JAXBException, SQLException {
		log.info("Recurly listener is working...");
		model.addAttribute("msg", "Testing Recurly webhook listener!");
        return "listener";
    }
	
	private static void setForSynchronization(String xmlData) throws JDOMException, IOException, JAXBException, SQLException{
		Object event = UnmarshallUtil.getEvent(xmlData);
		BaseNotification notification = (BaseNotification) event;
		
		AccountE account = notification.getAccount();
		String memberId = account.getAccountCode();
		
		Connection dbConn=null;
		try{
			dbConn = DbUtil.getTempConnection("VAData","root", "rootpass");
		
			//dbConn = DbUtil.getTempConnection(Configuration.DB_NAME, Configuration.DB_USER, Configuration.DB_PASSWORD);
			PreparedStatement preparedStatement = null;
			
			String sqlStr=null;
			if(!isMemberIdExist(dbConn, account.getAccountCode())){				
				sqlStr = "insert into recurlymsg(memberId, issync) values(?,0)";		
				preparedStatement = dbConn.prepareStatement(sqlStr);		
				preparedStatement.setString(1, memberId);			
				
			}else{
				//set memberId issync back to 0;
				sqlStr = "update recurlymsg set issync=0 where memberId=?";		
				preparedStatement = dbConn.prepareStatement(sqlStr);		
				preparedStatement.setString(1, memberId);		
			}
			
			preparedStatement.executeUpdate();	
			log.info("memberid "+memberId+" marked for recurly synchronization");
			
		}catch(SQLException e){
			throw new SQLException(e);
		}finally{
			if(dbConn!=null){
				dbConn.close();
			}
		}
	}
	
	private static boolean isMemberIdExist(Connection dbConn, String memberId) throws SQLException{
		boolean isMemberIdExist = false;
		PreparedStatement preparedStatement = null;
		String selectSQL = "select memberid from recurlymsg where memberId=?"; 

		preparedStatement = dbConn.prepareStatement(selectSQL);
		preparedStatement.setString(1, memberId);	
		
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			isMemberIdExist =true;
			break;
		}	
			
		return isMemberIdExist;
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
