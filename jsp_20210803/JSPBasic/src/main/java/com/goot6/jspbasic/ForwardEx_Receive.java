package com.goot6.jspbasic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goot6.jspbasicvo.Point;

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
		response.setContentType("text/html;charset=utf-8");
//		response.setCharacterEncoding("UTF-8"); 
		
		PrintWriter out = response.getWriter();
		out.println("receive.do ������ ");
		
		String data = (String)request.getAttribute("data");
		out.println("<h2>" + data + "</h2>");
		out.println(request.getParameter("data"));
		
		Point p = (Point)request.getAttribute("point");
		out.println(p.toString());
		
		request.removeAttribute("point");  // "point"��� �̸����� ���ε��� ������ ����
		
//		response.sendRedirect("both.do");
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("both.do?data=rice"); // �����͸� �̵� ��ų ������ ���� �ּ�
//		dispatcher.forward(request, response);
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}