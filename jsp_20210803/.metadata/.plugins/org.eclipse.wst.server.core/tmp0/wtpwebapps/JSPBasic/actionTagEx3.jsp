<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.goot6.jspbasicvo.Point" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		 Point p = new Point(100, 100);
	
	   	out.println(p.toString());
	%>
	
	<jsp:useBean id="p2" class="com.goot6.jspbasicvo.Point" scope="page"></jsp:useBean>
	
		<jsp:setProperty property="x" name="p2" value="200" />
		<jsp:setProperty property="y" name="p2" value="400" />
	
	
	
	<%
		out.println(p2.toString());
		out.println(p2.getX());
		out.println(p2.getY());
	%>	
	
	<div>
		<h6>x좌표 : <jsp:getProperty property="x" name="p2"/></h6>
		<h6>y좌표 : <jsp:getProperty property="y" name="p2"/></h6>
	</div>
</body>
</html>