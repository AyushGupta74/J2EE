<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form action="updateemp" method="post">
    Employee Id : <input type="text" name="empid" id="empid" value="${emp.empid}" readonly><br>
    Employee name: <input type="text" name="ename" id="ename" value="${emp.ename}"><br>
    Employee Salary: <input type="text" name="sal" id="sal" value="${emp.sal}"><br>
    <button type="submit" name="btn" id="btn">Update employee</button>
 </form>
</body>
</html>