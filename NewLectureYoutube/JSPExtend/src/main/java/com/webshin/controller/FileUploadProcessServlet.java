package com.webshin.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUploadProcessServlet
 */
@WebServlet("/upload.do")
public class FileUploadProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadProcessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String uploadPath = "\\uploads"; //파일 업로드 될 디렉토리 지정
		String encoding = "utf-8";
		
		ServletContext context = request.getServletContext(); //현재 request가 들어온 곳의 context객체 생성
		String realPath = context.getRealPath(uploadPath);	//uploads폴더의 물리적 경로(서버상)
		
		System.out.println("실제저장령로" + realPath);
		
		File curDirPath = new File(realPath); //파일이 실제 저장될 경로를 파일 객체로 생성
		
		// 파일업로드시 다른 데이터를 request.getParameter() 쓰지 않아야 함.
		String userId = null;
		String nickName = null;
		
		//파일이 저장될 공간의 경로, 사이즈 등의 정보를 가지고 있는 객체 
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(curDirPath);
		
		// 실제로 업로드할 객체
		ServletFileUpload sfu = new ServletFileUpload(factory);
		
		try {
			List<FileItem> items = sfu.parseRequest(request);
			//request 객체에서 파라미터를 가져온다, 파일은 .tmp로 저장됨
//			System.out.println(items);
			
			for (FileItem item : items) {
//				System.out.println(fileItem.getName());
				if(item.isFormField()) { // 파일이 아닌 매개변수
					System.out.println("파일이 아닌 매개변수 : " + item.getFieldName() + " - " + item.getString());
					
					if(item.getFieldName().equals("userId")) {
						userId = item.getString(encoding);
					}else if(item.getFieldName().equals("nickname")){
						nickName = item.getString(encoding);
					}
					System.out.println("userId : " + userId);
					System.out.println("nickname : " + nickName);
					
				}else { // 파일 매개변수
					long tmpFileSize = item.getSize();
					String tmpFileName = item.getName();
					System.out.println(tmpFileName);
					
					if(tmpFileSize > 0) { //실제 파일이 업로드 됐다면
						// tmpFileName 저장될 폴더에 중복파일 있나?
						// 중복이라면
						//1) 파일명(번호).확장자 이렇게 만들자
						//2) 전혀 다른 이름으로 저장
						makeNewFileName(tmpFileName, userId);
					}
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void makeNewFileName(String tmpFileName, String userId) {
		// TODO Auto-generated method stub
		// 확장자 분리, 저장
		String ext = tmpFileName.substring(tmpFileName.lastIndexOf(".")+1);
		// 1) 시간 이용해서 이름만들기
//		String newFileNameWithoutExt = userId + "_" + System.currentTimeMillis();
		
		// 2) UUID이용해서 파일이름 만들기
		String newFileNam = userId + "_" + UUID.randomUUID().toString()+ "." + ext;
		System.out.println("newFileNam : " + newFileNam);
	}

}
