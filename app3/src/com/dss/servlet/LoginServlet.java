package com.dss.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dss.bean.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Configuration cfg;
	SessionFactory sf;
	Session s;
	
	@SuppressWarnings("deprecation")
	@Override
	public void init() throws ServletException {
		try {
			cfg = new Configuration().configure();
			sf  = cfg.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	
	}
	
    public LoginServlet() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String uname = request.getParameter("uname");
			String upwd	 = request.getParameter("upwd");
			s = sf.openSession();
			User u = (User) s.get(User.class, uname);
			System.out.println(u.getUname());
			if (uname.equals(u.getUname()) && upwd.equals(u.getUpwd())) {
				 RequestDispatcher rd = request.getRequestDispatcher("/jsp/success.jsp");
				rd.forward(request,response);
				
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/failure.jsp");
				rd.forward(request,response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
