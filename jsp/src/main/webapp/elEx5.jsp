<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> request 객체에 바인딩 해보고 elEx5_rec.jsp에서 EL로 받아서 출력</h2>
	<%
		request.setCharacterEncoding("utf-8");
		request.setAttribute("address", "어떤 주소");
	%>
	
	<jsp:forward page="elEx5_rec.jsp"></jsp:forward>
</body>
</html>