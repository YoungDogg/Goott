package myOwnStudy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register.do")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");     
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int num = 0;
		String num_ = request.getParameter("num");
		if(num_ != null && !num_.equals(""))
			num = Integer.parseInt(num_);
		
		String result = "";
		
		if(num % 2 != 0) result = "È¦¼ö";
		else result = "Â¦¼ö";
		
		String[] names = {"name1", "name2"};
		Map<String, Object> notice = new HashMap<String, Object>();
		notice.put("id", 1);
		notice.put("title", "title Something");
		
		request.setAttribute("result", result);
		request.setAttribute("names", names);
		request.setAttribute("notice", notice);
		
		//forward
		RequestDispatcher dispatcher = request.getRequestDispatcher("/spag.jsp");
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response)
		String userId = request.getParameter("userId");
		String userpwd = request.getParameter("userPwd");

		// Ãâ·Â
		// mine-type : text/html, text/plain, application/xml, application/json
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<div>¾ÆÀÌµð : " + userId + "</div>");
		writer.println("<div>userPwd : " + userpwd + "</div>");

		writer.flush();
		writer.close();
	}

}
