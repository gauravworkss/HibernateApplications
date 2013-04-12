package com.dss.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/*import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
*/
import com.dss.bean.Employee;

public class Test {

	public static void main(String[] args) {
	
		Configuration cfg = new Configuration();
		cfg.configure();
		
		// **** There are two ways to use Schema Export and Schema Update One using below as i have used
		// **** and second is by defining in "Configuration File" with the property name as "hibernate.hbm2ddl.auto"
		// **** with value as "create/update/create-drop" any of one.
		
		// **** Schema Export Example ****
	/*	SchemaExport export = new SchemaExport(cfg);
		export.create(true,true);
	*/	
		// **** Schema Update Example ****
		/*SchemaUpdate update = new SchemaUpdate(cfg);
		update.execute(true, true);
		*/@SuppressWarnings("deprecation")
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Employee emp = new Employee();
	//	emp.setEno(800);
		emp.setEname("Bunny");
		emp.setEsal(18000.0f);
		emp.setEaddr("London");
		System.out.println("Data Inserted Successfully.....");
		
		Transaction tx = s.beginTransaction();
//		s.save(emp);
		s.saveOrUpdate(emp);
		//s.delete(emp);
		tx.commit();
		s.close();
		sf.close();		
	}
}
