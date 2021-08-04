package com.goot6.jspbasic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

	@Override
	public void init() throws ServletException { // 서블릿이 실행될 때 자동으로 호출
		// TODO Auto-generated method stub
		System.out.println("init 메서드 호출");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 클라이언트가 현재 서블릿 페이지를 GET방식으로 호출 했을 때 호출되는 메서드
		System.out.println("doGet 메서드 호출...");
	}

	@Override
	public void destroy() { // 서블릿 객체가 소멸될 때 자동으로 호출
		// TODO Auto-generated method stub
		System.out.println("destroy메서드 호출...");
	}

	

}
