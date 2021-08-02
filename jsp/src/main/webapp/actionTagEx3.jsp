<%@page import="com.goot.jspbasicvo.Point"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Point p = new Point(100, 10000);

	out.println(p.toString());
	%>

	<jsp:useBean id="p2" class="com.goot.jspbasicvo.Point" scope="page"></jsp:useBean>

	<%
	out.print(p2.toString());
	%>

	<jsp:setProperty property="x" name="p2" value="200" />
	<jsp:setProperty property="y" name="p2" value="20000" />
	<%
	out.print(p2.toString());
	%>
	<div>
		<jsp:getProperty property="x" name="p2"/>
		<jsp:getProperty property="y" name="p2"/>
	</div>
</body>
</html>