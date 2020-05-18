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
import it.polito.ezgas.service.UserService;
import it.polito.ezgas.controller.UserController;
import it.polito.ezgas.service.impl.UserServiceimpl;
import it.polito.ezgas.dto.UserDto;


public class UserServiceimplTest {
	private User ur;
	private UserDto ud;
	
	@Before
	public void setUp() {
		ur = new User("ciao", "password", "ciao@password", 3);
		ud = new UserDto(1, "ciao", "password", "ciao@password", 3, false);
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#getUserById(java.lang.Integer)}.
	 */
	@Test
	public void testGetUserById() {
			
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#saveUser(it.polito.ezgas.dto.UserDto)}.
	 */
	@Test
	public void testSaveUser() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#getAllUsers()}.
	 */
	@Test
	public void testGetAllUsers() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#deleteUser(java.lang.Integer)}.
	 */
	@Test
	public void testDeleteUser() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#login(it.polito.ezgas.dto.IdPw)}.
	 */
	@Test
	public void testLogin() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#increaseUserReputation(java.lang.Integer)}.
	 */
	@Test
	public void testIncreaseUserReputation() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#decreaseUserReputation(java.lang.Integer)}.
	 */
	@Test
	public void testDecreaseUserReputation() {
		fail("Not yet implemented"); // TODO
	}

}
