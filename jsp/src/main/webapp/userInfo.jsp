<%@page import="com.goot.jspbasicvo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>정보 수정 페이지</h4>
	<%
	MemberVo loginMember = (MemberVo) session.getAttribute("loginUser");
	if (loginMember != null){
		out.print(loginMember.getUserName());
	}
	%>
	반갑다 <br>
	<% out.print(loginMember.toString()); %>

</body>
</html>