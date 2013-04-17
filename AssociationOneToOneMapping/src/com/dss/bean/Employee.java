package com.dss.bean;

public class Employee {

// Properties	
	private String eid;
	private String ename;
	private Account acc;

// Getter and Setter Methods	
	public Account getAcc() {
		return acc;
	}
	public void setAcc(Account acc) {
		this.acc = acc;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
}
