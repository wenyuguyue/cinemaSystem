package com.icss.mapper;

import java.util.List;

import com.icss.entity.FilmPlan;
import com.icss.entity.Office;

public interface IFilmMapper {

	public List<FilmPlan> queryFilm1()throws Exception;

	public List<FilmPlan> queryFilm2()throws Exception;
	
	public List<FilmPlan> queryFilm3()throws Exception;
	
	public void editFilmPlan(String fpid, String field, String value)throws Exception;

	public void deleteFilmPlan(String fpid)throws Exception;

	public List<Office> queryOffice()throws Exception;

}
