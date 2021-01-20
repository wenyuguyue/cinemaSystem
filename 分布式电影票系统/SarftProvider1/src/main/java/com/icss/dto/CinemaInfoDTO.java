package com.icss.dto;

import java.io.Serializable;

public class CinemaInfoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String cinema_code;
	private String name;
	private int request;
	private int return_value;
	private String corporation;
	private String contact;
	private String telephone;
	private String fax;
	private String cinemas;
	private int status ;
	private int screen_count ;
	public String getCinema_code() {
		return cinema_code;
	}
	public void setCinema_code(String cinema_code) {
		this.cinema_code = cinema_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRequest() {
		return request;
	}
	public void setRequest(int request) {
		this.request = request;
	}
	public int getReturn_value() {
		return return_value;
	}
	public void setReturn_value(int return_value) {
		this.return_value = return_value;
	}
	public String getCorporation() {
		return corporation;
	}
	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getCinemas() {
		return cinemas;
	}
	public void setCinemas(String cinemas) {
		this.cinemas = cinemas;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getScreen_count() {
		return screen_count;
	}
	public void setScreen_count(int screen_count) {
		this.screen_count = screen_count;
	}
	
	
}
