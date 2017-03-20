package org.java.com.service.impl;

import java.util.List;

import org.java.com.bean.OfferBean;
import org.java.com.common.enums.DataSource;
import org.java.com.common.enums.DataSources;
import org.java.com.dao.OfferDao;
import org.java.com.model.OfferTbl;
import org.java.com.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OfferServiceImpl implements OfferService {

	@Autowired
	private OfferDao offerDao;
	
	public List<OfferTbl> getOffers(int id){
		OfferBean list = new OfferBean();
		list.setOfferId(String.valueOf(id));
		List<OfferTbl> results = offerDao.getSql(list);
		return results;
	}
}
