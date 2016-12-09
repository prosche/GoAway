package org.java.com.dao;

import java.util.List;

import org.java.com.bean.OfferBean;
import org.java.com.model.OfferTbl;

public interface OfferDao {

	List<OfferTbl> getSql(OfferBean list);

}
