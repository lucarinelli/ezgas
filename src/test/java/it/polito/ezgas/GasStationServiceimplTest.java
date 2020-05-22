/**
 * 
 */
package it.polito.ezgas;

import static org.mockito.Mockito.*;

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
	@Test
	public void testGasStationServiceimpl() {
		fail("Not yet implemented");
	}

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
		assertEquals(result,toBeSaved);
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
			assert(true);
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
			assert(true);
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
			assert(true);
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
			assert(true);
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
		assertEquals(result,toBeSaved);
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getAllGasStations()}.
	 */
	@Test
	public void testGetAllGasStations() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#deleteGasStation(java.lang.Integer)}.
	 */
	@Test
	public void testDeleteGasStation() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationsByGasolineType(java.lang.String)}.
	 */
	@Test
	public void testGetGasStationsByGasolineType() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationsByProximity(double, double)}.
	 */
	@Test
	public void testGetGasStationsByProximity() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationsWithCoordinates(double, double, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetGasStationsWithCoordinates() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationsWithoutCoordinates(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetGasStationsWithoutCoordinates() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#setReport(java.lang.Integer, double, double, double, double, double, java.lang.Integer)}.
	 */
	@Test
	public void testSetReport() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#getGasStationByCarSharing(java.lang.String)}.
	 */
	@Test
	public void testGetGasStationByCarSharing() {
		fail("Not yet implemented");
	}

}
