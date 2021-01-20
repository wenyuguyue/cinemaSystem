package com.icss.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.dao.FilmDao;
import com.icss.dto.FilmDTO;
import com.icss.dto.MoviesPackageDTO;
import com.icss.service.IFilmPack;

@Service
public class FilmPackImpl implements IFilmPack{
@Autowired
FilmDao filmDao;

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public MoviesPackageDTO getFilmsPackageList(Date start_date,Date end_date) throws Exception {
		int total=filmDao.gettotalNum();
		int count=filmDao.getcount(start_date,end_date);		
		int remain=total-count;
		List<FilmDTO> flist=filmDao.getFilmsPackage(start_date,end_date);
		MoviesPackageDTO map=new MoviesPackageDTO();
		map.setReturn_value(0);
		map.setCount(count);
		map.setRemain(remain);
		map.setTotal(total);
		map.setFlist(flist);
		return map;
	}


}
