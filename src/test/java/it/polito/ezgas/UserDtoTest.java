/**
 * 
 */
package it.polito.ezgas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.entity.User;

/**
 * @author dario
 *
 */
public class UserDtoTest {
	private UserDto ur;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ur = new UserDto(1, "ciao", "password", "ciao@password", 3);
	}


	/**
	 * Test method for {@link it.polito.ezgas.dto.UserDto#UserDto(java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer)}.
	 */
	@Test
	public final void testUserDtoIntegerStringStringStringInteger() {
		ur = new UserDto(1, "ciao", "password", "ciao@password", 3);
		
		assertEquals(ur.getUserName(), "ciao");
		assertEquals(ur.getPassword(), "password");
		assertEquals(ur.getEmail(), "ciao@password");
		assertEquals(ur.getReputation(), (Integer) 3);
	}

	/**
	 * Test method for {@link it.polito.ezgas.dto.UserDto#UserDto(java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Boolean)}.
	 */
	@Test
	public final void testUserDtoIntegerStringStringStringIntegerBoolean() {
		ur = new UserDto(1, "ciao", "password", "ciao@password", 3, false);
		
		assertEquals(ur.getUserName(), "ciao");
		assertEquals(ur.getPassword(), "password");
		assertEquals(ur.getEmail(), "ciao@password");
		assertEquals(ur.getReputation(), (Integer) 3);
		assertEquals(ur.getAdmin(), false);
	}

	/**
	 * Test method for {@link it.polito.ezgas.dto.UserDto#UserDto()}.
	 */
	@Test
	public final void testUserDto() {
		ur=new UserDto(1, "ciao", "password", "ciao@password", 3);
		
		assertEquals(ur.getUserName(), "ciao");
		assertEquals(ur.getPassword(), "password");
		assertEquals(ur.getEmail(), "ciao@password");
		assertEquals(ur.getReputation(), (Integer) 3);
	}
	
	@Test
	public void testUserDto2() {
		ur = new UserDto();
		assertNull(ur.getUserName());
		assertNull(ur.getPassword());
		assertNull(ur.getEmail());
		assertNull(ur.getReputation());
	}

	/**
	 * Test method for {@link it.polito.ezgas.dto.UserDto#getUserId()}.
	 * Test method for {@link it.polito.ezgas.dto.UserDto#setUserId(java.lang.Integer)}.
	 */
	@Test
	public final void testSetGetUserDtoId() {
		int Id=-1;
		ur.setUserId(1);
		assertEquals(ur.getUserId(), (Integer) 1);
		ur.setUserId(-1);
		assertEquals(ur.getUserId(), (Integer) Id);//FIXME: should this fail?
	}
	
	@Test
	public void testSetGetUserDtoId2() { 
		UserDto usr = new UserDto();
		assertNull(usr.getUserId());
	}


	/**
	 * Test method for {@link it.polito.ezgas.dto.UserDto#getUserName()}.
	 * Test method for {@link it.polito.ezgas.dto.UserDto#setUserName(java.lang.String)}.
	 */
	@Test
	public final void testSetGetUserName() {
		ur.setUserName("ciao");
		assertEquals(ur.getUserName(), "ciao");
	}
	
	@Test
	public void testSetGetUserName2() {
		UserDto usr = new UserDto();
		assertNull(usr.getUserName());
	}

	/**
	 * Test method for {@link it.polito.ezgas.dto.UserDto#getPassword()}.
	 * Test method for {@link it.polito.ezgas.dto.UserDto#setPassword(java.lang.String)}.
	 */
	@Test
	public final void testGetPassword() {
		ur.setPassword("password");
		assertEquals(ur.getPassword(), "password");
	}
	
	@Test
	public void testSetGetPassword2() {
		UserDto usr = new UserDto();
		assertNull(usr.getPassword());
	}

	/**
	 * Test method for {@link it.polito.ezgas.dto.UserDto#getEmail()}.
	 * Test method for {@link it.polito.ezgas.dto.UserDto#setEmail(java.lang.String)}.
	 */
	@Test
	public void testSetGetEmail() {
		ur.setEmail("ciao@password");
		assertEquals(ur.getEmail(), "ciao@password");
	}
	
	@Test
	public void testSetGetEmail2() {
		UserDto usr = new UserDto();
		assertNull(usr.getEmail());
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.dto.UserDto#getReputation()}.
	 * Test method for {@link it.polito.ezgas.dto.UserDto#setReputation(java.lang.Integer)}.
	 */
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
		UserDto usr = new UserDto();
		assertNull(usr.getReputation());
	}

	/**
	 * Test method for {@link it.polito.ezgas.dto.UserDto#getAdmin()}.
	 * Test method for {@link it.polito.ezgas.dto.UserDto#setAdmin(java.lang.Boolean)}.
	 */
	@Test
	public void testSetGetAdmin() {
		ur.setAdmin(false);
		assertEquals(ur.getAdmin(), false);
		ur.setAdmin(true);
		assertEquals(ur.getAdmin(), true);
	}
	
	@Test
	public void testSetGetAdmin2() { 
		UserDto usr = new UserDto();
		assertNull(usr.getAdmin());
	}

}
