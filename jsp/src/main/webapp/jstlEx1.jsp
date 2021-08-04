<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:set var="id" value="hong123" scope="page"/>
	<c:set var="pwd" value="ddd" scope="page"/>
	<c:set var="name" value="홍길동" scope="page"/>
	<c:set var="contextpath" value='${pageContext.request.contextPath}'></c:set>
	
	<div>아이디 : ${id }</div>
	<div>비밀번호 : ${pwd }</div>
	<div>이름 : ${name }</div>
	
	<a href='${contextpath}/login.jsp'>로긴하기</a>
	
	<c:remove var="name"/>
	<div>name : ${name }</div>
</body>
</html>