<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${requestScope.successUpload.userId != null}">
		<h2>fileUploadSuccess.jsp</h2>
	아이디 : ${requestScope.successUpload.userId}
	<br> 닉네임 : ${requestScope.successUpload.nickName}
	<br>
	이미지 : <img alt="" src="${requestScope.successUpload.imgName}">
		
	</c:if>
</body>
</html>