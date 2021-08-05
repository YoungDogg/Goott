package com.goot6.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

/**
 * Servlet implementation class SessionTestServlet
 */
@WebServlet("/sestest.do")
public class SessionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out =	response.getWriter();
		
		HttpSession ses = request.getSession();  // ���� ��ü ����
		out.println("���� ���̵� : " + ses.getId() + "<br />"); // ���� ���̵� ���
		out.println("���� ���� �ð� : " + new Date(ses.getCreationTime()) + "<br />");
		out.println("���� ��ȿ�ð� : " + ses.getMaxInactiveInterval() + "<br />");
		
		if (ses.isNew()) {
			out.println("������ ���� ���������!");
		} else {
			out.println("���� ������ �̿� ���̴�");
		}
		
		ses.invalidate(); // ���� ���� -> �α� �ƿ� �ÿ� ����Ѵ�.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}