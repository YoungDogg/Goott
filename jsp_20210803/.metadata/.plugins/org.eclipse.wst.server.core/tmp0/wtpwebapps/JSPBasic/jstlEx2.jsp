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
	
	<c:if test="${id eq 'hong' }">
		<h4>id는 hong과 같습니다...</h4>
	</c:if>
	
	<c:if test="${id == 'hong123' }">
		<h4>같습니다...</h4>
	</c:if>
	
	<c:if test="${(id eq 'hong123') and (pwd eq '123123') }">
		<h4>같습니다...</h4>
	</c:if>
	
	<c:if test='${name ne "홍길순" }'>
		<h4>...</h4>
	</c:if>
	
	
	<c:choose>
		<c:when test="${name eq '홍길순' }"> <h5>맞다</h5></c:when>
		<c:otherwise><h5>아니다</h5></c:otherwise>
	</c:choose>
	
</body>
</html>