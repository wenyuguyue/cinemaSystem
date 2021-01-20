package com.icss.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icss.biz.FilmBiz;
import com.icss.entity.FilmPlan;
import com.icss.entity.Office;
import com.icss.util.Log;

@Controller
public class FilmAction {
	@Autowired
	FilmBiz filmBiz;

	@RequestMapping("queryFilm")
	@ResponseBody
	public List<FilmPlan> queryFilm(String selectfp) {
		try {
			return filmBiz.queryFilm(selectfp);
		} catch (Exception e) {
			Log.logger.error(e.getMessage(), e);
			return null;
		}
	}

	@RequestMapping("editFilmPlan")
	@ResponseBody
	public String editFilmPlan(String fpid, String field, String value, String oldvalue) {
		if (value.equals(oldvalue)) {
			return "{\"msg\":\"success\",\"code\":\"200\"}";
		}
		try {
			filmBiz.editFilmPlan(fpid, field, value);
			return "{\"msg\":\"success\",\"code\":\"200\"}";
		} catch (Exception e) {
			Log.logger.error(e.getMessage(), e);
			return "{\"msg\":\"error\",\"code\":\"404\"}";
		}
	}

	@RequestMapping("deleteFilmPlan")
	@ResponseBody
	public String deleteFilmPlan(String fpid) {
		try {
			filmBiz.deleteFilmPlan(fpid);
			return "{\"msg\":\"success\",\"code\":\"200\"}";
		} catch (Exception e) {
			Log.logger.error(e.getMessage(), e);
			return "{\"msg\":\"error\",\"code\":\"404\"}";
		}
	}

	@RequestMapping("queryOffice")
	@ResponseBody
	public List<Office> queryOffice(){
		try {
			return filmBiz.queryOffice();
		} catch (Exception e) {
			Log.logger.error(e.getMessage(), e);
			return null;
		}
	}
}
