<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% int kotae = (int) application.getAttribute("kotae"); %>
<% String msg = (String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header><h1>Hight Low Game</h1></header>
	
	<main>
		<p>１～９９の数字を入力</p>
		<form action="/hi-low/game" method="post">
			<input type="text" name="num"><br>
			<input type="submit" value="送信">
		</form>
		<p><%= msg %></p>
		<p><a href="/hi-low/game">数字を再設定</a></p>
	</main>
	
</body>
</html>