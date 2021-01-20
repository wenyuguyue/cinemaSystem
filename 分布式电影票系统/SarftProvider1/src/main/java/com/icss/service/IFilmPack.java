package com.icss.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.icss.dto.FilmDTO;
import com.icss.dto.MoviesPackageDTO;

@WebService
public interface IFilmPack {
	@WebMethod
	public MoviesPackageDTO getFilmsPackageList(Date start_date,Date end_date) throws Exception;
	
}
