package fr.univbrest.dosi.spi.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



import java.util.Date;

import junit.framework.Assert;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.univbrest.dosi.spi.bean.Formation;
import fr.univbrest.dosi.spi.bean.Promotion;
import fr.univbrest.dosi.spi.bean.PromotionPK;


/**
 * @author DOSI
 *
 */

public class PromotionControllerTest {

	/*@Test
	public void addpromotionTest() throws ClientProtocolException, IOException {

		final Promotion promotion = new Promotion();
		
		Formation formation = new Formation();
		formation.setCodeFormation("M2DOSI");
		promotion.setFormation(formation);
		
		promotion.setNbMaxEtudiant((short) 25);
		promotion.setSiglePromotion("M2DOSI");
		promotion.setDateRentree(new Date("12/12/1994"));
		promotion.setLieuRentree("LC117B");
		
		// Creation du client et dune requete POST
				final HttpClient client = HttpClientBuilder.create().build();
				final HttpPost mockRequestPost = new HttpPost(
						"http://localhost:8090/promotions");
				
				// creation de l'objet mapper afin de convertir l'objet en jsonInSTring
				final ObjectMapper mapper = new ObjectMapper();
				com.fasterxml.jackson.databind.ObjectWriter ow = mapper.writer()
						.withDefaultPrettyPrinter();
				String jsonInString = ow.writeValueAsString(promotion);
				mockRequestPost.addHeader("Content-Type", "application/json");
				//mockRequestPost.addHeader("Accepts", "application/json");
				mockRequestPost.setEntity(new StringEntity(jsonInString));
				
				// creation de la reponse
				final HttpResponse mockResponse = client.execute(mockRequestPost);
				Assert.assertEquals(200, mockResponse.getStatusLine().getStatusCode());
			}

	@Test public void listPromotionsTest() throws ClientProtocolException,
	 IOException {
	  
	  final HttpClient client = HttpClientBuilder.create().build(); final
	 HttpGet mockRequest = new HttpGet("http://localhost:8090/promotions");
	 final HttpResponse mockResponse = client.execute(mockRequest);
	 
	  // Le code retour HTTP doit être un succès (200) Assert.assertEquals(200,mockResponse.getStatusLine().getStatusCode());
	  
	  final BufferedReader rd = new BufferedReader(new
	  InputStreamReader(mockResponse.getEntity().getContent())); final
	  ObjectMapper mapper = new ObjectMapper(); final Iterable<Promotion>
	  promotion = mapper.readValue(rd, Iterable.class);
	  
	  Assert.assertNotNull(promotion);
	  
	  }*/
	
	
	
	
	
	
	
		
}  
