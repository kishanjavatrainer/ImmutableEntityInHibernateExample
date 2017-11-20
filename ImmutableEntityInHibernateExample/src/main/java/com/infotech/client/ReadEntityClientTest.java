package com.infotech.client;

import org.hibernate.Session;

import com.infotech.util.HibernateUtil;

public class ReadEntityClientTest {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
