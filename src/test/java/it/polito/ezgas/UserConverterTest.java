package it.polito.ezgas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.polito.ezgas.converter.GasStationConverter;
import it.polito.ezgas.converter.UserConverter;
import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.entity.User;

public class UserConverterTest {

	private User ur;
	private UserDto urdto;
	private UserConverter userConverter;

	@Before
	public void setUp() {
		ur = new User("ciao", "password", "ciao@password", 3);
		urdto = new UserDto(ur.getUserId(),"ciao", "password", "ciao@password", 3);
	}

	/**
	 * Test method for {@link it.polito.ezgas.converter.UserConverter#toUserDto(it.polito.ezgas.entity.User)}.
	 */
	@Test
	public void testtoUserDto() {
		UserDto urdtotest = userConverter.toUserDto(ur);
		assertEquals(urdto.getAdmin() , urdtotest.getAdmin());
		assertEquals(urdto.getEmail() , urdtotest.getEmail());
		assertEquals(urdto.getPassword() , urdtotest.getPassword());
		assertEquals(urdto.getUserId() , urdtotest.getUserId());
		assertEquals(urdto.getUserName() , urdtotest.getUserName());
		
	}
	/**
	 * Test method for {@link it.polito.ezgas.converter.UserConverter#toUser(it.polito.ezgas.dto.UserDto)}.
	 */
	@Test
	public void testtoUser() {
		User urtest = userConverter.toUser(urdto);
		assertEquals(urdto.getAdmin() , urtest.getAdmin());
		assertEquals(urdto.getEmail() , urtest.getEmail());
		assertEquals(urdto.getPassword() , urtest.getPassword());
		assertEquals(urdto.getUserId() , urtest.getUserId());
		assertEquals(urdto.getUserName() , urtest.getUserName());
		
	}
}
