package com.board.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.dao.NoticeBoard;
import com.board.service.NoticeService;

@WebServlet("/notice/list")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession(false).getAttribute("admin").equals("Admin")) {
			NoticeService ns = new NoticeService();
			List<NoticeBoard> result = ns.listNotice();
			request.setAttribute("notice_result", result);
			request.getRequestDispatcher("/WEB-INF/view/board/index.jsp").forward(request, response);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService ns = new NoticeService();
		String[] delIds = request.getParameterValues("del-id");
		String btn = request.getParameter("delete");
		String result = "";
		
		for(int i = 0; i < delIds.length; i++) {
			result += delIds[i];
			if(i < delIds.length-1) {
				result += ",";
			}
		}
		
		if(btn.equals("Delete ALL")) {
			ns.delete(result);
		}
		response.sendRedirect("list");
	}

}
