package com.icss.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Movie {
private int code;
private String name;
private int duration;
private String area;
private String type;
private String director;
private BigDecimal score;
private int status;
private String introduction;
private String cover;
private Date publish_date;
private Date eddate;
private int sealnum;
private BigDecimal minsale;
private String version;
private String publisher;
private String producer;
private String cast;
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getDuration() {
	return duration;
}
public void setDuration(int duration) {
	this.duration = duration;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getDirector() {
	return director;
}
public void setDirector(String director) {
	this.director = director;
}
public BigDecimal getScore() {
	return score;
}
public void setScore(BigDecimal score) {
	this.score = score;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getIntroduction() {
	return introduction;
}
public void setIntroduction(String introduction) {
	this.introduction = introduction;
}
public String getCover() {
	return cover;
}
public void setCover(String cover) {
	this.cover = cover;
}
public Date getPublish_date() {
	return publish_date;
}
public void setPublish_date(Date publish_date) {
	this.publish_date = publish_date;
}
public Date getEddate() {
	return eddate;
}
public void setEddate(Date eddate) {
	this.eddate = eddate;
}
public int getSealnum() {
	return sealnum;
}
public void setSealnum(int sealnum) {
	this.sealnum = sealnum;
}
public BigDecimal getMinsale() {
	return minsale;
}
public void setMinsale(BigDecimal minsale) {
	this.minsale = minsale;
}
public String getVersion() {
	return version;
}
public void setVersion(String version) {
	this.version = version;
}
public String getPublisher() {
	return publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public String getProducer() {
	return producer;
}
public void setProducer(String producer) {
	this.producer = producer;
}
public String getCast() {
	return cast;
}
public void setCast(String cast) {
	this.cast = cast;
}

}
