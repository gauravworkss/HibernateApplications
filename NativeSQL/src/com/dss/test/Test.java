package com.dss.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
		
/*Programmatic Approach*/
		
		/*Example of simple NativeSQL query*/
/*		SQLQuery sqlQuery = s.createSQLQuery("select * from product");
		
		//Example of Positional Parameter and Named Parameter
		SQLQuery sqlQuery = s.createSQLQuery("select * from product where pcost > ? and pcost< :val");
		sqlQuery.setInteger(0, 1000);
		sqlQuery.setInteger("val", 1500);
		sqlQuery.addEntity(Product.class);
		List l = sqlQuery.list();
		for (int i = 0; i < l.size(); i++) {
			Product product = (Product)l.get(i);
			System.out.println(product.getPid()+"====="+product.getPcost()+"====="+product.getPname());
		}
*/	
	
/*Declarative Approach for Entity SQL Query*/
		
		/*Query q = s.getNamedQuery("entity_sql_query");
		List l = q.list();
		for (int i = 0; i < l.size(); i++) {
			Product product = (Product)l.get(i);
			System.out.println(product.getPid()+"====="+product.getPcost()+"====="+product.getPname());
		}*/

/*Declarative Approach for Scalar SQL Query*/
		//Scalar is used to retrieve direct value from the respective table column
		
		Query q = s.getNamedQuery("scalar_sql_query");
		List l = q.list();
		for (int i = 0; i < l.size(); i++) {
			Object[] product = (Object[])l.get(i);
			System.out.println(product[0]+"====="+product[1]+"====="+product[2]);
		}
	}
}

