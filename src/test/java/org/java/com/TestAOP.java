package org.java.com;

import org.java.com.service.OfferService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {
	@Test
	public void testAOP1() {
		// Æô¶¯SpringÈÝÆ÷
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "classpath:web.xml"});
		OfferService userService = (OfferService) ctx.getBean("ufferService");
		userService.getOffers(0);
	}

}
