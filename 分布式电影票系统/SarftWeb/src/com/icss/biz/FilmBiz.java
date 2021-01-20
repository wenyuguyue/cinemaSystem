package com.icss.biz;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.icss.dao.FilmDao;
import com.icss.entity.FilmPlan;
import com.icss.entity.Office;
import com.icss.kafka.KafkaProduce;
@Service
public class FilmBiz {
@Autowired
FilmDao filmDao;
@Autowired
KafkaProduce kafkaProduce;
	public List<FilmPlan> queryFilm(String selectfp) throws Exception {
		return filmDao.queryFilm(selectfp);
	}
	public void editFilmPlan(String fpid, String field, String value) throws Exception {
		filmDao.editFilmPlan(fpid,field,value);		
	}
	public void deleteFilmPlan(String fpid) throws Exception {
		filmDao.deleteFilmPlan(fpid);
		kafkaProduce.sendMessage("filmplan", fpid, "deleteFilmPlan");
	}
	public List<Office> queryOffice() throws Exception {
		return filmDao.queryOffice();
	}
}
