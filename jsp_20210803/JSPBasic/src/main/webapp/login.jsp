<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인 페이지</h2>
	<form enctype="UTF-8"  method="POST" action="loginses.do">
		아이디 : <input type="text" name="userId" /> <br />
		비밀번호 : <input type="password" name="userPwd"  /><br />
		<button type="submit" >로그인</button>
	</form>
</body>
</html>