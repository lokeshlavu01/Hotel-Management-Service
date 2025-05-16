package com.cognizant.hotel.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static String url = "jdbc:mysql://localhost:3306/hotel";
	private static String user = "root";
	private static String pass = "default";
	
	public static Connection getConnected() {
	
	Connection cn = null;
	try {
		cn = DriverManager.getConnection(url, user, pass);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return cn;
	}
}
