package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao{
    static Connection conn;
    static PreparedStatement selprod,insprod;
    static{
    	try {
    		conn=DBUtil.getMyConnection();
			selprod=conn.prepareStatement("select * from product");
			insprod=conn.prepareStatement("insert into product values(?,?,?,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	@Override
	public List<Product> findAll() {
		List<Product> plist=new ArrayList<>();
		try {
			ResultSet rs=selprod.executeQuery();
			while(rs.next()) {
				plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4)));
			}
			return plist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean save(Product p) {
		try {
			insprod.setInt(1, p.getPid());
			insprod.setString(2, p.getPnm());
			insprod.setInt(3, p.getQty());
			insprod.setDouble(4, p.getPrice());
			int n=insprod.executeUpdate();
			return n>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
