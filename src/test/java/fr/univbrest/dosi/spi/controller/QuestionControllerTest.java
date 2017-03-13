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

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.univbrest.dosi.spi.bean.Etudiant;
import fr.univbrest.dosi.spi.bean.Question;

public class QuestionControllerTest {
	Question q;

	@Before
	public void init() {
		q = new Question();
		q.setIdQuestion(new Long(26));
		q.setIdQualificatif(new BigDecimal(1));
		q.setIntitule("q1");
		q.setNoEnseignant(new BigDecimal(2));
		q.setType("QUS");

	}

	@Test
	public void addQuestionTest() throws ClientProtocolException, IOException {

		// Creation de qst et dune requete POST
		final HttpClient qst = HttpClientBuilder.create().build();
		final HttpPost mockRequestPost = new HttpPost(
				"http://localhost:8090/question");

		// creation de l'objet mapper afin de convertir l'objet en jsonInSTring
		final ObjectMapper mapper = new ObjectMapper();
		com.fasterxml.jackson.databind.ObjectWriter ow = mapper.writer()
				.withDefaultPrettyPrinter();
		String jsonInString = ow.writeValueAsString(q);

		// (header+body)
		mockRequestPost.addHeader("Content-Type", "application/json");
		mockRequestPost.setEntity(new StringEntity(jsonInString));

		// creation de la reponse
		final HttpResponse mockResponse = qst.execute(mockRequestPost);
		Assert.assertEquals(200, mockResponse.getStatusLine().getStatusCode());

	}

	@Test
	public void listerQuestionTest() throws ClientProtocolException,
			IOException {

		final HttpClient client = HttpClientBuilder.create().build();
		final HttpGet mockRequest = new HttpGet(
				"http://localhost:8090/question");
		final HttpResponse mockResponse = client.execute(mockRequest);

		// Le code retour HTTP doit être un succès (200)
		// Assert.assertEquals(200,mockResponse.getStatusLine().getStatusCode());

		final BufferedReader rd = new BufferedReader(new InputStreamReader(
				mockResponse.getEntity().getContent()));
		final ObjectMapper mapper = new ObjectMapper();
		final Iterable<Question> qst = mapper.readValue(rd, Iterable.class);

		Assert.assertNotNull(qst);

	}

	@Test
	public void getQuestionTest() throws ClientProtocolException, IOException {
		final HttpClient client = HttpClientBuilder.create().build();
		final HttpGet mockRequest = new HttpGet(
				"http://localhost:8090/question/1");
		final HttpResponse mockResponse = client.execute(mockRequest);
		Assert.assertEquals(200, mockResponse.getStatusLine().getStatusCode());
	}

	/*@Test
	public final void deleteQuestionTest() throws ClientProtocolException,
			IOException {

		// Creation de qst et dune requete POST
		final HttpClient qst = HttpClientBuilder.create().build();
		final HttpPost mockRequestPost = new HttpPost(
				"http://localhost:8090/question");

		// creation de l'objet mapper afin de convertir l'objet en jsonInSTring
		final ObjectMapper mapper = new ObjectMapper();
		com.fasterxml.jackson.databind.ObjectWriter ow = mapper.writer()
				.withDefaultPrettyPrinter();
		String jsonInString = ow.writeValueAsString(q);

		// (header+body)
		mockRequestPost.addHeader("Content-Type", "application/json");
		mockRequestPost.setEntity(new StringEntity(jsonInString));

		// creation de la reponse
		final HttpResponse mockResponse = qst.execute(mockRequestPost);
		Assert.assertEquals(200, mockResponse.getStatusLine().getStatusCode());

		// Création du client et éxécution d'une requete GET
		final HttpClient client = HttpClientBuilder.create().build();
		final HttpDelete mockRequest = new HttpDelete(
				"http://localhost:8090/question/delete/26");
		final HttpResponse mockResponseDelete = client.execute(mockRequest);

		// creation de l'objet mapper afin de convertir l'objet en jsonInSTring
		final ObjectMapper mapper = new ObjectMapper();
		com.fasterxml.jackson.databind.ObjectWriter ow = mapper.writer()
				.withDefaultPrettyPrinter();
		String jsonInString = ow.writeValueAsString(q);

		// (header+body)
		mockRequest.addHeader("Content-Type", "application/json");
		mockRequest.setEntity(new StringEntity(jsonInString));

		// Le code retour HTTP doit être un succès (200)
		Assert.assertEquals(200, mockResponse.getStatusLine().getStatusCode());

	}*/

	@Test
	public final void UpdateQuestionTest() throws ClientProtocolException,
			IOException {

		// Création du client et éxécution d'une requete Put
		final HttpClient client = HttpClientBuilder.create().build();
		final HttpPut mockRequest = new HttpPut(
				"http://localhost:8090/question");
		final HttpResponse mockResponse = client.execute(mockRequest);

		// Le code retour HTTP doit être un succès (200)
		Assert.assertEquals(200, mockResponse.getStatusLine().getStatusCode());

	}
}
