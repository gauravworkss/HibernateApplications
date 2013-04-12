package com.dss.gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dss.bean.Employee;

public class EmployeeSearchFrame extends Frame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	Configuration cfg;
	SessionFactory sf;
	Session s;
	
	Label l;	
	TextField tf;
	Button b;
	
	String status = "";
	Employee emp;
	@SuppressWarnings("deprecation")
	public EmployeeSearchFrame() {
		
		try {
			cfg = new Configuration();
			cfg.configure("myconfig.xml");
			sf = cfg.buildSessionFactory();
			
			this.setVisible(true);
			this.setSize(500,500);
			this.setBackground(Color.cyan);
			this.setLayout(new FlowLayout());
			this.setTitle("AWT HBN Example");
			
			l	= 	new Label("Employee ID ");
			tf	=	new TextField(20);
			b	=	new Button("Search");
			b.addActionListener(this);
			this.add(l);
			this.add(tf);
			this.add(b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			s	=	sf.openSession();
			int eno = Integer.parseInt(tf.getText());
			emp = (Employee)s.get(Employee.class, eno);
			repaint();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
	
	public void paint(Graphics g){
		
		Font f	=	new Font("arial",Font.BOLD,30);
		g.setFont(f);
	//	tf.setText("");
		if (emp == null) {
			g.drawString("Employee Not Existed", 100, 250);
			
		} else {
			g.drawString("Employee No......"+emp.getEno(), 50, 100);
			g.drawString("Employee Name......"+emp.getEname(), 50, 150);
			g.drawString("Employee Salary......"+emp.getEsal(), 50, 200);
		}
	}
	
	
	
	
}
