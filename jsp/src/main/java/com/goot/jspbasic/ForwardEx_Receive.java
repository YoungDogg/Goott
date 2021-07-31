package com.goot.jspbasic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goot.jspbasicvo.Point;

/**
 * Servlet implementation class ForwardEx_Receive
 */
@WebServlet("/receive.do")
public class ForwardEx_Receive extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardEx_Receive() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("receive.do 페이지");
		
		String data = (String)request.getAttribute("data");
		out.print("<h2> " + data +"</h2>");
		out.println(request.getParameter("data"));
//		response.getWriter().append("receive.do 페이지");
		
		Point p = (Point)request.getAttribute("point");
		out.println(p.getX());
		
		Point p2 = (Point)request.getAttribute("point2");
//		out.println(p.toString());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("both.do");
		dispatcher.forward(request, response);
//		response.sendRedirect("both.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
