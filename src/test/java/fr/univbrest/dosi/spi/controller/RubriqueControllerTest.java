package fr.univbrest.dosi.spi.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

/*
 import org.junit.runner.RunWith;
 import org.mockito.InjectMocks;
 import org.mockito.Mock;
 import org.mockito.runners.MockitoJUnitRunner;


 import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
 */
import fr.univbrest.dosi.spi.bean.Rubrique;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * 
 * @author Red1 15/03/2017
 * @Test du controller Rubrique
 *
 */
// @RunWith(MockitoJUnitRunner.class)

public class RubriqueControllerTest {
	/**
	 * Test de getAll
	 * 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Test
	public void getAllRubriqueTest() throws ClientProtocolException,
			IOException {

		final HttpClient client = HttpClientBuilder.create().build();
		final HttpGet mockRequest = new HttpGet(
				"http://localhost:8090/rubrique");
		final HttpResponse mockResponse = client.execute(mockRequest);

		Assert.assertEquals(200, mockResponse.getStatusLine().getStatusCode());

		BufferedReader rd;
		rd = new BufferedReader(new InputStreamReader(mockResponse.getEntity()
				.getContent()));
		final ObjectMapper mapper = new ObjectMapper();
		List<Rubrique> rubrique;
		rubrique = mapper.readValue(rd, ArrayList.class);
	}

	/**
	 * Test de UpdateRubrique
	 * 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */

	@Test
	public final void updateRubriqueTest() throws ClientProtocolException,
			IOException {

		Rubrique rub = new Rubrique();
		rub.setIdRubrique(3);
		rub.setDesignation("Cours");
		rub.setOrdre(BigInteger.valueOf(3));
		rub.setType("RBS");

		final HttpClient client = HttpClientBuilder.create().build();
		final HttpPost mockPost = new HttpPost("http://localhost:8090/rubrique");

		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

		String json = ow.writeValueAsString(rub);
		mockPost.addHeader("content-type", "application/json");
		mockPost.setEntity(new StringEntity(json));
		HttpResponse response = client.execute(mockPost);

		Assert.assertEquals(200, response.getStatusLine().getStatusCode());
	}

	/**
	 * Test de addRubrique
	 * 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Test
	public final void addRubriqueTest() throws ClientProtocolException,
			IOException {

		Rubrique rub = new Rubrique();
		rub.setIdRubrique(14);
		rub.setDesignation("Cours");
		rub.setOrdre(BigInteger.valueOf(14));
		rub.setType("RBS");

		final HttpClient client = HttpClientBuilder.create().build();
		final HttpPost mockPost = new HttpPost("http://localhost:8090/rubrique");

		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

		String json = ow.writeValueAsString(rub);
		mockPost.addHeader("content-type", "application/json");
		mockPost.setEntity(new StringEntity(json));
		HttpResponse response = client.execute(mockPost);

		Assert.assertEquals(200, response.getStatusLine().getStatusCode());
	}

	/**
	 * Test de deleteRubrique
	 * 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Test
	public final void deleteRubriqueTest() throws ClientProtocolException,
			IOException {

		Rubrique rub = new Rubrique();
		rub.setIdRubrique(33);
		rub.setOrdre(BigInteger.valueOf(33));
		rub.setDesignation("Cours");
		rub.setType("RBS");

		long id_rubrique = 33;

		final HttpClient client = HttpClientBuilder.create().build();
		final HttpPost mockPost = new HttpPost("http://localhost:8090/rubrique");

		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

		String json = ow.writeValueAsString(rub);
		mockPost.addHeader("content-type", "application/json");
		mockPost.setEntity(new StringEntity(json));
		HttpResponse response = client.execute(mockPost);

		Assert.assertEquals(200, response.getStatusLine().getStatusCode());

		final HttpDelete mockRequest = new HttpDelete(
				"http://localhost:8090/rubrique/delete/" + id_rubrique);
		final HttpResponse mockResponse = client.execute(mockRequest);

		Assert.assertEquals(200, mockResponse.getStatusLine().getStatusCode());
	}

}
