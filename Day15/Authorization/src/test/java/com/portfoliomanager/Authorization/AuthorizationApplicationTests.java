package com.portfoliomanager.Authorization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfoliomanager.Authorization.controller.AuthorizationController;
import com.portfoliomanager.Authorization.entity.AuthRequest;
import com.portfoliomanager.Authorization.entity.JwtResponse;
import com.portfoliomanager.Authorization.entity.User;
import com.portfoliomanager.Authorization.entity.UserDetailWithId;
import com.portfoliomanager.Authorization.util.JwtUtil;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class AuthorizationApplicationTests {
	@Autowired
	WebApplicationContext webApplicationContext;
	@Autowired
	MockMvc mockMvc;
	   
	@Autowired
	private AuthorizationController authorizationController;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Test
	void contextLoads() {
		assertNotNull(authorizationController);
		assertNotNull(jwtUtil);
		assertNotNull(webApplicationContext);
		assertNotNull(mockMvc);
	}
	
	AuthRequest auth=new AuthRequest("user", "pass");
	
	@Test
	public void testAuthUserName() {
		auth.setUserName("user");
		assertEquals("user", auth.getUserName());
	}
	
	@Test
	public void testAuthPassword() {
		auth.setPassword("pass");
		assertEquals("pass", auth.getPassword());
	}
	
	@Test
	public void authenticateTest() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mockMvc.perform(MockMvcRequestBuilders.post("/authenticate").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(auth))).andExpect(status().isOk());
	}
	
	@Test
	public void validateTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/validate").accept(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + jwtUtil.generateToken("user"))).andExpect(status().isOk());
	}
	
	JwtResponse jwtResponse =new JwtResponse();
	
	@Test
	public void testJwtResonseId() {
		jwtResponse.setId(1l);
		assertEquals(1l, jwtResponse.getId());
	}
	@Test
	public void testJwtResponseToken() {
		String token = jwtUtil.generateToken("user");
		jwtResponse.setToken(token);
		assertEquals(token, jwtResponse.getToken());
	}
	
	User user =new User();
	@Test
	public void testUserId() {
		user.setId(1l);
		assertEquals(1l, user.getId());
	}
	@Test
	public void testUserUserName() {
		user.setUserName("user");
		assertEquals("user", user.getUserName());
	}
	@Test
	public void testUserPassword() {
		user.setPassword("pass");
		assertEquals("pass", user.getPassword());
	}
	UserDetailWithId userdetails =new UserDetailWithId("user", "pass", true, false, false, false, new ArrayList<>());
	@Test
	public void testUserDetailWithIdId() {
		user.setId(1l);
		assertEquals(1l, user.getId());
	}
	@Test
	public void testUserDetailWithIdPassword() {
		user.setPassword("pass");
		assertEquals("pass", user.getPassword());
	}
}
