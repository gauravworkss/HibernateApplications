package com.dss.bean;

import java.util.Collection;

public class Department {

	private String did;
	private String dname;
	Collection<Employee> emp;
	
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Collection<Employee> getEmp() {
		return emp;
	}
	public void setEmp(Collection<Employee> emp) {
		this.emp = emp;
	}
	
	
}
