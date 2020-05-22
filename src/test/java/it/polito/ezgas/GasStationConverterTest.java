/**
 * 
 */
package it.polito.ezgas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.polito.ezgas.converter.GasStationConverter;
import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.entity.GasStation;

/**
 * @author Ignacio
 *
 */
public class GasStationConverterTest {

	private GasStation gs;
	private GasStationDto gsdto;
	GasStationConverter gsConverter;
	private static final double DELTA = 1e-15;
	
	@Before
	public void setUp(){
		gs = new GasStation("Gas Station Name", "1600 Amphitheatre Parkway, Mountain View, CA 94043", true, false, true, false, true, "Waymo", 37.422, -122.084, 1.99, 0, 2.99, 0, 0.99, 1, "TIMESTAMP?", 50);
		gsdto = new GasStationDto( 1 ,"Gas Station Name", "1600 Amphitheatre Parkway, Mountain View, CA 94043", true, false, true, false, true, "Waymo", 37.422, -122.084, 1.99, 0, 2.99, 0, 0.99, 1, "TIMESTAMP?", 50);
	}

	/**
	 * Test method for {@link it.polito.ezgas.converter.GasStationConverter#toGasStastionDto(it.polito.ezgas.entity.GasStation)}.
	 */
	
	@Test
	public void testtoGasStationDto() {
		gs.setGasStationId(1);
		GasStationDto gsdtotest = GasStationConverter.toGasStationDto(gs);
		
		assertEquals(gsdtotest.getCarSharing() ,gsdto.getCarSharing());
		assertEquals(gsdtotest.getDieselPrice() , gsdto.getDieselPrice(), DELTA);
		assertEquals(gsdtotest.getGasPrice() ,gsdto.getGasPrice(), DELTA);
		assertEquals(gsdtotest.getMethanePrice() ,gsdto.getMethanePrice(), DELTA);
		assertEquals(gsdtotest.getSuperPrice() ,gsdto.getSuperPrice(), DELTA);
		assertEquals(gsdtotest.getSuperPlusPrice() ,gsdto.getSuperPlusPrice(), DELTA);
		assertEquals(gsdtotest.getGasPrice() ,gsdto.getGasPrice(), DELTA);
		assertEquals(gsdtotest.getGasStationAddress() ,gsdto.getGasStationAddress());
		assertEquals(gsdtotest.getGasStationName() ,gsdto.getGasStationName());
		assertEquals(gsdtotest.getHasDiesel() ,gsdto.getHasDiesel());
		assertEquals(gsdtotest.getHasGas() ,gsdto.getHasGas());
		assertEquals(gsdtotest.getHasMethane() ,gsdto.getHasMethane());
		assertEquals(gsdtotest.getHasSuper() ,gsdto.getHasSuper());
		assertEquals(gsdtotest.getHasSuperPlus() ,gsdto.getHasSuperPlus());
		assertEquals(gsdtotest.getLat() ,gsdto.getLat(), DELTA);
		assertEquals(gsdtotest.getLon() ,gsdto.getLon(), DELTA);
		assertEquals(gsdtotest.getPriceReportDtos() ,gsdto.getPriceReportDtos());
		assertEquals(gsdtotest.getReportDependability() ,gsdto.getReportDependability(),DELTA);
		assertEquals(gsdtotest.getReportTimestamp() ,gsdto.getReportTimestamp());
		assertEquals(gsdtotest.getReportUser() ,gsdto.getReportUser());
		assertEquals(gsdtotest.getUserDto() ,gsdto.getUserDto());
		assertEquals(gsdtotest.getGasStationId() ,gsdto.getGasStationId());
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.entity.GasStationConverter#toGasStastion(it.polito.ezgas.dto.GasStationDto)}.
	 */
	@Test
	public void testtoGasStation() {
		gs.setGasStationId(1);
		GasStation gstest = GasStationConverter.toGasStation(gsdto);
		
		assertEquals(gstest.getCarSharing() ,gs.getCarSharing());
		assertEquals(gstest.getDieselPrice() , gs.getDieselPrice(), DELTA);
		assertEquals(gstest.getGasPrice() ,gs.getGasPrice(), DELTA);
		assertEquals(gstest.getMethanePrice() ,gs.getMethanePrice(), DELTA);
		assertEquals(gstest.getSuperPrice() ,gs.getSuperPrice(), DELTA);
		assertEquals(gstest.getSuperPlusPrice() ,gs.getSuperPlusPrice(), DELTA);
		assertEquals(gstest.getGasPrice() ,gs.getGasPrice(), DELTA);
		assertEquals(gstest.getGasStationAddress() ,gs.getGasStationAddress());
		assertEquals(gstest.getGasStationName() ,gs.getGasStationName());
		assertEquals(gstest.getHasDiesel() ,gs.getHasDiesel());
		assertEquals(gstest.getHasGas() ,gs.getHasGas());
		assertEquals(gstest.getHasMethane() ,gs.getHasMethane());
		assertEquals(gstest.getHasSuper() ,gs.getHasSuper());
		assertEquals(gstest.getHasSuperPlus() ,gs.getHasSuperPlus());
		assertEquals(gstest.getLat() ,gs.getLat(), DELTA);
		assertEquals(gstest.getLon() ,gs.getLon(), DELTA);
		assertEquals(gstest.getReportDependability() ,gs.getReportDependability(),DELTA);
		assertEquals(gstest.getReportTimestamp() ,gs.getReportTimestamp());
		assertEquals(gstest.getReportUser() ,gs.getReportUser());
		assertEquals(gstest.getUser() ,gs.getUser());
		assertEquals(gstest.getGasStationId() , gs.getGasStationId());
	}

}
