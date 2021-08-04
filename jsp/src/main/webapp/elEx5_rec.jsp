<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	출력ddd <br>
<%-- 	<%
	request.setCharacterEncoding("utf-8");
	String address = (String)request.getAttribute("address");
	%>
	<div><%= address %></div> --%>
	
	<div> ${requestScope.address}</div>
</body>
</html>