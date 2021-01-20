package com.icss.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.icss.dto.ScreenPackageDTO;
//@Service
//@WebService
public interface IScreenQuery {
	//@WebMethod
	public ScreenPackageDTO getScreenPackageList(String screen_code)throws Exception;
}
