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
		String data = "����Ŀ�!";
		
		
		Point p = new Point(100, 100);
		
		// Point ������ p2(200, 200) �� ���� both.do�� ������ �Ͻð�, both.do���� p2��ü�� ���
		
		request.setAttribute("point", p);  // Point ��ü p�� "point" ��� �̸����� ���ε�
		request.setAttribute("data", data); // ������ ���ε�(binding)
		RequestDispatcher dispatcher = request.getRequestDispatcher("receive.do?data=rice"); // �����͸� �̵� ��ų ���� ���� �ּ�
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
