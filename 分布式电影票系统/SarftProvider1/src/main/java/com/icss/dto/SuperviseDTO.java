package com.icss.dto;

import java.io.Serializable;
import java.util.Date;

public class SuperviseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date start_business_date;
	private Date end_business_date;
	private String screen_code;
	private String film_code;
	private String session_code;
	private Date start_session_datetime;
	private Date end_session_datetime;

	public Date getStart_business_date() {
		return start_business_date;
	}

	public void setStart_business_date(Date start_business_date) {
		this.start_business_date = start_business_date;
	}

	public Date getEnd_business_date() {
		return end_business_date;
	}

	public void setEnd_business_date(Date end_business_date) {
		this.end_business_date = end_business_date;
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

	public Date getStart_session_datetime() {
		return start_session_datetime;
	}

	public void setStart_session_datetime(Date start_session_datetime) {
		this.start_session_datetime = start_session_datetime;
	}

	public Date getEnd_session_datetime() {
		return end_session_datetime;
	}

	public void setEnd_session_datetime(Date end_session_datetime) {
		this.end_session_datetime = end_session_datetime;
	}

}
