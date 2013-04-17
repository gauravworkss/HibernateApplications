package com.dss.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dss.bean.Account;
import com.dss.bean.Emp_Acc_Property;
import com.dss.bean.Employee;

public class Test {

	public static void main(String[] args) {
	
		@SuppressWarnings("deprecation")
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		
		
		Account a = new Account();
		a.setAccNo("a1");
		a.setAccName("aaa");
		
		Employee  e = new Employee();
		e.setEid("e1");
		e.setEname("AAA");
		e.setAcc(a);
		
		Emp_Acc_Property emp_acc = new Emp_Acc_Property();
		emp_acc.setEid(e.getEid());
		emp_acc.setAccNo(a.getAccNo());
		
		Transaction tx = s.beginTransaction();
		s.save(e);
		s.save(emp_acc);
		tx.commit();
	}

}
