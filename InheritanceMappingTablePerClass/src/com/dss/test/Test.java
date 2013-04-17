package com.dss.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dss.bean.EmployeeAccount;
import com.dss.bean.StudentAccount;

public class Test {

	public static void main(String[] args) {
	
		@SuppressWarnings("deprecation")
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		
		StudentAccount sa = new StudentAccount();
		sa.setAccNo("s112");
		sa.setAccName("STUDENT");
		sa.setSid("S2");
		sa.setSbranch("HYD");
		
		EmployeeAccount ea = new EmployeeAccount();
		ea.setEid("E2");
		ea.setEdept("Networking");
		ea.setAccName("Employee");
		ea.setAccNo("e112");
		
		Transaction tx = s.beginTransaction();
		s.save(sa);
		s.save(ea);
		tx.commit();

	}

}
