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
		when(gasStationRepository.findOne(any(Integer.class))).thenReturn(gs);
		try {
			result = gasStationService.getGasStationById(42);
		}
		catch(Exception e) {
			fail();
		}
		assertEquals(result.getGasStationId(), gs.getGasStationId());
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.GasStationServiceimpl#saveGasStation(it.polito.ezgas.dto.GasStationDto)}.
	 */
	@Test
	public void testSaveGasStation() {
		fail("Not yet implemented");
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
