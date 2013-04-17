package com.dss.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dss.bean.Product;
import com.dss.form.ProductAddForm;
import com.dss.util.HibarnateUtil;

public class ProductAddAction extends Action {

	public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		ProductAddForm paf = (ProductAddForm)form;
		Product p = new Product();
		p.setPid(paf.getPid());
		p.setPname(paf.getPname());
		p.setPcost(paf.getPcost());
		Session s = HibarnateUtil.getSession();
		Transaction tx = s.beginTransaction();
		String pk_val = (String)s.save(p);
		tx.commit();
		if (pk_val == null) {
			return mapping.findForward("failure");
		} else {
			return mapping.findForward("success");
		}
	}
}
