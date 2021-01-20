package com.icss.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.icss.dto.RefundTicketPackageDTO;

@WebService
public interface IRefund {
	@WebMethod
	public void writeRefundInfo(RefundTicketPackageDTO refundTicketPackageDTO);
}
