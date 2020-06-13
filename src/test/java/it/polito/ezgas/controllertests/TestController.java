package it.polito.ezgas.controllertests;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.aspectj.lang.annotation.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import exception.GPSDataException;
import exception.InvalidLoginDataException;
import exception.PriceException;
import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.dto.IdPw;
import it.polito.ezgas.dto.LoginDto;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.repository.GasStationRepository;
import it.polito.ezgas.repository.UserRepository;
import it.polito.ezgas.service.GasStationService;
import it.polito.ezgas.service.UserService;
import junit.framework.TestCase;


@SpringBootTest
public class TestController extends TestCase {

@Autowired
GasStationService gasStationService;

@Autowired
 UserService userService;

@Autowired
UserRepository userRepository;

@Autowired
GasStationRepository gasStationRepository;


private List<Integer> userToDelete = new ArrayList<>();
private List<Integer> gasStationToDelete = new ArrayList<>();
private UserDto testUser;
private UserDto testAdmin;
private IdPw credentials;
private IdPw credentialsAdmin;
private GasStationDto testGasStation;
private GasStationDto testGasStationNoPriceList;
private GasStationDto testFarGasStation;

private String testName = "test";
private String testEmail = "test@test.test";
private String testPwd = "testPwd";
private String testNameAdmin = "test_Admin";
private String testEmailAdmin = "test_Admin@test.test";
private String testPwdAdmin = "testPwd_Admin";
private Integer testReputation = 0;
private String testGasStationName = "testGasStation";
private String testGasStationName2 = "testGasStation2";

private String testGasStationAddress = "testAddress";
private double testLat =40.628624;
private double testLon = 17.938168;
private int testRadius = 5;
private String testGasStationAddress2 = "testAddress2";
private double testLat2 = 60.005;
private double testLon2 = 60.005;
private double testFarLat = 80.00;
private double testFarLon = 80.00;

private String testCarSharing2 = "Enjoy";
private Double missingPrice = null;
private boolean testHasDiesel = true;
private double testDiesel = 1.2;
private boolean testHasSuper = true;
private double testSuper = 1.4;
private boolean testHasSuperPlus = true;
private double testSuperPlus = 1.45;
private boolean testHasGas = true;
private double testGas = 0.9;
private boolean testHasMethane = true;
private double testMethane = 0.9;
private boolean testHasPremiumDiesel = true;
private double testPremiumDiesel = 1.6;
private String testCarSharing = "Car2Go";
private UserDto userDto;
private GasStationDto gasStationDto;
private Integer userId,gasStationId,adminId;
@Before
public void init() throws PriceException, GPSDataException  {
    userToDelete.clear();
    gasStationToDelete.clear();
    System.out.println("---------------------INIT---------------------");
    testUser = new UserDto();
    testUser.setPassword(testPwd);
    testUser.setEmail(testEmail);
    testUser.setUserName(testName);
    testUser.setAdmin(false);
    testUser.setReputation(testReputation);

    testAdmin = new UserDto();
    testAdmin.setUserName(testNameAdmin);
    testAdmin.setEmail(testEmailAdmin);
    testAdmin.setPassword(testPwdAdmin);
    testAdmin.setAdmin(Boolean.TRUE);
    testAdmin.setReputation(0);
    credentials = new IdPw();
    credentials.setUser(testEmail);
    credentials.setPw(testPwd);

    credentialsAdmin = new IdPw();
    credentialsAdmin.setUser(testEmailAdmin);
    credentialsAdmin.setPw(testPwdAdmin);

    testGasStation = new GasStationDto();
    testGasStation.setGasStationName(testGasStationName);
    testGasStation.setGasStationAddress(testGasStationAddress);
    testGasStation.setLat(testLat);
    testGasStation.setLon(testLon);
    testGasStation.setHasDiesel(testHasDiesel);
    testGasStation.setDieselPrice(testDiesel);
    testGasStation.setHasSuper(testHasSuper);
    testGasStation.setSuperPrice(testSuper);
    testGasStation.setHasSuperPlus(testHasSuperPlus);
    testGasStation.setSuperPlusPrice(testSuperPlus);
    testGasStation.setHasGas(testHasGas);
    testGasStation.setGasPrice(testGas);
    testGasStation.setHasMethane(testHasMethane);
    testGasStation.setMethanePrice(testMethane);
    testGasStation.setHasPremiumDiesel(testHasPremiumDiesel);
    testGasStation.setPremiumDieselPrice(testPremiumDiesel);
    testGasStation.setCarSharing(testCarSharing);

    testFarGasStation = new GasStationDto();
    testFarGasStation.setGasStationName(testGasStationName);
    testFarGasStation.setGasStationAddress(testGasStationAddress);
    testFarGasStation.setLat(testFarLat);
    testFarGasStation.setLon(testFarLon);
    testFarGasStation.setHasDiesel(testHasDiesel);
    testFarGasStation.setDieselPrice(testDiesel);
    testFarGasStation.setHasSuper(testHasSuper);
    testFarGasStation.setSuperPrice(testSuper);
    testFarGasStation.setHasSuperPlus(testHasSuperPlus);
    testFarGasStation.setSuperPlusPrice(testSuperPlus);
    testFarGasStation.setHasGas(testHasGas);
    testFarGasStation.setGasPrice(testGas);
    testFarGasStation.setHasMethane(testHasMethane);
    testFarGasStation.setMethanePrice(testMethane);
    testFarGasStation.setHasPremiumDiesel(testHasPremiumDiesel);
    testFarGasStation.setPremiumDieselPrice(testPremiumDiesel);
    testFarGasStation.setCarSharing(testCarSharing);

    testGasStationNoPriceList = new GasStationDto();
    testGasStationNoPriceList.setGasStationName(testGasStationName2);
    testGasStationNoPriceList.setGasStationAddress(testGasStationAddress2);
    testGasStationNoPriceList.setLat(testLat2);
    testGasStationNoPriceList.setLon(testLon2);
    testGasStationNoPriceList.setHasDiesel(testHasDiesel);
    testGasStationNoPriceList.setDieselPrice(missingPrice);
    testGasStationNoPriceList.setHasSuper(testHasSuper);
    testGasStationNoPriceList.setSuperPrice(missingPrice);
    testGasStationNoPriceList.setHasSuperPlus(testHasSuperPlus);
    testGasStationNoPriceList.setSuperPlusPrice(missingPrice);
    testGasStationNoPriceList.setHasGas(testHasGas);
    testGasStationNoPriceList.setGasPrice(missingPrice);
    testGasStationNoPriceList.setHasMethane(testHasMethane);
    testGasStationNoPriceList.setMethanePrice(missingPrice);
    testGasStationNoPriceList.setHasPremiumDiesel(testHasPremiumDiesel);
    testGasStationNoPriceList.setPremiumDieselPrice(missingPrice);
    testGasStationNoPriceList.setCarSharing(testCarSharing2);
   userDto= userService.saveUser(testUser);
   userId=userDto.getUserId();
   userToDelete.add(userDto.getUserId());
   userDto= userService.saveUser(testAdmin);
   adminId=userDto.getUserId();
   userToDelete.add(userDto.getUserId());
   gasStationDto= gasStationService.saveGasStation(testFarGasStation);
   gasStationId=gasStationDto.getGasStationId();
   gasStationToDelete.add(gasStationId);
    
    

}
@After
public void after() {
    UserDto superadmin = new UserDto(null,"TESTSUPERADMIN","TESTSUPERADMIN","testsuper@admin.com",0,true);
    superadmin = userService.saveUser(superadmin);
    IdPw superAdminCred = new IdPw();
    superAdminCred.setUser("testsuper@admin.com");
    superAdminCred.setPw("TESTSUPERADMIN");
    try {
        LoginDto login = userService.login(superAdminCred);
        if(userToDelete.size() > 0){
            for(int id : userToDelete){
                userRepository.delete(id);
            }
        }
        if(gasStationToDelete.size() > 0){
            for(int id : gasStationToDelete){
                gasStationRepository.delete(id);
            }
        }
        userRepository.delete(superadmin.getUserId());
    } catch (InvalidLoginDataException e) {
        e.printStackTrace();
        fail();
    }
}
	// 1
	@Test
	public final void testGetGasStationById() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/gasstation/getGasStation/"+gasStationId);
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);

		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		GasStationDto gasStation = mapper.readValue(jsonFromResponse, GasStationDto.class);
		
		assertEquals((Integer)gasStationId, gasStation.getGasStationId()); //TODO Fix with the actual value!
	}

	// 2
	@Test
	public void testGetAllGasStations() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/gasstation/getAllGasStations/");
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);

		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		GasStationDto[] gasStationArray = mapper.readValue(jsonFromResponse, GasStationDto[].class);
		
		assertEquals(gasStationToDelete.size(), gasStationArray.length); //TODO Fix with the actual value!
		
	}

	// 3
	@Test
	public void testSaveGasStation() throws ClientProtocolException, IOException, JSONException {
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
				gasStationToDelete.add(gdto.getGasStationId());
				assertEquals("P tutt e frat ingiustamente carcerat", gdto.getGasStationAddress()); //TODO Fix with the actual value!
				assertEquals((double) 40.6794735, gdto.getLat(), 0.000001); //TODO Fix with the actual value!
				assertEquals((double) 17.938348, gdto.getLon(), 0.000001); //TODO Fix with the actual value!
				a = gdto.getGasStationId();
			}
		}
		
		assertNotEquals(a, 0);
		
		//HttpDelete delete = new HttpDelete("http://localhost:8080/gasstation/deleteGasStation/" + a + "/");
 	    
		//HttpClientBuilder.create().build().execute(delete);
		
	}

	// 4
	@Test
	public void testDeleteGasStation() throws ClientProtocolException, IOException, JSONException{
		
		HttpPost request = new HttpPost("http://localhost:8080/gasstation/saveGasStation/");
		JSONObject json = new JSONObject();
		int gasStationId = 0;
		
		json.put("gasStationName", "Pollo"); 
		json.put("gasStationAddress", "Corso Duca dei Polli 121C"); 
		json.put("lat", "40.6794735");
		json.put("lon", "17.938348"); 
		
		json.put("carSharing", "Enjoy");
		json.put("hasDiesel", true);
		json.put("reportUser", "-1");
		
		StringEntity params = new StringEntity(json.toString());
	    request.addHeader("content-type", "application/json");
	    request.setEntity(params);
		
		HttpClientBuilder.create().build().execute(request);
        
		HttpUriRequest request1 = new HttpGet("http://localhost:8080/gasstation/getGasStationsWithCoordinates/40.6794735/17.938348/Diesel/Enjoy");
		HttpResponse response1;
		
		response1 = HttpClientBuilder.create().build().execute(request1);

		String jsonFromResponse = EntityUtils.toString(response1.getEntity());
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		GasStationDto[] gasStationArray = mapper.readValue(jsonFromResponse, GasStationDto[].class);
		
		for(GasStationDto gdto : gasStationArray) {
			if(gdto.getGasStationName().equals("Pollo")) {
				gasStationId = gdto.getGasStationId();
			}
		}
		
		HttpDelete delete = new HttpDelete("http://localhost:8080/gasstation/deleteGasStation/" + gasStationId + "/");
		 	    
		HttpResponse deleteresponse = HttpClientBuilder.create().build().execute(delete);
		
		assert(deleteresponse.getStatusLine().getStatusCode() == 200);
		
	}

	// 5
	@Test
	public void testGetGasStationsByGasolineType() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/gasstation/searchGasStationByGasolineType/Diesel");
		HttpResponse response;
		Integer counter=0;
		response = HttpClientBuilder.create().build().execute(request);

		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		GasStationDto gasStationArray[] = mapper.readValue(jsonFromResponse, GasStationDto[].class);
		
		for (GasStationDto gs : gasStationArray) {
			if(gs.getHasDiesel())
				counter++;
		}
		assert(counter.compareTo(gasStationArray.length)==0); //TODO Fix with the actual value!
		
		for(GasStationDto gdto : gasStationArray) {
			assert(gdto.getHasDiesel());
		}
	}

	// 6
	@Test
	public void testGetGasStationsByProximity() throws ClientProtocolException, IOException {
		// trailing "/" is important! or the last double will be parsed as integer!
		HttpUriRequest request = new HttpGet("http://localhost:8080/gasstation/searchGasStationByProximity/"+testLat+"/"+testLon);
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);

		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		GasStationDto gasStationArray[] = mapper.readValue(jsonFromResponse, GasStationDto[].class);
		
		assert( gasStationArray.length>=1); //TODO Fix with the actual value!
		
		/*for(GasStationDto gdto : gasStationArray) {
			assert(check distance); //TODO improvement
		}*/
	}

	// 7
	@Test
	public void testGetGasStationsWithCoordinates() throws ClientProtocolException, IOException {
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
	public void testSetGasStationReport() throws JsonParseException, JsonMappingException, IOException, JSONException, ParseException {
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
		
		Date toDay = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		
		assertEquals(gasStation.getReportTimestamp(), sdf.format(toDay));
		
	}
	
	// 9
	@Test
	public void testAdmin() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/admin");
		HttpResponse response;
	
		response = HttpClientBuilder.create().build().execute(request);
		assertEquals(200,response.getStatusLine().getStatusCode());
		
	}

	// 10
	@Test
	public  void testIndex() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080");///gasstation/getGasStationsWithCoordinates/"+testGasStation.getLat()+"/"+testGasStation.getLon()+"/"+"Disel"+testGasStation.getCarSharing()+"/");
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);
		
		assertEquals(200, response.getStatusLine().getStatusCode());
	}

	
	// 11
	@Test
	public void testMap() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/map");
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);
		
		assertEquals(200, response.getStatusLine().getStatusCode());
	}

	// 12
	@Test
	public void testHomeLogin() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/login");
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);
		
		assertEquals(200, response.getStatusLine().getStatusCode());
	}

	// 13
	@Test
	public void testUpdate() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/update");
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);
		
		assertEquals(200, response.getStatusLine().getStatusCode());
	}

	// 14
	@Test
	public void testSignup() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/signup");
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);
		
		assertEquals(200, response.getStatusLine().getStatusCode());
	
	}
	
	// 15
	@Test
	public void testGetUserById() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/user/getUser/"+testUser.getUserId());
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);

		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		UserDto user = mapper.readValue(jsonFromResponse, UserDto.class);
		
		assertEquals((Integer)1, user.getUserId());

	}

	// 16
	@Test
	public void testGetAllUsers() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/user/getAllUsers");
		HttpResponse response;
		
		response = HttpClientBuilder.create().build().execute(request);

		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		UserDto[] userDtoArray = mapper.readValue(jsonFromResponse, UserDto[].class);
		
		assertEquals(userToDelete.size(), userDtoArray.length); //TODO Fix with the actual value!
	}

	// 17
	@Test
	public void testSaveUser() throws JSONException, ClientProtocolException, IOException {
		HttpPost request = new HttpPost("http://localhost:8080/user/saveUser");
		JSONObject json = new JSONObject();
		

		json.put("userName", "Test Test"); 
		json.put("password", "xxpass");
		json.put("email", "test1@myuser.com"); 
		
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
				userToDelete.add(userD.getUserId());
		assertFalse(userD.getAdmin());
		assertEquals(userD.getEmail(),"test1@myuser.com");
		assertEquals(userD.getUserName(),"Test Test");
		assertEquals(userD.getPassword(),"xxpass");
			}
		}
        int userId = userDtox.getUserId(); 
