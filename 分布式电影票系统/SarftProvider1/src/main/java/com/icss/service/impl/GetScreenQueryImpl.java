package com.icss.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icss.dto.ScreenPackageDTO;
import com.icss.service.IGetScreenQuery;
import com.icss.service.IScreenQuery;
import com.icss.util.Log;
//@WebService
//@Service
public class GetScreenQueryImpl implements IGetScreenQuery {
	@Autowired
	IScreenQuery iScreenQuery;

	@Override
	@WebMethod
	public ScreenPackageDTO getScreenQuery(String screen_code) {
		ScreenPackageDTO screenPackageDTO = null;
		try {
			screenPackageDTO = iScreenQuery.getScreenPackageList(screen_code);
			System.out.println(screenPackageDTO.getSlist());
		} catch (Exception e) {
			Log.logger.error(e.getMessage(), e);
		}
		return screenPackageDTO;
	}

}
