package com.webshin.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
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

import com.webshin.dao.DBProcess;
import com.webshin.dao.DBProcessImpl;
import com.webshin.vo.Imgs;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
//		싱글톤 연습
//		for(int i = 0; i < 5; i++) {
//			System.out.println(DBProcessImpl.getDao().hashCode());
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		String uploadPath = "\\uploads"; // 파일 업로드 될 디렉토리 지정
		String encoding = "utf-8";

		ServletContext context = request.getServletContext(); // 현재 request가 들어온 곳의 context객체 생성
		String realPath = context.getRealPath(uploadPath); // uploads폴더의 물리적 경로(서버상)

		System.out.println("실제저장령로" + realPath);

		File curDirPath = new File(realPath); // 파일이 실제 저장될 경로를 파일 객체로 생성

		// 파일업로드시 다른 데이터를 request.getParameter() 쓰지 않아야 함.
		String userId = null;
		String nickName = null;

		// 파일이 저장될 공간의 경로, 사이즈 등의 정보를 가지고 있는 객체
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(curDirPath);

		// 실제로 업로드할 객체
		ServletFileUpload sfu = new ServletFileUpload(factory);

		try {
			List<FileItem> items = sfu.parseRequest(request);
			// request 객체에서 파라미터를 가져온다, 파일은 .tmp로 저장됨
//			System.out.println(items);

			for (FileItem item : items) {
//				System.out.println(fileItem.getName());
				if (item.isFormField()) { // 파일이 아닌 매개변수
					System.out.println("파일이 아닌 매개변수 : " + item.getFieldName() + " - " + item.getString());

					if (item.getFieldName().equals("userId")) {
						userId = item.getString(encoding);
					} else if (item.getFieldName().equals("nickname")) {
						nickName = item.getString(encoding);
					}
//					System.out.println("userId : " + userId);
//					System.out.println("nickname : " + nickName);

				} else { // 파일 매개변수
					String newFileName = "";
					long tmpFileSize = item.getSize();
					String tmpFileName = item.getName();
//					System.out.println("tmpFileName : " + tmpFileName);

					if (tmpFileSize > 0) { // 실제 파일이 업로드 됐다면
						// tmpFileName 저장될 폴더에 중복파일 있나?
						// 중복이라면
						// 1) 파일명(번호).확장자 이렇게 만들자
						int cnt = 0;
						while (duplicateFileName(tmpFileName, realPath)) {
							tmpFileName = makeNewFileNameWithNumber(tmpFileName, cnt);
							cnt++;
						}
						System.out.println("newFileName : " + tmpFileName);
						newFileName = tmpFileName;
						// 2) 전혀 다른 이름으로 저장
//						String newFileName = makeNewFileName(tmpFileName, userId);
						// 실제저장
						// 마지막 디렉토리 구분자를 찾는다(windows, linux)
						// --> File.separator 이걸로 대체
//						int pos = tmpFileName.lastIndexOf("\\"); // windows
//						if(pos == -1) { 
//							pos = tmpFileName.lastIndexOf("/");// linux
//						}
//						
//						tmpFileName = tmpFileName.substring(pos + 1);
						File upFile = new File(curDirPath + File.separator + newFileName);
						System.out.println("upFile : " + upFile);
						String base64;
						try {
							item.write(upFile); // 실제 disk에 저장

							base64 = encodingImageToBase64(upFile);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							System.out.println("파일저장 실패");
							out.println("<script>");
							out.println("alert('파일 업로드 실패');");
							out.println("history.back();");
							out.println("</script>");
							e.printStackTrace();
						}

						newFileName = "uploads/" + newFileName;

						//base64로 바뀐 문자열을 이미지로 디코딩
						decodingImageWithBase64(base64);
						
						DBProcess dao = DBProcessImpl.getDao();
						Imgs imgs = new Imgs(newFileName, userId, nickName);
						try {
							if (dao.insertImgs(imgs)) {
								// 저장이 잘 됐을 때
								request.setCharacterEncoding("utf-8");
								response.setContentType("text/html; charset=utf-8");
								request.setAttribute("successUpload", imgs);
								RequestDispatcher rd = request.getRequestDispatcher("fileUploadSuccess.jsp");
								rd.forward(request, response);
							}
						} catch (NamingException | SQLException e) {
							// TODO Auto-generated catch block
							// 업로드 폴더의 업로드된 파일을 삭제해야 함.
							if (upFile.delete()) {
								out.println("<script>");
								out.println("alert('DB저장 실패');");
								out.println("history.back();");
								out.println("</script>");
								e.printStackTrace();
							}
						}
					}
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			out.println("<script>");
			out.println("alert('파일 업로드 실패');");
			out.println("history.back();");
			out.println("</script>");
			e.printStackTrace();
		}
	}

	private void decodingImageWithBase64(String base64) {
		// TODO Auto-generated method stub
		
	}

	private String encodingImageToBase64(File upFile) {
		// TODO Auto-generated method stub
		String imgBase64 = null;
		byte[] imageData = new byte[(int) upFile.length()]; // 파일의 크기만한 배열 생성

		try (FileInputStream fis = new FileInputStream(upFile)) {
			// 파일 읽기
			fis.read(imageData);

			Encoder encoder = Base64.getEncoder();
			imgBase64 = encoder.encodeToString(imageData);
		} catch (IOException e) {
			System.out.println("인코딩 에러!");
			// TODO: handle exception
		}
		System.out.println("imgBase64 : " + imgBase64);
		
		return imgBase64;
	}

	// tmpFIleNamme이 realPath 디렉토리에 존재하는지
	private boolean duplicateFileName(String tmpFileName, String realPath) {
		// TODO Auto-generated method stub
		boolean result = false;
		File realPathFile = new File(realPath);

		File[] files = realPathFile.listFiles();
		for (File tmp : files) {
			if (tmp.getName().equals(tmpFileName)) {
				result = true;
				break;
			}
		}
		return result;
	}

	private String makeNewFileNameWithNumber(String tmpFileName, int cnt) {
		// TODO Auto-generated method stub
		// 확장자 분리, 저장
		String ext = tmpFileName.substring(tmpFileName.lastIndexOf(".") + 1);
		String fileNameWithoutExt = tmpFileName.substring(0, tmpFileName.lastIndexOf("."));
		String newFileName = "";
//		System.out.println(ext + ", " + fileNameWithoutExt);

		int openPos = fileNameWithoutExt.indexOf("(");
		if (openPos == -1) { // 괄호가 없는 파일이름이 있다면
			newFileName = fileNameWithoutExt + "(" + cnt + ")" + "." + ext;
		} else { // 괄호가 있다면
			newFileName = fileNameWithoutExt.substring(0, openPos) + "(" + cnt + ")." + ext;
		}
//		System.out.println("newFileName: " + newFileName);
		return newFileName;
	}

	private String makeNewFileName(String tmpFileName, String userId) {
		// TODO Auto-generated method stub
		// 확장자 분리, 저장
		String ext = tmpFileName.substring(tmpFileName.lastIndexOf(".") + 1);
		// 1) 시간 이용해서 이름만들기
//		String newFileNameWithoutExt = userId + "_" + System.currentTimeMillis();

		// 2) UUID이용해서 파일이름 만들기
		String newFileNam = userId + "_" + UUID.randomUUID().toString() + "." + ext;
		System.out.println("newFileNam : " + newFileNam);
		return newFileNam;
	}

}
