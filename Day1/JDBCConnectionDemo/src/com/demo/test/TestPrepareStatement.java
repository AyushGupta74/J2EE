package com.demo.test;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPrepareStatement {

	public static void main(String[] args) {
		//Step 1--Register the driver
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			//step 2--Get connection
			String url="jdbc:mysql://localhost:3306/test?useSSL=false";
			Connection conn=DriverManager.getConnection(url,"root","root123");
			if (conn!=null) {
				System.out.println("connection done");
				//step 3:---create a statement
				PreparedStatement st=conn.prepareStatement("select * from product");
				ResultSet rs=st.executeQuery();
				while(rs.next()) {
					System.out.println("Pid: "+rs.getInt(1));
					System.out.println("Pname: "+rs.getString(2));
					System.out.println("Quantity: "+rs.getInt(3));
					System.out.println("Price: "+rs.getDouble(4));
					System.out.println("==================================");
				}
				int id=34;
				String pnm="chair";
	            int qty=56;
	            double pr=3456;
	            PreparedStatement st1=conn.prepareStatement("insert into product values(?,?,?,?)");
	            st1.setInt(1, id);
	            st1.setString(2, pnm);
	            st1.setInt(3,qty);
	            st1.setDouble(4, pr);
			    int n=st1.executeUpdate();
			    if(n>0) {
			    	System.out.println("added sucessfully");
			    }
			    
			}
			

		} catch (SQLException e) {
			System.out.println("Error occured"+e.getMessage());
			e.printStackTrace();
		}
		
	}

}
