package com.icss.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.icss.dto.SupplementDTO;

@WebService
public interface ISupplement {
@WebMethod
public void writeSupplement(SupplementDTO supplementDTO);

}
