<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>표현 언어(EL)로 여러가지 데이터를 출력해 보자</h2>
	
	<div>\${100 } : ${100 }</div>
	<div>\${"안녕하세요" } : ${"안녕하세요" }</div>
	<div>\${10 + 1 } : ${10 + 1 }</div>
	<div>\${"10" + 1 } : ${"10" + 1 }</div>
	<!-- 문자열 안의 값이 숫자로 바뀌어질 수 있다면 연산이 된다 -->
	<div>\${"10" + "1" } : ${"10" + "1" }</div>
	<!-- 문자열 끼리의 덧셈 연산은 허용하지 않는다 -->
	<div>\${"안녕"} ${" 홍길동" } : ${"안녕"}  ${" 홍길동" }</div>
	
	
</body>
</html>