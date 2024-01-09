package com.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.model.Employee;
import com.demo.service.EmpService;
import com.demo.service.EmpServiceImpl;

/**
 * Servlet implementation class UpdateEmpServlet
 */
@WebServlet("/updateemp")
public class UpdateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empid=Integer.parseInt(request.getParameter("empid"));
		String ename=request.getParameter("ename");
		double sal=Double.parseDouble(request.getParameter("sal"));
		EmpService eservice=new EmpServiceImpl();
		Employee e=new Employee(empid,ename,sal);
		eservice.modifyemp(e);
		RequestDispatcher rd=request.getRequestDispatcher("employees");
		rd.forward(request, response);
	}

}
