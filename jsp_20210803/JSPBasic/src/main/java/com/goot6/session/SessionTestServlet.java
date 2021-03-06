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
		
		HttpSession ses = request.getSession();  // 세션 객체 생성
		out.println("세션 아이디 : " + ses.getId() + "<br />"); // 세션 아이디 출력
		out.println("세션 생성 시간 : " + new Date(ses.getCreationTime()) + "<br />");
		out.println("세션 유효시간 : " + ses.getMaxInactiveInterval() + "<br />");
		
		if (ses.isNew()) {
			out.println("세션이 새로 만들어졌다!");
		} else {
			out.println("기존 세션을 이용 중이다");
		}
		
		ses.invalidate(); // 세션 만료 -> 로그 아웃 시에 사용한다.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
