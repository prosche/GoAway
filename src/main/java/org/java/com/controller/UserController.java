package org.java.com.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.java.com.model.OfferTbl;
import org.java.com.service.OfferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
//	@Qualifier("dataSourceAdvice")
	private OfferService offerService;
	
	@RequestMapping(value = "/getAllOffer", method = RequestMethod.GET)
	public void getAllOffer(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model){
		String offerId = request.getParameter("id");
		List<OfferTbl> results = offerService.getOffers(Integer.valueOf(offerId));
		logger.debug("{}", results.size() == 0 ? null : results.get(0).getUserId());
	}

}
