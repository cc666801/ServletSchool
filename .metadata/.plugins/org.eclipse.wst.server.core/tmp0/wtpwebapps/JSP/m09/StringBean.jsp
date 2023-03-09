<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Using JavaBeans with JSP</title>
</head>
<body>
<jsp:useBean id="stringBean" class="com.lcpan.bean.StringBean" />
	<ol>
		<li><jsp:setProperty property="message" name="stringBean" value="AAA" />
			Set and get with jsp:setProperty:<br>
			<i><jsp:getProperty property="message" name="stringBean"/></i>
		</li>
		<li><% stringBean.setMessage("BBB"); %></li>
			Set and get with scriptlet:<br>
			<i><%= stringBean.getMessage() %></i>
	
	
	</ol>
	
</body>
</html>