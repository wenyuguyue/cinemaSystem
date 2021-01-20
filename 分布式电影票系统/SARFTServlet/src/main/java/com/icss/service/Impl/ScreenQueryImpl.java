package com.icss.service.Impl;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.icss.dao.ScreenDao;
import com.icss.dto.ScreenDTO;
import com.icss.dto.ScreenPackageDTO;
import com.icss.service.IScreenQuery;

@Service
public class ScreenQueryImpl implements IScreenQuery{
@Autowired
ScreenDao screenDao;


	@Override
	@Transactional(rollbackFor = Throwable.class)
	public ScreenPackageDTO getScreenPackageList(String screen_code) throws Exception {
		int total=screenDao.gettotalNum();
		int count=screenDao.getcount(screen_code);
		int remain=total-count;
		List<ScreenDTO> slist=screenDao.getScreenPackageList(screen_code);
		ScreenPackageDTO map=new ScreenPackageDTO();
		map.setReturn_value(0);
		map.setCount(count);
		map.setRemain(remain);
		map.setTotal(total);
		map.setSlist(slist);
		return map;
	}

}
