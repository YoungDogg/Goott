<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파라메터를 elEx4_rec.jsp로 보내고, EL로 받아 출력해 보기</h2>
	<form enctype="UTF-8"  method="POST" action="elEx4_rec.jsp">
		이름 : <input type="text" name="userName" /> <br />
		나이 : <input type="text" name="userAge"  /><br />
		<button type="submit" >전송</button>
	</form>
</body>
</html>