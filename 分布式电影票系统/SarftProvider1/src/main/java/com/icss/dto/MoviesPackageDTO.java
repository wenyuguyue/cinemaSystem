package com.icss.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MoviesPackageDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private int return_value;
	private int total;
	private int remain;
	private int count;
	private List<FilmDTO> flist;
	public int getReturn_value() {
		return return_value;
	}
	public void setReturn_value(int return_value) {
		this.return_value = return_value;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getRemain() {
		return remain;
	}
	public void setRemain(int remain) {
		this.remain = remain;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<FilmDTO> getFlist() {
		return flist;
	}
	public void setFlist(List<FilmDTO> flist) {
		this.flist = flist;
	}
	
	
}
