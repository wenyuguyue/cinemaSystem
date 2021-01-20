package com.icss.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.dao.TicketDao;
import com.icss.dto.RefundTicketPackageDTO;
import com.icss.service.IRefund;
import com.icss.util.Log;
@Service
public class RefundImpl implements IRefund{
@Autowired
TicketDao ticketDao;
	@Override
	@Transactional(rollbackFor = Throwable.class)
	public void writeRefundInfo(RefundTicketPackageDTO refundTicketPackageDTO) {
		try {
			ticketDao.writeRefundInfo(refundTicketPackageDTO);
		} catch (SQLException e) {
			Log.logger.error(e.getMessage(),e);
		}
	}

}
