package com.icss.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.icss.dao.UserDao;
import com.icss.entity.User;

@Service
public class UserBiz {
@Autowired
UserDao userDao;

	public User login(String name, String pwd) throws Exception {
			return userDao.login(name,pwd);
	}

	public boolean isValid(String name) throws Exception {
		return userDao.isValidUname(name);
	}

	public int regist(User user) throws Exception {
		return userDao.regist(user);
	}

}
