package com.board.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class NoticeDAO {
	protected EntityManager entityManager;
	
	public NoticeDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<NoticeBoard> getListAll() {
		Query query = entityManager.createNamedQuery("notice_board.showAll");
		return query.getResultList();
	}
	
	public void create(NoticeBoard entity) {
		entityManager.getTransaction().begin();
		
		entityManager.persist(entity);
		
		entityManager.getTransaction().commit();
	}
	
	// Detail, Edit
	public NoticeBoard getSingleDetail(int id, String sql) {
		
		Query query = entityManager.createNamedQuery(sql);    
        query.setParameter("id", id);
		
		return (NoticeBoard) query.getSingleResult();
	}
	
	public void update(NoticeBoard nb, String sql) {
		entityManager.getTransaction().begin();
		
		Query query = entityManager.createNamedQuery(sql);    
        query.setParameter("title", nb.getTitle());
        query.setParameter("content", nb.getContent());
        query.setParameter("file", nb.getFile());
        query.setParameter("id", nb.getId());
        
		query.executeUpdate();
		entityManager.getTransaction().commit();
	}
	
	public void updateView(int id, String sql) {
		entityManager.getTransaction().begin();
		
		Query query = entityManager.createNamedQuery(sql);    
        query.setParameter("id", id);
        
		query.executeUpdate();
		entityManager.getTransaction().commit();
	}
	
	public void delete(String id) {
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("delete from NoticeBoard where id in ("+ id +")");
		query.executeUpdate();
		entityManager.getTransaction().commit();
	}
}
