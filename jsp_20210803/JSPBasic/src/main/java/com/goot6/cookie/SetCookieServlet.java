package com.goot6.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/setcookie.do")
public class SetCookieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8;");
		PrintWriter out = resp.getWriter();
		
//		Date now = new Date(); // ��Ű�� �������� �����ϱ� ����
		
		Cookie c = new Cookie("cookTest", URLEncoder.encode("ȫ�浿", "utf-8"));
		c.setMaxAge(24 * 60 * 60); 
		
		resp.addCookie(c);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
