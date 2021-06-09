package com.YANG.BDQN_shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

public class BaseDao {
	protected Connection conn = null;
	protected PreparedStatement ps= null;
	protected ResultSet rs = null;
	static DataSource dataSource;
	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/myDb");
		} catch (NamingException e) {
			e.printStackTrace();
		}	
	}
	
	public BaseDao() {
		
	}
	
	public Connection getConnection(){
		try {
			if(null!=dataSource){
				Connection connection = dataSource.getConnection();
				BasicDataSource ds = (BasicDataSource)dataSource;
				return connection;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 关闭数据库和相关对象
	 * 
	 * @param conn
	 *            Connection对象
	 * @param ps
	 *            Statement对象
	 * @param rs
	 *            ResultSet对象
	 */
	protected void closeAll(Connection conn, Statement ps, ResultSet rs) {
		try {
			if (null != rs) {
				rs.close();
			}
			rs = null;

			if (null != ps) {
				ps.close();
			}
			ps = null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != conn && !conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
}
