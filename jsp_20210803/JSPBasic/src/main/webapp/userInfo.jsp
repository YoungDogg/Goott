<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.goot6.jspbasicvo.MemberVo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>정보 수정 페이지</h4>
	<%
		MemberVo loginMember = (MemberVo)session.getAttribute("loginUser");
		if (loginMember != null) {
	%>
			<h4>
			<a href='userInfo.jsp'>
			<%
				out.println(loginMember.getUserName());
			%></a> 님 정보 수정 페이지!
			
			</h4>
			
			<%
			
				out.println(loginMember.toString());
			
			%>
			
			
	<% 
		} 
	%>
</body>
</html>