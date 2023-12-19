<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <%String n1=request.getParameter("num1");
     String n2=request.getParameter("num2");
     String msg=request.getParameter("msg");
     String ans=request.getParameter("ans");
   %>
   Num1 :   <%=n1 %>   ----- ${param.num1}
   Num2:    <%=n2 %>   ----- ${param.num2}
   Answer:  <%=ans %>  ----- ${param.ans}
   Message: <%=msg %>  ----- ${param.msg}
</body>
</html>