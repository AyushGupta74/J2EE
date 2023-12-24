package com.demo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.Product;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/addToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
         
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String btn=request.getParameter("btn");
	   if(btn.equals("add")) {
	   String[] products=request.getParameterValues("prod");
	   System.out.println(Arrays.toString(products));
	   HttpSession session=request.getSession();
	   List<Product> cart=(List<Product>)session.getAttribute("cart");
	   if(cart==null) {
		   cart=new ArrayList<>();
	   }
	   //add all products in the cart
	   for(String s:products) {  
		   String[] s1=s.split(":");
		   int pos=cart.indexOf(new Product(Integer.parseInt(s1[0])));
		   //if product not found then add in the cart
		   if(pos==-1) {
		     cart.add(new Product(Integer.parseInt(s1[0]),s1[1],1,Double.parseDouble(s1[2])));
		   }
		   else {
			   //if found in the cart then add quantity by 1
			   int nqty=cart.get(pos).getQty();
			   cart.get(pos).setQty(nqty+1);
		   }
	   }
	   session.setAttribute("cart", cart);
	   System.out.println("cart: ");
	   System.out.println(cart);
	   RequestDispatcher rd=request.getRequestDispatcher("findallprices");
	   rd.forward(request, response);
	   }else {
		   RequestDispatcher rd=request.getRequestDispatcher("showcart.jsp");
		   rd.forward(request, response);
	   }
	  
	}

}
