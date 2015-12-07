package com.va.client.recurly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.va.core.Configuration;
import com.va.reusable.db.DbUtil;

public class RecurlyMsgProcessor {
	public static void main(String[] args) throws SQLException{
		
		Connection dbConn=null;
		PreparedStatement preparedStatement = null;
		try{
			
			dbConn = DbUtil.getTempConnection(Configuration.DB_NAME, Configuration.DB_USER, Configuration.DB_PASSWORD);
			String selectSQL = "SELECT memberid FROM recurlysync issync=0;";
			preparedStatement = dbConn.prepareStatement(selectSQL);		
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

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
