package com.dss.test;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dss.bean.Department;
import com.dss.bean.Employee;

public class Test {

	public static void main(String[] args) {
		
		@SuppressWarnings("deprecation")
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		
		Employee e1 = new Employee();
		e1.setEid("111");
		e1.setEname("AAA");
		
		Employee e2 = new Employee();
		e2.setEid("222");
		e2.setEname("BBB");
		
		Employee e3 = new Employee();
		e3.setEid("333");
		e3.setEname("CCC");
		
		Employee e4 = new Employee();
		e4.setEid("444");
		e4.setEname("DDD");
		
		
		HashSet<Employee> hs1 = new HashSet<Employee>();
		hs1.add(e1);
		hs1.add(e2);
		
		HashSet<Employee> hs2 = new HashSet<Employee>();
		hs2.add(e3);
		hs2.add(e4);
		
		Department d1 = new Department();
		d1.setDid("d1");
		d1.setDname("CS");
		d1.setEmp(hs1);
		
		Department d2 = new Department();
		d2.setDid("d2");
		d2.setDname("IT");
		d2.setEmp(hs2);
		Transaction tx = s.beginTransaction();
		s.save(d1);
		s.save(d2);
		tx.commit();
		s.close();
		
	}

}
