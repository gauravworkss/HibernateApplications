package com.dss.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.dss.bean.Product;

public class Test {

	public static void main(String[] args) {
	
		Configuration cfg = new Configuration().configure();
		@SuppressWarnings("deprecation")
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		Criteria c = s.createCriteria(Product.class);
		Criterion c1 = Restrictions.ge("pid", "2");
		Criterion c2 = Restrictions.lt("pid", "4");
		c.add(c1);
		c.add(c2);
		ProjectionList pl = Projections.projectionList();
		/*pl.add(Projections.property("pid"));*/
		pl.add(Projections.property("pname"));
		pl.add(Projections.property("pcost"));
		c.setProjection(pl);
		List l = c.list();
		for (int i = 0; i < l.size(); i++) {
			Object[] product = (Object[])l.get(i);
			System.out.println(product[0]+"----"+product[1]);
		}
	}
}

