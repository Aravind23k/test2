package com.accenture.sts.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;

import com.accenture.sts.controller.UploadController;
import com.accenture.sts.entity.Upload_ticket;
import com.accenture.sts.exception.STSGenericException;

public class UploadDAOImpl implements UploadDAO {
	private static Logger log = Logger.getLogger(UploadController.class);
	private SessionFactory sessionFactory;

	@SuppressWarnings("deprecation")
	@Override
	public void saveorUpdate(Object entity) throws STSGenericException {

		log.info("Entering saveorUpdate DAO");
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Upload_ticket upload_ticket = (Upload_ticket) entity;
		session.save(upload_ticket);
		session.getTransaction().commit();
		
	}
	@Override
	public void showdate(Object entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void showcreate(Object entity) {
		// TODO Auto-generated method stub
		
	}

}
