package com.dss.test;

import java.util.List;

import org.hibernate.Filter;
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
		Query q = s.createQuery("from Product");		
	//	Filters not working
		Filter f = s.enableFilter("my_filter");
		f.setParameter("ptype", "temp");
		/*f.setParameter("pid", "2");*/
		List l = q.list();
		for (int i = 0; i < l.size(); i++) {
			Product product = (Product)l.get(i);
			System.out.println(product.getPid());
		}
	}
}

