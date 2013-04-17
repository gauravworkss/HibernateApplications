package com.dss.bean;

import java.util.Collection;

public class Students {
	
	private String sid;
	private String sname;
	private Collection<Courses> course;
	
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
	public Collection<Courses> getCourse() {
		return course;
	}
	public void setCourse(Collection<Courses> course) {
		this.course = course;
	}
}
