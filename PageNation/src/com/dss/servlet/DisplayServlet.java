package com.dss.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dss.bean.Product;

/**
 * Servlet implementation class DisplayServlet
 */
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    Configuration cfg;
    SessionFactory sf;
    Session s;
    PrintWriter out;
    
	
    public DisplayServlet() {
        super();
    }

	@SuppressWarnings("deprecation")
	public void init(ServletConfig config) throws ServletException {
		cfg = new Configuration().configure();
		sf = cfg.buildSessionFactory();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			response.setContentType("html/text");
			out = response.getWriter();
			s	=	sf.openSession();
			Query q	=	s.createQuery("from Product");
			q.setMaxResults(3);
			String val = request.getParameter("button");
			if (val == null) {
				getForm();
			}
			else {
				out.println("<html><body bgcolor='lightgreen'><center>");
				out.println("<table border='1' width = '30%' height='40%'>");
				out.println("<tr><td></td>PID...<td></td>PNAME...<td>PCOST...</td></tr>");
				if(val.equals("1")){
					q.setFirstResult(0);
				}
				if(val.equals("2")){
					q.setFirstResult(3);
				}
				if(val.equals("3")){
					q.setFirstResult(6);
				}
				List l = q.list();
				for (int i = 0; i < l.size(); i++) {
					Product p = (Product)l.get(i);
					out.println("<tr>");
					out.println("<td>"+p.getPid()+"</td>");
					out.println("<td>"+p.getPname()+"</td>");
					out.println("<td>"+p.getPcost()+"</td>");
					out.println("</tr>");
				}
				out.println("</table></center></body></html>");
				getForm();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getForm() {
		out.println("<html><body><center>");
		out.println("<form method='get action='./display''>");
		out.println("<input type='submit' name='button' value='1'>");
		out.println("<input type='submit' name='button' value='2'>");
		out.println("<input type='submit' name='button' value='3'>");
		out.println("</form></center></body></html>");
	}

}
