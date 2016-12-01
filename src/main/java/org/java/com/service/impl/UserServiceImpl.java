package org.java.com.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.java.com.dao.UserDao;
import org.java.com.model.UserTbl;
import org.java.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger log = LogManager.getLogger();
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<UserTbl> getAllUsers() {
		UserTbl bean = new UserTbl();
		bean.setId(12831);
		List<UserTbl> resultList = userDao.getSql(bean);
		for(UserTbl user : resultList){
			log.debug(user.getFullname());
		}
		return resultList;
	}
}
