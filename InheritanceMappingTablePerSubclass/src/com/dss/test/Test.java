package com.dss.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dss.bean.Accountant;
import com.dss.bean.Manager;

public class Test {

	public static void main(String[] args) {
	
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		
		Manager m = new Manager();
		m.setEid("M1");
		m.setEname("ABC");
		m.setEmail("mm@gmail.com");
		m.setAddr("MHYD");

		Accountant a = new Accountant();
		a.setEid("A1");
		a.setEname("abc");
		a.setEsal("10000");
		a.setEqual("MCA");
		
		Transaction tx = s.beginTransaction();
		s.save(m);
		s.save(a);
		tx.commit();
	}

}
