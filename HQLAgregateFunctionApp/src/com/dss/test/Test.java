package com.dss.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dss.bean.Product;

public class Test {

	public static void main(String[] args) {
	
		Configuration cfg = new Configuration().configure();
		@SuppressWarnings("deprecation")
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		/*Query q = s.createQuery("select count(p.pid) from Product as p");*/   /*Example of count() function*/
		/*Query q = s.createQuery("select sum(p.pcost) from Product as p");*/	/*Example of sum() function*/
		/*Query q = s.createQuery("select min(p.pcost) from Product as p");*/	/*Example of min() function*/
		/*Query q = s.createQuery("select max(p.pcost) from Product as p");*/		/*Example of max() function*/
		Query q = s.createQuery("select avg(p.pcost) from Product as p");		/*Example of avg() function*/
		
		List l = q.list();
		System.out.println(l.get(0)); /*Example of 'sum() function','min() function','max() function','avg() function'*/
		
		/*Example of count() function*/
		/*for (int i = 0; i < l.size(); i++) {
				System.out.println(l.get(i));
			}*/
		
	}

}
