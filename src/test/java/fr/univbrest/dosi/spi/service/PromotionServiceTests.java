package fr.univbrest.dosi.spi.service;

import static org.junit.Assert.*;

import  org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gemstone.gemfire.internal.Assert;
import com.google.common.collect.Iterables;
import com.sun.glass.ui.Application;

import fr.univbrest.dosi.spi.bean.Promotion;
import fr.univbrest.dosi.spi.dao.PromotionRepository;

/*
public class PromotionServiceTests {

	@RunWith(SpringJUnit4ClassRunner.class)
	@SpringApplicationConfiguration(classes = Application.class)
	public class PromotionServiceTest {

		PromotionService promotionService;

		private PromotionRepository repos;

		@Test
		public void doitAjouterPromotion() {
			this.repos = new PromotionDAOStub();
			this.promotionService = new PromotionService();
			this.promotionService.addPromotion(new Promotion());
			Assert.assertEquals(3, repos.count());
		
	}
	}
}
*/
