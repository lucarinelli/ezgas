package it.polito.ezgas;

import static org.junit.Assert.*;

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

public class GasStationControllerTest {

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

	@Test
	public final void testGetGasStationById() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/gasstation/getGasStation/1");
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);

		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		GasStationDto gasStation = mapper.readValue(jsonFromResponse, GasStationDto.class);
		
		assert(gasStation.getGasStationId()==1); //TODO Fix with the actual value!
	}

	@Test
	public final void testGetAllGasStations() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/gasstation/getAllGasStations");
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);

		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		GasStationDto[] gasStationArray = mapper.readValue(jsonFromResponse, GasStationDto[].class);
		
		assert(gasStationArray.length==2); //TODO Fix with the actual value!
		
	}

	@Test
	public final void testSaveGasStation() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testDeleteUser() {
		fail("Not yet implemented"); // TODO
	}

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

	@Test
	public final void testGetGasStationsByProximity() {
		fail("Not yet implemented"); // TODO Luca
	}

	@Test
	public final void testGetGasStationsWithCoordinates() {
		fail("Not yet implemented"); // TODO Luca
	}

	@Test
	public final void testSetGasStationReport() {
		fail("Not yet implemented"); // TODO
	}

}
