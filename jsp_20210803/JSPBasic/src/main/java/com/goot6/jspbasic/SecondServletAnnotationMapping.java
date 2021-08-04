package com.goot6.jspbasic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second.do")
public class SecondServletAnnotationMapping extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); // request ��ü�� ���ڵ� ����
		String name = req.getParameter("name"); // request��ü�� ���� name �Ķ���ͷ� �Ѱ��� ���� ���� name������ ����
		
		
		resp.setContentType("text/html"); // response�� Ÿ�� ����
		resp.setCharacterEncoding("utf-8"); // response�� ���ڵ� ����
		PrintWriter writer = null;
		writer = resp.getWriter(); // response ��ü�� writer ��ü�� ����
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title> �ȴ�?</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>�̷��� html�� ����� �����ؿ�~</h1>");
		writer.println("<h2>" + name + "�� �ȴ�? </h2>");
		
		writer.println("</body>");
		writer.println("</html>");
		
		writer.flush(); // response ���� ��� (response ��ü�� ����Ű�� ���� ���)
		writer.close(); // writer ��ü ����
	}

}
