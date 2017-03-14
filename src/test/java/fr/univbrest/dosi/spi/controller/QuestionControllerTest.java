package fr.univbrest.dosi.spi.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;

import fr.univbrest.dosi.spi.bean.Etudiant;
import fr.univbrest.dosi.spi.bean.Question;
import fr.univbrest.dosi.spi.bean.Question;
import fr.univbrest.dosi.spi.service.QuestionService;

@RunWith(MockitoJUnitRunner.class)
public class QuestionControllerTest {
	
	@InjectMocks
	QuestionController QuestionController;

	@Mock
	QuestionService QuestionService;

	String url = "http://localhost:8090/question";

	@Test
	public void doitAjouterQuestion() throws ClientProtocolException,
			IOException
	{
		/**
		 * Instanciation d'un nouveau Question
		 */
		Question q = new Question();
		q = new Question();
		q.setIdQuestion(new Long(26));
		q.setIntitule("q1");
		q.setNoEnseignant(new BigDecimal(2));
		q.setType("QUS");
		
		/**
		 * Test de l'ajout du Question
		 */
		RestAssuredMockMvc.given().standaloneSetup(QuestionController)
				.contentType("application/json").body(q).when()
				.post(url).then().statusCode(200);
	}

	@Test
	public void doitModifierQuestion()
	{
		/**
		 * Instanciation d'un nouveau Question
		 */
		Question q = new Question();
		q.setIdQuestion(new Long(26));
		q.setIntitule("q1");
		q.setNoEnseignant(new BigDecimal(2));
		q.setType("QUS");
		

		/**
		 * Test de l'ajout du Question
		 */
		RestAssuredMockMvc.given().standaloneSetup(QuestionController)
				.contentType("application/json").body(q).when()
				.post(url).then().statusCode(200);

		/**
		 * Mise à jour de la réponse
		 */
		q.setIntitule("questionUp");

		/**
		 * Test de la mise à jour
		 */
		RestAssuredMockMvc.given().standaloneSetup(QuestionController)
				.contentType("application/json").body(q).when()
				.put(url).then().statusCode(200);
	}

	@Test
	public void doitSupprimerQuestion()
	{
		/**
		 * Instanciation d'un nouveau Question
		 */
		Question q = new Question();
		q.setIdQuestion(new Long(26));
		q.setIntitule("q1");
		q.setNoEnseignant(new BigDecimal(2));
		q.setType("QUS");
		
		/**
		 * Test de l'ajout du Question
		 */
		RestAssuredMockMvc.given().standaloneSetup(QuestionController)
				.contentType("application/json").body(q).when()
				.post(url).then().statusCode(200);

		/**
		 * Test de la suppression du Question
		 */
		RestAssuredMockMvc.given().standaloneSetup(QuestionController)
				.contentType("application/json").when().delete(url + "/delete/26")
				.then().statusCode(200);
	}

	@Test
	public void doitRecupererQuestion()
	{
		/**
		 * Instanciation d'un nouveau Question
		 */
		Question q = new Question();
		q.setIdQuestion(new Long(26));
		q.setIntitule("q1");
		q.setNoEnseignant(new BigDecimal(2));
		q.setType("QUS");
		
		/**
		 * Test de l'ajout du Question
		 */
		RestAssuredMockMvc.given().standaloneSetup(QuestionController)
				.contentType("application/json").body(q).when()
				.post(url).then().statusCode(200);
		
		/**
		 * Vérification du status de la requête
		 */
		RestAssured.given().when().get(url + "/26").then().statusCode(200);
	}

	@Test
	public void doitRecupererQuestions()
	{
		/**
		 * Vérification du status de la requête
		 */
		RestAssured.given().when().get(url).then().statusCode(200);
	}

}
