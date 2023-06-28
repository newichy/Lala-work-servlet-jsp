<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = "湊 裕介";
	int age = 23;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	私の名前は<%= name %>、年齢は<%= age %>歳です。
	<% for(int i = 0; i < 5; i++) { %>
		<p>こんにちは！</p>
	<% } %>
</body>
</html>