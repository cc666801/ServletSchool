<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head><title>員工資料</title></head>
<body>
<div>
<h2>員工資料</h2>
<table>
<tr><td>員工編號<td><input type="text" disabled value=<%=request.getAttribute("empno") %>>

</table>
<% if((Integer)request.getAttribute("updateCount") > 0) {%>
	<%= "Delete Sucessfully"%>
	<% }else{ %>
	<%= "Delete Fail"%>
	<% }%>
</div>
</body>
</html>
