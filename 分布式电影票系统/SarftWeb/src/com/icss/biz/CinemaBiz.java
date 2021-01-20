package com.icss.biz;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.icss.dao.CinemaDao;
import com.icss.entity.Cinema;
import com.icss.entity.Moviehall;
import com.icss.kafka.KafkaProduce;
import com.icss.util.Log;
import com.icss.util.RedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

@Service
public class CinemaBiz {
	@Autowired
	CinemaDao cinemaDao;
	@Autowired
	KafkaProduce kafkaProduce;
	public List<Cinema> queryCinema() throws Exception {
		return cinemaDao.queryCinema();
	}

	public void editCinema(String code, String field, String value) throws Exception {
		cinemaDao.editCinema(code, field, value);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				kafkaProduce.sendMessage("cinema", code, "editCinema");
			}
		}).start();
		
	}

	public void deleteCinema(String code) throws Exception {
		cinemaDao.deleteCinema(code);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				kafkaProduce.sendMessage("cinema", code, "deleteCinema");
			}
		}).start();
	}

	public void addCinema(Cinema cinema) throws Exception {
		cinemaDao.addCinema(cinema);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				kafkaProduce.sendMessage("cinema", cinema.getCode(), "addCinema");
			}
		}).start();		
	}

	public List<Moviehall> queryMoviehall() throws Exception {
		return cinemaDao.queryMoviehall();
	}

	public void deleteMoviehall(String hno) throws Exception {
		cinemaDao.deleteMoviehall(hno);
	}

	public List<Cinema> queryCinemaCid() throws Exception {
		return cinemaDao.queryCinemaCid();
	}

	public void addMoviehall(Moviehall moviehall) throws Exception {
		cinemaDao.addMoviehall(moviehall);
	}

	public int getSale(String code) {
		double num = 0;
		Jedis jedis = RedisUtil.getJedis();
		Set<Tuple> s = jedis.zrevrangeWithScores("frank", 0, -1);
		for (Tuple tuple : s) {		
			if(tuple.getElement().equals("f"+code)) {
				Log.logger.info(tuple.getElement()+"********"+tuple.getScore());
				num = tuple.getScore();
				break;
			}
		}
		RedisUtil.returnResource(jedis);
		//Log.logger.info(num+"*******");
		return (int) num;
	}

}
