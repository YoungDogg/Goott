package com.goot6.jspbasic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

	@Override
	public void init() throws ServletException { // ������ ����� �� �ڵ����� ȣ��
		// TODO Auto-generated method stub
		System.out.println("init �޼��� ȣ��");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Ŭ���̾�Ʈ�� ���� ���� �������� GET������� ȣ�� ���� �� ȣ��Ǵ� �޼���
		System.out.println("doGet �޼��� ȣ��...");
	}

	@Override
	public void destroy() { // ���� ��ü�� �Ҹ�� �� �ڵ����� ȣ��
		// TODO Auto-generated method stub
		System.out.println("destroy�޼��� ȣ��...");
	}

	

}
