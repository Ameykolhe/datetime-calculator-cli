package com.ameykolhe.datetime;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:postgresql://localhost/datetimecalculator";
		String userName = "ameyk";
		String password = "1379";
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL, userName, password);
			
			System.out.println("Connection Successful");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
