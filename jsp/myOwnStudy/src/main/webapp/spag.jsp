<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<% pageContext.setAttribute("result", "hello"); %>
<body>
	<%= request.getAttribute("result") %> 입니다 <br>
	${requestScope.result} requestScope.result <br>
	${names[1]} : names 배열, 리스트에서 EL값으로 가져온 것 <br>
	${notice.title} : title map에서 가져온 것. <br>
	${result} : from pageContext <br>
	${param.num} ?num= 이 다음 값을 가져온다 <br>
	${header.Host} <br>
	${header["Host"]} <br>
	
	<h2>EL 연산자</h2>
	 ${param.num} > 10 :  ${param.num > 10} <br>
	 ${param.num} > 10 :  ${param.num gt 10} <br>
	 ${param.num} > 10 :  ${param.num ge 10} <br>
	 <br>
	 ${empty param.num} is equal ${param.num == null || param.num == ''} <br>
	 ${not empty param.num} <br>
	 ${param.num div 3} = ${param.num / 3} <br>
</body>
</html>