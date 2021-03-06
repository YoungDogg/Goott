package com.goot6.jspbasic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goot6.jspbasicvo.Point;

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
		String data = "배고파요!";
		
		
		Point p = new Point(100, 100);
		
		// Point 객ㅊㅔ p2(200, 200) 를 만들어서 both.do로 포워드 하시고, both.do에서 p2객체를 출력
		
		request.setAttribute("point", p);  // Point 객체 p를 "point" 라는 이름으로 바인딩
		request.setAttribute("data", data); // 데이터 바인딩(binding)
		RequestDispatcher dispatcher = request.getRequestDispatcher("receive.do?data=rice"); // 데이터를 이동 시킬 서블릿 매핑 주소
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
