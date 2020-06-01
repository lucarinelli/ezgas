package it.polito.ezgas.controllertests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.dto.LoginDto;
import it.polito.ezgas.dto.UserDto;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestController {

	int userId;
	int gasStationId;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	// 1
	@Test
	public final void testGetGasStationById() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/gasstation/getGasStation/1");
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);

		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		GasStationDto gasStation = mapper.readValue(jsonFromResponse, GasStationDto.class);
		
		assertEquals((Integer)1, gasStation.getGasStationId()); //TODO Fix with the actual value!
	}

	// 2
	@Test
	public final void testGetAllGasStations() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/gasstation/getAllGasStations");
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);

		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		GasStationDto[] gasStationArray = mapper.readValue(jsonFromResponse, GasStationDto[].class);
		
		assertEquals(4, gasStationArray.length); //TODO Fix with the actual value!
		
	}

	// 3
	@Test
	public final void test1SaveGasStation() throws ClientProtocolException, IOException, JSONException {
		HttpPost request = new HttpPost("http://localhost:8080/gasstation/saveGasStation/");
		JSONObject json = new JSONObject();
		int a = 0;
		
		json.put("gasStationName", "Fratm"); 
		json.put("gasStationAddress", "P tutt e frat ingiustamente carcerat"); 
		json.put("lat", "40.6794735");
		json.put("lon", "17.938348"); 
		
		json.put("carSharing", "Enjoy");
		json.put("hasDiesel", true);
		json.put("reportUser", "-1");
		
		StringEntity params = new StringEntity(json.toString());
	    request.addHeader("content-type", "application/json");
	    request.setEntity(params);
		
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);
		
		assertEquals(200, response.getStatusLine().getStatusCode());
        
		HttpUriRequest request1 = new HttpGet("http://localhost:8080/gasstation/getGasStationsWithCoordinates/40.6794735/17.938348/Diesel/Enjoy");
		HttpResponse response1;
		
		response1 = HttpClientBuilder.create().build().execute(request1);

		String jsonFromResponse = EntityUtils.toString(response1.getEntity());
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		GasStationDto[] gasStationArray = mapper.readValue(jsonFromResponse, GasStationDto[].class);
		
		for(GasStationDto gdto : gasStationArray) {
			if(gdto.getGasStationName().equals("Fratm")) {
				assertEquals("P tutt e frat ingiustamente carcerat", gdto.getGasStationAddress()); //TODO Fix with the actual value!
				assertEquals((double) 40.6794735, gdto.getLat(), 0.000001); //TODO Fix with the actual value!
				assertEquals((double) 17.938348, gdto.getLon(), 0.000001); //TODO Fix with the actual value!
				a = gdto.getGasStationId();
			}
		}
		
		assertNotEquals(a, 0);
		
		gasStationId = a;
		
	}

	// 4
	@Test
	public void test2DeleteGasStation() throws ClientProtocolException, IOException{
		
		HttpDelete request = new HttpDelete("http://localhost:8080/gasstation/deleteGasStation/" + gasStationId + "/");
		 	    
		
		HttpResponse response = HttpClientBuilder.create().build().execute(request);
		
		assert(response.getStatusLine().getStatusCode() == 200);
		
	}

	// 5
	@Test
	public final void testGetGasStationsByGasolineType() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/gasstation/searchGasStationByGasolineType/Diesel");
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);

		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		GasStationDto[] gasStationArray = mapper.readValue(jsonFromResponse, GasStationDto[].class);
		
		assertEquals(2, gasStationArray.length); //TODO Fix with the actual value!
		
		for(GasStationDto gdto : gasStationArray) {
			assert(gdto.getHasDiesel());
		}
	}

	// 6
	@Test
	public final void testGetGasStationsByProximity() throws ClientProtocolException, IOException {
		// trailing "/" is important! or the last double will be parsed as integer!
		HttpUriRequest request = new HttpGet("http://localhost:8080/gasstation/searchGasStationByProximity/40.628624/17.938168/");
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);

		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		GasStationDto[] gasStationArray = mapper.readValue(jsonFromResponse, GasStationDto[].class);
		
		assertEquals(2, gasStationArray.length); //TODO Fix with the actual value!
		
		/*for(GasStationDto gdto : gasStationArray) {
			assert(check distance); //TODO improvement
		}*/
	}

	// 7
	@Test
	public final void testGetGasStationsWithCoordinates() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/gasstation/getGasStationsWithCoordinates/40.628624/17.938168/Diesel/Enjoy");
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);

		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		GasStationDto[] gasStationArray = mapper.readValue(jsonFromResponse, GasStationDto[].class);
		
		assertEquals(1, gasStationArray.length); //TODO Fix with the actual value!
		
		for(GasStationDto gdto : gasStationArray) {
			assertEquals(true, gdto.getHasDiesel());
			assertEquals("Enjoy", gdto.getCarSharing());
		}
	}

	// 8
	@Test
	public final void testSetGasStationReport() throws JsonParseException, JsonMappingException, IOException, JSONException, ParseException {
		HttpPost request = new HttpPost("http://localhost:8080/gasstation/setGasStationReport/4/-1/2.0/-1/2.0/-1/1/");		
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);
		
		assertEquals(200, response.getStatusLine().getStatusCode());
        
		HttpUriRequest request1 = new HttpGet("http://localhost:8080/gasstation/getGasStation/4");
		HttpResponse response1;
		
		response1 = HttpClientBuilder.create().build().execute(request1);
		
		assertEquals(200,response1.getStatusLine().getStatusCode());
		
		String jsonFromResponse = EntityUtils.toString(response1.getEntity());
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		GasStationDto gasStation= mapper.readValue(jsonFromResponse, GasStationDto.class);
		assertEquals(gasStation.getDieselPrice(), -1.0, 0.00001);
		assertEquals(gasStation.getSuperPlusPrice(), -1.0, 0.00001);
		assertTrue(gasStation.getSuperPrice()==2.0);
		assertTrue(gasStation.getGasPrice()==2.0);
		assertEquals(gasStation.getMethanePrice(), -1.0, 0.00001);
		
		Date dateTimestamp = null;
		dateTimestamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(gasStation.getReportTimestamp());
		
		assertEquals(dateTimestamp.getTime(), new Date().getTime(), 60);
		
	}
	
	// 9
	@Test
	public final void testAdmin() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/admin");
		HttpResponse response;
	
		response = HttpClientBuilder.create().build().execute(request);
		assertEquals(200,response.getStatusLine().getStatusCode());
		
	}

	// 10
	@Test
	public final void testIndex() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/gasstation/getGasStationsWithCoordinates/40.628624/17.938168/Diesel/Enjoy");
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);
		
		assertEquals(200, response.getStatusLine().getStatusCode());
	}

	
	// 11
	@Test
	public final void testMap() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/map");
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);
		
		assertEquals(200, response.getStatusLine().getStatusCode());
	}

	// 12
	@Test
	public final void testHomeLogin() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/login");
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);
		
		assertEquals(200, response.getStatusLine().getStatusCode());
	}

	// 13
	@Test
	public final void testUpdate() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/update");
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);
		
		assertEquals(200, response.getStatusLine().getStatusCode());
	}

	// 14
	@Test
	public final void testSignup() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/signup");
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);
		
		assertEquals(200, response.getStatusLine().getStatusCode());
	
	}
	
	// 15
	@Test
	public final void testGetUserById() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/user/getUser/1");
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);

		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		UserDto user = mapper.readValue(jsonFromResponse, UserDto.class);
		
		assertEquals((Integer)1, user.getUserId());

	}

	// 16
	@Test
	public final void testGetAllUsers() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/user/getAllUsers");
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);

		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		UserDto[] userDtoArray = mapper.readValue(jsonFromResponse, UserDto[].class);
		
		assertEquals(4, userDtoArray.length); //TODO Fix with the actual value!
	}

	// 17
	@Test
	public final void test1SaveUser() throws JSONException, ClientProtocolException, IOException {
		
		HttpPost request = new HttpPost("http://localhost:8080/user/saveUser");
		JSONObject json = new JSONObject();
		

		json.put("userName", "Test Test"); 
		json.put("password", "xxpass");
		json.put("email", "test@myuser.com"); 
		
		json.put("reputation", "1");
		json.put("admin", "false");
		
		StringEntity params = new StringEntity(json.toString());
	    request.addHeader("content-type", "application/json");
	    request.setEntity(params);
	    
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);
String jsonFromResponsex = EntityUtils.toString(response.getEntity());
		
		ObjectMapper mapperx = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		UserDto userDtox= mapperx.readValue(jsonFromResponsex, UserDto.class);
		
		assertEquals(200, response.getStatusLine().getStatusCode());
        
		HttpUriRequest request1 = new HttpGet("http://localhost:8080/user/getAllUsers");
		HttpResponse response1;
		
		response1 = HttpClientBuilder.create().build().execute(request1);

		String jsonFromResponse = EntityUtils.toString(response1.getEntity());
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		UserDto []userDto= mapper.readValue(jsonFromResponse, UserDto[].class);
		
		for(UserDto userD : userDto) {
			if (userD.getUserId()==userDtox.getUserId()) {
		assertEquals(userD.getAdmin(),false);
		assertEquals(userD.getEmail(),"test@myuser.com");
		assertEquals(userD.getUserName(),"Test Test");
		assertEquals(userD.getPassword(),"xxpass");
			}

		}

		userId = userDtox.getUserId(); 
		HttpDelete delete = new HttpDelete("http://localhost:8080/user/getUser/10");
		HttpClientBuilder.create().build().execute(delete);

	}

	// 18
	@Test
	public void test2DeleteUser() throws ClientProtocolException, IOException{
		
		
		HttpUriRequest request = new HttpDelete("http://localhost:8080/user/deleteUser/" + userId);
		 	    
		
		HttpResponse response = HttpClientBuilder.create().build().execute(request);
		
		assert(response.getStatusLine().getStatusCode() == 200);
		
	}

	// 19
	@Test
	public final void testIncreaseUserReputation() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/user/getUser/1");
		HttpResponse response;
		int userId, userRep;
		
		response = HttpClientBuilder.create().build().execute(request);

		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		UserDto userDto = mapper.readValue(jsonFromResponse, UserDto.class);
		
		userId=userDto.getUserId();
		userRep=userDto.getReputation();
		
		HttpPost request1 = new HttpPost("http://localhost:8080/user/increaseUserReputation/" + userId);
		HttpResponse response1;
		
		response1 = HttpClientBuilder.create().build().execute(request1);
		
		String jsonFromResponse1 = EntityUtils.toString(response1.getEntity());
		
		ObjectMapper mapper1 = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		int reputation = mapper1.readValue(jsonFromResponse1, int.class);
		
		if (userRep < 5)
			assertEquals(reputation, userRep+1);
		else
			assertEquals(reputation, userRep);
		
		
		HttpPost request2 = new HttpPost("http://localhost:8080/user/decreaseUserReputation/" + userId);
		
		HttpClientBuilder.create().build().execute(request2);
	}

	// 20
	@Test
	public final void testDecreaseUserReputation() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/user/getUser/1");
		HttpResponse response;
		int userId, userRep;
		
		response = HttpClientBuilder.create().build().execute(request);

		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		UserDto userDto = mapper.readValue(jsonFromResponse, UserDto.class);
		
		userId=userDto.getUserId();
		userRep=userDto.getReputation();
		
		HttpPost request1 = new HttpPost("http://localhost:8080/user/decreaseUserReputation/" + userId);
		HttpResponse response1;
		
		response1 = HttpClientBuilder.create().build().execute(request1);
		
		String jsonFromResponse1 = EntityUtils.toString(response1.getEntity());
		
		ObjectMapper mapper1 = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		int reputation = mapper1.readValue(jsonFromResponse1, int.class);
		
		if (userRep > -5)
			assertEquals(reputation, userRep-1);
		else
			assertEquals(reputation, userRep);
		
		
		HttpPost request2 = new HttpPost("http://localhost:8080/user/increaseUserReputation/" + userId);
		
		HttpClientBuilder.create().build().execute(request2);
	}

	// 21
	@Test
	public final void testUserLogin() throws ClientProtocolException, IOException, JSONException {
		HttpPost request = new HttpPost("http://localhost:8080/user/login/");
		// Request parameters and other properties.
		JSONObject json = new JSONObject();
		json.put("user", "rinelliluca@gmail.com"); //TODO Fix with the actual value!
		json.put("pw", "12345678"); //TODO Fix with the actual value!
		StringEntity params = new StringEntity(json.toString());
	    request.addHeader("content-type", "application/json");
	    request.setEntity(params);
		
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);

		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		LoginDto loginDto = mapper.readValue(jsonFromResponse, LoginDto.class);
		
		assertEquals("rinelliluca@gmail.com", loginDto.getEmail()); //TODO Fix with the actual value!
		
	}
	
}
