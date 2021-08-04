<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>안녕하세요, JSP</h1>
	
	<%
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
	%>
	
	<%
		String id = "hr";
		String pwd = "1234";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
	
		Connection con =  null;
		PreparedStatement pstmt = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(url, id, pwd);
		
		if (con != null) {
	%>
			<h4>연결 성공</h4>
	<%
			String query = "select * from member where userid=? and password=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
	%>
				<script>
					alert("로그인 성공");
					location.href = 'index.jsp';
				</script>
	<%
			}
			
	%>
			<script>
					alert("로그인 실패");
					history.back();
				</script>	
		
	<% 	
	
		}
	
	%>
	
	<div>당신이 입력한 아이디는 <%=userId %> 이고, 비밀번호는 <%=userPwd %> 입니다.</div>
</body>
</html>