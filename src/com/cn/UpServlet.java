package com.cn;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UpServlet
 */
@WebServlet("/UpServlet")
public class UpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileItemFactory factory=new DiskFileItemFactory();
		
		ServletFileUpload upload=new ServletFileUpload(factory);
		//�趨�����ʽ
		upload.setHeaderEncoding("utf-8");
		//ָ�������ϴ��ļ������ߴ�,��λ:�ֽڣ�������Ϊ5Mb  
		upload.setSizeMax(5*1024*1024);
		// ָ��һ���ϴ�����ļ����ܳߴ�,��λ:�ֽڣ�������Ϊ100Mb
		upload.setFileSizeMax(100*1024*1024);
		
		try {
			List<FileItem> list=upload.parseRequest(request);
			for(int i=0;i<list.size();i++) {
				FileItem item=list.get(i);
				if(item.isFormField()) {
					System.out.println(item.getFieldName()+"----"+item.getString());
				}else {
					String fileName=item.getName();
					System.out.println("���յ��ļ���"+fileName);
					String realPath=request.getServletContext().getRealPath("/upload");
					String uuid=UUID.randomUUID().toString();
					String endname=fileName.substring(fileName.lastIndexOf('.'), fileName.length());
					File file=new File(realPath+"/"+uuid+endname);
					System.out.println("realPath"+realPath);
					request.setAttribute("filename", uuid+endname);
					File file2=new File(realPath);
					
//					if(file2.isDirectory()) {
//						String[] filelist=file2.list();
//						System.out.println(filelist.length);
//						request.setAttribute("filelist", filelist);
					//}
					try {
						item.write(file);
						if(file2.isDirectory()) {
							String[] filelist=file2.list();
							System.out.println(filelist.length);
							request.setAttribute("filelist", filelist);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("suc.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
