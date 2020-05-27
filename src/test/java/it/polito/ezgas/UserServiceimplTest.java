/**
 * 
 */
package it.polito.ezgas;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import exception.InvalidGasStationException;
import exception.InvalidLoginDataException;
import exception.InvalidUserException;
import it.polito.ezgas.entity.GasStation;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.UserRepository;
import it.polito.ezgas.service.UserService;
import it.polito.ezgas.controller.UserController;
import it.polito.ezgas.converter.UserConverter;
import it.polito.ezgas.service.impl.GasStationServiceimpl;
import it.polito.ezgas.service.impl.UserServiceimpl;
import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.dto.IdPw;
import it.polito.ezgas.dto.LoginDto;
import it.polito.ezgas.dto.UserDto;

public class UserServiceimplTest {
	// Repository

	private UserRepository userRepository;
	// User, Admin, NotUser
	/*private User user, adminUser, nonUser;
	private UserDto userDto, adminUserDto, nonUserDto;*/
	// UserService interface
	private UserServiceimpl userService;

	@Before
	public void setUp() {
		/*user = new User("ciao", "password", "ciao@password", 3);
		user.setUserId(1);
		userDto = UserConverter.toUserDto(user);
		nonUserDto = new UserDto();
		nonUser = new User();
		adminUser = new User("ciao", "password", "ciao@password", 5);
		adminUser.setUserId(2);
		adminUser.setAdmin(true);
		adminUserDto = UserConverter.toUserDto(adminUser);*/

		userRepository = mock(UserRepository.class);
		userService = new UserServiceimpl(userRepository);

	}

	/**
	 * Test method for
	 * {@link it.polito.ezgas.service.impl.UserServiceimpl#getUserById(java.lang.Integer)}.
	 */
	@Test
	public void testGetUserById() throws InvalidUserException {
		User user = new User("Name Surname","password123","email@email.com",0);
		user.setUserId(42);
		when(userRepository.findOne(42)).thenReturn(user);
		when(userRepository.getOne(42)).thenReturn(user);

		UserDto result = null;
		try {
			result = userService.getUserById(42);
		} catch (Exception e) {
			fail();
		}
		assertEquals(result.getUserId(), user.getUserId());

	}

	@Test
	public void testGetUserById3() throws InvalidUserException {
		when(userRepository.findOne(10)).thenReturn(null);
		UserDto result = null;
		try {
			result = userService.getUserById(10);
		} catch (Exception e) {
		}
		assertNull(result);

	}

	/**
	 * Test method for
	 * {@link it.polito.ezgas.service.impl.UserServiceimpl#getUserById(java.lang.Integer)}.
	 * throwing exception
	 */
	@Test
	public void testGetUserById2() throws InvalidUserException {
		try {
			userService.getUserById(-1);
		} catch (InvalidUserException e) {
			assertEquals(e.getMessage(), "Wrong userID");
			return;
		}
		fail("Expected InvalidUserException for userId -1");
	}

	/**
	 * Test method for
	 * {@link it.polito.ezgas.service.impl.UserServiceimpl#saveUser(it.polito.ezgas.dto.UserDto)}.
	 * existing user
	 */
	@Test
	public void testSaveUser() {
		UserDto result = null;
		UserDto userDto = new UserDto(1,"Name Surname","password123","email@email.com",0);
		User user = new User("Name Surname","password123","email@email.com",0);
		user.setUserId(1);

		when(userRepository.getOne(user.getUserId())).thenReturn(user);
		when(userRepository.save(any(User.class))).thenReturn(user);
		result = userService.saveUser(userDto);

		assertEquals(result.getUserId(), user.getUserId());
	}

	
	/**
	 * Test method for
	 * {@link it.polito.ezgas.service.impl.UserServiceimpl#saveUser(it.polito.ezgas.dto.UserDto)}.
	 * new user
	 */
	@Test
	public void testSaveUser1() {
		UserDto result = null;
		UserDto userDto = new UserDto(null,"Name Surname","password123","email@email.com",0);
		User user = new User("Name Surname","password123","email@email.com",0);
		user.setUserId(42);
		
		when(userRepository.getOne(any(Integer.class))).thenReturn(null);
		when(userRepository.save(any(User.class))).thenReturn(user);
		result = userService.saveUser(userDto);
		assertEquals(result.getUserId(), user.getUserId());
	}

