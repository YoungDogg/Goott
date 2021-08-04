<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="p1" class="com.goot6.jspbasicvo.Point" scope="page"></jsp:useBean>
	<jsp:setProperty property="x" name="p1" value="200"/>
	<jsp:setProperty property="y" name="p1" value="400"/>
	
	<jsp:useBean id="lst" class="java.util.ArrayList"></jsp:useBean>
	
	<h2>EL에서 empty 사용하기</h2>
	<div>\${empty p1 } : ${empty p1 }</div>
	<div>\${not empty p1 } : ${not empty p1 }</div>
	
	<div>\${empty lst } : ${empty lst }</div>
	<div>\${empty null } : ${empty null }</div>
	<div>\${empty "" } : ${empty "" }</div>
</body>
</html>