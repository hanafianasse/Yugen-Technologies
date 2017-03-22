/**
 * 
 */
package fr.univbrest.dosi.spi.controller;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;

import fr.univbrest.dosi.spi.bean.RubriqueEvaluation;
import fr.univbrest.dosi.spi.service.RubriqueEvaluationService;

/**
 * 21 mars 2017
 */
@RunWith(MockitoJUnitRunner.class)
public class RubriqueEvaluationControllerTest
{
	@InjectMocks
	RubriqueEvaluationController rubriqueEvaluationController;

	@Mock
	RubriqueEvaluationService rubriqueEvaluationService;

	String url = "http://localhost:8090/rubriqueEvaluation";

	@Test
	public void doitAjouterRubriqueEvaluation()
	{
		/**
		 * Instanciation d'une rubrique en se basant sur le jeu d'essai
		 */
		RubriqueEvaluation rubriqueEvaluation = new RubriqueEvaluation();

		rubriqueEvaluation.setOrdre(new BigDecimal(5));
		rubriqueEvaluation.setDesignation("Rub5");
		rubriqueEvaluation.setIdEvaluation(new BigDecimal(1));
		rubriqueEvaluation.setIdRubrique(new BigDecimal(1));

		/**
		 * Test de l'ajout
		 */
		RestAssuredMockMvc.given()
				.standaloneSetup(rubriqueEvaluationController)
				.contentType("application/json").body(rubriqueEvaluation)
				.when().post(url).then().statusCode(200);

	}

	@Test
	public void doitModifierRubriqueEvaluation()
	{
		/**
		 * Instanciation d'une rubrique en se basant sur le jeu d'essai
		 */
		RubriqueEvaluation rubriqueEvaluation = new RubriqueEvaluation();

		rubriqueEvaluation.setOrdre(new BigDecimal(5));
		rubriqueEvaluation.setDesignation("Rub5");
		rubriqueEvaluation.setIdEvaluation(new BigDecimal(1));
		rubriqueEvaluation.setIdRubrique(new BigDecimal(1));

		/**
		 * Test de l'ajout
		 */
		RestAssuredMockMvc.given()
				.standaloneSetup(rubriqueEvaluationController)
				.contentType("application/json").body(rubriqueEvaluation)
				.when().post(url).then().statusCode(200);

		/**
		 * Mise à jour de l'évaluation
		 */
		rubriqueEvaluation.setOrdre(new BigDecimal(5));
		rubriqueEvaluation.setDesignation("Rub5");

		/**
		 * Test de la mise à jour
		 */
		RestAssuredMockMvc.given()
				.standaloneSetup(rubriqueEvaluationController)
				.contentType("application/json").body(rubriqueEvaluation)
				.when().put(url).then().statusCode(200);

	}

	@Test
	public void doitSupprimerRubriqueEvaluation()
	{
		/**
		 * Instanciation d'une rubrique en se basant sur le jeu d'essai
		 */
		RubriqueEvaluation rubriqueEvaluation = new RubriqueEvaluation();

		rubriqueEvaluation.setOrdre(new BigDecimal(5));
		rubriqueEvaluation.setDesignation("Rub5");
		rubriqueEvaluation.setIdEvaluation(new BigDecimal(1));
		rubriqueEvaluation.setIdRubrique(new BigDecimal(1));

		/**
		 * Test de l'ajout
		 */
		RestAssuredMockMvc.given()
				.standaloneSetup(rubriqueEvaluationController)
				.contentType("application/json").body(rubriqueEvaluation)
				.when().post(url).then().statusCode(200);

		/**
		 * Test de la suppression
		 */
		RestAssuredMockMvc
				.given()
				.standaloneSetup(rubriqueEvaluationController)
				.contentType("application/json")
				.body(rubriqueEvaluation)
				.when()
				.delete(url + "/"
						+ rubriqueEvaluation.getIdRubriqueEvaluation()).then()
				.statusCode(200);
	}

	@Test
	public void doitRecupererRubriqueEvaluation()
	{
		/**
		 * Test de la récupération
		 */
		RestAssuredMockMvc.given()
				.standaloneSetup(rubriqueEvaluationController).when()
				.get(url + "/1").then().statusCode(200);
	}

	@Test
	public void doitRecupererRubriqueEvaluations()
	{
		/**
		 * Test de la récupération
		 */
		RestAssuredMockMvc.given()
				.standaloneSetup(rubriqueEvaluationController).when().get(url)
				.then().statusCode(200);
	}

}
