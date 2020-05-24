/**
 * 
 */
package it.polito.ezgas;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

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
import it.polito.ezgas.dto.UserDto;


public class UserServiceimplTest {
	//Repository

	private UserRepository userRepository;
	//User, Admin, NotUser
	private User ur, aur, nonur;
	private UserDto urD, aurD, nonurD;
	// UserService interface
	private UserServiceimpl userService;
	

    @PostConstruct
    @BeforeClass  // run only once
    public static void setUpDatabase() throws SQLException {
    }
	
	@Before
	public void setUp() {
		userRepository= mock(UserRepository.class);
		userService=  new UserServiceimpl(userRepository);
        ur = new User("ciao", "password", "ciao@password", 3);
		ur.setUserId(1);
		urD = UserConverter.toUserDto(ur);
		nonurD= new UserDto();
		nonur =new User();
		aur = new User("ciao", "password", "ciao@password", 5);
		aur.setUserId(2);
		aur.setAdmin(true);
		aurD = UserConverter.toUserDto(aur);
		when(userRepository.findOne(1)).thenReturn(ur);
		when(userRepository.getOne(1)).thenReturn(ur);
		when(userRepository.findOne(2)).thenReturn(aur);
		when(userRepository.getOne(2)).thenReturn(aur);
		
		

	}
	
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#getUserById(java.lang.Integer)}.
	 */
	@Test
	public void testGetUserById()  throws InvalidUserException {
	setUp();
		UserDto result = null;
		try {
			result = userService.getUserById(1);
		}
		catch(Exception e) {
			fail();
		}
		assertEquals(result.getUserId(), ur.getUserId());
				
   }
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#getUserById(java.lang.Integer)}. throwing exception
	 */
	@Test
	public void testGetUserById2()  throws InvalidUserException {

      UserServiceimpl userSnotMockedUp=new UserServiceimpl(null);		
		try {
	            userSnotMockedUp.getUserById(-1);
	            fail("Expected InvalidUserException for userId -1");
	        } catch (InvalidUserException e) {
	            assertEquals(e.getMessage(), "Wrong userID");
	        }
			
		

	}	

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#saveUser(it.polito.ezgas.dto.UserDto)}.
	 */
	@Test
	public void testSaveUser() {
		UserDto user;
		setUp();
		urD.setUserName("Pollo");
		
		user=userService.saveUser(urD);
		assertEquals(user.getUserName(), "Pollo");
		assertEquals(user, urD);	
     	user=userService.saveUser(nonurD);
	assertNull(user);
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#getAllUsers()}.
	 */
	@Test
	public void testGetAllUsers() {
		setUp();
		List<User> users= new ArrayList<User>();
		List<UserDto> users1 = new ArrayList<UserDto>();
		users.add(ur);
		users.add(aur);
     	when (userRepository.findAll()).thenReturn(users);
		users1=userService.getAllUsers();
		assertEquals(users1.get(0), urD);
		assertEquals(users1.get(1), aurD);

	
	
		
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#deleteUser(java.lang.Integer)}.
	 */
	@Test
	public void testDeleteUser() throws InvalidUserException {
setUp();
		try {
		

		assertTrue(	userService.deleteUser(1));
		userService.deleteUser(-112);
		fail("exception not thrown");
		}
		catch(InvalidUserException e){
			assertEquals(e.getMessage(),"Wrong userID");
		}
		
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#login(it.polito.ezgas.dto.IdPw)}.
	 */
	@Test
	public void testLogin() throws InvalidLoginDataException {
	setUp();
	IdPw id1=new IdPw(ur.getEmail(),ur.getPassword()),id2= new IdPw(ur.getEmail()+"wrong",ur.getPassword());
    try {
	assertNotNull(userService.login(id1));
	assertNull(userService.login(id2));
	fail("exception InvalidLoginDataException not thrown");
    } catch (InvalidLoginDataException  I) {
    	assertEquals(I.getMessage(),"Wrong Email or Password");
    }
    }

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#increaseUserReputation(java.lang.Integer)}.
	 * @throws InvalidUserException 
	 */
	@Test
	public void testIncreaseUserReputation() throws InvalidUserException {
		setUp();
		int a;
		
		a = userService.increaseUserReputation( ur.getUserId() );
		assertEquals((Integer) a, (Integer) 4);
		
        try {
            userService.increaseUserReputation(-1);
            fail("Expected InvalidUserException for userId ");
        } catch (InvalidUserException e) {
            assertEquals(e.getMessage(), "Wrong userID");
        }
        
        ur.setReputation(5);
        userService.saveUser(UserConverter.toUserDto(ur));
		a = userService.increaseUserReputation( ur.getUserId() );
		assertEquals((Integer) a, (Integer) 5);
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#decreaseUserReputation(java.lang.Integer)}.
	 * @throws InvalidUserException 
	 */
	@Test
	public void testDecreaseUserReputation() throws InvalidUserException {
		setUp();
		int a,b;
		userService.saveUser(urD);
		a = userService.decreaseUserReputation( ur.getUserId() );
		assertEquals((Integer) a, (Integer) 2);
	
        try {
            userService.decreaseUserReputation(nonur.getUserId());
            fail("Expected InvalidUserException for userId " + nonur.getUserId());
        } catch (InvalidUserException e) {
            assertEquals(e.getMessage(), "Wrong userID");
        }
        
        ur.setReputation(-5);
        userService.saveUser(UserConverter.toUserDto(ur));
		a = userService.decreaseUserReputation( ur.getUserId() );
		b = -5;
		assertEquals((Integer) a, (Integer) b);

	}

}
