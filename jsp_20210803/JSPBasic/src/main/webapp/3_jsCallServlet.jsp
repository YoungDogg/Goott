<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바스크립트에서 서블릿 호출하는 방법 중 하나</title>
<script>
	/*
	function checkValidate() {
		let frmLogin = document.loginForm;
		let userId = frmLogin.userId.value;
		let userPwd = frmLogin.userPwd.value;
		
		console.log(userId, userPwd);
		
		// 아이디, 비밀번호가 필수 값
		if(userId.length == 0 || userPwd.length == 0) {
			alert("아이디와 비밀번호는 필수 입니다");
		} else {
			// 유효성 검사에 통과 했다면...
			frmLogin.method = "POST"; // 전송방식 지정
			frmLogin.action = "login.do"; // 전송될 서블릿 지정(mapping 주소)
			frmLogin.submit();
		}
	}
	*/
</script>
</head>
<body>
	<h1>자바스크립트에서 서블릿 호출하는 방법 중 하나</h1>
	<form enctype="UTF-8" name="loginForm" method="POST" action="login.do">
		아이디 : <input type="text" name="userId" /> <br />
		비밀번호 : <input type="password" name="userPwd"  /><br />
		<!-- <button type="submit" onclick="checkValidate();">로그인</button> -->
		<button type="submit" >로그인</button>
	</form>
</body>
</html>