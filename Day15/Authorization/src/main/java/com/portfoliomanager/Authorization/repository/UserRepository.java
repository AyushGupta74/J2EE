package com.portfoliomanager.Authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfoliomanager.Authorization.entity.User;

//JPA repository to communicate with users database
public interface UserRepository extends JpaRepository<User, Long> {
	//Query to find user using username
	User findByUserName(String username);
}
