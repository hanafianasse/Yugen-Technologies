package fr.univbrest.dosi.spi.controller;

import java.io.IOException;
import java.math.BigInteger;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;

import fr.univbrest.dosi.spi.bean.Rubrique;
import fr.univbrest.dosi.spi.service.RubriqueService;


/**
 * 
 * @author Red1
 * 14/03/2017
 * @Test du controller Rubrique
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class RubriqueControllerTest {
	@InjectMocks
	RubriqueController rubriqueController;

	@Mock
	RubriqueService rubriqueService;

	String url = "http://localhost:8090/rubrique";

	@Test
	public void doitAjouterRubrique (){
		/**
		 * Instanciation d'uen nouvelle rubrique 
		 */
		
		Rubrique rubrique = new Rubrique();
		
		rubrique.setDesignation("Cours");
		rubrique.setType("RBS");
		rubrique.setDesignation("TD");
	//	rubrique.setOrdre(BigInteger.valueOf(10));
		rubrique.setIdRubrique(40);
	
		
		/**
		 * @Test de l'ajout de rubrique
		 */
		
		RestAssuredMockMvc.given().standaloneSetup(rubriqueController)
		.contentType("application/json").body(rubrique).when()
		.post(url).then().statusCode(200);

		
		
		
		
	}
	
	
	

}
