<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>elEx4.jsp에서 보낸 파라메터를 EL로 받아 출력해보자</h2>
	
	<%
		request.setCharacterEncoding("utf-8");
		//String name = request.getParameter("userName");
		//int age = Integer.parseInt(request.getParameter("userAge"));
	%>
	
	
	<!-- ------------------------------------------------------------------------------------------------ -->
	<div>이름은 ${param.userName } 이고, 나이는 ${param.userAge }살 입니다</div>
	
</body>
</html>