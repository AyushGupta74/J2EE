<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  prefix="mytag" uri="/calculate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to customtags</h1>
<mytag:calculatedata num1='${param.num1}' num2='${param.num2}'></mytag:calculatedata>
<mytag:hello fname='Kishori' lname='Khadilkar'></mytag:hello>
</body>
</html>