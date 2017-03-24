package fr.univbrest.dosi.spi.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.junit.Test;

import fr.univbrest.dosi.spi.bean.Evaluation;
import fr.univbrest.dosi.spi.bean.Rubrique;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;




public class EvaluationControllerTest {
	
	@Test
	public void getAllEvaluationTest() throws ClientProtocolException,
			IOException {

		final HttpClient client = HttpClientBuilder.create().build();
		final HttpGet mockRequest = new HttpGet(
				"http://localhost:8090/evaluation");
		final HttpResponse mockResponse = client.execute(mockRequest);

		Assert.assertEquals(200, mockResponse.getStatusLine().getStatusCode());

		BufferedReader rd;
		rd = new BufferedReader(new InputStreamReader(mockResponse.getEntity()
				.getContent()));
		final ObjectMapper mapper = new ObjectMapper();
		List<Rubrique> rubrique;
		rubrique = mapper.readValue(rd, ArrayList.class);
	}


	
	
	

	@Test
	public final void updateEvaluationTest() throws ClientProtocolException,
			IOException {

		
		Evaluation eval = new Evaluation();
		eval.setAnneeUniversitaire("2014-2015");
		eval.setCodeFormation("M2DOSI");
		eval.setCodeUe("J2EE");
		eval.setDebutReponse(new Date ("02/03/2015"));
		eval.setDesignation("zezeeze");
		eval.setEtat("ELA");
		eval.setFinReponse(new Date ("06/04/2015"));
		eval.setIdEvaluation(38);
		eval.setNoEnseignant(BigDecimal.valueOf(1));
		eval.setNoEvaluation(BigDecimal.valueOf(1));
		eval.setPeriode("testdfdf");
		

		final HttpClient client = HttpClientBuilder.create().build();
		final HttpPut mockPost = new HttpPut("http://localhost:8090/evaluation/updateEvaluation");

		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

		String json = ow.writeValueAsString(eval);
		mockPost.addHeader("content-type", "application/json");
		mockPost.setEntity(new StringEntity(json));
		HttpResponse response = client.execute(mockPost);

		Assert.assertEquals(200, response.getStatusLine().getStatusCode());
	}

	
	
	
	@Test
	public final void addEvaluationTest() throws ClientProtocolException,
			IOException {

		Evaluation eval = new Evaluation();
		eval.setAnneeUniversitaire("2014-2015");
		eval.setCodeFormation("M2DOSI");
		eval.setCodeUe("J2EE");
		eval.setDebutReponse(new Date ("02/03/2015"));
		eval.setDesignation("zezezezeze");
		eval.setEtat("ELA");
		eval.setFinReponse(new Date ("06/04/2015"));
		eval.setIdEvaluation(10);
		eval.setNoEnseignant(BigDecimal.valueOf(1));
		eval.setNoEvaluation(BigDecimal.valueOf(1));
		eval.setPeriode("test");

		final HttpClient client = HttpClientBuilder.create().build();
		final HttpPost mockPost = new HttpPost("http://localhost:8090/evaluation/addEvaluation");

		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

		String json = ow.writeValueAsString(eval);
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
		long IdEvaluation=45;

		final HttpClient client = HttpClientBuilder.create().build();

		final HttpDelete mockRequest = new HttpDelete(
				"http://localhost:8090/evaluation/delete/" + IdEvaluation);
		final HttpResponse mockResponse = client.execute(mockRequest);

		Assert.assertEquals(200, mockResponse.getStatusLine().getStatusCode());
	}

}
