package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/test")
public class TestServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		LocalDateTime dt=LocalDateTime.now();
		PrintWriter out=response.getWriter();
		out.println(dt);
		//response.setHeader("refresh","5");
		response.sendRedirect("http://google.com");
		
	} 

}
