package com.icss.service;

import java.sql.SQLException;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.icss.dto.CinemaInfoDTO;
@WebService
public interface ICinemaInfo {
	@WebMethod
public CinemaInfoDTO changeCinemaInfo(String cinema_code,int request) throws SQLException;
}
