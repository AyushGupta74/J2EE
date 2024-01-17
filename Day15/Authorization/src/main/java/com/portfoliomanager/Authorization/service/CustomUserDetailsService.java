package com.portfoliomanager.Authorization.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.portfoliomanager.Authorization.repository.UserRepository;
import com.portfoliomanager.Authorization.entity.User;
import com.portfoliomanager.Authorization.entity.UserDetailWithId;

//Service for Custom User Details
@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;
	
	@Autowired
	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	//Authenticate user with provided credentials
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("in loaduserbyusername method");
		User user = userRepository.findByUserName(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found!!");
		}
		return new UserDetailWithId(user.getUserName(), user.getPassword(), new ArrayList<>(), user.getId());
	}
}
