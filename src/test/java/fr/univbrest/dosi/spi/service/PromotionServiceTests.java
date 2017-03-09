package fr.univbrest.dosi.spi.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Iterables;

import fr.univbrest.dosi.spi.Application;
import fr.univbrest.dosi.spi.bean.Promotion;
import fr.univbrest.dosi.spi.bean.PromotionPK;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class PromotionServiceTests{
	
	@Autowired
	PromotionService promotionservice;
	@Test
	public void addFormationTest() {

		Promotion promotion = new Promotion();
        PromotionPK promotionpk = new PromotionPK("M2DOSIII","2014-2015");
		promotion.setNbMaxEtudiant((short) 25);
		promotion.setSiglePromotion("M2DOSIII");
		promotionservice.addPromotion(promotion);

		Promotion pro= promotionservice.getPromotion(promotionpk);
		
		Assert.assertNotNull(pro);
		Assert.assertEquals(promotion, pro);
	}
	
	@Test
	public void getPromotionTest() {
		PromotionPK promotionpk = new PromotionPK("M2DOSIII","2014-2015");
		
		Promotion promotions =  promotionservice.getPromotion(promotionpk);
		Assert.assertNotNull(promotions);
	}
	
	@Test
	public void listPromotionsTest() {

		Iterable<Promotion> promotions = promotionservice.listPromotions();
		Assert.assertNotNull(promotions);
	}
	
	@Test
	public void updatePromotionTest() {

		Promotion promotion = new Promotion();
		promotion.setNbMaxEtudiant((short) 25);
		promotion.setSiglePromotion("M2DOSIII");
		promotionservice.UpdatePromotion(promotion);
		PromotionPK promotionpk = new PromotionPK("M2DOSIII","2014-2015");
		Promotion pro = promotionservice.getPromotion(promotionpk);
		Assert.assertNotNull(pro);
		Assert.assertEquals(promotion, pro);
	}
	
	@Test
	public void deletePromotionTest() {
		int size = Iterables.size(promotionservice.listPromotions());
		PromotionPK promotionpk = new PromotionPK("M2DOSIII","2014-2015");
		promotionservice.deletePromotion(promotionpk);
		Assert.assertEquals(size - 1,
				Iterables.size(promotionservice.listPromotions()));
	}
	
	
	
	
	
}



