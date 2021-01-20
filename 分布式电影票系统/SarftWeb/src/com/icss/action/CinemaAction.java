package com.icss.action;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icss.biz.CinemaBiz;
import com.icss.entity.Cinema;
import com.icss.entity.Moviehall;
import com.icss.util.Log;

@Controller
public class CinemaAction {
@Autowired
CinemaBiz cinemaBiz;

	@RequestMapping("queryCinema")
	@ResponseBody
	public List<Cinema> queryCinema() {
		try {
			return cinemaBiz.queryCinema();
		} catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
			return null;
		}
	}
	
	@RequestMapping("editCinema")
	@ResponseBody
	public String editCinema(String code,String field,String value,String oldvalue) {
		if(value.equals(oldvalue)) {
			return "{\"msg\":\"success\",\"code\":\"200\"}";
		}
		try {
			cinemaBiz.editCinema(code,field,value);
			return "{\"msg\":\"success\",\"code\":\"200\"}";
		} catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
			return "{\"msg\":\"error\",\"code\":\"404\"}";			
		}
	}
	@RequestMapping("deleteCinema")
	@ResponseBody
	public String editCinema(String code) {		
		try {
			cinemaBiz.deleteCinema(code);
			return "{\"msg\":\"success\",\"code\":\"200\"}";
		} catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
			return "{\"msg\":\"error\",\"code\":\"404\"}";			
		}
	}
	
	@RequestMapping("addCinema")
	@ResponseBody
	public String addCinema(Cinema cinema) {		
		try {
			cinemaBiz.addCinema(cinema);
			return "{\"msg\":\"success\",\"code\":\"200\"}";
		} catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
			return "{\"msg\":\"error\",\"code\":\"404\"}";			
		}
	}
	
	@RequestMapping("queryMoviehall")
	@ResponseBody
	public List<Moviehall> queryMoviehall() {		
		try {
			return cinemaBiz.queryMoviehall();
		} catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
			return null;		
		}
	}
	
	@RequestMapping("queryCinemaCid")
	@ResponseBody
	public List<Cinema> queryCinemaCid() {		
		try {
			return cinemaBiz.queryCinemaCid();
		} catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
			return null;		
		}
	}
	@RequestMapping("deleteMoviehall")
	@ResponseBody
	public String deleteMoviehall(String hno) {		
		try {
			cinemaBiz.deleteMoviehall(hno);
			return "{\"msg\":\"success\",\"code\":\"200\"}";
		} catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
			return "{\"msg\":\"error\",\"code\":\"404\"}";			
		}
	}
	
	@RequestMapping("addMoviehall")
	@ResponseBody
	public String addMoviehall(Moviehall moviehall) {		
		try {
			cinemaBiz.addMoviehall(moviehall);
			return "{\"msg\":\"success\",\"code\":\"200\"}";
		} catch (Exception e) {
			Log.logger.error(e.getMessage(),e);
			return "{\"msg\":\"error\",\"code\":\"404\"}";			
		}
	}

	@RequestMapping("/getSale")
	@ResponseBody
	public int getSale(String code) {
		return cinemaBiz.getSale(code);
	}
}
