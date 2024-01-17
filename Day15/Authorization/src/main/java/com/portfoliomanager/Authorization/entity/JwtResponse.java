package com.portfoliomanager.Authorization.entity;

//POJO for JWT response
public class JwtResponse {
	private String token;
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public JwtResponse(String token, Long id) {
		super();
		this.token = token;
		this.id = id;
	}

	public JwtResponse() {
		super();
	}
}
