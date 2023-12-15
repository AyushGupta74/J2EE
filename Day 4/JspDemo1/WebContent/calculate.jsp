<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
   int n1=Integer.parseInt(request.getParameter("num1"));
   int n2=Integer.parseInt(request.getParameter("num2"));
   int sum=n1+n2;
   Date dt=new Date();
   out.println("testing jsp");
%>
<h2>Addition : <%=sum%></h2>
<h3>Today's Date : <%=dt %></h3>
</body>
</html>