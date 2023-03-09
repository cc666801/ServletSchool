<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Using JavaBeans with JSP</title>
</head>
<body>
	<h1>Hello, <%=(String)request.getAttribute("username") %></h1>
	
</body>
</html>