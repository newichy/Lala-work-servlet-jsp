<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.SiteEV" %>
<%
	SiteEV siteEV = (SiteEV) application.getAttribute("siteEV");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>湊雄介のページ</h1>
	<p>
	<a href="/chap09_example/MinatoIndex?action=like">いいね</a>:<%= siteEV.getLike() %>人
	<a href="/chap09_example/MinatoIndex?action=dislike">よくないね</a>:<%= siteEV.getDislike() %>人
	</p>
</body>
</html>