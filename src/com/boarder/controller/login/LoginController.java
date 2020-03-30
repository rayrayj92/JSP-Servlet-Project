package com.boarder.controller.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.model.dao.User;
import com.board.service.UserService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/login/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		try {
			
			UserService us = new UserService();
			User info = us.login(email);
			if(info != null) {
				String role = info.getRole();
				
				if(info.getPassword().equals(password)) {
					if(role.equals("admin")) {
						HttpSession session = request.getSession();  
				        session.setAttribute("admin", "Admin");
						response.sendRedirect("notice/list");
					} else {
						HttpSession session = request.getSession();
				        session.setAttribute("user", info);
						response.sendRedirect("user");
					}
				} else {
					//Invalid password. Try Again
				}
			} else {
				response.sendRedirect("register");
				// A user does not exist. Please register first.
			}
		} catch(NullPointerException e) {
			e.printStackTrace(); // A user does not exist.
			
		}
		
		
	}

}
