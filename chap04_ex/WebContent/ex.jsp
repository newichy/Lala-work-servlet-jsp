<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ex.Employee" %>
<% Employee emp = new Employee("0001","湊雄介"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.red { color: red; }
</style>
<title>Insert title here</title>
</head>
<body>
	<% for(int i = 0; i < 10; i++){ %>
	<% if(i==0 || i==3 || i ==6 || i==9 ){ %>
	<p	class="red">
	<% } else { %>
	<p>
	<% } %>
		IDは<%= emp.getId() %>、名前は<%= emp.getName() %>です</p>
	<% } %>
</body>
</html>