//		HttpDelete delete = new HttpDelete("http://localhost:8080/user/deleteUser/" + userId + "/");
 	    
	//	HttpClientBuilder.create().build().execute(delete);

	}

	// 18
	@Test
	public void testDeleteUser() throws ClientProtocolException, IOException, JSONException{
		int userId = 0; 
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
		
		HttpClientBuilder.create().build().execute(request);
        
		HttpUriRequest request1 = new HttpGet("http://localhost:8080/user/getAllUsers");
		HttpResponse response1;
		
		response1 = HttpClientBuilder.create().build().execute(request1);

		String jsonFromResponse = EntityUtils.toString(response1.getEntity());
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		UserDto []userDto= mapper.readValue(jsonFromResponse, UserDto[].class);
		
		for(UserDto userD : userDto) {
			if (userD.getEmail().equals("test@myuser.com")) {
				userId = userD.getUserId(); 
			}
		}
		
		HttpDelete delete = new HttpDelete("http://localhost:8080/user/deleteUser/" + userId + "/");
		 	    
		HttpResponse deleteresponse = HttpClientBuilder.create().build().execute(delete);
		
		assert(deleteresponse.getStatusLine().getStatusCode() == 200);
		
	}

	// 19
	@Test
	public void testIncreaseUserReputation() throws ClientProtocolException, IOException {
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
	public void testDecreaseUserReputation() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/user/getUser/"+testUser.getUserId());
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
	public void testUserLogin() throws ClientProtocolException, IOException, JSONException {
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
