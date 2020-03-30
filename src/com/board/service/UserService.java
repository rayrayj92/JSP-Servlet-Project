package com.board.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.board.model.dao.User;
import com.board.model.dao.UserDAO;

public class UserService {
	private EntityManagerFactory emf;
	private EntityManager em;
	private UserDAO userDAO;
	
	public UserService() {
		emf = Persistence.createEntityManagerFactory("Board");
		em = emf.createEntityManager();
		userDAO = new UserDAO(em);
	}
	
	public void register(User user) {
		userDAO.register(user);
	}
	
	public User login(String email) {
		User info = userDAO.login(email);
		return info;
	}
}
