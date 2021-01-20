package com.icss.action;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.icss.biz.MovieBiz;
import com.icss.entity.Movie;
import com.icss.util.Log;

@Controller
public class MovieAction {
	@Autowired
	MovieBiz movieBiz;

	@RequestMapping("queryMovie")
	@ResponseBody
	public List<Movie> queryMovie() {
		try {
			return movieBiz.queryMovie();
		} catch (Exception e) {
			Log.logger.error(e.getMessage(), e);
			return null;
		}
	}

	@RequestMapping("/deleteMovie")
	@ResponseBody
	public String deleteMovie(String code) {
		try {
			movieBiz.deleteMovie(code);
			return "{\"msg\":\"success\",\"code\":\"200\"}";
		} catch (Exception e) {
			Log.logger.error(e.getMessage(), e);
			return "{\"msg\":\"error\",\"code\":\"404\"}";
		}
	}

	@RequestMapping("/addMovie")
	@ResponseBody
	public String addMovie(Movie movie, String publish_date1, @RequestParam("file") MultipartFile file) {

		try {
			if (!file.isEmpty()) {
				String[] sz = file.getOriginalFilename().split("\\.");
				String suffix = sz[sz.length - 1];
				String name = movie.getCode() + "." + suffix;
				String path="D:/img/"+name;
				byte[] bytes = file.getBytes();
				OutputStream out=new FileOutputStream(path);
				out.write(bytes);
				out.close();
				movie.setCover("http://127.0.0.1:8080/img/"+name);
			}
			movieBiz.addMovie(movie);
			return "{\"msg\":\"success\",\"code\":\"200\"}";
		} catch (Exception e) {
			Log.logger.error(e.getMessage(), e);
			return "{\"msg\":\"error\",\"code\":\"404\"}";
		}
	}

	@RequestMapping("/editMovie")
	@ResponseBody
	public String editMovie(Movie movie, String publish_date1, @RequestParam("file") MultipartFile file) {

		try {
			if (!file.isEmpty()) {
				String[] sz = file.getOriginalFilename().split("\\.");
				String suffix = sz[sz.length - 1];
				String name = movie.getCode() + "." + suffix;
				String path="D:/img/"+name;
				byte[] bytes = file.getBytes();
				OutputStream out=new FileOutputStream(path);
				out.write(bytes);
				out.close();
				movie.setCover("http://127.0.0.1:8080/img/"+name);
			}
			movieBiz.editMovie(movie);
			return "{\"msg\":\"success\",\"code\":\"200\"}";
		} catch (Exception e) {
			Log.logger.error(e.getMessage(), e);
			return "{\"msg\":\"error\",\"code\":\"404\"}";
		}
	}
	
}
