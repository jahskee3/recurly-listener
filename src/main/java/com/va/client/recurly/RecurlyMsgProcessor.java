package com.va.client.recurly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.va.client.recurly.unmarshall.UnmarshallUtil;
import com.va.core.Configuration;
import com.va.reusable.db.DbUtil;

public class RecurlyMsgProcessor {
	public static void main(String[] args) throws SQLException{
		
		Connection dbConn=null;
		PreparedStatement preparedStatement = null;
		try{
			
			dbConn = DbUtil.getTempConnection(Configuration.DB_NAME, Configuration.DB_USER, Configuration.DB_PASSWORD);
			String selectSQL = "SELECT memberid, xmldata, priority FROM recurlymsg WHERE created < DATE_SUB(now()+INTERVAL 1 HOUR ,INTERVAL 5 MINUTE) and isdelete=0 order by priority;";
			preparedStatement = dbConn.prepareStatement(selectSQL);		
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String memberId = rs.getString("memberId");
				String xmlData = rs.getString("xmlData");			
				UnmarshallUtil.eventAction(xmlData);
			}
		}catch(Exception e){		
			
			throw new SQLException(e);
		}finally{
			if(dbConn!=null){
				dbConn.close();
			}
		}
	}

}
