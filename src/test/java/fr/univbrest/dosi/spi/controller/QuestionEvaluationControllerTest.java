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

import fr.univbrest.dosi.spi.bean.QuestionEvaluation;
import fr.univbrest.dosi.spi.service.QuestionEvaluationService;

/**
 * 21 mars 2017
 */
@RunWith(MockitoJUnitRunner.class)
public class QuestionEvaluationControllerTest
{
	@InjectMocks
	QuestionEvaluationController questionEvaluationController;

	@Mock
	QuestionEvaluationService questionEvaluationService;

	String url = "http://localhost:8090/questionEvaluation";

	@Test
	public void doitAjouterQuestionEvaluation()
	{
		/**
		 * Instanciation d'une question en se basant sur le jeu d'essai
		 */
		QuestionEvaluation questionEvaluation = new QuestionEvaluation();
		
		questionEvaluation.setIdQualificatif(new BigDecimal(1));
		questionEvaluation.setIdQuestion(new BigDecimal(1));
		questionEvaluation.setIdRubriqueEvaluation(new BigDecimal(1));
		questionEvaluation.setIntitule("Que1");
		questionEvaluation.setOrdre(new BigDecimal(1));

		/**
		 * Test de l'ajout
		 */
		RestAssuredMockMvc.given()
				.standaloneSetup(questionEvaluationController)
				.contentType("application/json").body(questionEvaluation)
				.when().post(url).then().statusCode(200);

	}

	@Test
	public void doitModifierQuestionEvaluation()
	{
		/**
		 * Instanciation d'une question en se basant sur le jeu d'essai
		 */
		QuestionEvaluation questionEvaluation = new QuestionEvaluation();

		questionEvaluation.setIdQualificatif(new BigDecimal(1));
		questionEvaluation.setIdQuestion(new BigDecimal(1));
		questionEvaluation.setIdRubriqueEvaluation(new BigDecimal(1));
		questionEvaluation.setIntitule("Que1");
		questionEvaluation.setOrdre(new BigDecimal(1));
		
		/**
		 * Test de l'ajout
		 */
		RestAssuredMockMvc.given()
				.standaloneSetup(questionEvaluationController)
				.contentType("application/json").body(questionEvaluation)
				.when().post(url).then().statusCode(200);

		/**
		 * Mise à jour de l'évaluation
		 */
		questionEvaluation.setIdQualificatif(new BigDecimal(2));
		questionEvaluation.setIdQuestion(new BigDecimal(2));
		questionEvaluation.setIntitule("Que2");

		/**
		 * Test de la mise à jour
		 */
		RestAssuredMockMvc.given()
				.standaloneSetup(questionEvaluationController)
				.contentType("application/json").body(questionEvaluation)
				.when().put(url).then().statusCode(200);

	}

	@Test
	public void doitSupprimerQuestionEvaluation()
	{
		/**
		 * Instanciation d'une question en se basant sur le jeu d'essai
		 */
		QuestionEvaluation questionEvaluation = new QuestionEvaluation();

		questionEvaluation.setIdQualificatif(new BigDecimal(1));
		questionEvaluation.setIdQuestion(new BigDecimal(1));
		questionEvaluation.setIdRubriqueEvaluation(new BigDecimal(1));
		questionEvaluation.setIntitule("Que1");
		questionEvaluation.setOrdre(new BigDecimal(1));

		/**
		 * Test de l'ajout
		 */
		RestAssuredMockMvc.given()
				.standaloneSetup(questionEvaluationController)
				.contentType("application/json").body(questionEvaluation)
				.when().post(url).then().statusCode(200);

		/**
		 * Test de la suppression
		 */
		RestAssuredMockMvc
				.given()
				.standaloneSetup(questionEvaluationController)
				.contentType("application/json")
				.body(questionEvaluation)
				.when()
				.delete(url + "/"
						+ questionEvaluation.getIdQuestionEvaluation()).then()
				.statusCode(200);
	}

	@Test
	public void doitRecupererQuestionEvaluation()
	{
		/**
		 * Test de la récupération
		 */
		RestAssuredMockMvc.given()
				.standaloneSetup(questionEvaluationController).when()
				.get(url + "/1").then().statusCode(200);
	}

	@Test
	public void doitRecupererQuestionEvaluations()
	{
		/**
		 * Test de la récupération
		 */
		RestAssuredMockMvc.given()
				.standaloneSetup(questionEvaluationController).when().get(url)
				.then().statusCode(200);
	}

}
