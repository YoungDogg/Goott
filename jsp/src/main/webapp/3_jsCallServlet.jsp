<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바스크립트에서 서블릿 호출하는 방법 중 하나</title>
<script>
/*
	function checkValidate(){
		let frmLogin = document.loginForm;
		let userId = frmLogin.userId.value;
		let userPwd = frmLogin.userPwd.value;
		
		console.log(userId, userPwd);
		
		//아이디, 비밀번호 필수 값
		if(userId.length == 0 || userPwd.length == 0){
			alert('아이디, 비밀번호 넣어야 한다');
		}else{ //유효성 검사 통과했다면 
			frmLogin.method = "POST";
			frmLogin.action = "login.do";
			frmLogin.submit();
		}
	}
	*/
</script>
</head>
<body>
	<h1>자바스크립트에서 서블릿 호출하는 방법 중 하나</h1>
	<!-- <form enctype="UTF-8" name="loginForm"> -->
	<form method = "POST" action = "login.do" enctype="UTF-8" name="loginForm">
	
			ID : <input type="text" name="userId"><br />
			PWD: <input type="password" name="userPwd"><br />
			
			<!-- <button type="button" onclick="checkValidate();">로그인</button> -->
			<button type="submit">로그인</button>
			<button type="reset">취소</button>
	</form>
</body>
</html>