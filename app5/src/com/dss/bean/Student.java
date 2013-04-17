package com.dss.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "product")
public class Student {
@Id
@Column(name="pid")
private	String sid;
@Column(name="pname")
private	String sname;
@Column(name="pcost")
private	int smarks;

public String getSid() {
	return sid;
}
public void setSid(String sid) {
	this.sid = sid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public int getSmarks() {
	return smarks;
}
public void setSmarks(int smarks) {
	this.smarks = smarks;
}
}
