package it.polito.ezgas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.entity.GasStation;
import it.polito.ezgas.entity.User;

public class GasStationDtoTest {

	private GasStationDto gs;

	@Before
	public void setUp() {
		gs = new GasStationDto(1, "Gas Station Name", "1600 Amphitheatre Parkway, Mountain View, CA 94043", true, false, true, false, true, true, "Waymo", 37.422, -122.084, 1.99, 0.0, 2.99, 0.0, 0.99, 1.0, 1, "TIMESTAMP?", 50);
	}	
	
	/**
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#setGasStationId(java.lang.Integer)}.
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#getGasStationId()}.
	 */
	@Test
	public void testSetGetGasStationDtoId() {
		gs.setGasStationId(1);
		assertEquals(gs.getGasStationId(), (Integer) 1);
	}
	
	@Test
	public void testSetGetGasStationDtoId1() {
		gs.setGasStationId(777);
		assertEquals((Integer) gs.getGasStationId(), (Integer) 777);
	}

	@Test
	public void testSetGetGasStationDtoId2() { 
		GasStationDto sg = new GasStationDto();
		assertNull(sg.getGasStationId());
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#setGasStationName(java.lang.String)}.
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#getGasStationName()}.
	 */
	@Test
	public void testSetGetGasStationDtoName() {
		gs.setGasStationName("Pippo Station");
		assertEquals(gs.getGasStationName(), "Pippo Station");
	}

	@Test
	public void testSetGetGasStationDtoName1() {
		gs.setGasStationName("Pollo");
		assertEquals((String) gs.getGasStationName(), (String) "Pollo");
	}

	@Test
	public void testSetGetGasStationDtoName2() {
		GasStationDto sg = new GasStationDto();
		assertNull(sg.getGasStationName());
	}

	/**
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#setGasStationAddress(java.lang.String)}.
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#getGasStationAddress()}.
	 */
	@Test
	public void testSetGetGasStationDtoAddress() {
		gs.setGasStationAddress("Best Way, 123");
		assertEquals(gs.getGasStationAddress(), "Best Way, 123");
	}
	
	@Test
	public void testSetGetGasStationDtoAddress1() {
		gs.setGasStationAddress("Corso Duca");
		assertEquals(gs.getGasStationAddress() , "Corso Duca");
	}
	
	@Test
	public void testSetGetGasStationDtoAddress2() {
		GasStationDto sg = new GasStationDto();
		assertNull(sg.getGasStationAddress());
	}

	/**
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#GasStationDto(java.lang.String, java.lang.String, boolean, boolean, boolean, boolean, boolean, java.lang.String, double, double, double, double, double, double, double, java.lang.Integer, java.lang.String, double)}.
	 */
	@Test
	public void testGasStationStringStringBooleanBooleanBooleanBooleanBooleanStringDoubleDoubleDoubleDoubleDoubleDoubleDoubleIntegerStringDouble() {
		gs = new GasStationDto(1, "Gas Station Name", "1600 Amphitheatre Parkway, Mountain View, CA 94043", true, false, true, false, true, true, "Waymo", 37.422, -122.084, 1.99, 0.0, 2.99, 0.0, 0.99, 1.0, 1, "TIMESTAMP?", 50);
		
		assertEquals(gs.getGasStationName(), (String) "Gas Station Name");
		assertEquals(gs.getGasStationAddress(), (String) "1600 Amphitheatre Parkway, Mountain View, CA 94043");
		assertEquals(gs.getCarSharing(), (String) "Waymo");
		assertTrue(gs.getHasDiesel());
		assertFalse(gs.getHasSuper());
		assertTrue(gs.getHasSuperPlus());
		assertFalse(gs.getHasGas());
		assertTrue(gs.getHasMethane());
		assertEquals(gs.getLat(), (double) 37.422, 0.0001);
		assertEquals(gs.getLon(), (double) -122.084, 0.0001);
		assertEquals(gs.getDieselPrice(), (double) 1.99, 0.0001);
		assertEquals(gs.getSuperPrice(), (double) 0, 0.0001);
		assertEquals(gs.getSuperPlusPrice(), (double) 2.99, 0.0001);
		assertEquals(gs.getGasPrice(), (double) 0, 0.0001);
		assertEquals(gs.getMethanePrice(),  (double) 0.99, 0.0001);
		assertEquals(gs.getReportUser(), (Integer) 1);
		assertEquals(gs.getReportTimestamp(), "TIMESTAMP?");
		assertEquals(gs.getReportDependability(), (double) 50, 0.0001);
	}

	/**
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#setReportDependability(double)}.
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#getReportDependability()}.
	 */
	@Test
	public void testSetGetReportDependability() {
		gs.setReportDependability(96);
		assertEquals(gs.getReportDependability(), (double) 96, 0.0001);
	}
	
	@Test
	public void testSetGetReportDependability2() { 
		GasStationDto sg = new GasStationDto();
		assertEquals(sg.getReportDependability(), (double) 0.0, 0.0001);
	}	

	/**
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#setReportUser(java.lang.Integer)}.
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#getReportUser()}.
	 */
	@Test
	public void testSetGetReportUser() {
		gs.setReportUser(42);
		assertEquals(gs.getReportUser(), (Integer) 42);
	}
	
	@Test
	public void testSetGetReportUse2() { 
		GasStationDto sg = new GasStationDto();
		assertNull(sg.getReportUser());
	}

	/**
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#setReportTimestamp(java.lang.String)}.
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#getReportTimestamp()}.
	 */
	@Test
	public void testSetGetReportTimestamp() {
		gs.setReportTimestamp("TIMESTAMP FORMAT");
		assertEquals(gs.getReportTimestamp(), "TIMESTAMP FORMAT");
	}
	
	@Test
	public void testSetGetReportTimestamp1() {
		gs.setReportTimestamp("25/12");
		assertEquals((String) gs.getReportTimestamp(), (String) "25/12");
	}
	
	@Test
	public void testSetGetReportTimestamp2() {
		GasStationDto sg = new GasStationDto();
		assertNull(sg.getReportTimestamp());
	}

	/**
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#setHasDiesel(boolean)}.
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#getHasDiesel()}.
	 */
	@Test
	public void testSetGetHasDiesel() {
		gs.setHasDiesel(false);
		assertFalse(gs.getHasDiesel());
		gs.setHasDiesel(true);
		assertTrue(gs.getHasDiesel());
	}
	
	@Test
	public void testSetGetHasDiesel2() { 
		GasStationDto sg = new GasStationDto();
		assertFalse(sg.getHasDiesel());
	}

	/**
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#setHasSuper(boolean)}.
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#getHasSuper()}.
	 */
	@Test
	public void testSetGetHasSuper() {
		gs.setHasSuper(false);
		assertFalse(gs.getHasSuper());
		gs.setHasSuper(true);
		assertTrue(gs.getHasSuper());
	}
	
	@Test
	public void testSetGetHasSuper2() { 
		GasStationDto sg = new GasStationDto();
		assertFalse(sg.getHasSuper());
	}

	/**
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#getHasSuperPlus()}.
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#setHasSuperPlus(boolean)}.
	 */
	@Test
	public void testSetGetHasSuperPlus() {
		gs.setHasSuperPlus(false);
		assertFalse(gs.getHasSuperPlus());
		gs.setHasSuperPlus(true);
		assertTrue(gs.getHasSuperPlus());
	}
	
	@Test
	public void testSetGetHasSuperPlus2() { 
		GasStationDto sg = new GasStationDto();
		assertFalse(sg.getHasSuperPlus());
	}

	/**
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#setHasGas(boolean)}.
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#getHasGas()}.
	 */
	@Test
	public void testSetGetHasGas() {
		gs.setHasGas(false);
		assertFalse(gs.getHasGas());
		gs.setHasGas(true);
		assertTrue(gs.getHasGas());
	}
	
	@Test
	public void testSetGetHasGas2() { 
		GasStationDto sg = new GasStationDto();
		assertFalse(sg.getHasGas());
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#setHasMethane(boolean)}.
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#getHasMethane()}.
	 */
	@Test
	public void testSetGetHasMethane() {
		gs.setHasMethane(false);
		assertFalse(gs.getHasMethane());
		gs.setHasMethane(true);
		assertTrue(gs.getHasMethane());
	}
	
	@Test
	public void testSetGetHasMethane2() { 
		GasStationDto sg = new GasStationDto();
		assertFalse(sg.getHasMethane());
	}

	/**
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#setLat(double)}.
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#getLat()}.
	 */
	@Test
	public void testSetGetLat() {
		gs.setLat(45.45);
		assertEquals(gs.getLat(), (double) 45.45, 0);
		gs.setLat(505.45);
		assertEquals(gs.getLat(), (double) 505.45, 0);//FIXME: should this fail?
		gs.setLat((double) 0);
		assertEquals(gs.getLat(), (double) 0, 0);
		gs.setLat(-23.1);
		assertEquals(gs.getLat(), (double) -23.1, 0);
		gs.setLat((double) -91);
		assertEquals(gs.getLat(), (double) -91, 0);//FIXME: should this fail?
	}
	
	@Test
	public void testSetGetLat2() { 
		GasStationDto sg = new GasStationDto();
		assertEquals(sg.getLat(), (double) 0, 0);
	}

	/**
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#setLon(double)}.
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#getLon()}.
	 */
	@Test
	public void testSetGetLon() {
		gs.setLon(45.45);
		assertEquals(gs.getLon(), (double) 45.45, 0);
		gs.setLon(505.45);
		assertEquals(gs.getLon(), (double) 505.45, 0);//FIXME: should this fail?
		gs.setLon((double) 0);
		assertEquals(gs.getLon(), (double) 0, 0);
		gs.setLon(-23.1);
		assertEquals(gs.getLon(), (double) -23.1, 0);
		gs.setLon((double) -181);
		assertEquals(gs.getLon(), (double) -181, 0);//FIXME: should this fail?
	}
	
	@Test
	public void testSetGetLon2() { 
		GasStationDto sg = new GasStationDto();
		assertEquals(sg.getLon(), (double) 0, 0);
	}

	/**
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#setDieselPrice(double)}.
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#getDieselPrice()}.
	 */
	@Test
	public void testSetGetDieselPrice() {
		gs.setDieselPrice(99.99);
		assertEquals(gs.getDieselPrice(), (double) 99.99, 0);
		gs.setDieselPrice(0.0);
		assertEquals(gs.getDieselPrice(), (double) 0, 0);
		gs.setDieselPrice(-1.0);
		assertEquals(gs.getDieselPrice(), (double) -1, 0);//FIXME: should this fail?
	}
	
	@Test
	public void testSetGetDieselPrice2() { 
		GasStationDto sg = new GasStationDto();
		assertEquals(sg.getDieselPrice(), (double) 0, 0);
	}

	/**
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#setSuperPrice(double)}.
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#getSuperPrice()}.
	 */
	@Test
	public void testSetGetSuperPrice() {
		gs.setSuperPrice(99.99);
		assertEquals(gs.getSuperPrice(), (double) 99.99, 0);
		gs.setSuperPrice(0.0);
		assertEquals(gs.getSuperPrice(), (double) 0, 0);
		gs.setSuperPrice(-1.0);
		assertEquals(gs.getSuperPrice(), (double) -1, 0);//FIXME: should this fail?
	}
	
	@Test
	public void testSetGetSuperPrice2() { 
		GasStationDto sg = new GasStationDto();
		assertEquals(sg.getSuperPrice(), (double) 0, 0);
	}

	/**
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#setSuperPlusPrice(double)}.
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#getSuperPlusPrice()}.
	 */
	@Test
	public void testSetGetSuperPlusPrice() {
		gs.setSuperPlusPrice(99.99);
		assertEquals(gs.getSuperPlusPrice(), (double) 99.99, 0);
		gs.setSuperPlusPrice(0.0);
		assertEquals(gs.getSuperPlusPrice(), (double) 0, 0);
		gs.setSuperPlusPrice(-1.0);
		assertEquals(gs.getSuperPlusPrice(), (double) -1, 0);//FIXME: should this fail?
	}
	
	@Test
	public void testSetGetSuperPlusPrice2() { 
		GasStationDto sg = new GasStationDto();
		assertEquals(sg.getSuperPlusPrice(), (double) 0, 0);
	}

	/**
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#setGasPrice(double)}.
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#getGasPrice()}.
	 */
	@Test
	public void testSetGetGasPrice() {
		gs.setGasPrice(99.99);
		assertEquals(gs.getGasPrice(), (double) 99.99, 0);
		gs.setGasPrice(0.0);
		assertEquals(gs.getGasPrice(), (double) 0, 0);
		gs.setGasPrice(-1.0);
		assertEquals(gs.getGasPrice(), (double) -1, 0);//FIXME: should this fail?
	}
	
	@Test
	public void testSetGetGasPrice2() { 
		GasStationDto sg = new GasStationDto();
		assertEquals(sg.getGasPrice(), (double) 0, 0);
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#setMethanePrice(double)}.
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#getMethanePrice()}.
	 */
	@Test
	public void testSetGetMethanePrice() {
		gs.setMethanePrice(99.99);
		assertEquals(gs.getMethanePrice(), (double) 99.99, 0);
		gs.setMethanePrice(0.0);
		assertEquals(gs.getMethanePrice(), (double) 0, 0);
		gs.setMethanePrice(-1.0);
		assertEquals(gs.getMethanePrice(), (double) -1, 0);//FIXME: should this fail?
	}
	
	@Test
	public void testSetGetMethanePrice2() { 
		GasStationDto sg = new GasStationDto();
		assertEquals(sg.getMethanePrice(), (double) 0, 0);
	}

	/**
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#setUser(it.polito.ezgas.entity.User)}.
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#getUser()}.
	 */
	@Test
	public void testSetGetUser() {
		UserDto user = new UserDto();
		gs.setUserDto(user);
		assertEquals(gs.getUserDto(), user);
	}

	/**
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#setCarSharing(java.lang.String)}.
	 * Test method for {@link it.polito.ezgas.dto.GasStationDto#getCarSharing()}.
	 */
	@Test
	public void testSetGetCarSharing() {
		gs.setCarSharing("Engioi");
		assertEquals(gs.getCarSharing(), "Engioi");
	}
	
	@Test
	public void testSetGetCarSharing2() {
		GasStationDto sg = new GasStationDto();
		assertNull(sg.getCarSharing());
	}

}
