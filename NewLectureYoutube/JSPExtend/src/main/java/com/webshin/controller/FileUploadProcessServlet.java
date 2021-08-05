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
//		�̱��� ����
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

		String uploadPath = "\\uploads"; // ���� ���ε� �� ���丮 ����
		String encoding = "utf-8";

		ServletContext context = request.getServletContext(); // ���� request�� ���� ���� context��ü ����
		String realPath = context.getRealPath(uploadPath); // uploads������ ������ ���(������)

		System.out.println("��������ɷ�" + realPath);

		File curDirPath = new File(realPath); // ������ ���� ����� ��θ� ���� ��ü�� ����

		// ���Ͼ��ε�� �ٸ� �����͸� request.getParameter() ���� �ʾƾ� ��.
		String userId = null;
		String nickName = null;

		// ������ ����� ������ ���, ������ ���� ������ ������ �ִ� ��ü
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(curDirPath);

		// ������ ���ε��� ��ü
		ServletFileUpload sfu = new ServletFileUpload(factory);

		try {
			List<FileItem> items = sfu.parseRequest(request);
			// request ��ü���� �Ķ���͸� �����´�, ������ .tmp�� �����
//			System.out.println(items);

			for (FileItem item : items) {
//				System.out.println(fileItem.getName());
				if (item.isFormField()) { // ������ �ƴ� �Ű�����
					System.out.println("������ �ƴ� �Ű����� : " + item.getFieldName() + " - " + item.getString());

					if (item.getFieldName().equals("userId")) {
						userId = item.getString(encoding);
					} else if (item.getFieldName().equals("nickname")) {
						nickName = item.getString(encoding);
					}
//					System.out.println("userId : " + userId);
//					System.out.println("nickname : " + nickName);

				} else { // ���� �Ű�����
					String newFileName = "";
					long tmpFileSize = item.getSize();
					String tmpFileName = item.getName();
//					System.out.println("tmpFileName : " + tmpFileName);

					if (tmpFileSize > 0) { // ���� ������ ���ε� �ƴٸ�
						// tmpFileName ����� ������ �ߺ����� �ֳ�?
						// �ߺ��̶��
						// 1) ���ϸ�(��ȣ).Ȯ���� �̷��� ������
						int cnt = 0;
						while (duplicateFileName(tmpFileName, realPath)) {
							tmpFileName = makeNewFileNameWithNumber(tmpFileName, cnt);
							cnt++;
						}
						System.out.println("newFileName : " + tmpFileName);
						newFileName = tmpFileName;
						// 2) ���� �ٸ� �̸����� ����
//						String newFileName = makeNewFileName(tmpFileName, userId);
						// ��������
						// ������ ���丮 �����ڸ� ã�´�(windows, linux)
						// --> File.separator �̰ɷ� ��ü
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
							item.write(upFile); // ���� disk�� ����

							base64 = encodingImageToBase64(upFile);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							System.out.println("�������� ����");
							out.println("<script>");
							out.println("alert('���� ���ε� ����');");
							out.println("history.back();");
							out.println("</script>");
							e.printStackTrace();
						}

						newFileName = "uploads/" + newFileName;

						//base64�� �ٲ� ���ڿ��� �̹����� ���ڵ�
						decodingImageWithBase64(base64);
						
						DBProcess dao = DBProcessImpl.getDao();
						Imgs imgs = new Imgs(newFileName, userId, nickName);
						try {
							if (dao.insertImgs(imgs)) {
								// ������ �� ���� ��
								request.setCharacterEncoding("utf-8");
								response.setContentType("text/html; charset=utf-8");
								request.setAttribute("successUpload", imgs);
								RequestDispatcher rd = request.getRequestDispatcher("fileUploadSuccess.jsp");
								rd.forward(request, response);
							}
						} catch (NamingException | SQLException e) {
							// TODO Auto-generated catch block
							// ���ε� ������ ���ε�� ������ �����ؾ� ��.
							if (upFile.delete()) {
								out.println("<script>");
								out.println("alert('DB���� ����');");
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
			out.println("alert('���� ���ε� ����');");
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
		byte[] imageData = new byte[(int) upFile.length()]; // ������ ũ�⸸�� �迭 ����

		try (FileInputStream fis = new FileInputStream(upFile)) {
			// ���� �б�
			fis.read(imageData);

			Encoder encoder = Base64.getEncoder();
			imgBase64 = encoder.encodeToString(imageData);
		} catch (IOException e) {
			System.out.println("���ڵ� ����!");
			// TODO: handle exception
		}
		System.out.println("imgBase64 : " + imgBase64);
		
		return imgBase64;
	}

	// tmpFIleNamme�� realPath ���丮�� �����ϴ���
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
		// Ȯ���� �и�, ����
		String ext = tmpFileName.substring(tmpFileName.lastIndexOf(".") + 1);
		String fileNameWithoutExt = tmpFileName.substring(0, tmpFileName.lastIndexOf("."));
		String newFileName = "";
//		System.out.println(ext + ", " + fileNameWithoutExt);

		int openPos = fileNameWithoutExt.indexOf("(");
		if (openPos == -1) { // ��ȣ�� ���� �����̸��� �ִٸ�
			newFileName = fileNameWithoutExt + "(" + cnt + ")" + "." + ext;
		} else { // ��ȣ�� �ִٸ�
			newFileName = fileNameWithoutExt.substring(0, openPos) + "(" + cnt + ")." + ext;
		}
//		System.out.println("newFileName: " + newFileName);
		return newFileName;
	}

	private String makeNewFileName(String tmpFileName, String userId) {
		// TODO Auto-generated method stub
		// Ȯ���� �и�, ����
		String ext = tmpFileName.substring(tmpFileName.lastIndexOf(".") + 1);
		// 1) �ð� �̿��ؼ� �̸������
//		String newFileNameWithoutExt = userId + "_" + System.currentTimeMillis();

		// 2) UUID�̿��ؼ� �����̸� �����
		String newFileNam = userId + "_" + UUID.randomUUID().toString() + "." + ext;
		System.out.println("newFileNam : " + newFileNam);
		return newFileNam;
	}

}
