package com.dss.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dss.bean.Product;

public class Test {

	public static void main(String[] args) {
	
		Configuration cfg = new Configuration().configure();
		@SuppressWarnings("deprecation")
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
	/*Example of Update*/
		/*Query q = s.createQuery("update Product as p set p.pcost= p.pcost+? where p.pcost >= :cost");
		q.setParameter(0, 1000);
		q.setInteger("cost", 100);*/
		
	/*Example of Delete*/
		Query q = s.createQuery("delete Product1 where pid >= '11' and pid <= '13'");
	/*Example of Insert*/
		/*Query q = s.createQuery("insert into Product1(pid,pname,pcost) select p.pname,p.pid,p.pcost from Product p");
		*/
		Transaction tx = s.beginTransaction();
		int rowCount = q.executeUpdate();
		tx.commit();
		System.out.println(rowCount);
	}
}
