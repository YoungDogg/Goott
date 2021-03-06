<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.goot6.jspbasicvo.MemberVo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function getParameter(param) {
    let returnVal; // 리턴할 값을 저장할 변수
    let url = location.href.toLowerCase(); // url 주소 
    console.log(url);

    let queryString = url.slice(url.indexOf("?") + 1).split("&");
    console.log(queryString);

    for (let i in queryString) { // 배열의 맨 끝까지 param이 있는지 검색
        if(queryString[i].indexOf(param.toLowerCase()) != -1) { // queryString[i]번째에 param이 있다면
            returnVal = queryString[i].split("=")[1];
            return decodeURIComponent(returnVal);   // = 뒤의 찾은 값 반환
        }
    }

    return -1; // 찾는 매개변수가 쿼리스트링에 없다면 -1 반환
}

window.onload = function () {
	if (getParameter("login") === 'success') {
		alert('로그인 성공!');	
	}
}
</script>
</head>
<body>
	<h2>main.jsp</h2>
	
	<%
		MemberVo loginMember = (MemberVo)session.getAttribute("loginUser");
		if (loginMember != null) {
	%>
			<h4>
			<a href='userInfo.jsp'>
				${sessionScope.loginUser.userName } </a>
				
			포인트 : ${sessionScope.loginUser.point }점
			</h4>
			<form method="POST" action="logout.do">
				<input type="submit" value="로그아웃" />
			</form>
	<% 
		} else {  // 로그인 하지 않았다면...
			
			//out.println(session.getId());
			
	%> 
	
			<a href='login.jsp'>로그인</a>
	<%
		}
	%>
	
</body>
</html>