<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h2>포맷팅 태그 라이브러리 예제</h2>
	
	<h4>fmt의 number 태그를 이용한 숫자 포맷팅</h4>
	<c:set var="price" value="100000000" />
	<fmt:formatNumber value="${price }" type="number"  groupingUsed="false"/>
	<div>통화로 표현시
		: <fmt:formatNumber type="currency" currencySymbol="￦" value="${price }"/>
		
	</div>
	
	<div>퍼센트로 표현시
		: <fmt:formatNumber type="percent" value="${price }"/>
	
	</div>
	
	
	<h4>formatDate예제</h4>
	<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
	<div>원래 now 값 : ${now }</div>
	<div>
		<fmt:formatDate value="${now }" type="date" dateStyle="full"/>
	</div>
	<div>
		<fmt:formatDate value="${now }" type="date" dateStyle="short"/>
	</div>
	<div>
		<fmt:formatDate value="${now }" type="time" />
	</div>
	<div>
		<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>
	</div>
	<div>
		<fmt:formatDate value="${now }" pattern="YYYY-MM-dd hh:mm:ss"/>
	</div>
	
	<fmt:timeZone value="America/New York">
		<jsp:useBean id="nowNY" class="java.util.Date"></jsp:useBean>
		
		<div> 뉴욕의 현재 시간 :
		<fmt:formatDate value="${nowNY }" type="both" dateStyle="full" timeStyle="full"/>
		</div>
	</fmt:timeZone>
</body>
</html>