package com.edu;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="hibernatecourse")
public class Course {
@Id
@Column(name="course_id")
private int cid;
@Column(length=20)
private String cname;
private double cost;
@ManyToMany(mappedBy = "courselist")
private Set<Student>studentset;
public Course(int cid,String cname, double cost) {
	super();
	this.cid=cid;
	this.cname=cname;
	this.cost=cost;
}

public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public double getCost() {
	return cost;
}
public void setCost(double cost) {
	this.cost = cost;
}
public Course() {
	super();
}

@Override
public String toString() {
	return "Course [cid=" + cid + ", cname=" + cname + ", cost=" + cost + ", studentset=" + studentset + "]";
}




}
