<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일 업로드</h1>
	<img alt="" src="uploads/pikachu.jpg">
	<form action="upload.do" method="post" enctype="multipart/form-data">
		아이디 : <input type="text" name="userId">
		닉네임 : <input type="text" name="nickname">
		파일 : <input type="file" name="upFile"> <input type="submit"
			value="업로드">
	</form>
</body>
</html>