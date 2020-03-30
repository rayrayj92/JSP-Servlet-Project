package com.board.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class UserDAO {
	protected EntityManager entityManager;

	public UserDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void register(User user) {
		entityManager.getTransaction().begin();
		
		entityManager.persist(user);
		
		entityManager.getTransaction().commit();
	}
	
	public User login(String email) {	
		Query query = entityManager.createNamedQuery("user.login");
		query.setParameter("email", email);
		try {
			User info = (User) query.getSingleResult();
			return info;
		} catch (NoResultException e) {
			e.printStackTrace(); // a user does not exist.
		}
		return null;
	}
}
