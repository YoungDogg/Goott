<%@page import="org.apache.tomcat.dbcp.dbcp2.PStmtKey"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.DriverManager" %>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>서블릿 쓰는 이유</h1>
	<%
	int a = 10;
	if (a > 5) {
	%>	
	<%=a %><h2>크다</h2>
	<%
	} else {
	%>
	<h2>작다</h2>
	<%
	}
	%>
	
	<h2>index.jsp 에서 GET 방식으로 받아오기</h2>
	<%
		String userId = request.getParameter("user_id");
		String userPwd = request.getParameter("user_pwd");
		
		final String id = "hr";
		final String pwd = "oracle";
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection connection = null;		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection(url, id, pwd);
		PreparedStatement psmt = null;
		      
		      if (connection != null) {
		    	  %>
		    	  <h4>연결 성공</h4>
		    	  <%
		    	  String query = "select * from member where userId = ? and password = ?";
		    	  psmt = connection.prepareStatement(query);
		    	  psmt.setString(1, userId);
		    	  psmt.setString(2, userPwd);
		    	  
		    	  ResultSet rs = psmt.executeQuery();
		    	  while(rs.next()){
		    		  %><script>
		    		  		
		    		  </script>
		    		  <% 
		    	  }
		      }
	%>
	<div> ID : <%= userId %></div>
	<div> PWD : <%= userPwd %></div>
</body>
</html>