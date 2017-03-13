/**
 * 
 */
package fr.univbrest.dosi.spi.controller;

import java.io.IOException;

import junit.framework.Assert;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import fr.univbrest.dosi.spi.bean.Qualificatif;

/**
 * @author Chobaz
 *
 * 10 mars 2017
 */
public class QualificatifControllerTest
{
	private String url = "http://localhost:8090/qualificatif";
	
	@Test
	public void doitAjouterQualificatif() throws ClientProtocolException, IOException
	{
		/**
		 * Instanciation d'un nouveau qualificatif
		 */
		Qualificatif qualificatif = new Qualificatif();
		
		qualificatif.setMinimal("Newbie");
		qualificatif.setMaximal("Expert");
		
		/**
		 * Instanciation du client et de la requete
		 */
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost mockRequestPost = new HttpPost(this.url);
		
		/**
		 * Instanciation des objets necessaires au mapping objet --> String json
		 */
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String jsonInString = ow.writeValueAsString(qualificatif);
		
		/**
		 * Parametrage de la requete
		 */
		mockRequestPost.addHeader("Content-Type", "application/json");
		mockRequestPost.setEntity(new StringEntity(jsonInString));
		
		/**
		 * Création de la reponse
		 */
		HttpResponse mockResponse = client.execute(mockRequestPost);
		
		/**
		 * Test de l'ajout du qualificatif
		 */
		Assert.assertEquals(200, mockResponse.getStatusLine().getStatusCode());
	}
	
	@Test
	public void doitModifierQualificatif()
	{
		
	}
	
	@Test
	public void doitSupprimerQualificatif()
	{
		
	}
	
	@Test
	public void doitRecupererQualificatif()
	{
		
	}
	
	@Test 
	public void doitRecupererQualificatifs()
	{
		
	}

}
