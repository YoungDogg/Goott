<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!--  지역변수가 아니다 -->
<%!String name = "홍길동"; //멤버면수

	public String getName() {
		return this.name;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String gender = "M"; //지역변수
	%>
	<%=getName()%>
	불러온다.
</body>
</html>