package com.icss.entity;

import java.util.Date;

public class User {
private String name;
private String pwd;
private String rname;
private String family;
private Date stime;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getRname() {
	return rname;
}
public void setRname(String rname) {
	this.rname = rname;
}
public String getFamily() {
	return family;
}
public void setFamily(String family) {
	this.family = family;
}
public Date getStime() {
	return stime;
}
public void setStime(Date stime) {
	this.stime = stime;
}

}
