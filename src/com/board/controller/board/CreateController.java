package com.board.controller.board;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.board.model.dao.NoticeBoard;
import com.board.service.NoticeService;


@MultipartConfig(
		fileSizeThreshold = 1024 * 1024, // 1MB가 넘어가면 메모리가 아닌 디스크를 쓰자
		maxFileSize = 1024 * 1024 * 5, //하나의 파일 사이즈
		maxRequestSize = 1024 * 1024 * 5 * 5 //전체 요청의 사이즈 25MB
)
@WebServlet("/notice/create")
public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/board/create.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String author = "Admin";
		String content = request.getParameter("content");
		Part filePart = request.getPart("file");
		Date date = new Date();
		Integer view = 0;
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
				
				uid_file = uid + "_" + fileName;
				
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
			
			
			NoticeService ns = new NoticeService();
			NoticeBoard nb = new NoticeBoard(title, author, content, date, uid_file, view, fileName);
			ns.createNotice(nb);
			response.sendRedirect("list");
		}
	}

}
