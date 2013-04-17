package com.dss.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dss.bean.Student;
import com.dss.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
	
		Student student = new Student();
		Session session= HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		student.setSid("321");
		student.setSname("Sham");
		student.setSmarks(85);
		session.save(student);
		tx.commit();
	}
}
