<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String msg = (String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>じゃんけんゲーム</h1>
	<form action="/janken/play" method="post">
		
			<input type="radio" name="user" value="0">グー<br>
			<input type="radio" name="user" value="1">チョキ<br>
			<input type="radio" name="user" value="2">パー<br>

		<input type="submit" value="送信">
	</form>
	<p>
	<% if(msg != null){ %>
	<%= msg %>
	<% } %>
	</p>
</body>
</html>