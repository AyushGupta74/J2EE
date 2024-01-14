package com.demo.dao;

import com.demo.model.MyUser;

public interface LoginDao {

	MyUser checkUser(String unm, String passwd);

}
