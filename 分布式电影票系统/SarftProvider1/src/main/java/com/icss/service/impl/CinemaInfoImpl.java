package com.icss.service.impl;

import java.sql.SQLException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.icss.dao.CinemaDao;
import com.icss.dto.CinemaInfoDTO;
import com.icss.service.ICinemaInfo;


@Service
public class CinemaInfoImpl implements ICinemaInfo {
	@Autowired
	CinemaDao cinemaDao;


	@Override
	@Transactional(rollbackFor = Throwable.class)
	public CinemaInfoDTO changeCinemaInfo(String cinema_code, int request) throws SQLException {
		cinemaDao.changeCinemaInfo(cinema_code, request);
		CinemaInfoDTO cinemaInfoDTO = cinemaDao.getCinemaInfo(cinema_code);
		cinemaInfoDTO.setReturn_value(0);
		cinemaInfoDTO.setRequest(request);
		return cinemaInfoDTO;
	}

}
