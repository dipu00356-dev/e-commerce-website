package com.eazydeals.helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	
	private static final long serialVersionUID = 1L;
	private static Connection connection;

	public static Connection getConnection() {

		try {
			if (connection == null) {
				System.out.println("ConnectionProvider - Creating new database connection...");
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eazydeals", "root", "");
				System.out.println("ConnectionProvider - Database connection established successfully");
			} else {
				System.out.println("ConnectionProvider - Using existing database connection");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ConnectionProvider - Failed to establish database connection: " + e.getMessage());
		}
		return connection;
	}

}
