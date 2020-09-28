package com.ameykolhe.datetime.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ameykolhe.datetime.entities.DateTime;

public class DateTimeDAO {
	
	SessionFactory factory;
	
	
	
	public DateTimeDAO() {
		factory = new Configuration()
						.configure()
						.addAnnotatedClass(DateTime.class)
						.buildSessionFactory();
	}

	public void add(DateTime dateTime) {
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			session.save(dateTime);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public List<DateTime> getHisotry() {
		Session session = factory.getCurrentSession();
		
		List<DateTime> resultList = null;
		
		try {
			
			session.beginTransaction();
			resultList = session.createQuery("FROM DateTime ex ORDER BY ex.timeStamp").setMaxResults(100).getResultList();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}
	
}
