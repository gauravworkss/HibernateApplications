package com.dss.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dss.bean.Account;
import com.dss.bean.Address;
import com.dss.bean.Employee;

public class Test {

	public static void main(String[] args) {
		
		@SuppressWarnings("deprecation")
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		Address addr = new Address();
		addr.setPno("P1");
		addr.setStreet("MG Road");
		addr.setCity("HYD");
		
		Account acc =	new Account();
		acc.setAccNo("123456");
		acc.setAccName("abc");
		acc.setAccType("Saving");
		
		Employee e = new Employee();
		e.setEid("100");
		e.setEname("Gaurav");
		e.setAddr(addr);
		e.setAccnt(acc);
		
		Transaction tx = s.beginTransaction();
		s.save(e);
		tx.commit();
		System.out.println("Employee Inserted Successsfully");
		s.close();

	}

}
