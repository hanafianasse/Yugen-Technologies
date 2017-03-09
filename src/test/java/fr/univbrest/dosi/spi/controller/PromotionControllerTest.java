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
import fr.univbrest.dosi.spi.bean.Promotion;
import fr.univbrest.dosi.spi.service.EnseignantService;
import fr.univbrest.dosi.spi.service.PromotionService;

public class PromotionControllerTest {

	private static PromotionService promotionservice = new PromotionService();
	private final Promotion promotion = new Promotion();

	@Test
	public void addserviceTest() throws ClientProtocolException, IOException {

		final Promotion promotion = new Promotion();
		promotion.setNbMaxEtudiant((short) 25);
		promotion.setSiglePromotion("M2DOSIII");
		
		// Création du client et éxécution d'une requete GET
		final HttpClient client = HttpClientBuilder.create().build();
		final HttpPost mockRequestPost = new HttpPost("http://localhost:8090/ajouterPromotion");
		final ObjectMapper mapper = new ObjectMapper();
		final com.fasterxml.jackson.databind.ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		final String jsonInString = ow.writeValueAsString(promotion);
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


	@Test
	public final void listPromotionsTest() throws ClientProtocolException, IOException {

		// Création du client et éxécution d'une requete GET
		final HttpClient client = HttpClientBuilder.create().build();
		final HttpGet mockRequest = new HttpGet("http://localhost:8090/pro");
		final HttpResponse mockResponse = client.execute(mockRequest);

		// Le code retour HTTP doit être un succès (200)
		Assert.assertEquals(200, mockResponse.getStatusLine().getStatusCode());

		final BufferedReader rd = new BufferedReader(new InputStreamReader(mockResponse.getEntity().getContent()));
		final ObjectMapper mapper = new ObjectMapper();
		final Iterable<Promotion> pro = mapper.readValue(rd, Iterable.class);

		Assert.assertNotNull(pro);

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
	
	@Test
	public final void deletePromotionTest() throws ClientProtocolException, IOException {
	
		// Création du client et éxécution d'une requete GET
		final HttpClient client = HttpClientBuilder.create().build();
		final HttpGet mockRequest = new HttpGet("http://localhost:8090/deletePromotion/{codeFormation}/{anneeUniversitaire}");
		final HttpResponse mockResponse = client.execute(mockRequest);
	
		// Le code retour HTTP doit être un succès (200)
		Assert.assertEquals(200, mockResponse.getStatusLine().getStatusCode());
	
		final BufferedReader rd = new BufferedReader(new InputStreamReader(mockResponse.getEntity().getContent()));
		final ObjectMapper mapper = new ObjectMapper();
		final Iterable<Promotion> pro = mapper.readValue(rd, Iterable.class);
	
		Assert.assertNotNull(pro);
	
	}
}
