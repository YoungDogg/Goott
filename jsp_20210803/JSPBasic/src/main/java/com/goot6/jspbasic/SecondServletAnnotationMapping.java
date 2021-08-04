package com.goot6.jspbasic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second.do")
public class SecondServletAnnotationMapping extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); // request 객체의 인코딩 설정
		String name = req.getParameter("name"); // request객체를 통해 name 파라메터로 넘겨진 값을 얻어와 name변수에 저장
		
		
		resp.setContentType("text/html"); // response할 타입 설정
		resp.setCharacterEncoding("utf-8"); // response할 인코딩 설정
		PrintWriter writer = null;
		writer = resp.getWriter(); // response 객체의 writer 객체를 얻어옴
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title> 안뇽?</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>이렇게 html로 출력이 가능해요~</h1>");
		writer.println("<h2>" + name + "님 안뇽? </h2>");
		
		writer.println("</body>");
		writer.println("</html>");
		
		writer.flush(); // response 버퍼 비움 (response 객체가 가리키는 곳에 출력)
		writer.close(); // writer 객체 닫음
	}

}
