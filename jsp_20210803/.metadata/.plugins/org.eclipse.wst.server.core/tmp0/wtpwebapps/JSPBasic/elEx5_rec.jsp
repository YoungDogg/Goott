<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>elEx5.jsp에서 request영역에 바인딩해서 보내준 데이터를 EL로 얻어와 출력해보자</h2>
	
	<%
		//String address = (String)request.getAttribute("address");
	%>
	
	
	<div>${requestScope.address }</div>
</body>
</html>