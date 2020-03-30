package com.board.controller.board;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.dao.NoticeBoard;
import com.board.service.NoticeService;

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
		String file = request.getParameter("file");
		Date date = new Date();
		Integer view = 0;
		
		if(title == null || title.equals("") || content == null || content.equals("")) {
			response.sendRedirect("list");
		} else {
			NoticeService ns = new NoticeService();
			NoticeBoard nb = new NoticeBoard(title, author, content, date, file, view);
			ns.createNotice(nb);
			response.sendRedirect("list");
		}
	}

}
