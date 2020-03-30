package com.board.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String file = request.getParameter("file");
		
		NoticeBoard nb = new NoticeBoard(notice_id, title, content, file);
		
		if(title == null || title.equals("") || content == null || content.equals("")) {
			response.sendRedirect("list");
		} else {
			NoticeService ns = new NoticeService();
			ns.update(nb);
			response.sendRedirect("list");
		}
	}

}
