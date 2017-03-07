package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

import fr.univbrest.dosi.spi.bean.Enseignant;
import fr.univbrest.dosi.spi.service.EnseignantService;

/**
 * @author DOSI
 *
 */
public class EnseignantServiceTest {

	private static EnseignantService enseignantService = new EnseignantService();
	private final Enseignant enseignant = new Enseignant();

	@Test
	public final void addserviceTest() throws ClientProtocolException, IOException {

		final Enseignant enseignant = new Enseignant();
		enseignant.setNoEnseignant(7);
		enseignant.setNom("LAHNAKI");
		enseignant.setPrenom("Chakib");
		enseignant.setType("INT");
		enseignant.setSexe("H");
		enseignant.setAdresse("cite universitaire de kergoat");
		enseignant.setCodePostal("29200");
		enseignant.setVille("Brest");
		enseignant.setPays("FR");
		enseignant.setMobile("06.67.58.23.68");
		enseignant.setTelephone("06.67.58.23.00");
		enseignant.setEmailPerso("chakib.lahnaki@gmail.com");
		enseignant.setEmailUbo("chakib.lah@gmail.com");
		// Création du client et éxécution d'une requete GET
		final HttpClient client = HttpClientBuilder.create().build();
		final HttpPost mockRequestPost = new HttpPost("http://localhost:8090/ajouterEnseignant");
		final ObjectMapper mapper = new ObjectMapper();
		final com.fasterxml.jackson.databind.ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		final String jsonInString = ow.writeValueAsString(enseignant);
		mockRequestPost.addHeader("content-type", "application/json");
		mockRequestPost.setEntity(new StringEntity(jsonInString));

		// final HttpGet mockRequest = new HttpGet("http://localhost:8090/deleteEnseignant/7");
		// mapper.writeValue(new File("c:\\user.json"), enseignant);
		final HttpResponse mockResponse = client.execute(mockRequestPost);

		// Le code retour HTTP doit être un succès (200)
		Assert.assertEquals(200, mockResponse.getStatusLine().getStatusCode());

		/*
		 * final BufferedReader rd = new BufferedReader(new InputStreamReader(mockResponse.getEntity().getContent()));
		 * 
		 * Iterable<Enseignant> ens = mapper.readValue(rd, Iterable.class);
		 * 
		 * Assert.assertNotNull(ens);
		 */

	}

	@Test
	public final void deleteEnseignanrTest() throws ClientProtocolException, IOException {

		// Création du client et éxécution d'une requete GET
		final HttpClient client = HttpClientBuilder.create().build();
		final HttpGet mockRequest = new HttpGet("http://localhost:8090/deleteEnseignant/7");
		final HttpResponse mockResponse = client.execute(mockRequest);

		// Le code retour HTTP doit être un succès (200)
		Assert.assertEquals(200, mockResponse.getStatusLine().getStatusCode());

		final BufferedReader rd = new BufferedReader(new InputStreamReader(mockResponse.getEntity().getContent()));
		final ObjectMapper mapper = new ObjectMapper();
		final Iterable<Enseignant> ens = mapper.readValue(rd, Iterable.class);

		Assert.assertNotNull(ens);

	}

	@Test
	public final void listEnseignantTest() throws ClientProtocolException, IOException {

		// Création du client et éxécution d'une requete GET
		final HttpClient client = HttpClientBuilder.create().build();
		final HttpGet mockRequest = new HttpGet("http://localhost:8090/ens");
		final HttpResponse mockResponse = client.execute(mockRequest);

		// Le code retour HTTP doit être un succès (200)
		Assert.assertEquals(200, mockResponse.getStatusLine().getStatusCode());

		final BufferedReader rd = new BufferedReader(new InputStreamReader(mockResponse.getEntity().getContent()));
		final ObjectMapper mapper = new ObjectMapper();
		final Iterable<Enseignant> ens = mapper.readValue(rd, Iterable.class);

		Assert.assertNotNull(ens);

	}
	/*
	 * public void makeHTTPPOSTRequest() { try { HttpClient c = new DefaultHttpClient(); HttpPost p = new HttpPost(this.apiURL);
	 * 
	 * p.setEntity(new StringEntity("{\"username\":\"" + this.apiusername + "\",\"password\":\"" + this.apipassword + "\"}", ContentType.create("application/json")));
	 * 
	 * HttpResponse r = c.execute(p);
	 * 
	 * BufferedReader rd = new BufferedReader(new InputStreamReader(r.getEntity().getContent())); String line = ""; while ((line = rd.readLine()) != null) { //Parse our JSON response JSONParser j =
	 * new JSONParser(); JSONObject o = (JSONObject)j.parse(line); Map response = (Map)o.get("response");
	 * 
	 * System.out.println(response.get("somevalue")); } } catch(ParseException e) { System.out.println(e); } catch(IOException e) { System.out.println(e); } }
	 */

}
