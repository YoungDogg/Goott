package com.goot.jspbasic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.do")
public class LoginProcessServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		System.out.println("GET 호출");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		System.out.println("POST 호출");
		
		//request encoding 
		req.setCharacterEncoding("UTF-8");

		
		
//		Enumeration<String> enu = req.getParameterNames();
//		while(enu.hasMoreElements()) { //요소 있다? 반복
//			String paraName = enu.nextElement();
//			String[] values = req.getParameterValues(paraName);
////			System.out.println(Arrays.toString(values));
//			for (String string : values) {
//				System.out.println(paraName + " : " + string + " ");
//			}
//		}
		
		
		String userId = req.getParameter("userId");
		String userPwd = req.getParameter("userPwd");
		
		String hobbies = "";
		String[] hobbiesArr = req.getParameterValues("hobby");
		for (String h : hobbiesArr) {
			hobbies += h + " ";
		}
		String genre = req.getParameter("genre");
		System.out.println(genre);
		String livingArea = req.getParameter("livingArea");
		System.out.println(livingArea);

		//출력
		//mine-type : text/html, text/plain, application/xml, application/json
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.println("<div>아이디 : " + userId + "</div>");
		writer.println("<div>userPwd : " + userPwd + "</div>");
		writer.println("<div>genre : " + genre + "</div>");
		writer.println("<div>hobbies : " + hobbies + "</div>");
		
		writer.flush();
		writer.close();
		
//		String id = "hr";
//		String pwd = "oracle";
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//
//		Connection con =  null;
//	      PreparedStatement pstmt = null;
//	      try {
//	         Class.forName("oracle.jdbc.driver.OracleDriver");
//	      } catch (ClassNotFoundException e) {
//	         // TODO Auto-generated catch block
//	         e.printStackTrace();
//	      }
//	      try {
//	         con = DriverManager.getConnection(url, id, pwd);
//	      } catch (SQLException e) {
//	         // TODO Auto-generated catch block
//	         e.printStackTrace();
//	      }
//
//	      if (con != null) {
//	    
//	          String query = "select * from member where userid=? and password=?";
//	          try {
//	             pstmt = con.prepareStatement(query);
//	             pstmt.setString(1, userId);
//	             pstmt.setString(2, userPwd);
//	             
//	             ResultSet rs = pstmt.executeQuery();
////	             System.out.println(rs.next());
//	             while(rs.next()) {
//	           	 
//	                resp.setContentType("text/html"); // response할 타입 설정
//	                resp.setCharacterEncoding("utf-8"); // response할 인코딩 설정
//	                PrintWriter writer = null;
//	                writer = resp.getWriter(); // response 객체의 writer 객체를 얻어옴
//	                writer.println("<script>");
//	                writer.println("alert('로그인 성공');");
//	                writer.println("</script>");
//	                writer.flush(); // response 버퍼 비움 (response 객체가 가리키는 곳에 출력)
//	                writer.close(); // writer 객체 닫음
//	             }
//	          } catch (SQLException e) {
//	             // TODO Auto-generated catch block
//	             e.printStackTrace();
//	          }
	          
//	       }

	}
	
}
