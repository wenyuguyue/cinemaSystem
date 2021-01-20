package com.icss.dto;

import java.io.Serializable;

public class SeatDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String code;
	private int row_num;
	private int column_num;
	private int x_coord;
	private int y_coord;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getRow_num() {
		return row_num;
	}
	public void setRow_num(int row_num) {
		this.row_num = row_num;
	}
	public int getColumn_num() {
		return column_num;
	}
	public void setColumn_num(int column_num) {
		this.column_num = column_num;
	}
	public int getX_coord() {
		return x_coord;
	}
	public void setX_coord(int x_coord) {
		this.x_coord = x_coord;
	}
	public int getY_coord() {
		return y_coord;
	}
	public void setY_coord(int y_coord) {
		this.y_coord = y_coord;
	}
	
}
