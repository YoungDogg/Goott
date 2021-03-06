package com.goot6.jspbasic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetPostBothServlet
 * 
 */
@WebServlet("/both.do")
public class GetPostBothServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doBoth(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doBoth(request, response);
	}
	
	// GET, POST방식 어떤 방식으로 이 서블릿을 호출해도 똑같은 코드가 실행 되어야 할 경우에는 이렇게 코딩하는것이 간결하다
	private void doBoth(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html;charset=utf-8");
//		response.setCharacterEncoding("UTF-8"); 
		
		PrintWriter out = response.getWriter();
		out.println("both.do 페이지 ");
		
		String data = (String)request.getAttribute("data");
		out.println("<h2>" + data + "</h2>");
		out.println(request.getParameter("data"));
	}

}
