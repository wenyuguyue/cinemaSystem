package com.icss.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.icss.dto.ScreenPackageDTO;

@WebService
public interface IGetScreenQuery {
@WebMethod
public ScreenPackageDTO getScreenQuery(String screen_code);
}
