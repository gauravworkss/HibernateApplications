package com.dss.test;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dss.bean.Courses;
import com.dss.bean.Students;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		@SuppressWarnings("deprecation")
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		
		Courses c1 = new Courses();
		c1.setCid("C1");
		c1.setCname("English");
		
		Courses c2 = new Courses();
		c2.setCid("C2");
		c2.setCname("Hindi");
		
		HashSet<Courses> hs = new HashSet<Courses>();
		hs.add(c1);
		hs.add(c2);
		
		Students s1 = new Students();
		s1.setSid("S1");
		s1.setSname("Honey");
		s1.setCourse(hs);
		
		Students s2 = new Students();
		s2.setSid("S2");
		s2.setSname("Money");
		s2.setCourse(hs);
		
		Transaction tx = s.beginTransaction();
		s.save(s1);
		s.save(s2);
		tx.commit();
		
		

	}

}
