<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OrderBean1</title>
</head>
<body>
<div align="center"></div>
<h3>Using OrderBeans with JSP</h3>
<jsp:useBean id="order" class="com.lcpan.bean.OrderBean" scope="request"></jsp:useBean>
<jsp:setProperty property="bookno" name="order"/>
<jsp:setProperty property="price" name="order"/>
<jsp:setProperty property="quantity" name="order"/>
<table border="1">
	<tr><th>book no.</th><th>unit price</th><th>quantity</th><th>subTotal
	<tr align="right">
		<td><jsp:getProperty property="bookno" name="order"/>
		<td>$<jsp:getProperty property="price" name="order"/>
		<td><jsp:getProperty property="quantity" name="order"/>
		<td>$<jsp:getProperty property="subTotal" name="order"/>
</table>
</body>
</html>