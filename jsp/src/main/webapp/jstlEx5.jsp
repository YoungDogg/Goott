<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>포매팅 태그 라이브러리 예제</h2>
	<c:set var="price" value="1111"></c:set>
	<fmt:formatNumber value="${price }" type="number" groupingUsed="false" var="priceNumber"></fmt:formatNumber>
	<div>
		통화로 표현시 :
		<fmt:formatNumber type="currency" currencySymbol="₩" value="${price }" />
	</div>

	<div>
		퍼센트 표현시 :
		<fmt:formatNumber type="percent" value="${price }" />
	</div>

	<h4>formatDate</h4>
	<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
	<div>원래값 : ${now }</div>
	<div>
		<fmt:formatDate value="${now }" type="date" dateStyle="full" />
	</div>
	<div>
		<fmt:formatDate value="${now }" type="date" dateStyle="short" />
	</div>
	<div>
		<fmt:formatDate value="${now }" type="time" />
	</div>
	<div>
		<fmt:formatDate value="${now }" type="both" dateStyle="full"
			timeStyle="full" />
	</div>
	<div>
		<fmt:formatDate value="${now }" pattern="YYYY-MM-dd hh:mm:ss" />
	</div>
	<div>
		뉴욕 잘 안된다
		<fmt:timeZone value="PST">
			<fmt:formatDate value="${now }" pattern="YYYY-MM-dd hh:mm:ss" />
		</fmt:timeZone>
	</div>
	<div>
		<fmt:timeZone value="Hongkong">
			<fmt:formatDate value="${now}" type="both" dateStyle="full"
				timeStyle="full" />
		</fmt:timeZone>
	</div>
	
	<table border='1'>
		<c:forEach var="i" begin="0" end="2" step="1" varStatus="loop1">
			<tr>
				<c:forEach var="j" begin="0" end="3" step="1" varStatus="loop2">
					<td>${(loop1.index *4) + loop2.count }</td>	
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>