package com.dss.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibarnateUtil {

	static Configuration cfg;
	static SessionFactory sf;
	static Session s;
	
	static{
		try {
			cfg = new Configuration().configure();
			sf  = cfg.buildSessionFactory(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Session  getSession() {
		s	=	sf.openSession();
		return s;
	}
}
