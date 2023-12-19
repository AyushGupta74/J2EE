<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <jsp:useBean id="p" class="com.demo.beans.Product"></jsp:useBean>
    <jsp:setProperty property="*" name="p"/>
    
    <hr>
    
     Pid: <jsp:getProperty name="p" property="pid"/>
     Pname: <jsp:getProperty name="p" property="pname"/>
     Quantity: <jsp:getProperty name="p" property="qty"/>
     Price:   <jsp:getProperty name="p" property="price"/>
</body>
</html>