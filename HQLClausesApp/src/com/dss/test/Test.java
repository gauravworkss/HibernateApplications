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
		/*Query q = s.createQuery("from Product");*/      //**Example of from clause** 
		/*Query q = s.createQuery("select p.pid, p.pname,p.pcost from Product as p");*/		//**Example of select clause**
		/*Query q = s.createQuery("select p.pid, p.pname,p.pcost from Product as p where p.pcost < 250 ");*/   //**Example of where clause**
		/*Query q = s.createQuery("select p.pid, p.pname,p.pcost from Product as p order by p.pcost desc ");*/ //**Example of order by clause**
		/*Query q = s.createQuery("select sum(p.pcost) from Product as p group by p.pname");*/		//**Example of group by clause** 
		Query q = s.createQuery("select sum(p.pcost) from Product as p group by p.pcost having p.pcost <= 700");		//**Example of having clause**
		
		List l = q.list();
	/*Forloop for 'from clause'*/
		/*	for (int i = 0; i < l.size(); i++) {
			Product p = (Product)l.get(i);
			System.out.println(p.getPid()+"----"+p.getPname()+"----"+p.getPcost());
		}*/
		
	/*Forloop for 'select clause','where clause','order by clause'*/
			/*for (int i = 0; i < l.size(); i++) {
			Object[] o = (Object[])l.get(i);
			System.out.println(o[0]+"--------"+o[1]+"-------"+o[2]);
		}*/
	/*Forloop for 'group by clause','having clause'*/
		for (int i = 0; i < l.size(); i++) {
				System.out.println(l.get(i));
			}
		
	}

}
