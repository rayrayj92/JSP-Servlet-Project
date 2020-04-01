package com.board.controller.board;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.board.model.dao.NoticeBoard;
import com.board.service.NoticeService;

/**
 * Servlet implementation class EditController
 */
@WebServlet("/notice/edit")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int notice_id = Integer.parseInt(request.getParameter("id"));
		
		//GET Detail
		NoticeService ns = new NoticeService();
		NoticeBoard notice = ns.getSingleDetail(notice_id);
		request.setAttribute("notice", notice);
		
		request.getRequestDispatcher("/WEB-INF/view/board/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int notice_id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Part filePart = request.getPart("file");
		String uid_file;
		String fileName;
		
		
		
		if(title == null || title.equals("") || content == null || content.equals("")) {
			response.sendRedirect("list");
		} else {
			
			if(filePart.getSubmittedFileName().equals("")) {
				uid_file = "";
				fileName = "";
			} else {
				fileName = filePart.getSubmittedFileName();
				InputStream fis = filePart.getInputStream();
				
				UUID uuid = UUID.randomUUID();
				String uid = uuid.toString();
				
				uid_file = uid +"_"+ fileName;
				
				String realPath = request.getServletContext().getRealPath("/upload"); // request = 입력
				String filePath = realPath + File.separator + uid_file;
				FileOutputStream fos = new FileOutputStream(filePath);
			
				byte[] buf = new byte[1024]; //1kb
				int size = 0;
				while((size = fis.read(buf)) != -1)
					fos.write(buf, 0, size); //0~size개의 바이트를 출력 스트림으로 보낸다. 해당 url에 저장.
				
				fos.close();
				fis.close();
			}
			NoticeBoard nb = new NoticeBoard(notice_id, title, content, uid_file, fileName);
			NoticeService ns = new NoticeService();
			ns.update(nb);
			response.sendRedirect("list");
		}
	}

}
