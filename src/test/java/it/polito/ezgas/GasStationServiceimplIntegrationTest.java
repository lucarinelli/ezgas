/**
 * 
 */
package it.polito.ezgas;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import exception.GPSDataException;
import exception.InvalidGasStationException;
import exception.InvalidGasTypeException;
import exception.InvalidUserException;
import exception.PriceException;
import it.polito.ezgas.converter.UserConverter;
import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.GasStationRepository;
import it.polito.ezgas.repository.UserRepository;
import it.polito.ezgas.service.GasStationService;
import it.polito.ezgas.service.UserService;
import it.polito.ezgas.service.impl.GasStationServiceimpl;
import it.polito.ezgas.service.impl.UserServiceimpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class GasStationServiceimplIntegrationTest {
	
	@TestConfiguration
    static class GasStationServiceimplTestContextConfiguration {
		
		@Autowired
		GasStationRepository gasStationRepository;
		@Autowired
		UserRepository userRepository;
  
        @Bean
        public GasStationService gasStationService() {
            return new GasStationServiceimpl(gasStationRepository, userRepository);
        }
        
        @Bean
	    public UserService userService() {
	    	return new UserServiceimpl(userRepository);
	    }
	   
    }
	
	@Autowired
	private GasStationService gasStationService;
	
	@Autowired
	private UserService userService;
	
	private UserDto userForReportsDto;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		User userForReports = new User("Utente reports", "password", "ciao@password", 3);
		userForReportsDto = UserConverter.toUserDto(userForReports);
		userForReportsDto = userService.saveUser(userForReportsDto);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#GasStationServiceimpl(it.polito.ezgas.repository.GasStationRepository, it.polito.ezgas.repository.UserRepository)}.
	 */
/*	@Test
	public final void testGasStationServiceimplGasStationRepositoryUserRepository() {
		fail("Not yet implemented"); // TODO
	}*/

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#GasStationServiceimpl()}.
	 */
/*	@Test
	public final void testGasStationServiceimpl() {
		fail("Not yet implemented"); // TODO
	}*/

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationById(java.lang.Integer)}.
	 */
	@Test
	public final void testGetGasStationById() {
		GasStationDto result = null;
		List<GasStationDto> inserted = new ArrayList<GasStationDto>();
		GasStationDto gs = new GasStationDto();
		int a;
		double DELTA = 1e-15;
		
		for(int i = 0; i < 5; i++)
			inserted.add(new GasStationDto(null, "CLOSE ENOUGH", "Address", true, true, false, false, false, "engioi", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 7; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", false, true, true, false, false, "engioi", 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 6; i++)
			inserted.add(new GasStationDto(null, "CLOSE ENOUGH", "Address", true, true, false, false, false, "car2go", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 7; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", false, true, true, false, false, "engioi", 42.42, 42.42, 0.0, 1.0, 1.0, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		
		for(GasStationDto g : inserted) {
			try {
				gs=gasStationService.saveGasStation(g);
			} catch (PriceException | GPSDataException e) {
				fail();
			}
		}
		
		a=gs.getGasStationId();
		
		try {
			result = gasStationService.getGasStationById( a );
		} catch (InvalidGasStationException e) {
			fail();
		}
		
		assertEquals(gs.getGasStationId(), result.getGasStationId());
		assertEquals(result.getCarSharing() ,gs.getCarSharing());
		assertEquals(result.getDieselPrice() , gs.getDieselPrice(), DELTA);
		assertEquals(result.getGasPrice() ,gs.getGasPrice(), DELTA);
		assertEquals(result.getMethanePrice() ,gs.getMethanePrice(), DELTA);
		assertEquals(result.getSuperPrice() ,gs.getSuperPrice(), DELTA);
		assertEquals(result.getSuperPlusPrice() ,gs.getSuperPlusPrice(), DELTA);
		assertEquals(result.getGasPrice() ,gs.getGasPrice(), DELTA);
		assertEquals(result.getGasStationAddress() ,gs.getGasStationAddress());
		assertEquals(result.getGasStationName() ,gs.getGasStationName());
		assertEquals(result.getHasDiesel() ,gs.getHasDiesel());
		assertEquals(result.getHasGas() ,gs.getHasGas());
		assertEquals(result.getHasMethane() ,gs.getHasMethane());
		assertEquals(result.getHasSuper() ,gs.getHasSuper());
		assertEquals(result.getHasSuperPlus() ,gs.getHasSuperPlus());
		assertEquals(result.getLat() ,gs.getLat(), DELTA);
		assertEquals(result.getLon() ,gs.getLon(), DELTA);
		assertEquals(result.getReportDependability() ,gs.getReportDependability(),DELTA);
		assertEquals(result.getReportTimestamp() ,gs.getReportTimestamp());
		assertEquals(result.getReportUser() ,gs.getReportUser());
		assertEquals(result.getGasStationId() , gs.getGasStationId());
	}
	
	@Test
	public final void testGetGasStationById1() {
		List<GasStationDto> inserted = new ArrayList<GasStationDto>();
		GasStationDto gs = new GasStationDto();
		
		for(int i = 0; i < 5; i++)
			inserted.add(new GasStationDto(null, "CLOSE ENOUGH", "Address", true, true, false, false, false, "engioi", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 7; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", false, true, true, false, false, "engioi", 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 6; i++)
			inserted.add(new GasStationDto(null, "CLOSE ENOUGH", "Address", true, true, false, false, false, "car2go", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 7; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", false, true, true, false, false, "engioi", 42.42, 42.42, 0.0, 1.0, 1.0, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		
		for(GasStationDto g : inserted) {
			try {
				gs=gasStationService.saveGasStation(g);
			} catch (PriceException | GPSDataException e) {
				fail();
			}
		}
		
		try {
			gasStationService.getGasStationById( null );
		} catch (InvalidGasStationException e) {
			assertEquals(e.getMessage(), "Wrong gasStationId");
		}
		
	}
	
	@Test
	public final void testGetGasStationById2() {
		List<GasStationDto> inserted = new ArrayList<GasStationDto>();
		GasStationDto gs = new GasStationDto();
		GasStationDto result = null;
		int a;
		
			inserted.add(new GasStationDto(null, "CLOSE ENOUGH", "Address", true, true, false, false, false, "engioi", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		
		for(GasStationDto g : inserted) {
			try {
				gs=gasStationService.saveGasStation(g);
			} catch (PriceException | GPSDataException e) {
				fail();
			}
		}
		
		a = gs.getGasStationId();
		a = a+1;
		
		try {
			result = gasStationService.getGasStationById( a );
		} catch (InvalidGasStationException e) {
			fail();
		}
		
		assertEquals(result, null);
		
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#saveGasStation(it.polito.ezgas.dto.GasStationDto)}.
	 */
	@Test
	public final void testSaveGasStation() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getAllGasStations()}.
	 */
	@Test
	public final void testGetAllGasStations() {
		GasStationDto gsdto = new GasStationDto();
		List<GasStationDto> list = null;
		try {
			gasStationService.saveGasStation(gsdto);
		} catch (PriceException | GPSDataException e) {
			fail();
		}
		list=gasStationService.getAllGasStations();
		assertEquals(list.size(),1);
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#deleteGasStation(java.lang.Integer)}.
	 */
	@Test
	public final void testDeleteGasStation() {
		boolean result = false;
		List<GasStationDto> inserted = new ArrayList<GasStationDto>();
		GasStationDto gs = new GasStationDto();
		int a;
		
		for(int i = 0; i < 5; i++)
			inserted.add(new GasStationDto(null, "CLOSE ENOUGH", "Address", true, true, false, false, false, "engioi", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 7; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", false, true, true, false, false, "engioi", 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 6; i++)
			inserted.add(new GasStationDto(null, "CLOSE ENOUGH", "Address", true, true, false, false, false, "car2go", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		
		for(GasStationDto g : inserted) {
			try {
				gs=gasStationService.saveGasStation(g);
			} catch (PriceException | GPSDataException e) {
				fail();
			}
		}
		
		a=gs.getGasStationId();
		
		try {
			result = gasStationService.deleteGasStation(a);
		} catch (InvalidGasStationException e) {
			fail();
		}
		
		assertTrue(result);
		
	}
	
	@Test
	public final void testDeleteGasStation2() {
		boolean result = false;
		List<GasStationDto> inserted = new ArrayList<GasStationDto>();
		GasStationDto gs = new GasStationDto();
		int a;
		
			inserted.add(new GasStationDto(null, "CLOSE ENOUGH", "Address", true, true, false, false, false, "engioi", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		
		for(GasStationDto g : inserted) {
			try {
				gs=gasStationService.saveGasStation(g);
			} catch (PriceException | GPSDataException e) {
				fail();
			}
		}
		
		
		try {
			result = gasStationService.deleteGasStation(null);
		} catch (InvalidGasStationException e) {
			assertEquals(e.getMessage(), "Wrong gasStationId");
		}
		
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationsByGasolineType(java.lang.String)}.
	 * valid, gas stations exists with this type in the db
	 */
	@Test
	public final void testGetGasStationsByGasolineType() {
		double price = 1.50;
		Random rand = new Random();
		List<GasStationDto> inserted = new ArrayList<GasStationDto>();
		List<GasStationDto> result = null;
		for(int i = 0; i < 5; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", true, true, false, false, false, "engioi", 0.0, 0.0, price+rand.nextDouble(), 1.0, 0.0, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 5; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", false, true, true, false, false, "engioi", 0.0, 0.0, 0.0, 1.0, price+rand.nextDouble(), 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		
		for(GasStationDto g : inserted) {
			try {
				gasStationService.saveGasStation(g);
			} catch (PriceException | GPSDataException e) {
				fail();
			}
		}
		
		try {
			result=gasStationService.getGasStationsByGasolineType("Diesel");
		} catch (InvalidGasTypeException e) {
			fail();
		}
		double previous = -1;
		for(GasStationDto r : result) {
			assert(r.getHasDiesel());
			assert(r.getDieselPrice()>previous);
			previous = r.getDieselPrice();
		}
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationsByGasolineType(java.lang.String)}.
	 * valid, NO gas stations exists with this type in the db
	 */
	@Test
	public final void testGetGasStationsByGasolineTypeAbsent() {
		double price = 1.50;
		Random rand = new Random();
		List<GasStationDto> inserted = new ArrayList<GasStationDto>();
		List<GasStationDto> result = null;
		for(int i = 0; i < 5; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", true, true, false, false, false, "engioi", 0.0, 0.0, price+rand.nextDouble(), 1.0, 0.0, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 5; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", false, true, true, false, false, "engioi", 0.0, 0.0, 0.0, 1.0, price+rand.nextDouble(), 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		
		for(GasStationDto g : inserted) {
			try {
				gasStationService.saveGasStation(g);
			} catch (PriceException | GPSDataException e) {
				fail();
			}
		}
		
		try {
			result=gasStationService.getGasStationsByGasolineType("LPG");
		} catch (InvalidGasTypeException e) {
			fail();
		}
		assertEquals(0,result.size());
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationsByGasolineType(java.lang.String)}.
	 * invalid
	 */
	@Test
	public final void testGetGasStationsByGasolineTypeInvalid() {
		double price = 1.50;
		Random rand = new Random();
		List<GasStationDto> inserted = new ArrayList<GasStationDto>();
		for(int i = 0; i < 5; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", true, true, false, false, false, "engioi", 0.0, 0.0, price+rand.nextDouble(), 1.0, 0.0, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 5; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", false, true, true, false, false, "engioi", 0.0, 0.0, 0.0, 1.0, price+rand.nextDouble(), 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		
		for(GasStationDto g : inserted) {
			try {
				gasStationService.saveGasStation(g);
			} catch (PriceException | GPSDataException e) {
				fail();
			}
		}
		
		try {
			gasStationService.getGasStationsByGasolineType("Coke");
		} catch (InvalidGasTypeException e) {
			return;
		}
		fail();
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationsByProximity(double, double)}.
	 * Correct input, gas stations exists in range.
	 * Returns all gas stations within 1km from the GeoPoint whose latitude and longitude are passed as parameters.
	 * Specific order?
	 */
	@Test
	public final void testGetGasStationsByProximity() {
		List<GasStationDto> result = null;
		Random rand = new Random();
		List<GasStationDto> inserted = new ArrayList<GasStationDto>();
		for(int i = 0; i < 5; i++)
			inserted.add(new GasStationDto(null, "CLOSE ENOUGH", "Address", true, true, false, false, false, "engioi", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 7; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", false, true, true, false, false, "engioi", 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		
		for(GasStationDto g : inserted) {
			try {
				gasStationService.saveGasStation(g);
			} catch (PriceException | GPSDataException e) {
				fail();
			}
		}
		
		try {
			result = gasStationService.getGasStationsByProximity(42.424, 42.424);
		} catch (GPSDataException e) {
			fail();
		}
		assertEquals(5,result.size());
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationsByProximity(double, double)}.
	 * Correct input, gas stations exists in range.
	 * Returns all gas stations within 1km from the GeoPoint whose latitude and longitude are passed as parameters.
	 * Specific order? Boundary in
	 */
	@Test
	public final void testGetGasStationsByProximityBoundaryIn() {
		List<GasStationDto> result = null;
		Random rand = new Random();
		List<GasStationDto> inserted = new ArrayList<GasStationDto>();
		for(int i = 0; i < 5; i++)
			inserted.add(new GasStationDto(null, "CLOSE ENOUGH", "Address", true, true, false, false, false, "engioi", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 7; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", false, true, true, false, false, "engioi", 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		
		for(GasStationDto g : inserted) {
			try {
				gasStationService.saveGasStation(g);
			} catch (PriceException | GPSDataException e) {
				fail();
			}
		}
		
		try {
			// distance 0.99km
			result = gasStationService.getGasStationsByProximity(42.427, 42.4275);
		} catch (GPSDataException e) {
			fail();
		}
		assertEquals(5,result.size());
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationsByProximity(double, double)}.
	 * Correct input, NO gas stations exists in range. Returns an empty ArrayList.
	 */
	@Test
	public final void testGetGasStationsByProximityAbsent() {
		List<GasStationDto> result = null;
		List<GasStationDto> inserted = new ArrayList<GasStationDto>();
		for(int i = 0; i < 5; i++)
			inserted.add(new GasStationDto(null, "CLOSE ENOUGH", "Address", true, true, false, false, false, "engioi", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 7; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", false, true, true, false, false, "engioi", 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		
		for(GasStationDto g : inserted) {
			try {
				gasStationService.saveGasStation(g);
			} catch (PriceException | GPSDataException e) {
				fail();
			}
		}
		
		try {
			// distance 1.01km
			result = gasStationService.getGasStationsByProximity(42.4273, 42.4273);
		} catch (GPSDataException e) {
			fail();
		}
		assertEquals(0,result.size());
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationsWithCoordinates(double, double, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testGetGasStationsWithCoordinatesOnlyCoordinates() {
		List<GasStationDto> result = null;
		Random rand = new Random();
		List<GasStationDto> inserted = new ArrayList<GasStationDto>();
		for(int i = 0; i < 5; i++)
			inserted.add(new GasStationDto(null, "CLOSE ENOUGH", "Address", true, true, false, false, false, "engioi", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 7; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", false, true, true, false, false, "engioi", 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		
		for(GasStationDto g : inserted) {
			try {
				gasStationService.saveGasStation(g);
			} catch (PriceException | GPSDataException e) {
				fail();
			}
		}
		
		try {
			result = gasStationService.getGasStationsWithCoordinates(42.424, 42.424, "null", "null");
		} catch (InvalidGasTypeException | GPSDataException e) {
			fail();
		}
		
		assertEquals(5,result.size());
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationsWithCoordinates(double, double, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testGetGasStationsWithCoordinates() {
		List<GasStationDto> result = null;
		Random rand = new Random();
		List<GasStationDto> inserted = new ArrayList<GasStationDto>();
		for(int i = 0; i < 5; i++)
			inserted.add(new GasStationDto(null, "CLOSE ENOUGH", "Address", true, true, false, false, false, "engioi", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 7; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", false, true, true, false, false, "engioi", 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 6; i++)
			inserted.add(new GasStationDto(null, "CLOSE ENOUGH", "Address", true, true, false, false, false, "car2go", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 7; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", false, true, true, false, false, "engioi", 42.42, 42.42, 0.0, 1.0, 1.0, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		
		for(GasStationDto g : inserted) {
			try {
				gasStationService.saveGasStation(g);
			} catch (PriceException | GPSDataException e) {
				fail();
			}
		}
		
		try {
			result = gasStationService.getGasStationsWithCoordinates(42.424, 42.424, "Diesel", "engioi");
		} catch (InvalidGasTypeException | GPSDataException e) {
			fail();
		}
		
		assertEquals(5, result.size());
	}


	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationsWithoutCoordinates(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testGetGasStationsWithoutCoordinates() {
		List<GasStationDto> result = null;
		Random rand = new Random();
		List<GasStationDto> inserted = new ArrayList<GasStationDto>();
		for(int i = 0; i < 5; i++)
			inserted.add(new GasStationDto(null, "CLOSE ENOUGH", "Address", true, true, false, false, false, "engioi", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 7; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", false, true, true, false, false, "engioi", 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 6; i++)
			inserted.add(new GasStationDto(null, "CLOSE ENOUGH", "Address", true, true, false, false, false, "car2go", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 7; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", false, true, true, false, false, "engioi", 42.42, 42.42, 0.0, 1.0, 1.0, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		
		for(GasStationDto g : inserted) {
			try {
				gasStationService.saveGasStation(g);
			} catch (PriceException | GPSDataException e) {
				fail();
			}
		}
		
		try {
			result = gasStationService.getGasStationsWithoutCoordinates( "Diesel", "engioi");
		} catch (InvalidGasTypeException e) {
			fail();
		}
		
		assertEquals(5, result.size());
	}
	
	@Test
	public final void testGetGasStationsWithoutCoordinates1() {
		List<GasStationDto> result = null;
		Random rand = new Random();
		List<GasStationDto> inserted = new ArrayList<GasStationDto>();
		for(int i = 0; i < 5; i++)
			inserted.add(new GasStationDto(null, "CLOSE ENOUGH", "Address", true, true, false, false, false, "engioi", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 7; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", false, true, true, false, false, "engioi", 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 6; i++)
			inserted.add(new GasStationDto(null, "CLOSE ENOUGH", "Address", true, true, false, false, false, "car2go", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 7; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", false, true, true, false, false, "engioi", 42.42, 42.42, 0.0, 1.0, 1.0, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		
		for(GasStationDto g : inserted) {
			try {
				gasStationService.saveGasStation(g);
			} catch (PriceException | GPSDataException e) {
				fail();
			}
		}
		
		try {
			result = gasStationService.getGasStationsWithoutCoordinates( "null", null);
		} catch (InvalidGasTypeException e) {
			assertEquals(e.getMessage(), "Wrong gasolinetype");
		}
		
	}
	
	@Test
	public final void testGetGasStationsWithoutCoordinates2() {
		List<GasStationDto> result = null;
		Random rand = new Random();
		List<GasStationDto> inserted = new ArrayList<GasStationDto>();
		for(int i = 0; i < 5; i++)
			inserted.add(new GasStationDto(null, "CLOSE ENOUGH", "Address", true, true, false, false, false, "engioi", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 7; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", false, true, true, false, false, "engioi", 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 6; i++)
			inserted.add(new GasStationDto(null, "CLOSE ENOUGH", "Address", true, true, false, false, false, "car2go", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 7; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", false, true, true, false, false, "engioi", 42.42, 42.42, 0.0, 1.0, 1.0, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		
		for(GasStationDto g : inserted) {
			try {
				gasStationService.saveGasStation(g);
			} catch (PriceException | GPSDataException e) {
				fail();
			}
		}
		
		try {
			result = gasStationService.getGasStationsWithoutCoordinates( "Diesel", "null");
		} catch (InvalidGasTypeException e) {
			fail();
		}
		
		assertEquals(0, result.size());
	}
	
	@Test
	public final void testGetGasStationsWithoutCoordinates3() {
		List<GasStationDto> result = null;
		Random rand = new Random();
		List<GasStationDto> inserted = new ArrayList<GasStationDto>();
		for(int i = 0; i < 5; i++)
			inserted.add(new GasStationDto(null, "CLOSE ENOUGH", "Address", true, true, false, false, false, "engioi", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 7; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", false, true, true, false, false, "engioi", 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 6; i++)
			inserted.add(new GasStationDto(null, "CLOSE ENOUGH", "Address", true, true, false, false, false, "car2go", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 7; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", false, true, true, false, false, "engioi", 42.42, 42.42, 0.0, 1.0, 1.0, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		
		for(GasStationDto g : inserted) {
			try {
				gasStationService.saveGasStation(g);
			} catch (PriceException | GPSDataException e) {
				fail();
			}
		}
		
		try {
			result = gasStationService.getGasStationsWithoutCoordinates( "null", "engioi");
		} catch (InvalidGasTypeException e) {
			assertEquals(e.getMessage(), "Wrong gasolinetype");
		}
		
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#setReport(java.lang.Integer, double, double, double, double, double, java.lang.Integer)}.
	 */
	@Test
	public final void testSetReport() {
		List<GasStationDto> inserted = new ArrayList<GasStationDto>();
		GasStationDto gs = new GasStationDto();
		GasStationDto result = null;
		int a;
		double DELTA = 1e-15;
		
		for(int i = 0; i < 5; i++)
			inserted.add(new GasStationDto(null , "CLOSE ENOUGH", "Address", true, true, false, false, false, "engioi", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));		
		
		for(GasStationDto g : inserted) {
			try {
				gs=gasStationService.saveGasStation(g);
			} catch (PriceException | GPSDataException e) {
				fail();
			}
		}
		
		//create user for test
		User user = new User("ciao", "password", "ciao@password", 3);
		UserDto userDto = UserConverter.toUserDto(user);
		userDto = userService.saveUser(userDto);
		
		
		a=gs.getGasStationId();
		
		try {
			gasStationService.setReport(a, 9.0, 9.0, 9.0, 9.0, 9.0, userDto.getUserId());
		} catch (InvalidGasStationException | PriceException | InvalidUserException e) {
			fail();
		}	
		
		try {
			result = gasStationService.getGasStationById( a );
		} catch (InvalidGasStationException e) {
			fail();
		}
		
		assertEquals(result.getDieselPrice() , 9.0, 0);
		assertEquals(result.getGasPrice() , 9.0, DELTA);
		assertEquals(result.getMethanePrice() , 9.0, DELTA);
		assertEquals(result.getSuperPrice() , 9.0, DELTA);
		assertEquals(result.getSuperPlusPrice() , 9.0, DELTA);
	}
	
	@Test
	public final void testSetReport1() {
		List<GasStationDto> inserted = new ArrayList<GasStationDto>();
		
		for(int i = 0; i < 5; i++)
			inserted.add(new GasStationDto(null , "CLOSE ENOUGH", "Address", true, true, false, false, false, "engioi", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));		
		
		int i = 0;
		for(GasStationDto g : inserted) {
			try {
				inserted.set(i++, gasStationService.saveGasStation(g));
			} catch (PriceException | GPSDataException e) {
				fail();
			}
		}
		
		try {
			gasStationService.setReport(-1, 0.0, 0.0, 0.0, 0.0, 0.0, userForReportsDto.getUserId());
		} catch (InvalidGasStationException | PriceException | InvalidUserException e) {
			assertEquals(e.getMessage(), "Wrong gasStationId");
			return;
		}	
		fail();
	}
	
	@Test
	public final void testSetReport2() {
		List<GasStationDto> inserted = new ArrayList<GasStationDto>();
		
		for(int i = 0; i < 5; i++)
			inserted.add(new GasStationDto(null , "CLOSE ENOUGH", "Address", true, true, false, false, false, "engioi", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));		
		
		int i = 0;
		for(GasStationDto g : inserted) {
			try {
				inserted.set(i++, gasStationService.saveGasStation(g));
			} catch (PriceException | GPSDataException e) {
				fail();
			}
		}
		
		try {
			gasStationService.setReport(inserted.get(0).getGasStationId(), 0.0, -2, 0.0, 0.0, 0.0, userForReportsDto.getUserId());
		} catch (InvalidGasStationException | PriceException | InvalidUserException e) {
			assertEquals(e.getMessage(),"Wrong Price");
			return;
		}	
		fail();
	}

	@Test
	public final void testSetReport3() {
		List<GasStationDto> inserted = new ArrayList<GasStationDto>();
		
		for(int i = 0; i < 5; i++)
			inserted.add(new GasStationDto(null , "CLOSE ENOUGH", "Address", true, true, false, false, false, "engioi", 42.42, 42.42, 0.0, 0.0, 1.0, 1.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));		
		
		int i = 0;
		for(GasStationDto g : inserted) {
			try {
				inserted.set(i++, gasStationService.saveGasStation(g));
			} catch (PriceException | GPSDataException e) {
				fail();
			}
		}
		
		try {
			gasStationService.setReport(inserted.get(0).getGasStationId(), 0.0, 0.0, 0.0, 0.0, 0, null);
		} catch (InvalidGasStationException | PriceException | InvalidUserException e) {
			assertEquals(e.getMessage(), "Wrong userId");
			return;
		}	
		fail();
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationByCarSharing(java.lang.String)}.
	 */
	@Test
	public final void testGetGasStationByCarSharing() {
		List<GasStationDto> inserted = new ArrayList<GasStationDto>();
		List<GasStationDto> result = null;
		for(int i = 0; i < 5; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", true, true, false, false, false, "cartugo", 0.0, 0.0,1.2, 1.0, 0.0, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 6; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", false, true, true, false, false, "engioi", 0.0, 0.0, 0.0, 1.0, 1.19, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		
		for(GasStationDto g : inserted) {
			try {
				gasStationService.saveGasStation(g);
			} catch (PriceException | GPSDataException e) {
				fail();
			}
		}
		result=gasStationService.getGasStationByCarSharing("engioi");
		assertEquals(result.size(), 6);
		assertEquals(result.get(0).getCarSharing(), "engioi");
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationByCarSharing(java.lang.String)}.
	 */
	@Test
	public final void testGetGasStationByCarSharingAbsent() {
		List<GasStationDto> inserted = new ArrayList<GasStationDto>();
		List<GasStationDto> result = null;
		for(int i = 0; i < 5; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", true, true, false, false, false, "cartugo", 0.0, 0.0, 1.2, 1.0, 0.0, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		for(int i = 0; i < 6; i++)
			inserted.add(new GasStationDto(null, "Name", "Address", false, true, true, false, false, "engioi", 0.0, 0.0, 0.0, 1.0, 1.19, 0.0, 0.0, userForReportsDto.getUserId(), "30/04/2020 00:00:00", 0.50));
		
		for(GasStationDto g : inserted) {
			try {
				gasStationService.saveGasStation(g);
			} catch (PriceException | GPSDataException e) {
				fail();
			}
		}
		result=gasStationService.getGasStationByCarSharing("fake");
		assertEquals(result.size(), 0);
	}

}
