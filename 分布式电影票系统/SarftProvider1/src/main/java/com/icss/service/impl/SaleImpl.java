package com.icss.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icss.dao.TicketDao;
import com.icss.dto.SalePackageDTO;
import com.icss.service.ISale;
import com.icss.util.Log;
import com.icss.util.RedisUtil;

import redis.clients.jedis.Jedis;
@Service
public class SaleImpl implements ISale{
@Autowired
TicketDao ticketDao;
	@Override
	public void writeSale(SalePackageDTO salePackageDTO) {
		try {
			ticketDao.writeSale(salePackageDTO);
			String film_name=ticketDao.getName(salePackageDTO.getFilm_code());
			Jedis jedis = RedisUtil.getJedis();	
			jedis.zincrby("frank", 1, "f"+salePackageDTO.getFilm_code());
			RedisUtil.returnResource(jedis);	
		} catch (SQLException e) {
			Log.logger.error(e.getMessage(),e);
		}
	}

}
