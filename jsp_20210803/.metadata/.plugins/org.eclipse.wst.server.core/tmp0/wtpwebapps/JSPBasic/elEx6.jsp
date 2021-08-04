<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>자바 빈을 배열에 담아두고, EL을 이용해 출력하자</h2>
	
	<jsp:useBean id="lst" class="java.util.ArrayList"></jsp:useBean>
	<jsp:useBean id="p1" class="com.goot6.jspbasicvo.Point"></jsp:useBean>
	<jsp:setProperty property="x" name="p1" value="100"/>
	<jsp:setProperty property="y" name="p1" value="100"/>
	<jsp:useBean id="p2" class="com.goot6.jspbasicvo.Point"></jsp:useBean>
	<jsp:setProperty property="x" name="p2" value="200"/>
	<jsp:setProperty property="y" name="p2" value="200"/>
	
	<%
		lst.add(p1); lst.add(p2);
	%>
	
	<div>p1
		<div>x좌표 : ${lst[0].x }</div>
		<div>y좌표 : ${lst[0].y }</div>
	</div>
	
	<div>p2
		<div>x좌표 : ${lst[1].x }</div>
		<div>y좌표 : ${lst[1].y }</div>
	</div>
</body>
</html>