package com.dss.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dss.bean.Student;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	
	static Configuration configuration;
	static SessionFactory sessionFactory;
	static Session session;
	
	static{
		configuration = new Configuration();
		configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/honey");
		configuration.setProperty("hibernate.connection.user", "root");
		configuration.setProperty("hibernate.connection.password", "root");
		configuration.setProperty("hibernate.connection.pool_size", "100");
		configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		configuration.setProperty("hibernate.show_sql", "true");
		configuration.addAnnotatedClass(Student.class);		
		
		sessionFactory = configuration.buildSessionFactory();
	}
	
	public static Session getSession(){
		return sessionFactory.openSession();
	}
}
