<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	String name = "홍길동"; // 멤버 변수
	
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
	
		String gender = "Male";  // 지역변수
	%>
	<h2>안녕하세요 <%= getName() %></h2>
	
	
</body>
</html>