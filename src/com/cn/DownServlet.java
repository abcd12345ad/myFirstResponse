package com.cn;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownServlet
 */
@WebServlet("/DownServlet")
public class DownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename=request.getParameter("filename");
		String realPath=request.getServletContext().getRealPath("/upload");
		System.out.println(realPath);
		File file=new File(realPath+"/"+filename);
		InputStream is=new FileInputStream(file);
		byte[] b=new byte[1024];
		ServletOutputStream sos=response.getOutputStream();
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		int a=is.read(b);
		while(a!=-1) {
			sos.write(b);
			sos.flush();
			a=is.read(b);
		}
		
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
