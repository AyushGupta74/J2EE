<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  errprPage="errhandle.jsp" import="java.util.Date,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
    public int factorial(int n){
	int ans=1;
	for(int i=1;i<=n;i++){
		ans=ans*i;
	}
	return ans;
}
%>
<%@include file="header.html" %>
<%
   String op=request.getParameter("btn");
   int n1=Integer.parseInt(request.getParameter("num1"));
   if(op.equals("add")){
        int n2=Integer.parseInt(request.getParameter("num2"));
        int sum=n1+n2;
   }else{
	   
	   int sum=factorial(n1);
   }
   
   Date dt=new Date();
   out.println("testing jsp");
  
%>
<h2>Addition : <%=sum%></h2>
<h4>Today's Date : <%=dt %></h4>
<%@include file="footer.html" %>
</body>
</html>