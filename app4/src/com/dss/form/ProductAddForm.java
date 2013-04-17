package com.dss.form;

import org.apache.struts.action.ActionForm;

public class ProductAddForm extends ActionForm{

	private static final long serialVersionUID = 1L;
	
	String pid;
	String pname;
	int pcost;
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPcost() {
		return pcost;
	}
	public void setPcost(int pcost) {
		this.pcost = pcost;
	}
	
	
	
}
