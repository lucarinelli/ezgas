/**
 * 
 */
package it.polito.ezgas;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import exception.GPSDataException;
import exception.InvalidGasStationException;
import exception.InvalidGasTypeException;
import exception.PriceException;
import it.polito.ezgas.converter.GasStationConverter;
import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.entity.GasStation;
import it.polito.ezgas.repository.GasStationRepository;
import it.polito.ezgas.repository.UserRepository;
import it.polito.ezgas.service.GasStationService;
import it.polito.ezgas.service.impl.GasStationServiceimpl;

public class GasStationServiceimplTest {
	
	private GasStationRepository gasStationRepository;
	
	private UserRepository userRepository;
	
	private GasStationService gasStationService;

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
		gasStationRepository = mock(GasStationRepository.class);
		userRepository = mock(UserRepository.class);
		gasStationService = new GasStationServiceimpl(gasStationRepository,userRepository);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#GasStationServiceimpl()}.
	 */
	/*
	@Test
	public void testGasStationServiceimpl() {
		fail("Not yet implemented");
	}*/

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationById(java.lang.Integer)}.
	 */
	@Test
	public void testGetGasStationById() {
		GasStation gs = new GasStation();
		gs.setGasStationId(42);
		GasStationDto result = null;
		when(gasStationRepository.findOne(42)).thenReturn(gs);
		try {
			result = gasStationService.getGasStationById(42);
		}
		catch(Exception e) {
			fail();
		}
		assertEquals(result.getGasStationId(), gs.getGasStationId());
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationById(java.lang.Integer)}.
	 */
	@Test
	public void testGetGasStationByIdAbsent() {
		GasStationDto result = null;
		when(gasStationRepository.findOne(any(Integer.class))).thenReturn(null);
		try {
			result = gasStationService.getGasStationById(42);
		}
		catch(Exception e) {
			fail();
		}
		assertEquals(result, null);
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#saveGasStation(it.polito.ezgas.dto.GasStationDto)}.
	 * Correct insertion, no exception should be generated
	 */
	@Test
	public void testSaveGasStation1() {
		GasStationDto result = null, toBeSaved = new GasStationDto(null,"TestName","TestAddress", 
				true, true, true, true, true, "Engioi", 
				0.0, 0.0, 1.99, 1.99, 1.99, 1.99, 1.99, 
				11, "timestamp", 50.0);
		GasStation savedGs = new GasStation("TestName","TestAddress", 
				true, true, true, true, true, "Engioi", 
				0.0, 0.0, 1.99, 1.99, 1.99, 1.99, 1.99, 
				11, "timestamp", 50.0);
		savedGs.setGasStationId(43);
		when(gasStationRepository.save(any(GasStation.class))).thenReturn(savedGs);
		try {
			result = gasStationService.saveGasStation(toBeSaved);
		} catch (PriceException | GPSDataException e) {
			fail();
		}
		toBeSaved.setGasStationId(43);
		//TODO: this comparison is the bare minimum, a deeper equality method can be useful
		assertEquals(result.getGasStationId(),toBeSaved.getGasStationId());
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#saveGasStation(it.polito.ezgas.dto.GasStationDto)}.
	 * Correct GPS. Negative price, an exception for price must be generated
	 */
	@Test
	public void testSaveGasStation2() {
		GasStationDto toBeSaved = new GasStationDto(null,"TestName","TestAddress", 
				true, true, true, true, true, "Engioi", 
				0.0, 0.0, 1.99, -1.99, -1.99, 1.99, 1.99, 
				11, "timestamp", 50.0);
		try {
			gasStationService.saveGasStation(toBeSaved);
		} catch (GPSDataException e) {
			fail();
		} catch (PriceException e) {
			return;
		}
		fail();
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#saveGasStation(it.polito.ezgas.dto.GasStationDto)}.
	 * Correct price. Wrong longitude, an exception for GPS should be generated
	 */
	@Test
	public void testSaveGasStation3() {
		GasStationDto toBeSaved = new GasStationDto(null,"TestName","TestAddress", 
				true, true, true, true, true, "Engioi", 
				0.0, 200.0, 1.99, 1.99, 1.99, 1.99, 1.99, 
				11, "timestamp", 50.0);
		try {
			gasStationService.saveGasStation(toBeSaved);
		} catch (GPSDataException e) {
			return;
		} catch (PriceException e) {
			fail();
		}
		fail();
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#saveGasStation(it.polito.ezgas.dto.GasStationDto)}.
	 * Correct price. Wrong latitude, an exception for GPS should be generated
	 */
	@Test
	public void testSaveGasStation4() {
		GasStationDto toBeSaved = new GasStationDto(null,"TestName","TestAddress", 
				true, true, true, true, true, "Engioi", 
				500.0, 0.0, 1.99, 1.99, 1.99, 1.99, 1.99, 
				11, "timestamp", 50.0);
		try {
			gasStationService.saveGasStation(toBeSaved);
		} catch (GPSDataException e) {
			return;
		} catch (PriceException e) {
			fail();
		}
		fail();
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#saveGasStation(it.polito.ezgas.dto.GasStationDto)}.
	 * Wrong prices and GPS, an exception for one of the two error must be generated
	 */
	@Test
	public void testSaveGasStation5() {
		GasStationDto toBeSaved = new GasStationDto(null,"TestName","TestAddress", 
				true, true, true, true, true, "Engioi", 
				500.0, 200.0, 1.99, 1.99, -1.99, 1.99, 1.99, 
				11, "timestamp", 50.0);
		try {
			gasStationService.saveGasStation(toBeSaved);
		} catch (GPSDataException|PriceException e) {
			return;
		} 
		fail();
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#saveGasStation(it.polito.ezgas.dto.GasStationDto)}.
	 * Existing gas station. Correct insertion, no exception should be generated
	 */
	@Test
	public void testSaveGasStation6() {
		GasStationDto result = null, toBeSaved = new GasStationDto(42,"TestName","TestAddress", 
				true, true, true, true, true, "Engioi", 
				0.0, 0.0, 1.99, 1.99, 1.99, 1.99, 1.99, 
				11, "timestamp", 50.0);
		GasStation savedGs = new GasStation("TestName","TestAddress", 
				true, true, true, true, true, "Engioi", 
				0.0, 0.0, 1.99, 1.99, 1.99, 1.99, 1.99, 
				11, "timestamp", 50.0);
		savedGs.setGasStationId(42);
		when(gasStationRepository.findOne(42)).thenReturn(savedGs);
		when(gasStationRepository.save(any(GasStation.class))).thenReturn(savedGs);
		try {
			result = gasStationService.saveGasStation(toBeSaved);
		} catch (PriceException | GPSDataException e) {
			fail();
		}
		assertEquals(result.getGasStationId(),toBeSaved.getGasStationId());
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getAllGasStations()}.
	 * No gas station in db, empty list
	 */
	@Test
	public void testGetAllGasStationsNone() {
		List<GasStation> listGs = new ArrayList<GasStation>();
		List<GasStationDto> listDto = new ArrayList<GasStationDto>();
		List<GasStationDto> result = null;
		when(gasStationRepository.findAll()).thenReturn(listGs);
		result = gasStationService.getAllGasStations();
		assertEquals(result, listDto);
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getAllGasStations()}.
	 * Multiple gas stations in db, list returned
	 */
	@Test
	public void testGetAllGasStations() {
		List<GasStation> listGs = new ArrayList<GasStation>();
		int i = 0;
		listGs.add(new GasStation());
		listGs.add(new GasStation());
		listGs.add(new GasStation());
		for(GasStation l : listGs) {
			i++;
			l.setGasStationId(i);
		}
		List<GasStationDto> result = null;
		when(gasStationRepository.findAll()).thenReturn(listGs);
		result = gasStationService.getAllGasStations();
		i = 0;
		for(GasStationDto r : result) {
			assertEquals(r.getGasStationId(), listGs.get(i).getGasStationId());
			i++;
		}
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#deleteGasStation(java.lang.Integer)}.
	 * Delete the corresponding gas station from the db, no exception.
	 */
	@Test
	public void testDeleteGasStation() {
		Boolean result = null;
		doNothing().when(gasStationRepository).delete(any(Integer.class));
		GasStation savedGs = new GasStation("TestName","TestAddress", 
				true, true, true, true, true, "Engioi", 
				0.0, 0.0, 1.99, 1.99, 1.99, 1.99, 1.99, 
				11, "timestamp", 50.0);
		savedGs.setGasStationId(42);
		when(gasStationRepository.findOne(42)).thenReturn(savedGs);
		try {
			result = gasStationService.deleteGasStation(42);
		} catch (InvalidGasStationException e) {
			fail();
		}
		assertEquals(result, true);
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#deleteGasStation(java.lang.Integer)}.
	 * No gas station for this id in the db, the function should return null
	 */
	@Test
	public void testDeleteGasStationAbsent() {
		Boolean result = null;
		doNothing().when(gasStationRepository).delete(any(Integer.class));
		when(gasStationRepository.findOne(42)).thenReturn(null);
		try {
			result = gasStationService.deleteGasStation(42);
		} catch (InvalidGasStationException e) {
			fail();
		}
		assertNull(result);
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#deleteGasStation(java.lang.Integer)}.
	 * No gas station for this id in the db, the function should return null
	 */
	@Test
	public void testDeleteGasStationInvalid() {
		try {
			gasStationService.deleteGasStation(-42);
		} catch (InvalidGasStationException e) {
			return;
		}
		fail();
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationsByGasolineType(java.lang.String)}.
	 * valid, gas stations exists with this type in the db
	 * Returns all gas stations that provide the gasoline type provided as parameter, SORTED by increasing price of that gasoline type
	 */
	@Test
	public void testGetGasStationsByGasolineTypeInvalid() {
		String gasolinetype = "coke";
		try {
			gasStationService.getGasStationsByGasolineType(gasolinetype);
		} catch (InvalidGasTypeException e) {
			return;
		}
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationsByProximity(double, double)}.
	 * Wrong input longitude, throws GPSDataException.
	 */
	@Test
	public void testGetGasStationsByProximityWrongLon() {
		try {
			gasStationService.getGasStationsByProximity(242.427, 42.4275);
		} catch (GPSDataException e) {
			return;
		}
		fail();
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationsByProximity(double, double)}.
	 * Wrong input latitude, throws GPSDataException.
	 */
	@Test
	public void testGetGasStationsByProximityWrongLat() {
		try {
			gasStationService.getGasStationsByProximity(42.427, 242.4275);
		} catch (GPSDataException e) {
			return;
		}
		fail();
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationsByProximity(double, double)}.
	 * Wrong input latitude and longitude, throws GPSDataException.
	 */
	@Test
	public void testGetGasStationsByProximityWrongLonLat() {
		try {
			gasStationService.getGasStationsByProximity(-242.427, 242.4275);
		} catch (GPSDataException e) {
			return;
		}
		fail();
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationsWithCoordinates(double, double, java.lang.String, java.lang.String)}.
	 */
	/*
	@Test
	public void testGetGasStationsWithCoordinates() {
		fail("Not yet implemented");
	}*/

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationsWithoutCoordinates(java.lang.String, java.lang.String)}.
	 */
	/*
	@Test
	public void testGetGasStationsWithoutCoordinates() {
		fail("Not yet implemented");
	}*/

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#setReport(java.lang.Integer, double, double, double, double, double, java.lang.Integer)}.
	 */
	/*
	@Test
	public void testSetReport() {
		fail("Not yet implemented");
	}
	*/

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationByCarSharing(java.lang.String)}.
	 */
	/*
	@Test
	public void testGetGasStationByCarSharing() {
		fail("Not yet implemented");
	}*/

}
