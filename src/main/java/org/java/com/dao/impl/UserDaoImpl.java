package org.java.com.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import org.java.com.common.dao.impl.BaseHibernateDaoImpl;
import org.java.com.dao.UserDao;
import org.java.com.model.UserTbl;

@Repository
public class UserDaoImpl extends BaseHibernateDaoImpl<UserTbl> implements UserDao {

	@Override
	public List<UserTbl> getSql(UserTbl list) {
		List<UserTbl> result = getObjectByids(list.getId());
		return result;
	}

}