package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) {
		//Step 1--Register the driver
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			//step 2--Get connection
			String url="jdbc:mysql://localhost:3306/test?useSSL=false";
			Connection conn=DriverManager.getConnection(url,"root","root123");
			if (conn!=null) {
				System.out.println("connection done");
			}

		} catch (SQLException e) {
			System.out.println("Error occured"+e.getMessage());
			e.printStackTrace();
		}
		
	}

}
