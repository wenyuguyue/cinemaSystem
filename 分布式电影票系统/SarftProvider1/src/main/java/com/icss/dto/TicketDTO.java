package com.icss.dto;

import java.io.Serializable;

public class TicketDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String code;
	private double price;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
