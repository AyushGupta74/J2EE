package com.demo.service;

import com.demo.beans.MyUser;

public interface LoginService {

	MyUser validateUser(String uname, String pass);

	boolean registeruser(String nm, String uname, String pass);

}
