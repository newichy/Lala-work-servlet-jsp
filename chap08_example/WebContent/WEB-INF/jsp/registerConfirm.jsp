<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User"  %>
<% 
	User registerUser = (User) session.getAttribute("registerUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
	<p>下記の内容で登録します</p>
	<p>
	ログインID：<%= registerUser.getId() %><br>
	名前：<%= registerUser.getName() %><br>
	</p>
	<a href="/chap08_example/RegisterUser">戻る</a>
	<a href="/chap08_example/RegisterUser?action=done">登録</a>	
	<!-- リクエストパラメータに「action=done」設定！ -->
</body>
</html>