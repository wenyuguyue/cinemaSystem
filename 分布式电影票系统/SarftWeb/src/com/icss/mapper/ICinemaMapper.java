package com.icss.mapper;

import java.util.List;

import com.icss.entity.Cinema;
import com.icss.entity.Moviehall;

public interface ICinemaMapper {

	public List<Cinema> queryCinema() throws Exception;

	public void editCinema(String code, String field, String value)throws Exception;

	public void deleteCinema(Cinema cinema)throws Exception;

	public void deleteCinema(String code)throws Exception;

	public List<Moviehall> queryMoviehall()throws Exception;

	public void deleteMoviehall(String hno)throws Exception;

	public List<Cinema> queryCinemaCid()throws Exception;

	public void addMoviehall(Moviehall moviehall)throws Exception;
}
