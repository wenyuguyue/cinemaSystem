package com.icss.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.icss.dto.ScreenPackageDTO;

@WebService
public interface IScreenQuery {
@WebMethod
public ScreenPackageDTO getScreenPackageList(String screen_code)throws Exception;
}
