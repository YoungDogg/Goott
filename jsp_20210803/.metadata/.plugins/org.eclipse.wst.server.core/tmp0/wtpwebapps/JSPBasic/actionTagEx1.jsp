<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>여기는 actionTagEx1.jsp</h2>
	<jsp:include page="header.jsp"></jsp:include>
	
	<%
		out.println(request.getParameter("name"));
	%>
</body>
</html>