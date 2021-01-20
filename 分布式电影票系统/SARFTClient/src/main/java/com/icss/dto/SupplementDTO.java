package com.icss.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SupplementDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cinema_code;
	private Date business_date;
	private String screen_code;
	private String film_code;
	private String session_code;
	private Date session_datetime;
	private int count;
	private BigDecimal price;

	public String getCinema_code() {
		return cinema_code;
	}

	public void setCinema_code(String cinema_code) {
		this.cinema_code = cinema_code;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
