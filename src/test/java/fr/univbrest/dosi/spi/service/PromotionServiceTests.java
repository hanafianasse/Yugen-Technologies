package fr.univbrest.dosi.spi.service;


import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import fr.univbrest.dosi.spi.Application;
import fr.univbrest.dosi.spi.bean.Formation;
import fr.univbrest.dosi.spi.bean.Promotion;
import fr.univbrest.dosi.spi.bean.PromotionPK;
import fr.univbrest.dosi.spi.dao.PromotionRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class PromotionServiceTests{
	
	
	@Autowired
	 PromotionService promotionservice;
	
	private Formation formation;
	
	@Test
	public void addPromotionTest() {
		PromotionRepository entrepot=new PromotionDAOStub();
		PromotionService promotionService= new PromotionService(entrepot);
		promotionService.addPromotion(new Promotion());
		Assert.assertEquals(1, entrepot.count());
	}
	/*	
	@Test
       public void getPromotionTest() {
		PromotionPK promotionpk = new PromotionPK("M2DOSIII","2014-2015");
		
		Promotion promotions =  promotionservice.getPromotion(promotionpk);
		Assert.assertNotNull(promotions);
	}
	*/
	@Test
	public void listPromotionsTest() {

		List<Promotion> promotions=Lists.newArrayList(new Promotion("M2DOSI","2012-2013"),new Promotion("M1TILL","2014-2015"));
		PromotionRepository entrepot = new PromotionDAOStub(promotions);
		PromotionService promotionService = new PromotionService(entrepot);
		
		Assert.assertEquals(2, Iterables.size(promotionService.listPromotions()));
		
	
	}
	/*
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
	}*/

	}
	
	



