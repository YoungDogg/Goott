<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>why? Servlet</title>
<script>
	
</script>
</head>
<body>
	<h1>서블릿을 사용해야 하는 이유</h1>
	
	<%
		// 스크립트 릿(scriptlet) : jsp파일내에 java문법을 사용하는 부분
		int a = 10;
		
		
		if (a > 5) {
	%>
		<h2 style="color: red;">
		<!-- 아래는 표현식으로 자바 문법을 작성한 부분이다. --> 
			<%=a%>는 5보다 크다</h2>	
			
	<% 
		} else {
	%>
		<h2 style="color: blue;"> 작다</h2>
	<%
		}
	%>
</body>
</html>