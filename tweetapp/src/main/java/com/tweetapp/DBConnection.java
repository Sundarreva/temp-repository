package com.tweetapp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {

	public static Connection getConnection() {
		Connection connection = null;
		   
		final String URL = "jdbc:mysql://localhost:3306/"
		final String USER = "root"
		final String PASSWORD = "root"
		final String PARAMETERS = "?verifyServerCertificate=false&useSSL=true"

		try {
			connection = DriverManager.getConnection(URL + DBNAME + PARAMETERS, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void disconnect(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
