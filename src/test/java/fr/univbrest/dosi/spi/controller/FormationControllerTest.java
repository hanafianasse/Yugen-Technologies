package fr.univbrest.dosi.spi.controller;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.univbrest.dosi.spi.bean.Formation;

public class FormationControllerTest {
	/**
	 * @author Red1
	 * @Test de la methode addFormation
	 * @throws ClientProtocolException
	 * @throws IOException
	 */

	@Test
	public void addFormationTest() throws ClientProtocolException, IOException {

		Formation formation = new Formation();
		formation.setCodeFormation("M2DOSIII");
		formation.setDiplome("M");
		formation.setDoubleDiplome('O');
		formation.setN0Annee((short) 2);
		formation.setNomFormation("Systemes Informatiques..");
		formation.setDebutAccreditation(new java.util.Date("10/10/2012"));
		formation.setFinAccreditation(new java.util.Date("10/10/2017"));

		// Creation du client et dune requete POST
		final HttpClient client = HttpClientBuilder.create().build();
		final HttpPost mockRequestPost = new HttpPost(
				"http://localhost:8090/formation/addFormation");
		
		// creation de l'objet mapper afin de convertir l'objet en jsonInSTring
		final ObjectMapper mapper = new ObjectMapper();
		com.fasterxml.jackson.databind.ObjectWriter ow = mapper.writer()
				.withDefaultPrettyPrinter();
		String jsonInString = ow.writeValueAsString(formation);
		System.err.println(jsonInString);

		// etablition de la requette (header+body)
		mockRequestPost.addHeader("content-type", "application/json");
		mockRequestPost.setEntity(new StringEntity(jsonInString));
		// creation de la reponse

		final HttpResponse mockResponse = client.execute(mockRequestPost);
		Assert.assertEquals(200, mockResponse.getStatusLine().getStatusCode());
		// la requete est bonne sil retourne 200
	}

	/**
	 * @author Red1
	 * @Test de la methode deleteFormation
	 * @throws ClientProtocolException
	 * @throws IOException
	 */

	@Test
	public void deleteFormationTest() throws ClientProtocolException,
			IOException {
		String codeFormation = "M2DD";
		HttpClient client = HttpClientBuilder.create().build();
		HttpDelete requestDelete = new HttpDelete(
				"http://localhost:8090/formation/delete/" + codeFormation);
		HttpResponse response = client.execute(requestDelete);
		Assert.assertEquals(200, response.getStatusLine().getStatusCode());
		// la requete est bonne sil retourne 200
	}

	/**
	 * @author Red1
	 * @test de la methode getFormation
	 * 
	 */
	@Test
	public void getFormationTest() throws ClientProtocolException, IOException {
		String codeFormation = "M2DOSI";
		HttpClient client = HttpClientBuilder.create().build();
		HttpDelete request = new HttpDelete("http://localhost:8090/formation/"
				+ codeFormation);
		HttpResponse response = client.execute(request);
		Assert.assertEquals(200, response.getStatusLine().getStatusCode());
		// la requete est bonne sil retourne 200
	}
	/**
	 * @author Red1
	 * @throws ClientProtocolException
	 * @throws IOException
	 */

	@Test
	public void listFormationTest() throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpDelete request = new HttpDelete("http://localhost:8090/formations");
		HttpResponse response = client.execute(request);
		Assert.assertEquals(200, response.getStatusLine().getStatusCode());
		// la requete est bonne sil retourne 200
	}

}
