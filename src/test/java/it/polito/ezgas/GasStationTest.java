/**
 * 
 */
package it.polito.ezgas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.polito.ezgas.entity.GasStation;

/**
 * @author lucar
 *
 */
public class GasStationTest {
	
	private GasStation gs;

	@Before
	public void initUseCase() {
		gs = new GasStation("Gas Station Name", "1600 Amphitheatre Parkway, Mountain View, CA 94043", true, false, true, false, true, "Waymo", 37.422, -122.084, 1.99, 0, 2.99, 0, 0.99, 1, "TIMESTAMP?", 50);
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setGasStationId(java.lang.Integer)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getGasStationId()}.
	 */
	@Test
	public void testSetGetGasStationId() {
		gs.setGasStationId(1);
		assert(gs.getGasStationId()==1);
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setGasStationName(java.lang.String)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getGasStationName()}.
	 */
	@Test
	public void testSetGetGasStationName() {
		gs.setGasStationName("Pippo Station");
		assert(gs.getGasStationName()=="Pippo Station");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setGasStationAddress(java.lang.String)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getGasStationAddress()}.
	 */
	@Test
	public void testSetGetGasStationAddress() {
		gs.setGasStationAddress("Best Way, 123");
		assert(gs.getGasStationAddress()=="Best Way, 123");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#GasStation()}.
	 */
	@Test
	public void testGasStation() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#GasStation(java.lang.String, java.lang.String, boolean, boolean, boolean, boolean, boolean, java.lang.String, double, double, double, double, double, double, double, java.lang.Integer, java.lang.String, double)}.
	 */
	@Test
	public void testGasStationStringStringBooleanBooleanBooleanBooleanBooleanStringDoubleDoubleDoubleDoubleDoubleDoubleDoubleIntegerStringDouble() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setReportDependability(double)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getReportDependability()}.
	 */
	@Test
	public void testSetGetReportDependability() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setReportUser(java.lang.Integer)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getReportUser()}.
	 */
	@Test
	public void testSetGetReportUser() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setReportTimestamp(java.lang.String)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getReportTimestamp()}.
	 */
	@Test
	public void testSetGetReportTimestamp() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setHasDiesel(boolean)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getHasDiesel()}.
	 */
	@Test
	public void testSetGetHasDiesel() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getHasSuper()}.
	 */
	@Test
	public void testGetHasSuper() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setHasSuper(boolean)}.
	 */
	@Test
	public void testSetHasSuper() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getHasSuperPlus()}.
	 */
	@Test
	public void testGetHasSuperPlus() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setHasSuperPlus(boolean)}.
	 */
	@Test
	public void testSetHasSuperPlus() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getHasGas()}.
	 */
	@Test
	public void testGetHasGas() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setHasGas(boolean)}.
	 */
	@Test
	public void testSetHasGas() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getLat()}.
	 */
	@Test
	public void testGetLat() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setLat(double)}.
	 */
	@Test
	public void testSetLat() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getLon()}.
	 */
	@Test
	public void testGetLon() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setLon(double)}.
	 */
	@Test
	public void testSetLon() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getDieselPrice()}.
	 */
	@Test
	public void testGetDieselPrice() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setDieselPrice(double)}.
	 */
	@Test
	public void testSetDieselPrice() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getSuperPrice()}.
	 */
	@Test
	public void testGetSuperPrice() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setSuperPrice(double)}.
	 */
	@Test
	public void testSetSuperPrice() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getSuperPlusPrice()}.
	 */
	@Test
	public void testGetSuperPlusPrice() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setSuperPlusPrice(double)}.
	 */
	@Test
	public void testSetSuperPlusPrice() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getGasPrice()}.
	 */
	@Test
	public void testGetGasPrice() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setGasPrice(double)}.
	 */
	@Test
	public void testSetGasPrice() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getUser()}.
	 */
	@Test
	public void testGetUser() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setUser(it.polito.ezgas.entity.User)}.
	 */
	@Test
	public void testSetUser() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getHasMethane()}.
	 */
	@Test
	public void testGetHasMethane() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setHasMethane(boolean)}.
	 */
	@Test
	public void testSetHasMethane() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getMethanePrice()}.
	 */
	@Test
	public void testGetMethanePrice() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setMethanePrice(double)}.
	 */
	@Test
	public void testSetMethanePrice() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getCarSharing()}.
	 */
	@Test
	public void testGetCarSharing() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setCarSharing(java.lang.String)}.
	 */
	@Test
	public void testSetCarSharing() {
		fail("Not yet implemented");
	}

}
