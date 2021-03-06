package com.goot6.jspbasic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.sql.ResultSet; 

@WebServlet("/login.do")
public class LoginProcessServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("text/html; charset=utf-8;");
//		
//		PrintWriter writer = resp.getWriter();
//		writer.println("<script>");
//		writer.println("alert('잘못된 접근입니다!');");
//		writer.println("location.href='index.jsp?result=fail'"); // javascript 로 페이지 이동
//		writer.println("</script>");
		
//		resp.sendRedirect("index.jsp?result=fail"); // servlet으로 페이지 이동
		
		resp.addHeader("refresh", "5;url=index.jsp?result=fail");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST방식으로 호출...");
		
		// -------------------  입력 양식 하나 하나 파라메터를 얻어오는 방식 -----------
		// request 인코딩 설정
		req.setCharacterEncoding("utf-8");
		// 1) response객체의 MIME-TYPE 설정
		resp.setContentType("text/html; charset=utf-8;");
		// 2) response 객체로부터 writer를 얻어온다.
		PrintWriter writer = resp.getWriter();
		
		String userId = req.getParameter("userId");
		String userPwd = req.getParameter("userPwd");
		
		// 만약 유효성 검사를 back-end 단에서 한다면...
		if (userId.length() == 0 || userPwd.length() == 0) {
			writer.println("<script>");
			writer.println("alert('아이디와 비밀번호는 필수 입니다.');");
//			writer.println("location.href='3_jsCallServlet.jsp';");
			writer.println("</script>");
		}
		
//		String[] hobbies = req.getParameterValues("hobby");
//		String outHobby = "";
//		for (int i = 0; i < hobbies.length; i++) {
//			System.out.println("선택한 취미 : " + hobbies[i]);
//			outHobby += hobbies[i] + ", ";
//		}
//		
//		
//		String genre = req.getParameter("genre");
//		System.out.println("좋아하는 영화 장르 : " + genre);
//		
//		
//		String area = req.getParameter("livingArea");
//		System.out.println("선택한 거주지 : " + area);
		
		
		// ---------------------------- 입력 양식 모두를 가져와 한꺼번에 처리하는 방식
		
//		Enumeration<String> enu = req.getParameterNames();
//		while(enu.hasMoreElements()) { // 요소가 있을 동안 반복
//			String paramName = enu.nextElement(); // 파라메터 이름
//			String[] values = req.getParameterValues(paramName);
//			for (String s : values) {
//				System.out.println("name=" + paramName + ", value=" + s);
//			}
//		}
		
		// 유저가 입력한 데이터를 HttpServletResponse 객체를 이용하여 웹 페이지 형식으로 출력
		
		writer.println("<div>아이디 : " + userId + "</div>");
		writer.println("<div>비밀번호 : " + userPwd + "</div>");
//		writer.println("<div>선택한 취미 : " + outHobby + "</div>");
//		writer.println("<div>좋아하는 영화 장르 : " + genre + "</div>");
//		writer.println("<div>선택한 거주지 : " + area + "</div>");
		
		writer.flush();
		writer.close();
		
	}
	
	
}
