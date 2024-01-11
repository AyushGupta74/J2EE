package com.demo.service;

import java.util.List;

import com.demo.model.MyUser;

public interface UserService {

	void addnewUser();

	List<MyUser> getAllUsers();

	MyUser getById(int uid);

	boolean removeById(int uid);

	boolean modifyById(int uid, String unm, String street);

	List<MyUser> sortById();

	void closeMySessionFactory();

}
