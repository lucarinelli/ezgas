package it.polito.ezgas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.polito.ezgas.dto.LoginDto;

public class LoginDtoTest {
	private LoginDto ur;
	
	@Before
	public void setUp() throws Exception {
		ur = new LoginDto(1, "ciao", "password", "ciao@password", 3);
	}

	@Test
	public final void testLoginDtoIntegerStringStringStringInteger() {
		ur = new LoginDto(1, "ciao", "password", "ciao@password", 3);
		
		assertEquals(ur.getUserName(), "ciao");
		assertEquals(ur.getToken(), "password");
		assertEquals(ur.getEmail(), "ciao@password");
		assertEquals(ur.getReputation(), (Integer) 3);
	}

	@Test
	public final void testLoginDto() {
		ur=new LoginDto(1, "ciao", "password", "ciao@password", 3);
		
		assertEquals(ur.getUserName(), "ciao");
		assertEquals(ur.getToken(), "password");
		assertEquals(ur.getEmail(), "ciao@password");
		assertEquals(ur.getReputation(), (Integer) 3);
	}

	@Test
	public final void testSetGetUserId() {
		int Id=-1;
		ur.setUserId(1);
		assertEquals(ur.getUserId(), (Integer) 1);
		ur.setUserId(-1);
		assertEquals(ur.getUserId(), (Integer) Id);//FIXME: should this fail?
	}
	
	@Test
	public void testSetGetUserId2() { 
		LoginDto usr = new LoginDto();
		assertNull(usr.getUserId());
	}

	@Test
	public final void testSetGetUserName() {
		ur.setUserName("ciao");
		assertEquals(ur.getUserName(), "ciao");
	}
	
	@Test
	public void testSetGetUserName2() {
		LoginDto usr = new LoginDto();
		assertNull(usr.getUserName());
	}

	@Test
	public final void testSetGetToken() {
		ur.setToken("password");
		assertEquals(ur.getToken(), "password");
	}
	
	@Test
	public void testSetGetToken2() {
		LoginDto usr = new LoginDto();
		assertNull(usr.getToken());
	}

	@Test
	public void testSetGetEmail() {
		ur.setEmail("ciao@password");
		assertEquals(ur.getEmail(), "ciao@password");
	}
	
	@Test
	public void testSetGetEmail2() {
		LoginDto usr = new LoginDto();
		assertNull(usr.getEmail());
	}

	@Test
	public void testSetGetReputation() {
		int reputation=3;
		ur.setReputation(1);
		assertEquals(ur.getReputation(),(Integer) 1);
		ur.setReputation(reputation);
		assertEquals(ur.getReputation(),(Integer) 3);
		reputation=reputation+1;
		ur.setReputation(reputation);
		assertEquals(ur.getReputation(),(Integer) 4);
		reputation = -5;
		ur.setReputation(-5);
		assertEquals(ur.getReputation(),(Integer) reputation);
		ur.setReputation(5);
		assertEquals(ur.getReputation(),(Integer) 5);
		ur.setReputation(6);
		assertEquals(ur.getReputation(),(Integer) 6);//FIXME: should this fail?
	}
	
	@Test
	public void testSetGetReputation2() { 
		LoginDto usr = new LoginDto();
		assertNull(usr.getReputation());
	}

	@Test
	public void testSetGetAdmin() {
		ur.setAdmin(false);
		assertEquals(ur.getAdmin(), false);
		ur.setAdmin(true);
		assertEquals(ur.getAdmin(), true);
	}
	
	@Test
	public void testSetGetAdmin2() { 
		LoginDto usr = new LoginDto();
		assertNull(usr.getAdmin());
	}

}
