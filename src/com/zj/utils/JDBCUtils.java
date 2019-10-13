package com.zj.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCUtils {

	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;

	static {
		ResourceBundle rb = ResourceBundle.getBundle("jdbc");
		driver = rb.getString("driver");
		url = rb.getString("url");
		username = rb.getString("username");
		password = rb.getString("password");
	}

	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {

		Connection conn = DriverManager.getConnection(url, username, password);

		return conn;
	}

	public static void close(Connection conn, Statement state, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
			try {
				if (state != null) {
					state.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				state = null;
				try{
					if(rs!=null){
						rs.close();
					}
				}catch(SQLException e){
					e.printStackTrace();
				}finally{
					rs = null;
				}
			}
		}
	}
}
