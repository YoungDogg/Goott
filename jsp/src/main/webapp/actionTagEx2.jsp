<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	para 태그를 이용해 전달, dispatcher의 forward랑 같은 역할이다 <br>
	<jsp:forward page="actionTAgEx1.jsp">
		<jsp:param value="param value" name="name"/>
	</jsp:forward>
</body>
</html>