package com.goot.jspbasic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goot.jspbasicvo.Point;

/**
 * Servlet implementation class ForwardEx_Send
 */
@WebServlet("/send.do")
public class ForwardEx_Send extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardEx_Send() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String data = "스트링 데이터";
		
		Point p = new Point(100, 100);
		
		//Point 객체 p2(200, 200)만들고 both.do로 포워드, both.do에서 p2 객체 출력 
		Point p2 = new Point(200, 200);
		
		request.setAttribute("point2", p2);
		request.setAttribute("point", p);		
		request.setAttribute("data", data); //binding of data
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("receive.do?data=rice"); //데이터를 이동 시킬 서블릿 매핑 주소
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
