package fr.univbrest.dosi.spi.service;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univbrest.dosi.spi.Application;
import fr.univbrest.dosi.spi.bean.CgRefCode;




@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class DomainesServicesTest {
	
	@Autowired
	DomainesService DomainesService;
	
	/**
	 * test de la methode getDomainByRvDomain
	 */
	
	@Test
	public void getDomainByRvDomainTest() {

		List<CgRefCode> domaines = DomainesService.getDomainByRvDomain("SALLE");
		Assert.assertNotNull(domaines);
	}
	
}
