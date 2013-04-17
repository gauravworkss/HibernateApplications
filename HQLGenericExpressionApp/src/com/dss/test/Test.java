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
		/*Query q = s.createQuery("select (p.pcost-10) from Product as p");*/											 		/*Example of mathematical operators*/
		/*Query q = s.createQuery("select p.pname from Product as p  where p.pcost >= 50 and p.pcost < 501");*/			        /*Example of binary and logical(and,or etc) operators*/
		/*Query q = s.createQuery("select lower(p.pname) from Product as p  where p.pcost >= 50 and p.pcost < 501");*/	 		/*Example of scalar function*/
		/*Query q = s.createQuery("select p.pname,p.pcost from Product as p  where p.pname in('aaa','eee','ccc')");*/	 		/*Example of in*/
		/*Query q = s.createQuery("select p.pname,p.pcost from Product as p  where p.pname between 'aaa' and 'eee')");*/	 	/*Example of between*/
		/*Query q = s.createQuery("select p.pname,p.pcost from Product as p  where p.pname like '%b')");*/	 					/*Example of like*/
		/*Query q = s.createQuery("select p.pid,p.pcost from Product as p  where p.pname is null)");*/	 						/*Example of is null*/
		Query q = s.createQuery("select p.pid,p.pcost from Product as p  where p.pname is not null)");	 						/*Example of is not null*/
		List l = q.list();
		
/*Example of Mathematical Operators*/		
		/*for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}*/
		
/*Example of binary,logical(and,or etc) operators and scalar funtions such as (upper,lower)*/		
		/*for (int i = 0; i < l.size(); i++) {
			String o = (String) l.get(i);
			System.out.println(o);
		}*/
		
/*Example of in,between,like,is null,is not null  */
		for (int i = 0; i < l.size(); i++) {
			Object[] o = (Object[]) l.get(i);
			System.out.println(o[0]+"-------"+o[1]);
		}
		
		
	}

}
