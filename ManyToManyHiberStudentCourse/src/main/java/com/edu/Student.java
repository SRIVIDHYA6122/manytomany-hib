package com.edu;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

@Entity
@Table(name="hibernatestudent")
public class Student {
	@Id
	@Column(name="student_id")
private int sid;
	@Column(length=20)
private String sname;
	@Column(length=20)
private String smobile;

@ManyToMany
private Set<Course>courselist;
@JoinTable(
		name="hiberstudent_course",
		joinColumns = {
			@JoinColumn(name="stud_id",referencedColumnName="student_id")	
		},
		inverseJoinColumns = {
				@JoinColumn(name="course_id",referencedColumnName = "course_id")
		}
	)
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getSmobile() {
	return smobile;
}
public void setSmobile(String smobile) {
	this.smobile = smobile;
}



public Set<Course> getCourselist() {
	return courselist;
}
public void setCourselist(Set<Course> courselist) {
	this.courselist = courselist;
}
public Student() {
	super();
}

@Override
public String toString() {
	return "Student [sid=" + sid + ", sname=" + sname + ", smobile=" + smobile + ", courselist=" + courselist + "]";
}
public Student(int sid, String sname, String smobile) {
	super();
	this.sid = sid;
	this.sname = sname;
	this.smobile = smobile;
}
}
