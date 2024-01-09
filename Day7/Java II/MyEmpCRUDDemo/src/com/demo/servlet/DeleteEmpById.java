package com.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.EmpService;
import com.demo.service.EmpServiceImpl;

/**
 * Servlet implementation class DeleteEmpById
 */
@WebServlet("/deleteemp")
public class DeleteEmpById extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empid=Integer.parseInt(request.getParameter("eid"));
		EmpService eservice=new EmpServiceImpl();
		eservice.deleteById(empid);
		RequestDispatcher rd=request.getRequestDispatcher("employees");
		rd.forward(request, response);
		
	}

	

}
