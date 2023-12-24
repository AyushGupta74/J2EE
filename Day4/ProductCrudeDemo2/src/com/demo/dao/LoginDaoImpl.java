package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.MyUser;

public class LoginDaoImpl implements LoginDao{
	static Connection conn;
	static PreparedStatement seluser,insuser;
	static {
		conn=DBUtil.getMyConnection();
		try {
			seluser=conn.prepareStatement("select uname,password,role from user where uname=? and password=?");
			insuser=conn.prepareStatement("insert into user(uname,password,role,username,user_id) values(?,?,?,?,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public MyUser findUSer(String uname, String pass) {
		try {
		seluser.setString(1, uname);
		seluser.setString(2, pass);
		ResultSet rs=seluser.executeQuery();
		if(rs.next()) {
			return new MyUser(rs.getString(1),rs.getString(2),rs.getString(3));
			
		}}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addnewuser(String nm, String uname, String pass) {
		try {
			insuser.setString(1, uname);
			insuser.setString(2, pass);
			insuser.setString(3,"user");
			insuser.setString(4,nm);
			insuser.setInt(5, 0);
			int n=insuser.executeUpdate();
			return n>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
	}

}
