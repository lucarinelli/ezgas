/**
 * 
 */
package it.polito.ezgas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.polito.ezgas.entity.GasStation;
import it.polito.ezgas.entity.User;


public class GasStationTest {
	
	private GasStation gs;

	@Before
	public void setUp() {
		gs = new GasStation("Gas Station Name", "1600 Amphitheatre Parkway, Mountain View, CA 94043", true, false, true, false, true, true, "Waymo", 37.422, -122.084, 1.99, 0.0, 2.99, 0.0, 0.99, 1.0, 1, "TIMESTAMP?", 50);
	}	
	
	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setGasStationId(java.lang.Integer)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getGasStationId()}.
	 */
	@Test
	public void testSetGetGasStationId() {
		gs.setGasStationId(1);
		assertEquals(gs.getGasStationId(), (Integer) 1);
	}
	
	@Test
	public void testSetGetGasStationId1() {
		gs.setGasStationId(777);
		assertEquals((Integer) gs.getGasStationId(), (Integer) 777);
	}

	@Test
	public void testSetGetGasStationId2() { 
		GasStation sg = new GasStation();
		assertNull(sg.getGasStationId());
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setGasStationName(java.lang.String)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getGasStationName()}.
	 */
	@Test
	public void testSetGetGasStationName() {
		gs.setGasStationName("Pippo Station");
		assertEquals(gs.getGasStationName(), "Pippo Station");
	}

	@Test
	public void testSetGetGasStationName1() {
		gs.setGasStationName("Pollo");
		assertEquals((String) gs.getGasStationName(), (String) "Pollo");
	}

	@Test
	public void testSetGetGasStationName2() {
		GasStation sg = new GasStation();
		assertNull(sg.getGasStationName());
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setGasStationAddress(java.lang.String)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getGasStationAddress()}.
	 */
	@Test
	public void testSetGetGasStationAddress() {
		gs.setGasStationAddress("Best Way, 123");
		assertEquals(gs.getGasStationAddress(), "Best Way, 123");
	}
	
	@Test
	public void testSetGetGasStationAddress1() {
		gs.setGasStationAddress("Corso Duca");
		assertEquals(gs.getGasStationAddress() , "Corso Duca");
	}
	
	@Test
	public void testSetGetGasStationAddress2() {
		GasStation sg = new GasStation();
		assertNull(sg.getGasStationAddress());
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#GasStation(java.lang.String, java.lang.String, boolean, boolean, boolean, boolean, boolean, java.lang.String, double, double, double, double, double, double, double, java.lang.Integer, java.lang.String, double)}.
	 */
	@Test
	public void testGasStationStringStringBooleanBooleanBooleanBooleanBooleanStringDoubleDoubleDoubleDoubleDoubleDoubleDoubleIntegerStringDouble() {
		gs = new GasStation("Gas Station Name", "1600 Amphitheatre Parkway, Mountain View, CA 94043", true, false, true, false, true, true, "Waymo", 37.422, -122.084, 1.99, 0.0, 2.99, 0.0, 0.99, 1.0, 1, "TIMESTAMP?", 50);
		
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
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setReportDependability(double)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getReportDependability()}.
	 */
	@Test
	public void testSetGetReportDependability() {
		gs.setReportDependability(96);
		assertEquals(gs.getReportDependability(), (double) 96, 0.0001);
	}
	
	@Test
	public void testSetGetReportDependability2() { 
		GasStation sg = new GasStation();
		assertEquals(sg.getReportDependability(), (double) 0.0, 0.0001);
	}	

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setReportUser(java.lang.Integer)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getReportUser()}.
	 */
	@Test
	public void testSetGetReportUser() {
		gs.setReportUser(42);
		assertEquals(gs.getReportUser(), (Integer) 42);
	}
	
	@Test
	public void testSetGetReportUse2() { 
		GasStation sg = new GasStation();
		assertNull(sg.getReportUser());
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setReportTimestamp(java.lang.String)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getReportTimestamp()}.
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
		GasStation sg = new GasStation();
		assertNull(sg.getReportTimestamp());
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setHasDiesel(boolean)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getHasDiesel()}.
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
		GasStation sg = new GasStation();
		assertFalse(sg.getHasDiesel());
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setHasPremiumDiesel(boolean)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getHasPremiumDiesel()}.
	 */
	@Test
	public void testSetGetHasPremiumDiesel() {
		gs.setHasPremiumDiesel(false);
		assertFalse(gs.getHasPremiumDiesel());
		gs.setHasPremiumDiesel(true);
		assertTrue(gs.getHasPremiumDiesel());
	}
	
	@Test
	public void testSetGetHasPremiumDiesel2() { 
		GasStation sg = new GasStation();
		assertFalse(sg.getHasPremiumDiesel());
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setHasSuper(boolean)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getHasSuper()}.
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
		GasStation sg = new GasStation();
		assertFalse(sg.getHasSuper());
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getHasSuperPlus()}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setHasSuperPlus(boolean)}.
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
		GasStation sg = new GasStation();
		assertFalse(sg.getHasSuperPlus());
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setHasGas(boolean)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getHasGas()}.
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
		GasStation sg = new GasStation();
		assertFalse(sg.getHasGas());
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setHasMethane(boolean)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getHasMethane()}.
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
		GasStation sg = new GasStation();
		assertFalse(sg.getHasMethane());
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setLat(double)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getLat()}.
	 */
	@Test
	public void testSetGetLat() {
		gs.setLat(45.45);
		assertEquals(gs.getLat(), (double) 45.45, 0);
		gs.setLat(505.45);
		assertEquals(gs.getLat(), (double) 505.45, 0);//FIXME: should this fail?
		gs.setLat(0);
		assertEquals(gs.getLat(), (double) 0, 0);
		gs.setLat(-23.1);
		assertEquals(gs.getLat(), (double) -23.1, 0);
		gs.setLat(-91);
		assertEquals(gs.getLat(), (double) -91, 0);//FIXME: should this fail?
	}
	
	@Test
	public void testSetGetLat2() { 
		GasStation sg = new GasStation();
		assertEquals(sg.getLat(), (double) 0, 0);
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setLon(double)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getLon()}.
	 */
	@Test
	public void testSetGetLon() {
		gs.setLon(45.45);
		assertEquals(gs.getLon(), (double) 45.45, 0);
		gs.setLon(505.45);
		assertEquals(gs.getLon(), (double) 505.45, 0);//FIXME: should this fail?
		gs.setLon(0);
		assertEquals(gs.getLon(), (double) 0, 0);
		gs.setLon(-23.1);
		assertEquals(gs.getLon(), (double) -23.1, 0);
		gs.setLon(-181);
		assertEquals(gs.getLon(), (double) -181, 0);//FIXME: should this fail?
	}
	
	@Test
	public void testSetGetLon2() { 
		GasStation sg = new GasStation();
		assertEquals(sg.getLon(), (double) 0, 0);
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setDieselPrice(double)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getDieselPrice()}.
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
	public void testSetGetPremiumDieselPrice2() { 
		GasStation sg = new GasStation();
		assertEquals(sg.getPremiumDieselPrice(), null);
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setPremiumDieselPrice(double)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getPremiumDieselPrice()}.
	 */
	@Test
	public void testSetGetPremiumDieselPrice() {
		gs.setPremiumDieselPrice(99.99);
		assertEquals(gs.getPremiumDieselPrice(), (double) 99.99, 0);
		gs.setPremiumDieselPrice(0.0);
		assertEquals(gs.getPremiumDieselPrice(), (double) 0, 0);
		gs.setPremiumDieselPrice(-1.0);
		assertEquals(gs.getPremiumDieselPrice(), (double) -1, 0);//FIXME: should this fail?
	}
	
	@Test
	public void testSetGetDieselPrice2() { 
		GasStation sg = new GasStation();
		assertEquals(sg.getDieselPrice(), null);
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setSuperPrice(double)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getSuperPrice()}.
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
		GasStation sg = new GasStation();
		assertEquals(sg.getSuperPrice(), null);
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setSuperPlusPrice(double)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getSuperPlusPrice()}.
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
		GasStation sg = new GasStation();
		assertEquals(sg.getSuperPlusPrice(), null);
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setGasPrice(double)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getGasPrice()}.
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
		GasStation sg = new GasStation();
		assertEquals(sg.getGasPrice(), null);
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setMethanePrice(double)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getMethanePrice()}.
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
		GasStation sg = new GasStation();
		assertEquals(sg.getMethanePrice(), null);
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setUser(it.polito.ezgas.entity.User)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getUser()}.
	 */
	@Test
	public void testSetGetUser() {
		User user = new User();
		gs.setUser(user);
		assertEquals(gs.getUser(), user);
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setCarSharing(java.lang.String)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getCarSharing()}.
	 */
	@Test
	public void testSetGetCarSharing() {
		gs.setCarSharing("Engioi");
		assertEquals(gs.getCarSharing(), "Engioi");
	}
	
	@Test
	public void testSetGetCarSharing2() {
		GasStation sg = new GasStation();
		assertNull(sg.getCarSharing());
	}

}
