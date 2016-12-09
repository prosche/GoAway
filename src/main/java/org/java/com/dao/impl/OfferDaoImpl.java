package org.java.com.dao.impl;

import java.util.List;

import org.java.com.bean.OfferBean;
import org.java.com.common.dao.impl.BaseHibernateDaoImpl;
import org.java.com.dao.OfferDao;
import org.java.com.model.OfferTbl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OfferDaoImpl extends BaseHibernateDaoImpl<OfferTbl> implements OfferDao {
	
	@Override
	public List<OfferTbl> getSql(OfferBean list) {
		List<OfferTbl> result = getObjectByids(Integer.valueOf(list.getOfferId()));
		return result;
	}
}
