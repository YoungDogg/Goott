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
//		writer.println("alert('�߸��� �����Դϴ�!');");
//		writer.println("location.href='index.jsp?result=fail'"); // javascript �� ������ �̵�
//		writer.println("</script>");
		
//		resp.sendRedirect("index.jsp?result=fail"); // servlet���� ������ �̵�
		
		resp.addHeader("refresh", "5;url=index.jsp?result=fail");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST������� ȣ��...");
		
		// -------------------  �Է� ��� �ϳ� �ϳ� �Ķ���͸� ������ ��� -----------
		// request ���ڵ� ����
		req.setCharacterEncoding("utf-8");
		// 1) response��ü�� MIME-TYPE ����
		resp.setContentType("text/html; charset=utf-8;");
		// 2) response ��ü�κ��� writer�� ���´�.
		PrintWriter writer = resp.getWriter();
		
		String userId = req.getParameter("userId");
		String userPwd = req.getParameter("userPwd");
		
		// ���� ��ȿ�� �˻縦 back-end �ܿ��� �Ѵٸ�...
		if (userId.length() == 0 || userPwd.length() == 0) {
			writer.println("<script>");
			writer.println("alert('���̵�� ��й�ȣ�� �ʼ� �Դϴ�.');");
//			writer.println("location.href='3_jsCallServlet.jsp';");
			writer.println("</script>");
		}
		
//		String[] hobbies = req.getParameterValues("hobby");
//		String outHobby = "";
//		for (int i = 0; i < hobbies.length; i++) {
//			System.out.println("������ ��� : " + hobbies[i]);
//			outHobby += hobbies[i] + ", ";
//		}
//		
//		
//		String genre = req.getParameter("genre");
//		System.out.println("�����ϴ� ��ȭ �帣 : " + genre);
//		
//		
//		String area = req.getParameter("livingArea");
//		System.out.println("������ ������ : " + area);
		
		
		// ---------------------------- �Է� ��� ��θ� ������ �Ѳ����� ó���ϴ� ���
		
//		Enumeration<String> enu = req.getParameterNames();
//		while(enu.hasMoreElements()) { // ��Ұ� ���� ���� �ݺ�
//			String paramName = enu.nextElement(); // �Ķ���� �̸�
//			String[] values = req.getParameterValues(paramName);
//			for (String s : values) {
//				System.out.println("name=" + paramName + ", value=" + s);
//			}
//		}
		
		// ������ �Է��� �����͸� HttpServletResponse ��ü�� �̿��Ͽ� �� ������ �������� ���
		
		writer.println("<div>���̵� : " + userId + "</div>");
		writer.println("<div>��й�ȣ : " + userPwd + "</div>");
//		writer.println("<div>������ ��� : " + outHobby + "</div>");
//		writer.println("<div>�����ϴ� ��ȭ �帣 : " + genre + "</div>");
//		writer.println("<div>������ ������ : " + area + "</div>");
		
		writer.flush();
		writer.close();
		
	}
	
	
}