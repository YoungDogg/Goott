<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>

</head>
<body>
	<h1>index.jsp는 웹 사이트의 시작페이지 역할(web.xml의 welcome-file-list에 의해)</h1>
	
	<form method="POST" action="login.do" enctype="UTF-8">
		아이디 : <input type="text" name="userId" /> <br />
		비밀번호 : <input type="password" name="userPwd"  /><br />
		
		취미 : <input type="checkbox" name="hobby" value="soccer" /> 축구
		<input type="checkbox" name="hobby"  value="volleyball"/> 배구
		<input type="checkbox" name="hobby"  value="basketball"/> 농구
		<input type="checkbox" name="hobby"  value="pingpong"/> 탁구 <br />
		
		좋아하는 장르 : <input type="radio" name="genre" value="horror" /> 호러
		<input type="radio" name="genre" value="drama" /> 드라마
		<input type="radio" name="genre" value="comic" /> 코믹
		<input type="radio" name="genre" value="sf" /> SF
		<br />
		거주지 : <select name="livingArea">
			<option value="club">클럽</option>
			<option value="pcroom">PC방</option>
			<option value="pub">술집</option>
			<option value="comicbook">만화방</option>
		</select>
		<br />
		<button type="submit" >로그인</button> <button type="reset">다시입력</button>
		
	</form>
</body>
</html>