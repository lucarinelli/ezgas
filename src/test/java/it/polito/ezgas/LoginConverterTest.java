package it.polito.ezgas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.polito.ezgas.converter.LoginConverter;
import it.polito.ezgas.dto.LoginDto;
import it.polito.ezgas.entity.User;

public class LoginConverterTest {

	private User ur;
	private LoginDto loginDto;
	
	@Before
	public void setUp(){
		ur = new User("ciao", "password", "ciao@password", 3);
		loginDto = new LoginDto(ur.getUserId(), "ciao", "token", "ciao@password", 3 );
	}

	/**
	 * Test method for {@link it.polito.ezgas.converter.LoginConverter#toLoginDto(it.polito.ezgas.entity.User)}.
	 */
	@Test
	public void testtoLoginDto() {
		LoginDto loginDtotest = LoginConverter.toLoginDto(ur);
		assertEquals(loginDtotest.getEmail(), loginDto.getEmail());
		assertEquals(loginDtotest.getReputation(), loginDto.getReputation());
		assertEquals(loginDtotest.getToken(), loginDto.getToken());
		assertEquals(loginDtotest.getUserId(), loginDto.getUserId());
		assertEquals(loginDtotest.getUserName(), loginDto.getUserName());
	}

}
