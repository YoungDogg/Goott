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
	<%= request.getAttribute("result") %> �Դϴ� <br>
	${requestScope.result} requestScope.result <br>
	${names[1]} : names �迭, ����Ʈ���� EL������ ������ �� <br>
	${notice.title} : title map���� ������ ��. <br>
	${result} : from pageContext <br>
	${param.num} ?num= �� ���� ���� �����´� <br>
	${header.Host} <br>
	${header["Host"]} <br>
	
	<h2>EL ������</h2>
	 ${param.num} > 10 :  ${param.num > 10} <br>
	 ${param.num} > 10 :  ${param.num gt 10} <br>
	 ${param.num} > 10 :  ${param.num ge 10} <br>
	 <br>
	 ${empty param.num} is equal ${param.num == null || param.num == ''} <br>
	 ${not empty param.num} <br>
	 ${param.num div 3} = ${param.num / 3} <br>
</body>
</html>