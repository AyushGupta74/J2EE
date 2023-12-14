package com.demo.service;

import com.demo.beans.MyUser;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService{
	private LoginDao ldao;

	public LoginServiceImpl() {
		super();
		this.ldao = new LoginDaoImpl();
	}

	@Override
	public MyUser validateUser(String uname, String pass) {
		return ldao.findUSer(uname,pass);
	}

	@Override
	public boolean registeruser(String nm, String uname, String pass) {
		// TODO Auto-generated method stub
		return ldao.addnewuser(nm,uname,pass);
	}
	

}
