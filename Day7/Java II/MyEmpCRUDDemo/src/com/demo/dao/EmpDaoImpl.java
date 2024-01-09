package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.Employee;
import com.mysql.cj.protocol.Resultset;

public class EmpDaoImpl implements EmpDao{
	static Connection conn;
	static PreparedStatement selemp,insemp,seleById,upById,delById;
	static {
		try {
			conn=DBUtil.getMyConnection();
			selemp=conn.prepareStatement("select * from employee");
			insemp=conn.prepareStatement("insert into employee values(?,?,?)");
			seleById=conn.prepareStatement("select * from employee where empid=?");
			upById=conn.prepareStatement("update employee set ename=?,sal=? where empid=?");
			delById=conn.prepareStatement("delete from employee where empid=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> lst=new ArrayList<>();
		try {
			
			ResultSet rs=selemp.executeQuery();
			while(rs.next()) {
				Employee e=new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				lst.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}

	@Override
	public void insertnewEmp(Employee e) {
		try {
			insemp.setInt(1,e.getEmpid());
			insemp.setString(2,e.getEname());
			insemp.setDouble(3,e.getSal());
			insemp.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public Employee findById(int empid) {
		try {
			seleById.setInt(1, empid);
			ResultSet rs=seleById.executeQuery();
			if(rs.next())
			   return new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateById(Employee e) {
		try {
			upById.setString(1, e.getEname());
			upById.setDouble(2, e.getSal());
			upById.setInt(3, e.getEmpid());
			upById.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void removeById(int empid) {
		try {
			delById.setInt(1, empid);
			delById.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
