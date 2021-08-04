<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>EL 연산자</h2>
	<div>\${10 + 10 } : ${10 + 10 }</div>
	<div>\${10 div 10 } : ${10 div 10 }</div>
	<div>\${10 mod 10 } : ${10 mod 10 }</div>

	<h2>비교연산</h2>
	<div>\${10 eq 10 } : ${10 eq 10 }</div>
	<div>\${10 == 10 } : ${10 == 10 }</div>
	<div>\${10 lt 10 } : ${10 lt 10 }</div>
	<div>\${10 gt 10 } : ${10 gt 10 }</div>
	
	<!-- EL 문자열 비교, 주소가 아닌 실제 내용 비교 -->
	<div>\${"안녕" eq "안녕" } : ${"안녕" eq "안녕" }</div>
	<div>\${"안녕" == "안녕" } : ${"안녕" == "안녕" }</div>
	<div>\${"안녕" != "안녕" } : ${"안녕" != "안녕" }</div>
	<div>\${"Hi" ne "hi" } : ${"Hi" ne "hi" }</div>
	<%-- <div>\${"Hi" eq empty} : ${"Hi" eq empty}</div> --%>
	
	<h2>EL 논리연산자</h2>
	<div>\${(10 == 10) && (10 < 1)} : ${(10 == 10) && (10 < 1)}</div>
	<div>\${(10 == 10) || (10 < 1)} : ${(10 == 10) || (10 < 1)}</div>
	<div>\${not (10 == 10) && (10 < 1)} : ${not (10 == 10) && (10 < 1)}</div>
	
</body>
</html>