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

import fr.univbrest.dosi.spi.bean.UniteEnseignement;
import fr.univbrest.dosi.spi.bean.UniteEnseignementPK;
import fr.univbrest.dosi.spi.service.UniteEnseignementService;

/**
 * @author Chobaz
 *
 * 23 mars 2017
 */
@RunWith(MockitoJUnitRunner.class)
public class UniteEnseignementControllerTest
{
	@InjectMocks
	UniteEnseignementController uniteEnseignementController;

	@Mock
	UniteEnseignementService uniteEnseignementService;

	String url = "http://localhost:8090/uniteEnseignement";

	@Test
	public void doitAjouterUniteEnseignement()
	{
		/**
		 * Instanciation d'un nouveau uniteEnseignement
		 */
		String uniteEnseignement = "{" +
			    						"\"uniteEnseignementPK\": {" +
			    							"\"codeFormation\": \"M2DOSI\"," +
		    								"\"codeUe\": \"UE1\"" +
	    								"}," +
	    								
	    								"\"designation\": \"Unité d'enseignement 1\"," +
	    								"\"semestre\": \"9  \"," +
	    								"\"description\": null," +
	    								"\"nbhCm\": 20," +
	    								"\"nbhTd\": 20," +
	    								"\"nbhTp\": 20," +
	    								
	    								"\"noEnseignant\": {" +
	    									"\"noEnseignant\": 1," +
	    									"\"type\": \"MCF\"," +
	    									"\"sexe\": \"H\"," +
	    									"\"nom\": \"Saliou\"," +
	    									"\"prenom\": \"Philippe\"," +
	    									"\"adresse\": \"6 rue de l'Argoat\"," +
	    									"\"codePostal\": \"29860\"," +
	    									"\"ville\": \"LE DRENNEC\"," +
	    									"\"pays\": \"FR\"," +
	    									"\"mobile\": \"06.29.24.01.00\"," +
	    									"\"telephone\": \"02.98.01.69.74\"," +
	    									"\"emailUbo\": \"philippe.saliou@univ-brest.fr\"," +
	    									"\"emailPerso\": \"philippe.saliou@gmail.com\"" +
    									"}," +
	    									
										"\"formation\": {" +
											"\"codeFormation\": \"M2DOSI\"," +
											"\"diplome\": \"M\"," +
											"\"n0Annee\": 2," +
											"\"nomFormation\": \"Master Développement à l'Offshore des Systèmes d'Information\"," +
											"\"doubleDiplome\": \"O\"," +
											"\"debutAccreditation\": 1346450400000," +
											"\"finAccreditation\": 1506722400000" +
										"}" +
									"}";

		/**
		 * Test de l'ajout du uniteEnseignement
		 */
		RestAssuredMockMvc.given().standaloneSetup(uniteEnseignementController)
				.contentType("application/json").body(uniteEnseignement).when()
				.post(url).then().statusCode(200);
	}

	@Test
	public void doitModifierUniteEnseignement()
	{
		/**
		 * Instanciation d'un nouveau uniteEnseignement
		 */
	

		/**
		 * Test de l'ajout du uniteEnseignement
		 */
//		RestAssuredMockMvc.given().standaloneSetup(uniteEnseignementController)
//				.contentType("application/json").body(uniteEnseignement).when()
//				.post(url).then().statusCode(200);

		/**
		 * Mise à jour de la réponse
		 */
		

		/**
		 * Test de la mise à jour
		 */
//		RestAssuredMockMvc.given().standaloneSetup(uniteEnseignementController)
//				.contentType("application/json").body(uniteEnseignement).when()
//				.put(url).then().statusCode(200);
	}

	@Test
	public void doitSupprimerUniteEnseignement()
	{
		/**
		 * Instanciation d'un nouveau uniteEnseignement
		 */
		

		/**
		 * Test de l'ajout du uniteEnseignement
		 */
//		RestAssuredMockMvc.given().standaloneSetup(uniteEnseignementController)
//				.contentType("application/json").body(uniteEnseignement).when()
//				.post(url).then().statusCode(200);

		/**
		 * Test de la suppression du uniteEnseignement
		 */
//		RestAssuredMockMvc.given().standaloneSetup(uniteEnseignementController)
//				.contentType("application/json").when().delete(url + "/9999")
//				.then().statusCode(200);
	}

	@Test
	public void doitRecupererUniteEnseignement()
	{
		/**
		 * Instanciation d'un nouveau uniteEnseignement
		 */
		
		/**
		 * Test de l'ajout du uniteEnseignement
		 */
//		RestAssuredMockMvc.given().standaloneSetup(uniteEnseignementController)
//				.contentType("application/json").body(uniteEnseignement).when()
//				.post(url).then().statusCode(200);
		
		/**
		 * Vérification du status de la requête
		 */
//		RestAssured.given().when().get(url + "/9999").then().statusCode(200);
	}

	@Test
	public void doitRecupererUniteEnseignements()
	{
		/**
		 * Vérification du status de la requête
		 */
		RestAssured.given().when().get(url).then().statusCode(200);
	}

}
