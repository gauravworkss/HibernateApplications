package com.dss.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dss.bean.Branch;
import com.dss.bean.Students;

public class Test {

	public static void main(String[] args) {

		@SuppressWarnings("deprecation")
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		
		Branch b1 = new Branch();
		b1.setBid("111");
		b1.setBname("CS");
		
		Students stu = new Students();
		stu.setSid("s1");
		stu.setSname("Honey");
		stu.setSbranch(b1);
		
		Transaction tx = s.beginTransaction();
		s.save(stu);
		tx.commit();
		s.close();
		
	}

}
