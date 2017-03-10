package fr.univbrest.dosi.spi.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.univbrest.dosi.spi.bean.Enseignant;
import fr.univbrest.dosi.spi.bean.Etudiant;
import fr.univbrest.dosi.spi.bean.Formation;
import fr.univbrest.dosi.spi.bean.Promotion;
import fr.univbrest.dosi.spi.bean.PromotionEtudiant;
import fr.univbrest.dosi.spi.bean.PromotionPK;

public class EtudiantControllerTest {
	String noEtudiant;

	@Before
	public void init() {

		noEtudiant = "14578999";

	}

	@Test
	public void addEtudiantTest() throws ClientProtocolException, IOException {

		Formation formation = new Formation();
		formation.setCodeFormation("M2DOSI");

		Promotion promotion = new Promotion();
		promotion.setPromotionPK(new PromotionPK("M2DOSI", "2013-2014"));
		promotion.setFormation(formation);

		Etudiant etudiant = new Etudiant();
		etudiant.setNoEtudiant("14578999");
		etudiant.setNom("HASSOUNI");
		etudiant.setPrenom("amal");
		etudiant.setSexe("F");
		etudiant.setDateNaissance(new Date("12/12/1994"));
		etudiant.setLieuNaissance("Agadir");
		etudiant.setNationalite("marocaine");
		etudiant.setTelephone("0669995571");
		etudiant.setMobile("0669995571");
		etudiant.setEmail("amalhassouni@gmail.com");
		etudiant.setEmailUbo("amalhassouni@univ-brest.com");
		etudiant.setAdresse("cite U kergoat");
		etudiant.setCodePostal("29200");
		etudiant.setVille("brest");
		etudiant.setPaysOrigine("maroc");
		etudiant.setUniversiteOrigine("UIZ");
		etudiant.setGroupeAnglais(BigInteger.valueOf(1));
		etudiant.setGroupeTp(BigInteger.valueOf(2));

		PromotionEtudiant promotionEtudiant = new PromotionEtudiant();
		promotionEtudiant.setEtudiant(etudiant);
		promotionEtudiant.setPromotion(promotion);

		// Creation du client et dune requete POST
		final HttpClient client = HttpClientBuilder.create().build();
		final HttpPost mockRequestPost = new HttpPost(
				"http://localhost:8090/etudiant");

		// creation de l'objet mapper afin de convertir l'objet en jsonInSTring
		final ObjectMapper mapper = new ObjectMapper();
		com.fasterxml.jackson.databind.ObjectWriter ow = mapper.writer()
				.withDefaultPrettyPrinter();
		String jsonInString = ow.writeValueAsString(promotionEtudiant);
		//System.err.println(jsonInString);

		//Etudiant etu = mapper.readValue(jsonInString, Etudiant.class);

		// etablition de la requette (header+body)
		mockRequestPost.addHeader("Content-Type", "application/json");
		//mockRequestPost.addHeader("Accepts", "application/json");
		mockRequestPost.setEntity(new StringEntity(jsonInString));
		
		// creation de la reponse
		final HttpResponse mockResponse = client.execute(mockRequestPost);
		Assert.assertEquals(200, mockResponse.getStatusLine().getStatusCode());
	}

	
	  @Test public void listeEtudiantTest() throws ClientProtocolException,
	 IOException {
	  
	  final HttpClient client = HttpClientBuilder.create().build(); final
	 HttpGet mockRequest = new HttpGet("http://localhost:8090/etudiant");
	 final HttpResponse mockResponse = client.execute(mockRequest);
	 
	  // Le code retour HTTP doit être un succès (200) Assert.assertEquals(200,mockResponse.getStatusLine().getStatusCode());
	  
	  final BufferedReader rd = new BufferedReader(new
	  InputStreamReader(mockResponse.getEntity().getContent())); final
	  ObjectMapper mapper = new ObjectMapper(); final Iterable<Etudiant>
	  etudiant = mapper.readValue(rd, Iterable.class);
	  
	  Assert.assertNotNull(etudiant);
	  
	  }
	 
	  @Test public void recupererEtudiantTest() throws ClientProtocolException,
	  IOException{ final HttpClient client=HttpClientBuilder.create().build();
	  final HttpGet mockRequest= new
	  HttpGet("http://localhost:8090/etudiant/"+noEtudiant); final
	  HttpResponse mockResponse = client.execute(mockRequest);
	  Assert.assertEquals(200, mockResponse.getStatusLine().getStatusCode()); }
	 
	
	@Test
	public final void deleteEtudiantTest() throws ClientProtocolException, IOException {
	
		// Création du client et éxécution d'une requete GET
		final HttpClient client = HttpClientBuilder.create().build();
		final HttpGet mockRequest = new HttpGet("http://localhost:8090/etudiant/delete/"+noEtudiant);
		final HttpResponse mockResponse = client.execute(mockRequest);
	
		// Le code retour HTTP doit être un succès (200)
		Assert.assertEquals(200, mockResponse.getStatusLine().getStatusCode());
	
	
	
	}
}
