package org.java.com.dao;

import java.util.List;

import org.java.com.common.dao.BaseHibernateDao;
import org.java.com.model.UserTbl;

public interface UserDao extends BaseHibernateDao<UserTbl>{

	List<UserTbl> getSql(UserTbl list);
}
