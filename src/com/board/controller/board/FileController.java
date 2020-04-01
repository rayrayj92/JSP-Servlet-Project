package com.board.controller.board;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileController
 */
@WebServlet("/notice/list/FileDown")
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("fileName");
		
		// 서버에 올라간 경로를 가져옴
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath("/upload");
		String filePath = uploadFilePath + File.separator + fileName;
		
		byte[] b = new byte[4096];
		FileInputStream fileInputStream = new FileInputStream(filePath);
		
		String mimeType = getServletContext().getMimeType(filePath);
		if(mimeType == null) {
			mimeType = "application/octet-stream";
		}
		response.setContentType(mimeType);
		
        // Kor
        String sEncoding = new String(fileName.getBytes("UTF-8"));
        response.setHeader("Content-Disposition", "attachment; fileName= " + sEncoding);
        
        // Output
        ServletOutputStream servletOutStream = response.getOutputStream();
        
        int read;
        while((read = fileInputStream.read(b,0,b.length))!= -1){
            servletOutStream.write(b,0,read);            
        }
        
        servletOutStream.flush();
        servletOutStream.close();
        fileInputStream.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
