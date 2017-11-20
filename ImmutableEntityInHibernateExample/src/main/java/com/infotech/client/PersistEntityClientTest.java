package com.infotech.client;

import java.util.Date;

import org.hibernate.Session;

import com.infotech.entities.Event;
import com.infotech.util.HibernateUtil;

public class PersistEntityClientTest {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			//createEvents(session);
			updateEvent(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void updateEvent(Session session) {
		long eventId =2L;
		
		Event event = session.get(Event.class, eventId);
		if(event != null){
			session.beginTransaction();
			event.setMessage("Updated Event again");
			session.update(event);
			session.getTransaction().commit();
		}else{
			System.out.println("Event not found with ID:"+eventId);
		}
	}

	private static void createEvents(Session session) {
		Event event1 = new Event();
		event1.setCreatedOn(new Date());
		event1.setMessage("Event 1");
		
		Event event2 = new Event();
		event2.setCreatedOn(new Date());
		event2.setMessage("Event 2");
		
		session.beginTransaction();
		session.save(event1);
		session.save(event2);
		
		session.getTransaction().commit();
	}
}