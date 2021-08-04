<%@page import="java.sql.Connection"%>
<%@page import="com.webshin.dao.DBConn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	ddd
	<%
Connection con = DBConn.getConnection();
if (con != null) {
	out.print("DB 접속");
}
%>
</body>
</html>