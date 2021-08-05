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
	<h2>ViewAllImages.jsp</h2>
	<c:if test="${requestScope.allImgs != null}">
		<ul>
			<c:forEach var="img" items="${requestScope.allImgs}">
				<li>
					<span>${img.no }</span>
					<span>${img.userId }</span>
					<span>${img.nickName }</span>
					<span> <img alt="" src="${img.imgName}"> </span>		
				</li>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>