<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>param 태그를 이용한 매개변수 전달</h2>
	<jsp:forward page="actionTagEx1.jsp">
		<jsp:param value="hkd" name="name"/>
	</jsp:forward>
</body>
</html>