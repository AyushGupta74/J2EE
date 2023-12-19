<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <% int num1=Integer.parseInt(request.getParameter("num1"));
   int num2=Integer.parseInt(request.getParameter("num2"));
   int ans=num1+num2;
   if (num1>0 && num2>0){%>
       <jsp:forward page="displayresult.jsp">
          <jsp:param name="ans" value="<%=ans%>"/>
          <jsp:param name="msg" value="this is message"/>
       </jsp:forward>
	   
  <% }else{
   %>  
      <h3>Data is invalid, pls reenter</h3>
      <jsp:include page="acceptdata.jsp"></jsp:include>
   
   <%}%>
</body>
</html>