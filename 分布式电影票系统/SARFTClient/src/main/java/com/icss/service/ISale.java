package com.icss.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.icss.dto.SalePackageDTO;

@WebService
public interface ISale {
@WebMethod
public void writeSale(SalePackageDTO salePackageDTO);
}
