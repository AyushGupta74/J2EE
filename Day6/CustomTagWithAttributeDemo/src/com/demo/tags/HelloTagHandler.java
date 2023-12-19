package com.demo.tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTagHandler extends TagSupport{
	private String fname,lname;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	public int doStartTag() {
		return EVAL_BODY_INCLUDE;
	}
	
	public int doEndTag() {
		JspWriter out=pageContext.getOut();
		try {
			out.println("welcome to cutom tag hello");
			out.println("Welcome "+fname+" "+lname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
		
	}

}
