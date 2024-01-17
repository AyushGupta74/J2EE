package com.portfoliomanager.Authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfoliomanager.Authorization.entity.AuthRequest;
import com.portfoliomanager.Authorization.entity.JwtResponse;
import com.portfoliomanager.Authorization.entity.UserDetailWithId;
import com.portfoliomanager.Authorization.util.JwtUtil;

@RestController
//Allow requests from http://localhost:9090
@CrossOrigin(origins = "http://localhost:9090")
public class AuthorizationController {
	
	private final JwtUtil jwtUtil;
	private final AuthenticationManager authenticationManager;
	
	@Autowired
	public AuthorizationController(JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
		this.jwtUtil = jwtUtil;
		this.authenticationManager = authenticationManager;
	}
	
	//Validate incoming JWT token
	@GetMapping("/validate")
	public ResponseEntity<?> validateToken() {
		System.out.println("in validate url");
		//If access granted through filter, user is authenticated
		return ResponseEntity.ok(true);
	}
	
	//Authenticate provided credentials, if valid, generate JWT token
	@PostMapping(value= "/authenticate", consumes = "application/JSON")
	public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		Authentication ob;
		try {
			ob = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("invalid username/password");
		}
		return ResponseEntity.ok(new JwtResponse(jwtUtil.generateToken(authRequest.getUserName()), ((UserDetailWithId)ob.getPrincipal()).getId()));
	}
}
