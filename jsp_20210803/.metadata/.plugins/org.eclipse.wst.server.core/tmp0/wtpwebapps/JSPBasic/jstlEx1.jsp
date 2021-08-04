<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="id" value="hong123" scope="page" />
	<c:set var="pwd" value="123123" scope="page" />
	<c:set var="name" value="홍길동" scope="page" />
	
	<c:set var="contextPath" value="${pageContext.request.contextPath }" />
	
	<div>아이디 : ${id }</div>
	<div>비밀번호 : ${pwd }</div>
	<div>이름 : ${name }</div>
	
	<a href='${contextPath }/login.jsp'>로그인 하기</a>
	
	<c:remove var="name"/>
	
	<div>이름 : ${name }</div>
	
</body>
</html>