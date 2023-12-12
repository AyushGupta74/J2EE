package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao {
	static Connection conn;
	static PreparedStatement findsorted,selectprod,insprod,selectbypid,delbyid,upbyid;
	static {
		try {
			conn=DBUtil.getMyConnection();
			selectprod=conn.prepareStatement("select * from product");
			insprod=conn.prepareStatement("insert into product values(?,?,?,?)");
			selectbypid=conn.prepareStatement("select * from product where pid=?");
			delbyid=conn.prepareStatement("delete from product where pid=?");
			upbyid=conn.prepareStatement("update product set pname=?,qty=?,price=? where pid=?");
			findsorted=conn.prepareStatement("select * from product order by price");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public List<Product> findAll() {
		List<Product> plist=new ArrayList<>();
		try {
			ResultSet rs=selectprod.executeQuery();
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
	public void save(Product p) {
		try {
			insprod.setInt(1, p.getPid());
			insprod.setString(2,p.getPnm());
			insprod.setInt(3, p.getQty());
			insprod.setDouble(4,p.getPrice());
			int n=insprod.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	@Override
	public Product findById(int id) {
		try {
			selectbypid.setInt(1, id);
			ResultSet rs=selectbypid.executeQuery();
			if(rs.next()) {
				return new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public boolean removeById(int id) {
		try {
			delbyid.setInt(1, id);
			int n=delbyid.executeUpdate();
			if(n>0)
				return true;
			else
				return false;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}


	@Override
	public boolean updateById(int id, String pnm, int qty, double price) {
		try {
			upbyid.setString(1,pnm);
			upbyid.setInt(2,qty);
			upbyid.setDouble(3,price);
			upbyid.setInt(4,id);
			int n=upbyid.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}


	@Override
	public List<Product> findSorted() {
		List<Product> plist=new ArrayList<>();
		try {
			ResultSet rs=findsorted.executeQuery();
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
	public void closeConnection() {
		DBUtil.closeMyConnection();
		
	}

}
