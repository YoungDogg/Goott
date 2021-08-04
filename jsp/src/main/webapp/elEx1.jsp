<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>EL 데이터 출력</h4>
	<div> \${100} : ${100}</div>
	<div> \${"안녕하세요"} : ${"안녕하세요"}</div>
	<div> \${10 + 1 } : ${10 + 1 }</div>
	<div> \${"10" + "10" } : ${"10" + "10" } </div>
	<%-- <div> \${"안녕" + "하세요" } : ${"안녕" + "하세요" }</div>
 --%>
 	<div>\${"안녕" } + \${"하세요" } : ${"안녕" } + ${"하세요" }</div>
 </body>
</html>