package com.dss.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dss.bean.Customer;
import com.dss.bean.Employee;

public class Test {

	public static void main(String[] args) {
	
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		
		Employee e = new Employee();
		e.setPname("E1");
		e.setPaddr("CHD");
		e.setEid("E111");
		e.setEsal("10000");

		Customer c = new Customer();
		c.setPname("C1");
		c.setPaddr("HYD");
		c.setCid("C111");
		c.setCmobile("040234567");
		
		Transaction tx = s.beginTransaction();
		s.save(e);
		s.save(c);
		tx.commit();
	}

}
