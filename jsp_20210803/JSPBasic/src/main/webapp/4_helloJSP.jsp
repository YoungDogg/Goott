<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="commonError.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file='header.jsp'%>
	<h2>안녕하세요, JSP입니다!!!!</h2>
	
	<%
	
		int a = 3, b = 0;
	
		// out.println(a / b); // 일부로 예외 발생 시킴 (errorPage의 동작 유무 테스트)
	%>
	
	<%@ include file='footer.jsp' %>
</body>
</html>