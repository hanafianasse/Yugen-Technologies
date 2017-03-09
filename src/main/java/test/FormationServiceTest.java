package test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Iterables;

import fr.univbrest.dosi.spi.Application;
import fr.univbrest.dosi.spi.bean.Formation;
import fr.univbrest.dosi.spi.bean.Promotion;
import fr.univbrest.dosi.spi.service.FormationService;

/**
 * 
 * @author Red1
 * @Test du Service Formation
 * 
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class FormationServiceTest {

	@Autowired
	FormationService formationService;

	
	/**
	 * @author Red1
	 * @Test de la méthode addFormation
	 */
	@Test
	public void addFormationTest() {

		Formation formation = new Formation();
		formation.setCodeFormation("M2DOSIII");
		formation.setDiplome("M");
		formation.setDoubleDiplome('O');
		formation.setN0Annee((short) 2);
		formation.setNomFormation("2eme Systeme informatique reseaux");
		formation.setDebutAccreditation(new java.util.Date(2011, 02, 03));
		formation.setFinAccreditation(new java.util.Date(11, 11, 2019));
		formationService.addFormation(formation);
		Formation f = formationService.getFormation("M2DOSIII");
		Assert.assertNotNull(f);
		Assert.assertEquals(formation, f);
	}
	
	

	/**
	 * @author Red1
	 * @Test de la méthode getPromotions
	 */
	@Test
	public void getPromotionsTest() {

		Iterable<Promotion> promotions = formationService.getPromotions("M2DOSIII");
		Assert.assertNotNull(promotions);
	}
	
	
	/**
	 * @author Red1
	 * @Test de la méthode listFormations
	 */
	
	@Test
	public void listFormationsTest() {

		Iterable<Formation> formations = formationService.listFormations();
		Assert.assertNotNull(formations);
	}
	
	
	
	/**
	 * @author Red1
	 * @test de la methode getFormation
	 * 
	 */
	@Test
	public void getFormationTest() {

		Formation formations = formationService.getFormation("M2DOSIII");
		Assert.assertNotNull(formations);
	}
	

	/**
	 * @author Red1
	 * @Test de la methode updateFormation
	 *
	 */
	@Test
	public void updateFormationTest() {

		Formation formation = new Formation();
		formation.setCodeFormation("M2DOSIII");
		formation.setDiplome("M");
		formation.setDoubleDiplome('N');
		formation.setN0Annee((short) 1);
		formation.setNomFormation("2eme annee Science de l'information...");
		formation.setDebutAccreditation(new java.util.Date(2011, 02, 03));
		formation.setFinAccreditation(new java.util.Date(11, 11, 2019));
		formationService.updateFormation(formation);
		Formation f = formationService.getFormation("M2DOSIII");
		Assert.assertNotNull(f);
		Assert.assertEquals(formation, f);
	}

	
	/**
	 * @author Red1
	 * @Test de la methode deleteFormation
	 * 
	 */
	@Test
	public void deleteFormationTest() {
		int size = Iterables.size(formationService.listFormations());
		formationService.deleteFormation("M2DOSIII");
		Assert.assertEquals(size - 1,
				Iterables.size(formationService.listFormations()));
	}
	

}