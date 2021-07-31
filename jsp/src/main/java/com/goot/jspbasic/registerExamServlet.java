package com.goot.jspbasic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/regi.do")
public class registerExamServlet extends HttpServlet{

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
		
		String userId = req.getParameter("userId");
		String userPwd = req.getParameter("userPwd");
		String userName = req.getParameter("userName");
		String gender = req.getParameter("gender");
		String birthDay = req.getParameter("birthDay");
		String email = req.getParameter("email");
		String registerPath = req.getParameter("registerPath");
	

		//출력
		//mine-type : text/html, text/plain, application/xml, application/json
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.println("<div>아이디 : " + userId + "</div>");
		writer.println("<div>userPwd : " + userPwd + "</div>");
		writer.println("<div>userName : " + userName + "</div>");
		writer.println("<div>gender : " + gender + "</div>");
		writer.println("<div>birthDay : " + birthDay + "</div>");
		writer.println("<div>email : " + email + "</div>");
		writer.println("<div>registerPath : " + registerPath + "</div>");
		
		writer.flush();
		writer.close();
		
	}
 
}
