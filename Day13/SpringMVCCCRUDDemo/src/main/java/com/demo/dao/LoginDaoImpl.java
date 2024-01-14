package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.MyUser;

@Repository
public class LoginDaoImpl implements LoginDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
 
	public MyUser checkUser(String unm, String passwd) {
		try {
		  String str="select user_name,password,roles from my_user where user_name=? and password=?";
		  return jdbcTemplate.queryForObject(str, new Object[] {unm,passwd},BeanPropertyRowMapper.newInstance(MyUser.class));
		}catch(EmptyResultDataAccessException e) {
			System.out.println("not found"+e.getMessage());
			return null;
		}
	}

}
