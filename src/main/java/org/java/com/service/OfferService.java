package org.java.com.service;

import java.util.List;

import org.java.com.model.OfferTbl;

public interface OfferService {

	List<OfferTbl> getOffers(int id);

}
