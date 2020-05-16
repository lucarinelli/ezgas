/**
 * 
 */
package it.polito.ezgas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.polito.ezgas.entity.GasStation;
import it.polito.ezgas.entity.User;

/**
 * @author lucar
 *
 */
public class GasStationTest {
	
	private GasStation gs;

	@Before
	public void setUp() {
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
		assert(gs.getGasStationName().equals("Pippo Station"));
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setGasStationAddress(java.lang.String)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getGasStationAddress()}.
	 */
	@Test
	public void testSetGetGasStationAddress() {
		gs.setGasStationAddress("Best Way, 123");
		assert(gs.getGasStationAddress().equals("Best Way, 123"));
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#GasStation(java.lang.String, java.lang.String, boolean, boolean, boolean, boolean, boolean, java.lang.String, double, double, double, double, double, double, double, java.lang.Integer, java.lang.String, double)}.
	 */
	@Test
	public void testGasStationStringStringBooleanBooleanBooleanBooleanBooleanStringDoubleDoubleDoubleDoubleDoubleDoubleDoubleIntegerStringDouble() {
		gs = new GasStation("Gas Station Name", "1600 Amphitheatre Parkway, Mountain View, CA 94043", true, false, true, false, true, "Waymo", 37.422, -122.084, 1.99, 0, 2.99, 0, 0.99, 1, "TIMESTAMP?", 50);
		
		assert(gs.getGasStationName().equals("Gas Station Name"));
		assert(gs.getGasStationAddress()=="1600 Amphitheatre Parkway, Mountain View, CA 94043");
		assert(gs.getCarSharing().equals("Waymo"));
		assert(gs.getHasDiesel()==true);
		assert(gs.getHasSuper()==false);
		assert(gs.getHasSuperPlus()==true);
		assert(gs.getHasGas()==false);
		assert(gs.getHasMethane()==true);
		assert(gs.getLat()==37.422);
		assert(gs.getLon()==-122.084);
		assert(gs.getDieselPrice()==1.99);
		assert(gs.getSuperPrice()==0);
		assert(gs.getSuperPlusPrice()==2.99);
		assert(gs.getGasPrice()==0);
		assert(gs.getMethanePrice()==0.99);
		assert(gs.getReportUser()==1);
		assert(gs.getReportTimestamp().equals("TIMESTAMP?"));
		assert(gs.getReportDependability()==50);
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setReportDependability(double)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getReportDependability()}.
	 */
	@Test
	public void testSetGetReportDependability() {
		gs.setReportDependability(96);
		assert(gs.getReportDependability()==96);
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setReportUser(java.lang.Integer)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getReportUser()}.
	 */
	@Test
	public void testSetGetReportUser() {
		gs.setReportUser(42);
		assert(gs.getReportUser()==42);
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setReportTimestamp(java.lang.String)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getReportTimestamp()}.
	 */
	@Test
	public void testSetGetReportTimestamp() {
		gs.setReportTimestamp("TIMESTAMP FORMAT");
		assert(gs.getReportTimestamp().equals("TIMESTAMP FORMAT"));
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setHasDiesel(boolean)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getHasDiesel()}.
	 */
	@Test
	public void testSetGetHasDiesel() {
		gs.setHasDiesel(false);
		assert(gs.getHasDiesel()==false);
		gs.setHasDiesel(true);
		assert(gs.getHasDiesel()==true);
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setHasSuper(boolean)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getHasSuper()}.
	 */
	@Test
	public void testSetGetHasSuper() {
		gs.setHasSuper(false);
		assert(gs.getHasSuper()==false);
		gs.setHasSuper(true);
		assert(gs.getHasSuper()==true);
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getHasSuperPlus()}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setHasSuperPlus(boolean)}.
	 */
	@Test
	public void testSetGetHasSuperPlus() {
		gs.setHasSuperPlus(false);
		assert(gs.getHasSuperPlus()==false);
		gs.setHasSuperPlus(true);
		assert(gs.getHasSuperPlus()==true);
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setHasGas(boolean)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getHasGas()}.
	 */
	@Test
	public void testSetGetHasGas() {
		gs.setHasGas(false);
		assert(gs.getHasGas()==false);
		gs.setHasGas(true);
		assert(gs.getHasGas()==true);
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setHasMethane(boolean)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getHasMethane()}.
	 */
	@Test
	public void testSetGetHasMethane() {
		gs.setHasMethane(false);
		assert(gs.getHasMethane()==false);
		gs.setHasMethane(true);
		assert(gs.getHasMethane()==true);
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setLat(double)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getLat()}.
	 */
	@Test
	public void testSetGetLat() {
		gs.setLat(45.45);
		assert(gs.getLat()==45.45);
		gs.setLat(505.45);
		assert(gs.getLat()==505.45);//FIXME: should this fail?
		gs.setLat(0);
		assert(gs.getLat()==0);
		gs.setLat(-23.1);
		assert(gs.getLat()==-23.1);
		gs.setLat(-91);
		assert(gs.getLat()==-91);//FIXME: should this fail?
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setLon(double)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getLon()}.
	 */
	@Test
	public void testSetGetLon() {
		gs.setLon(45.45);
		assert(gs.getLon()==45.45);
		gs.setLon(505.45);
		assert(gs.getLon()==505.45);//FIXME: should this fail?
		gs.setLon(0);
		assert(gs.getLon()==0);
		gs.setLon(-23.1);
		assert(gs.getLon()==-23.1);
		gs.setLon(-181);
		assert(gs.getLon()==-181);//FIXME: should this fail?
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setDieselPrice(double)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getDieselPrice()}.
	 */
	@Test
	public void testSetGetDieselPrice() {
		gs.setDieselPrice(99.99);
		assert(gs.getDieselPrice()==99.99);
		gs.setDieselPrice(0);
		assert(gs.getDieselPrice()==0);
		gs.setDieselPrice(-1);
		assert(gs.getDieselPrice()==-1);//FIXME: should this fail?
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setSuperPrice(double)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getSuperPrice()}.
	 */
	@Test
	public void testSetGetSuperPrice() {
		gs.setSuperPrice(99.99);
		assert(gs.getSuperPrice()==99.99);
		gs.setSuperPrice(0);
		assert(gs.getSuperPrice()==0);
		gs.setSuperPrice(-1);
		assert(gs.getSuperPrice()==-1);//FIXME: should this fail?
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setSuperPlusPrice(double)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getSuperPlusPrice()}.
	 */
	@Test
	public void testSetGetSuperPlusPrice() {
		gs.setSuperPlusPrice(99.99);
		assert(gs.getSuperPlusPrice()==99.99);
		gs.setSuperPlusPrice(0);
		assert(gs.getSuperPlusPrice()==0);
		gs.setSuperPlusPrice(-1);
		assert(gs.getSuperPlusPrice()==-1);//FIXME: should this fail?
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setGasPrice(double)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getGasPrice()}.
	 */
	@Test
	public void testSetGetGasPrice() {
		gs.setGasPrice(99.99);
		assert(gs.getGasPrice()==99.99);
		gs.setGasPrice(0);
		assert(gs.getGasPrice()==0);
		gs.setGasPrice(-1);
		assert(gs.getGasPrice()==-1);//FIXME: should this fail?
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setMethanePrice(double)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getMethanePrice()}.
	 */
	@Test
	public void testSetGetMethanePrice() {
		gs.setMethanePrice(99.99);
		assert(gs.getMethanePrice()==99.99);
		gs.setMethanePrice(0);
		assert(gs.getMethanePrice()==0);
		gs.setMethanePrice(-1);
		assert(gs.getMethanePrice()==-1);//FIXME: should this fail?
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setUser(it.polito.ezgas.entity.User)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getUser()}.
	 */
	@Test
	public void testSetGetUser() {
		User user = new User();
		gs.setUser(user);
		assert(gs.getUser()==user);
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStation#setCarSharing(java.lang.String)}.
	 * Test method for {@link it.polito.ezgas.entity.GasStation#getCarSharing()}.
	 */
	@Test
	public void testSetGetCarSharing() {
		gs.setCarSharing("Engioi");
		assert(gs.getCarSharing().equals("Engioi"));
	}

}
