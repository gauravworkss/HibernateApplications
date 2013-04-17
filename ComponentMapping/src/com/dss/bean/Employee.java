package com.dss.bean;

public class Employee {

	private String eid;
	private String ename;
	private Address addr;
	private Account accnt;
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
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public Account getAccnt() {
		return accnt;
	}
	public void setAccnt(Account accnt) {
		this.accnt = accnt;
	}
	
	
}
