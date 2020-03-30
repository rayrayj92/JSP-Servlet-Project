package com.board.service;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.board.model.dao.NoticeBoard;
import com.board.model.dao.NoticeDAO;

public class NoticeService {
	private EntityManagerFactory emf;
	private EntityManager em;
	private NoticeDAO noticeDAO;
	
	public NoticeService() {
		emf = Persistence.createEntityManagerFactory("Board");
		em = emf.createEntityManager();
		noticeDAO = new NoticeDAO(em);
	}
	
	public List<NoticeBoard> listNotice() {
		List<NoticeBoard> result = noticeDAO.getListAll();
		return result;
	}
	
	public void createNotice(NoticeBoard nb){
		noticeDAO.create(nb);
	}
	
	public void update(NoticeBoard nb) {
		noticeDAO.update(nb, "notice_board.update");
	}
	
	public void updateView(int id) {
		noticeDAO.updateView(id, "notice_board.updateView");
	}
	
	public NoticeBoard getSingleDetail(int id) {
		
		NoticeBoard result = noticeDAO.getSingleDetail(id, "notice_board.detail");
		
		return result;
	}
	
	public void delete(String id) {
		noticeDAO.delete(id);
	}
}
