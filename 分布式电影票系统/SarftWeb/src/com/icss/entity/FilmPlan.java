package com.icss.entity;

import java.math.BigDecimal;
import java.util.Date;

public class FilmPlan {
	private int fpid;
	private Date business_date;
	private String screen_code;
	private String film_code;
	private String session_code;
	private Date session_datetime;
	private int seat_by_number;
	private BigDecimal price;
	private BigDecimal lowest_price;
	private String film_name;
	private byte[] film_cover;
	private int valid;

	public int getFpid() {
		return fpid;
	}

	public void setFpid(int fpid) {
		this.fpid = fpid;
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

	public int getSeat_by_number() {
		return seat_by_number;
	}

	public void setSeat_by_number(int seat_by_number) {
		this.seat_by_number = seat_by_number;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getLowest_price() {
		return lowest_price;
	}

	public void setLowest_price(BigDecimal lowest_price) {
		this.lowest_price = lowest_price;
	}

	public String getFilm_name() {
		return film_name;
	}

	public void setFilm_name(String film_name) {
		this.film_name = film_name;
	}

	public byte[] getFilm_cover() {
		return film_cover;
	}

	public void setFilm_cover(byte[] film_cover) {
		this.film_cover = film_cover;
	}

	public int getValid() {
		return valid;
	}

	public void setValid(int valid) {
		this.valid = valid;
	}

}