	/**
	 * Test method for
	 * {@link it.polito.ezgas.service.impl.UserServiceimpl#getAllUsers()}.
	 */
	@Test
	public void testGetAllUsers() {
		List<User> listUsers = new ArrayList<User>();
		int i = 0;
		listUsers.add(new User());
		listUsers.add(new User());
		listUsers.add(new User());
		listUsers.add(new User());
		listUsers.add(new User());
		for(User l : listUsers) {
			i++;
			l.setUserId(i);
		}
		List<UserDto> result = null;
		when(userRepository.findAll()).thenReturn(listUsers);
		result = userService.getAllUsers();
		i = 0;

		for(UserDto r : result) {
			assertEquals(r.getUserId(), listUsers.get(i).getUserId());
			i++;
		}
	}

	/**
	 * Test method for
	 * {@link it.polito.ezgas.service.impl.UserServiceimpl#deleteUser(java.lang.Integer)}.
	 * Delete the corresponding user from the db, no exception.
	 */
	@Test
	public void testDeleteUser() {
		Boolean result = null;
		doNothing().when(userRepository).delete(any(Integer.class));
		User savedUser = new User("Name Surname","password123","email@email.com",0);
		savedUser.setUserId(42);
		when(userRepository.findOne(42)).thenReturn(savedUser);
		try {
			result = userService.deleteUser(42);
		} catch (InvalidUserException e) {
			fail();
		}
		assertEquals(result, true);
	}
	
	/**
	 * Test method for
	 * {@link it.polito.ezgas.service.impl.UserServiceimpl#deleteUser(java.lang.Integer)}.
	 * No user for this id in the db, the function should return null
	 */
	@Test
	public void testDeleteUserAbsent() {
		Boolean result = null;
		doNothing().when(userRepository).delete(any(Integer.class));
		when(userRepository.findOne(42)).thenReturn(null);
		try {
			result = userService.deleteUser(42);
		} catch (InvalidUserException e) {
			fail();
		}
		assertNull(result);
	}
	
	/**
	 * Test method for
	 * {@link it.polito.ezgas.service.impl.UserServiceimpl#deleteUser(java.lang.Integer)}.
	 * invalid user id, throws exception
	 */
	@Test
	public void testDeleteUserInvalid() {
		try {
			userService.deleteUser(-112);
		} catch (InvalidUserException e) {
			assertEquals(e.getMessage(), "Wrong userID");
			return;
		}
		fail("exception not thrown");
	}

	/**
	 * Test method for
	 * {@link it.polito.ezgas.service.impl.UserServiceimpl#login(it.polito.ezgas.dto.IdPw)}.
	 */
	@Test
	public void testLogin() {
		IdPw id = new IdPw("email@email.com", "ciao@password");
		User user = new User("Name Surname","ciao@password","email@email.com",3);
		user.setUserId(42);
		LoginDto result = null;
		when(userRepository.findByEmail("email@email.com")).thenReturn(user);
		try {
			result = userService.login(id);
		} catch (InvalidLoginDataException I) {
			fail();
		}
		assertEquals(result.getEmail(),id.getUser());
	}
	
	/**
	 * Test method for
	 * {@link it.polito.ezgas.service.impl.UserServiceimpl#login(it.polito.ezgas.dto.IdPw)}.
	 */
	@Test
	public void testLoginWrongPassword() {
		IdPw id = new IdPw("email@email.com", "wrong");
		User user = new User("Name Surname","ciao@password","email@email.com",3);
		user.setUserId(42);
		LoginDto result = null;
		when(userRepository.findByEmail("email@email.com")).thenReturn(user);
		try {
			result = userService.login(id);
		} catch (InvalidLoginDataException I) {
			return;
		}
		fail("exception InvalidLoginDataException not thrown");
	}
	
	/**
	 * Test method for
	 * {@link it.polito.ezgas.service.impl.UserServiceimpl#login(it.polito.ezgas.dto.IdPw)}.
	 */
	@Test
	public void testLoginWrongEmail() {
		IdPw id = new IdPw("eeeeemail@email.com", "wrong");
		when(userRepository.findByEmail(any(String.class))).thenReturn(null);
		try {
			userService.login(id);
		} catch (InvalidLoginDataException I) {
			return;
		}
		fail("exception InvalidLoginDataException not thrown");
	}

