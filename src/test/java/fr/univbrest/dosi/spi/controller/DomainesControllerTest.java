package fr.univbrest.dosi.spi.controller;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

public class DomainesControllerTest {

	@Test
	public void getDomainByRvDomainTest() throws ClientProtocolException, IOException {
		String  rvDomain= "ROLE";
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet("http://localhost:8090/domaine/" + rvDomain);
		HttpResponse response = client.execute(request);
		Assert.assertEquals(200, response.getStatusLine().getStatusCode());
		// la requete est bonne sil retourne 200
	}

}
