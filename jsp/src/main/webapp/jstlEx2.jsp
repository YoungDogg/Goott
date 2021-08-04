<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="id" value="hong123" scope="page"></c:set>
	<c:set var="pwd" value="123123" scope="page"></c:set>
	<c:set var="name" value="홍길동" scope="page"></c:set>

	<c:if test="${id eq 'hong' }">
		<h4>id는 hong과 같다</h4>
	</c:if>
	<c:if test="${id == 'hong123' }">
		<h4>
			<h4>id는 hong123과 같다</h4>
		</h4>
	</c:if>

	<c:if test="${id eq 'hong123' and (pwd eq '123123')}">
		<h4>같다</h4>
	</c:if>
	<c:if test="${name ne '홍길순' }">
		<h4>같지 않다</h4>
	</c:if>

	<c:choose>
		<c:when test="${name eq '홍길순' }">
			<h4>같다</h4>
			<c:otherwise>
				<h4>같지 않다</h4>
			</c:otherwise>
		</c:when>
	</c:choose>
</body>
</html>