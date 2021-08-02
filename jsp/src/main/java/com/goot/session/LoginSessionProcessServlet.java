package com.goot.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.goot.jspbasicvo.MemberVo;

/**
 * Servlet implementation class LoginSessionProcessServlet
 */
@WebServlet({ "/LoginSessionProcessServlet", "/loginses.do" })
public class LoginSessionProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginSessionProcessServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");

		System.out.println(userId + " : " + userPwd);

		String id = "hr";
		String pwd = "oracle";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		MemberVo loginMember = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, id, pwd);
			
			if (con != null) {
				
				String query = "select * from member where userid = ? and password = ?";

				pstmt = con.prepareStatement(query);
				pstmt.setString(1, userId);
				pstmt.setString(2, userPwd);

				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					result = true;					
					loginMember = new MemberVo(rs.getString("USERID"), 
							rs.getString("PASSWORD"),
							rs.getString("USERNAME"), 
							rs.getString("GENDER"), 
							rs.getString("EMAIL"), 
							rs.getInt("POINT"), 
							rs.getDate("REGISTERDATE")
							);
				}

				rs.close();
				pstmt.close();
				con.close();
				
				HttpSession ses = request.getSession();
				
				if (result) {
					// 세션객체에 로긍인한 유저의 정보를 바인딩
					ses.setAttribute("loginUser", loginMember);
					
//					out.println("<script>");
//					out.println("alert('로그인성공');");
//					out.println("location.href='main.jsp');");
//					out.println("</script>");
					
//					세션에서 이미 바인딩 했다.
//					RequestDispatcher rd = request.getRequestDispatcher("main.jsp?login=success");
//					rd.forward(request, response);
					
					response.sendRedirect("main.jsp?login=success");
				}else {
//					out.println("<script>");
//					out.println("alert('로그인 실패');");
//					out.println("location.href='main.jsp');");
//					out.println("</script>");
					response.sendRedirect("main.jsp?login=fail");
				}
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sql 문제");
			e.printStackTrace();
		}

	}

}
