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
		
		String uploadPath = "\\uploads"; //���� ���ε� �� ���丮 ����
		String encoding = "utf-8";
		
		ServletContext context = request.getServletContext(); //���� request�� ���� ���� context��ü ����
		String realPath = context.getRealPath(uploadPath);	//uploads������ ������ ���(������)
		
		System.out.println("��������ɷ�" + realPath);
		
		File curDirPath = new File(realPath); //������ ���� ����� ��θ� ���� ��ü�� ����
		
		// ���Ͼ��ε�� �ٸ� �����͸� request.getParameter() ���� �ʾƾ� ��.
		String userId = null;
		String nickName = null;
		
		//������ ����� ������ ���, ������ ���� ������ ������ �ִ� ��ü 
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(curDirPath);
		
		// ������ ���ε��� ��ü
		ServletFileUpload sfu = new ServletFileUpload(factory);
		
		try {
			List<FileItem> items = sfu.parseRequest(request);
			//request ��ü���� �Ķ���͸� �����´�, ������ .tmp�� �����
//			System.out.println(items);
			
			for (FileItem item : items) {
//				System.out.println(fileItem.getName());
				if(item.isFormField()) { // ������ �ƴ� �Ű�����
					System.out.println("������ �ƴ� �Ű����� : " + item.getFieldName() + " - " + item.getString());
					
					if(item.getFieldName().equals("userId")) {
						userId = item.getString(encoding);
					}else if(item.getFieldName().equals("nickname")){
						nickName = item.getString(encoding);
					}
					System.out.println("userId : " + userId);
					System.out.println("nickname : " + nickName);
					
				}else { // ���� �Ű�����
					long tmpFileSize = item.getSize();
					String tmpFileName = item.getName();
					System.out.println(tmpFileName);
					
					if(tmpFileSize > 0) { //���� ������ ���ε� �ƴٸ�
						// tmpFileName ����� ������ �ߺ����� �ֳ�?
						// �ߺ��̶��
						//1) ���ϸ�(��ȣ).Ȯ���� �̷��� ������
						//2) ���� �ٸ� �̸����� ����
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
		// Ȯ���� �и�, ����
		String ext = tmpFileName.substring(tmpFileName.lastIndexOf(".")+1);
		// 1) �ð� �̿��ؼ� �̸������
//		String newFileNameWithoutExt = userId + "_" + System.currentTimeMillis();
		
		// 2) UUID�̿��ؼ� �����̸� �����
		String newFileNam = userId + "_" + UUID.randomUUID().toString()+ "." + ext;
		System.out.println("newFileNam : " + newFileNam);
	}

}
