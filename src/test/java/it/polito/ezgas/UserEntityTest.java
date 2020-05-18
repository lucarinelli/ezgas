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

import it.polito.ezgas.entity.User;


public class UserEntityTest {
	private User ur;

	@Before
	public void setUp() {
		ur = new User("ciao", "password", "ciao@password", 3);
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.User#getUserId()}.
	 * Test method for {@link it.polito.ezgas.entity.User#setUserId(java.lang.Integer)}.
	 */
	@Test
	public void testSetGetUserId() {
		int Id=-1;
		ur.setUserId(1);
		assertEquals(ur.getUserId(), (Integer) 1);
		ur.setUserId(-1);
		assertEquals(ur.getUserId(), (Integer) Id);//FIXME: should this fail?
	}
	
	@Test
	public void testSetGetUserId2() { 
		User usr = new User();
		assertNull(usr.getUserId());
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.entity.User#getUserName()}.
	 * Test method for {@link it.polito.ezgas.entity.User#setUserName(java.lang.String)}.
	 */
	@Test
	public void testSetGetUserName() {
		ur.setUserName("ciao");
		assertEquals(ur.getUserName(), "ciao");
	}
	
	@Test
	public void testSetGetUserName2() {
		User usr = new User();
		assertNull(usr.getUserName());
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.User#getPassword()}.
	 * Test method for {@link it.polito.ezgas.entity.User#setPassword(java.lang.String)}.
	 */
	@Test
	public void testSetGetPassword() {
		ur.setPassword("password");
		assertEquals(ur.getPassword(), "password");
	}
	
	@Test
	public void testSetGetPassword2() {
		User usr = new User();
		assertNull(usr.getPassword());
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.User#getEmail()}.
	 * Test method for {@link it.polito.ezgas.entity.User#setEmail(java.lang.String)}.
	 */
	@Test
	public void testSetGetEmail() {
		ur.setEmail("ciao@password");
		assertEquals(ur.getEmail(), "ciao@password");
	}
	
	@Test
	public void testSetGetEmail2() {
		User usr = new User();
		assertNull(usr.getEmail());
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.User#User()}.
	 */
	@Test
	public void testUser() {
		ur=new User("ciao", "password", "ciao@password", 3);
		
		assertEquals(ur.getUserName(), "ciao");
		assertEquals(ur.getPassword(), "password");
		assertEquals(ur.getEmail(), "ciao@password");
		assertEquals(ur.getReputation(), (Integer) 3);
	}
	
	@Test
	public void testUser2() {
		ur = new User();
		assertNull(ur.getUserName());
		assertNull(ur.getPassword());
		assertNull(ur.getEmail());
		assertNull(ur.getReputation());
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.User#getReputation()}.
	 * Test method for {@link it.polito.ezgas.entity.User#setReputation(java.lang.Integer)}.
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
		User usr = new User();
		assertNull(usr.getReputation());
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.User#getAdmin()}.
	 * Test method for {@link it.polito.ezgas.entity.User#setAdmin(java.lang.Boolean)}.
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
		User usr = new User();
		assertNull(usr.getAdmin());
	}

}
