/**
 * 
 */
package it.polito.ezgas;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exception.InvalidUserException;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.UserRepository;
import it.polito.ezgas.service.UserService;
import it.polito.ezgas.controller.UserController;
import it.polito.ezgas.service.impl.UserServiceimpl;
import it.polito.ezgas.dto.UserDto;


public class UserServiceimplTest {
//	// DB managment
//	static Connection db;
//	static Statement st;
	//Repository
	UserRepository userRepository;
	//User, Admin, NotUser
	private User ur, aur, nonur;
	private UserDto urD, aurD, nonurD;
	// UserService interface
	private UserService userService;
	

	
	@Before
	public void setUp() {
		userRepository.deleteAll();
		
		ur = new User("ciao", "password", "ciao@password", 3);
		ur.setUserId(1);
		urD = new UserDto(1, "ciao", "password", "ciao@password", 3, false);
		
		aur = new User("ciao", "password", "ciao@password", 5);
		aur.setUserId(2);
		aur.setAdmin(true);
		aurD = new UserDto(2,"ciao", "password", "ciao@password", 5, true);
		
		userRepository.save(ur);
		userRepository.save(aur);
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#getUserById(java.lang.Integer)}.
	 */
	@Test
	public void testGetUserById()  throws InvalidUserException {
		setUp();
		
        try {
            userService.getUserById(nonur.getUserId());
            fail("Expected InvalidUserException for userId " + nonur.getUserId());
        } catch (InvalidUserException e) {
            assertEquals(e.getMessage(), "Wrong userID");
        }
		
		assertEquals(userService.getUserById(ur.getUserId()).getUserId(), urD.getUserId());  
        
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
