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
		ur.setUserId(1);
		assert(ur.getUserId()==1);
		ur.setUserId(-1);
		assert(ur.getUserId()==-1);//FIXME: should this fail?
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.User#getUserName()}.
	 * Test method for {@link it.polito.ezgas.entity.User#setUserName(java.lang.String)}.
	 */
	@Test
	public void testSetGetUserName() {
		ur.setUserName("ciao");
		assert(ur.getUserName().equals("ciao"));
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.User#getPassword()}.
	 * Test method for {@link it.polito.ezgas.entity.User#setPassword(java.lang.String)}.
	 */
	@Test
	public void testSetGetPassword() {
		ur.setPassword("password");
		assert(ur.getPassword().equals("password"));
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.User#getEmail()}.
	 * Test method for {@link it.polito.ezgas.entity.User#setEmail(java.lang.String)}.
	 */
	@Test
	public void testSetGetEmail() {
		ur.setEmail("ciao@password");
		assert(ur.getEmail().equals("ciao@password"));
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.User#User()}.
	 */
	@Test
	public void testUser() {
		ur=new User("ciao", "password", "ciao@password", 3);
		
		assert(ur.getUserName().equals("ciao"));
		assert(ur.getPassword().equals("password"));
		assert(ur.getEmail().equals("ciao@password"));
		assert(ur.getReputation().equals(3));
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.User#getReputation()}.
	 * Test method for {@link it.polito.ezgas.entity.User#setReputation(java.lang.Integer)}.
	 */
	@Test
	public void testSetGetReputation() {
		int reputation=3;
		ur.setReputation(1);
		assert(ur.getReputation().equals(1));
		ur.setReputation(reputation);
		assert(ur.getReputation().equals(3));
		reputation=reputation+1;
		ur.setReputation(reputation);
		assert(ur.getReputation().equals(4));
		ur.setReputation(-5);
		assert(ur.getReputation().equals(-5));
		ur.setReputation(5);
		assert(ur.getReputation().equals(5));
		ur.setReputation(6);
		assert(ur.getReputation().equals(6));//FIXME: should this fail?
	}

	/**
	 * Test method for {@link it.polito.ezgas.entity.User#getAdmin()}.
	 * Test method for {@link it.polito.ezgas.entity.User#setAdmin(java.lang.Boolean)}.
	 */
	@Test
	public void testSetGetAdmin() {
		ur.setAdmin(false);
		assert(ur.getAdmin().equals(false));
		ur.setAdmin(true);
		assert(ur.getAdmin().equals(true));
	}

}
