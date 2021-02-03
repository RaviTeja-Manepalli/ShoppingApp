package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public Connection getConnection() throws Exception {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/org";
		String userName = "root";
		String password = "12345678";
		con = DriverManager.getConnection(url, userName, password);
		return con;
	}

	public void closeResource(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
