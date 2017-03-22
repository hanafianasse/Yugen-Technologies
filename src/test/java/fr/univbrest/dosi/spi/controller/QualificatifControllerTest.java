/**
 * 
 */
package fr.univbrest.dosi.spi.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;

import fr.univbrest.dosi.spi.bean.Qualificatif;
import fr.univbrest.dosi.spi.service.QualificatifService;

/**
 * @author Chobaz
 *
 *         10 mars 2017
 */
@RunWith(MockitoJUnitRunner.class)
public class QualificatifControllerTest
{
	@InjectMocks
	QualificatifController qualificatifController;

	@Mock
	QualificatifService qualificatifService;

	String url = "http://localhost:8090/qualificatif";

	@Test
	public void doitAjouterQualificatif()
	{
		/**
		 * Instanciation d'un nouveau qualificatif
		 */
		Qualificatif qualificatif = new Qualificatif();
		qualificatif.setMaximal("Expert");
		qualificatif.setMinimal("Newbie");

		/**
		 * Test de l'ajout du qualificatif
		 */
		RestAssuredMockMvc.given().standaloneSetup(qualificatifController)
				.contentType("application/json").body(qualificatif).when()
				.post(url).then().statusCode(200);
	}

	@Test
	public void doitModifierQualificatif()
	{
		/**
		 * Instanciation d'un nouveau qualificatif
		 */
		Qualificatif qualificatif = new Qualificatif();
		qualificatif.setIdQualificatif(9999);
		qualificatif.setMaximal("Expert");
		qualificatif.setMinimal("Newbie");

		/**
		 * Test de l'ajout du qualificatif
		 */
		RestAssuredMockMvc.given().standaloneSetup(qualificatifController)
				.contentType("application/json").body(qualificatif).when()
				.post(url).then().statusCode(200);

		/**
		 * Mise à jour de la réponse
		 */
		qualificatif.setMinimal("Noob");

		/**
		 * Test de la mise à jour
		 */
		RestAssuredMockMvc.given().standaloneSetup(qualificatifController)
				.contentType("application/json").body(qualificatif).when()
				.put(url).then().statusCode(200);
	}

	@Test
	public void doitSupprimerQualificatif()
	{
		/**
		 * Instanciation d'un nouveau qualificatif
		 */
		Qualificatif qualificatif = new Qualificatif();
		qualificatif.setIdQualificatif(9999);
		qualificatif.setMaximal("Expert");
		qualificatif.setMinimal("Newbie");

		/**
		 * Test de l'ajout du qualificatif
		 */
		RestAssuredMockMvc.given().standaloneSetup(qualificatifController)
				.contentType("application/json").body(qualificatif).when()
				.post(url).then().statusCode(200);

		/**
		 * Test de la suppression du qualificatif
		 */
		RestAssuredMockMvc.given().standaloneSetup(qualificatifController)
				.contentType("application/json").when().delete(url + "/9999")
				.then().statusCode(200);
	}

	@Test
	public void doitRecupererQualificatif()
	{
		/**
		 * Instanciation d'un nouveau qualificatif
		 */
		Qualificatif qualificatif = new Qualificatif();
		qualificatif.setIdQualificatif(9999);
		qualificatif.setMaximal("Expert");
		qualificatif.setMinimal("Newbie");
		
		/**
		 * Test de l'ajout du qualificatif
		 */
		RestAssuredMockMvc.given().standaloneSetup(qualificatifController)
				.contentType("application/json").body(qualificatif).when()
				.post(url).then().statusCode(200);
		
		/**
		 * Vérification du status de la requête
		 */
		RestAssured.given().when().get(url + "/9999").then().statusCode(200);
	}

	@Test
	public void doitRecupererQualificatifs()
	{
		/**
		 * Vérification du status de la requête
		 */
		RestAssured.given().when().get(url).then().statusCode(200);
	}

}
