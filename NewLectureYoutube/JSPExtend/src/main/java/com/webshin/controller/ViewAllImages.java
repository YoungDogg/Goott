package com.webshin.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webshin.dao.DBProcessImpl;
import com.webshin.vo.Imgs;

/**
 * Servlet implementation class ViewAllImages
 */
@WebServlet("/viewAllImg.do")
public class ViewAllImages extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewAllImages() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("hi");
		
		try {
			List<Imgs> lst =  DBProcessImpl.getDao().selectAllImgs();
			//???ε?
			
			request.setAttribute("allImgs", lst);
			request.getRequestDispatcher("viewAllImages.jsp").forward(request, response);
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("commonError.jsp");			
		}
		
		
	}
}
