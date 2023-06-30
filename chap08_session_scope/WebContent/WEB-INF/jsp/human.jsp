<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="model.Human" %>
 <% Human h =(Human) session.getAttribute("human"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><%= h.getName() %>さんは<%= h.getAge() %>歳です。</p>
	<a href="/chap08_session_scope/end">終了</a>
</body>
</html>