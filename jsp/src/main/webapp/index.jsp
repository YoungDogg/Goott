<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<h1>index.jsp</h1>
	
	<form method=POST action="login.do" enctype="UTF-8">
		ID : <input type="text" name="userId"><br />
		PWD: <input type="password" name="userPwd"><br />
		취미: 
		<input type="checkbox" name="hobby" value="football">축구
		<input type="checkbox" name="hobby" value="volleyball">배구
		<input type="checkbox" name="hobby" value="pingpon">탁구
		<br>
		장르:
		<input type="radio" name="genre" value="hrror">horror
		<input type="radio" name="genre" value="comedy">comedy
		<input type="radio" name="genre" value="romance">romance
		<br>
		거주지:
		<select name="livingArea">
			<option value="club">club</option>
			<option value="pc">pc</option>
			<option value="pub">pub</option>
		</select>
		<button type="submit">로그인</button>
		<button type="reset">취소</button>
	</form>
</body>
</html>