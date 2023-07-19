<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.User" %>
<%@ page import="model.Mutter" %>
<%@ page import="java.util.List" %>
<% 
	User loginUser = (User) session.getAttribute("loginUser");
	List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
	String errorMsg = (String) request.getAttribute("errorMsg");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
	<h1>どこつぶメイン</h1>
	<p>
		<%= loginUser.getName() %>
		<a href="/docoTsubu/Logout">ログアウト</a>
	</p>
	<p><a href="/docoTsubu/Main">更新</a></p>
	<form action="/docoTsubu/Main" method="post">
		<input type="text" name="text">
		<input type="submit" value="つぶやく">
	</form>
	<% if(errorMsg != null){
		<P style="color:red;"><%= errorMsg %></P>
	<% } %>
	
	<% for(Mutter mutter : mutterList){ %>
		<P><%= mutter.getUserName() %>:<%= mutter.getText() %></P>
	<% } %>

</body>
</html>