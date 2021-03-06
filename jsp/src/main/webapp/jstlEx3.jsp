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
	<jsp:useBean id="lst" class="java.util.ArrayList"></jsp:useBean>
	<jsp:useBean id="m1" class="com.goot.jspbasicvo.MemberVo"></jsp:useBean>
	<jsp:setProperty property="userid" name="m1" value="hong123" />
	<jsp:setProperty property="userPwd" name="m1" value="123123" />
	<jsp:setProperty property="userName" name="m1" value="홍길동" />
	<jsp:setProperty property="gender" name="m1" value="Male" />
	<jsp:setProperty property="point" name="m1" value="100" />

	<jsp:useBean id="m2" class="com.goot.jspbasicvo.MemberVo"></jsp:useBean>
	<jsp:setProperty property="userid" name="m2" value="dooly" />
	<jsp:setProperty property="userPwd" name="m2" value="123123" />
	<jsp:setProperty property="userName" name="m2" value="둘리" />
	<jsp:setProperty property="gender" name="m2" value="FeMale" />
	<jsp:setProperty property="point" name="m2" value="200" />

	<%
	lst.add(m1);
	lst.add(m2);
	%>

	<c:forEach var="i" begin="1" end="5" step="1" varStatus="hkd">
		<c:choose>
			<c:when test="${hkd.first}">
				<div style='background-color: yellow;'>i의 값 : ${i }, 반복 회수
					${hkd.count }, 반복인덱스 : ${hkd.index }</div>
			</c:when>
			<c:when test="${hkd.last}">
				<div style='background-color: yellow;'>i의 값 : ${i }, 반복 회수
					${hkd.count }, 반복인덱스 : ${hkd.index }</div>
			</c:when>
			<c:otherwise>
				<div style='border: 1px solid blue;'>i의 값 : ${i }, 반복 회수
					${hkd.count }, 반복인덱스 : ${hkd.index }</div>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<table border='1'>
		<c:forEach var="i" begin="0" end="2" step="1" varStatus="loop1">
			<tr>
				<c:forEach var="j" begin="0" end="3" step="1" varStatus="loop2">
					<td>${(loop1.index) * loop2.count }</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>

	<table class="table table-hover">
		<thead>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>성별</th>
				<th>포인트</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="member" items="${lst}">
				<tr>
					<td>${member.userid }</td>
					<td>${member.userPwd }</td>
					<td>${member.userName }</td>
					<td>${member.gender }</td>
					<td>${member.point }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<c:set var="sports" value="탁구, 배구, 야구"></c:set>
	<ul>
		<c:forTokens var="s" items="${sports }" delims=",">
			<li>${s }</li>
		</c:forTokens>
	</ul>
</body>
</html>