package com.va.reusable.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.lang.time.FastDateFormat;
import org.apache.log4j.Logger;


public class DbUtil {
	
	private static final Logger log = Logger.getLogger(DbUtil.class);

	
	public static void close(ResultSet rs, Statement st, Connection conn) {
		close(rs);
		close(st);
		close(conn);
	}

	public static void close(ResultSet rs, Statement st) {
		close(rs);
		close(st);
	}

	public static void close(Statement st, Connection conn) {
		close(st);
		close(conn);
	}

	private static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				log.error(e);
			}
		}
	}

	public static void close(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				log.error(e);
			}
		}
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				log.error(e);
			}
		}
	}

	public static final int TYPE_SELECT = 0;
	public static final int TYPE_UPDATE = 1;

	public static Object[] runSql(String dsName, String sql, int type) throws SQLException {
		Collection rows = null;
		if (type == TYPE_SELECT) {
			rows = executeQuery(dsName, sql);
		} else {
			rows = executeUpdate(dsName, sql);
		}

		return rows.toArray();
	}

	private static Collection executeQuery(String dsName, String sql) throws SQLException {
		Collection rows = new ArrayList();

		Connection conn = getConnection(dsName);
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			//
			Collection<String> headers = new ArrayList<String>();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			for (int i = 0; i < columnCount; i++) {
				headers.add(rsmd.getColumnName(i + 1));
			}
			rows.add(headers.toArray());

			while (rs.next()) {
				Collection<Object> cols = new ArrayList<Object>(columnCount);
				for (int i = 0; i < columnCount; i++) {
					int columnType = rsmd.getColumnType(i + 1);
					if (columnType == Types.DATE) {
						cols.add(rs.getTimestamp(i + 1));
					} else {
						cols.add(rs.getObject(i + 1));
					}
				}
				rows.add(cols.toArray());
			}
		} finally {
			DbUtil.close(rs, stmt, conn);
		}

		return rows;
	}

	private static Collection executeUpdate(String dsName, String sql) throws SQLException {
		Collection rows = new ArrayList();

		Connection conn = getConnection(dsName);
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);

			Collection<Integer> cols = new ArrayList<Integer>(1);
			cols.add(new Integer(result));
			rows.add(cols.toArray());
		} finally {
			DbUtil.close(rs, stmt, conn);
		}

		return rows;
	}

	public static Connection getConnection(String dsName) throws SQLException {
		// logger.info("DbUtil.getConnection(dsName=" + dsName + ")");

		// TODO use service locator with caching
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(dsName);
			conn = ds.getConnection();
		} catch (NamingException ex) {
			throw new SQLException(ex.getMessage() + " DataSource=" + dsName);
		}
		return conn;
	}

	public static Connection getConnection(String dsName, Properties env) throws SQLException {
		// logger.info("DbUtil.getConnection(dsName=" + dsName + ", env)");

		// TODO use service locator with caching
		Connection conn = null;
		try {
			Context ctx = new InitialContext(env);
			DataSource ds = (DataSource) ctx.lookup(dsName);
			conn = ds.getConnection();
		} catch (NamingException ex) {
			throw new SQLException(ex.getMessage() + " DataSource=" + dsName);
		}
		return conn;
	}

	public static Connection getTempConnection(String dbName, String userName, String password) throws SQLException {
		// logger.info("DbUtil.getConnection(dbName=" + dbName + ", userName=" +
		// userName + ", password)");

		// TODO: remove hard coding
		String url = "jdbc:mysql://db1:3306/";
		String driver = "com.mysql.jdbc.Driver";

		try {
			Class.forName(driver).newInstance();
		} catch (Exception e) {
			throw new SQLException("Cannot instantiate driver=" + driver, e);
		}

		return DriverManager.getConnection(url + dbName, userName, password);
	}

	public static final FastDateFormat DATE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
}