	/**
	 * Test method for
	 * {@link it.polito.ezgas.service.impl.UserServiceimpl#increaseUserReputation(java.lang.Integer)}.
	 */
	@Test
	public void testIncreaseUserReputation() {
		User user = new User("Name Surname","ciao@password","email@email.com",3);
		user.setUserId(42);
		when(userRepository.findOne(user.getUserId())).thenReturn(user);
		when(userRepository.getOne(user.getUserId())).thenReturn(user);
		when(userRepository.save(any(User.class))).thenReturn(user);
		Integer a = null;
		try {
			a = userService.increaseUserReputation(user.getUserId());
		} catch (InvalidUserException e) {
			fail();
		}
		assertEquals(a, (Integer) 4);
	}
	
	/**
	 * Test method for
	 * {@link it.polito.ezgas.service.impl.UserServiceimpl#increaseUserReputation(java.lang.Integer)}.
	 */
	@Test
	public void testIncreaseUserReputationLimit() {
		User user = new User("Name Surname","ciao@password","email@email.com",5);
		user.setUserId(42);
		when(userRepository.findOne(user.getUserId())).thenReturn(user);
		when(userRepository.getOne(user.getUserId())).thenReturn(user);
		when(userRepository.save(any(User.class))).thenReturn(user);
		Integer a = null;
		try {
			a = userService.increaseUserReputation(user.getUserId());
		} catch (InvalidUserException e) {
			fail();
		}
		assertEquals(a, (Integer) 5);
	}
	
	/**
	 * Test method for
	 * {@link it.polito.ezgas.service.impl.UserServiceimpl#increaseUserReputation(java.lang.Integer)}.
	 */
	@Test
	public void testIncreaseUserReputationInvalid() {
		User user = new User("Name Surname","ciao@password","email@email.com",3);
		user.setUserId(-42);
		when(userRepository.findOne(user.getUserId())).thenReturn(user);
		when(userRepository.getOne(user.getUserId())).thenReturn(user);
		when(userRepository.save(any(User.class))).thenReturn(user);
		Integer a = null;
		try {
			a = userService.increaseUserReputation(user.getUserId());
		} catch (InvalidUserException e) {
			return;
		}
		fail();
	}

	/**
	 * Test method for
	 * {@link it.polito.ezgas.service.impl.UserServiceimpl#decreaseUserReputation(java.lang.Integer)}.
	 */
	@Test
	public void testDecreaseUserReputation() {
		User user = new User("Name Surname","ciao@password","email@email.com",3);
		user.setUserId(42);
		when(userRepository.findOne(user.getUserId())).thenReturn(user);
		when(userRepository.getOne(user.getUserId())).thenReturn(user);
		when(userRepository.save(any(User.class))).thenReturn(user);
		Integer a = null;
		try {
			a = userService.decreaseUserReputation(user.getUserId());
		} catch (InvalidUserException e) {
			fail();
		}
		assertEquals(a, (Integer) 2);
	}
	
	/**
	 * Test method for
	 * {@link it.polito.ezgas.service.impl.UserServiceimpl#decreaseUserReputation(java.lang.Integer)}.
	 */
	@Test
	public void testDecreaseUserReputationLimit() {
		User user = new User("Name Surname","ciao@password","email@email.com",-5);
		user.setUserId(42);
		when(userRepository.findOne(user.getUserId())).thenReturn(user);
		when(userRepository.getOne(user.getUserId())).thenReturn(user);
		when(userRepository.save(any(User.class))).thenReturn(user);
		Integer a = null;
		try {
			a = userService.decreaseUserReputation(user.getUserId());
		} catch (InvalidUserException e) {
			fail();
		}
		assertEquals(a, new Integer(-5));
	}
	
	/**
	 * Test method for
	 * {@link it.polito.ezgas.service.impl.UserServiceimpl#decreaseUserReputation(java.lang.Integer)}.
	 */
	@Test
	public void testDecreaseUserReputationInvalid() {
		User user = new User("Name Surname","ciao@password","email@email.com",3);
		user.setUserId(-42);
		when(userRepository.findOne(user.getUserId())).thenReturn(user);
		when(userRepository.getOne(user.getUserId())).thenReturn(user);
		when(userRepository.save(any(User.class))).thenReturn(user);
		Integer a = null;
		try {
			a = userService.decreaseUserReputation(user.getUserId());
		} catch (InvalidUserException e) {
			return;
		}
		fail();
	}
}
