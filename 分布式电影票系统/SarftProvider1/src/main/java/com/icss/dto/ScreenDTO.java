package com.icss.dto;

import java.io.Serializable;

public class ScreenDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String code;
	private String name;
	private int seat_count;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSeat_count() {
		return seat_count;
	}
	public void setSeat_count(int seat_count) {
		this.seat_count = seat_count;
	}
	
}
