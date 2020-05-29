package it.polito.ezgas.controllertests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.polito.ezgas.dto.GasStationDto;

public class TestController {

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
		
		assertEquals(2, gasStationArray.length); //TODO Fix with the actual value!
		
	}

	// 3
	@Test
	public final void testSaveGasStation() {
		fail("Not yet implemented"); // TODO
	}

	// 4
	@Test
	public final void testGasStationDeleteUser() {
		fail("Not yet implemented"); // TODO
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
	public final void testGetGasStationsByProximity() {
		fail("Not yet implemented"); // TODO Luca
	}

	// 7
	@Test
	public final void testGetGasStationsWithCoordinates() {
		fail("Not yet implemented"); // TODO Luca
	}

	// 8
	@Test
	public final void testSetGasStationReport() {
		fail("Not yet implemented"); // TODO
	}
	
	// 9
	@Test
	public final void testAdmin() {
		fail("Not yet implemented"); // TODO
	}

	// 10
	@Test
	public final void testIndex() {
		fail("Not yet implemented"); // TODO Luca
	}

	
	// 11
	@Test
	public final void testMap() {
		fail("Not yet implemented"); // TODO
	}

	// 12
	@Test
	public final void testHomeLogin() {
		fail("Not yet implemented"); // TODO
	}

	// 13
	@Test
	public final void testUpdate() {
		fail("Not yet implemented"); // TODO
	}

	// 14
	@Test
	public final void testSignup() {
		fail("Not yet implemented"); // TODO
	}
	
	// 15
	@Test
	public final void testGetUserById() {
		fail("Not yet implemented"); // TODO
	}

	// 16
	@Test
	public final void testGetAllUsers() {
		fail("Not yet implemented"); // TODO
	}

	// 17
	@Test
	public final void testSaveUser() {
		fail("Not yet implemented"); // TODO
	}

	// 18
	@Test
	public final void testUserDeleteUser() {
		fail("Not yet implemented"); // TODO
	}

	// 19
	@Test
	public final void testIncreaseUserReputation() {
		fail("Not yet implemented"); // TODO
	}

	// 20
	@Test
	public final void testDecreaseUserReputation() {
		fail("Not yet implemented"); // TODO
	}

	// 21
	@Test
	public final void testUserLogin() {
		fail("Not yet implemented"); // TODO Luca
	}
	
}
