package com.goot.jspbasic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goot.jspbasicvo.Point;

/**
 * Servlet implementation class GetPostBoth
 */
@WebServlet("/both.do")
public class GetPostBoth extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doBoth(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doBoth(request, response);
	}

	// GET,POST 둘 다 똑같이 실행시키는 함수
	private void doBoth(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.print("/both.do 페이지");
		String data = (String) request.getAttribute("data");
		out.print("<h2> " + data + "</h2>");
		
		Point point = (Point) request.getAttribute("point2");
		out.print("<h2> " + point.toString() + "</h2>");
//		out.println(request.getParameter("point"));
	}

}
