<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>EL에서의 산술 연산</h2>
	
	<div>\${10 + 10 } : ${10 + 10 }</div>
	<div>\${100 div 10 } : ${100 div 10 }</div>
	<div>\${10 mod 3 } : ${10 mod 3 }</div>
	
	<h2>EL에서의 비교 연산</h2>
	<div>\${10 eq 10 } : ${10 eq 10 }</div>
	<!-- EL에서는 문자열을 비교 할때 == 나 eq를 사용하더라도 주소가 아닌 실제 내용을 비교하게 된다 -->
	<div>\${"hello" == "hello" } : ${"hello" == "hello" }</div>
	<div>\${"hello" eq "hello" } : ${"hello" eq "hello" }</div>
	<div>\${20 ne 10 } : ${20 ne 10 }</div>
	<div>\${"hello" ne "Hello" } : ${"hello" ne "Hello" }</div>
	<div>\${10 lt 5 } : ${10 lt 5 }</div>
	<div>\${100 gt 10 } : ${100 gt 10 }</div>
	
	
	
	<h2>EL에서의 논리 연산</h2>
	<div>\${(10 == 10) && (20 == 20)} : ${(10 == 10) && (20 == 20)} </div>
	<div>\${(10 == 10) || (20 == 20)} : ${(10 == 10) || (20 == 20)} </div>
	<div>\${not(10 == 10) && (20 == 20)} : ${not(10 == 10) && (20 == 20)} </div>
</body>
</html>