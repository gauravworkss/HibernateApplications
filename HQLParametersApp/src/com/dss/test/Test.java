package com.dss.test;

import java.util.Iterator;
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
		
	/*Example of Positional Parameter*/
		/*Query q = s.createQuery("from Product as p where p.pcost < ?");		
		q.setParameter(0, 500);   // Method To be used in Positional Parameter is setParameter(index,value)
		q.list();
		Iterator i = q.iterate();
		while (i.hasNext()) {
			Product p = (Product) i.next();
			//System.out.println(p[0]);
			System.out.println(p.getPid()+"-------"+p.getPname()+"-------"+p.getPcost());
		}*/
		
	/*Example of Named Parameter*/
		/*Query q = s.createQuery("from Product as p where p.pcost < :name");		
		q.setInteger("name", 500); 	// Method To be used in Namaed Parameter is setXXX(name,xxx)
		q.list();
		Iterator i = q.iterate();
		while (i.hasNext()) {
			Product p = (Product) i.next();
			//System.out.println(p[0]);
			System.out.println(p.getPid()+"-------"+p.getPname()+"-------"+p.getPcost());
		}*/
		
	/*Example of Subquery*/
		Query q = s.createQuery("from Product as p where p.pcost < (select p.pcost from Product as p where p.pname = 'ddd')"); 
		q.list();
		Iterator i = q.iterate();
		while (i.hasNext()) {
			Product p = (Product) i.next();
			//System.out.println(p[0]);
			System.out.println(p.getPid()+"-------"+p.getPname()+"-------"+p.getPcost());
		}
	}
}
