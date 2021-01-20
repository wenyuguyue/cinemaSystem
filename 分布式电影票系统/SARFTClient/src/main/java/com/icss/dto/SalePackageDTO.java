package com.icss.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SalePackageDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String cinema_code;
	private int cinema_status;
	private Date business_date;
	private String screen_code;
	private String film_code;
	private String session_code;
	private Date session_datetime;
	private int operation;
	private String code;
	private String seat_code;
	private BigDecimal price;
	private BigDecimal service;
	private int online_sale;
	private Date datetime;
	private String signature;

	public String getCinema_code() {
		return cinema_code;
	}

	public void setCinema_code(String cinema_code) {
		this.cinema_code = cinema_code;
	}

	public int getCinema_status() {
		return cinema_status;
	}

	public void setCinema_status(int cinema_status) {
		this.cinema_status = cinema_status;
	}

	public Date getBusiness_date() {
		return business_date;
	}

	public void setBusiness_date(Date business_date) {
		this.business_date = business_date;
	}

	public String getScreen_code() {
		return screen_code;
	}

	public void setScreen_code(String screen_code) {
		this.screen_code = screen_code;
	}

	public String getFilm_code() {
		return film_code;
	}

	public void setFilm_code(String film_code) {
		this.film_code = film_code;
	}

	public String getSession_code() {
		return session_code;
	}

	public void setSession_code(String session_code) {
		this.session_code = session_code;
	}

	public Date getSession_datetime() {
		return session_datetime;
	}

	public void setSession_datetime(Date session_datetime) {
		this.session_datetime = session_datetime;
	}

	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSeat_code() {
		return seat_code;
	}

	public void setSeat_code(String seat_code) {
		this.seat_code = seat_code;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getService() {
		return service;
	}

	public void setService(BigDecimal service) {
		this.service = service;
	}

	public int getOnline_sale() {
		return online_sale;
	}

	public void setOnline_sale(int online_sale) {
		this.online_sale = online_sale;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

}
