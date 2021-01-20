package com.icss.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icss.dao.TicketDao;
import com.icss.dto.SupplementDTO;
import com.icss.service.ISupplement;
import com.icss.util.Log;
@Service
public class SupplementImpl implements ISupplement{
@Autowired
TicketDao ticketDao;
	@Override
	public void writeSupplement(SupplementDTO supplementDTO) {
		try {
			ticketDao.writeSupplement(supplementDTO);
		} catch (SQLException e) {
			Log.logger.error(e.getMessage(),e);
		}
	}

}
