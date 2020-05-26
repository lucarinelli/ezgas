package it.polito.ezgas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.aspectj.lang.annotation.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import exception.InvalidLoginDataException;
import exception.InvalidUserException;
import it.polito.ezgas.converter.UserConverter;
import it.polito.ezgas.dto.IdPw;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.GasStationRepository;
import it.polito.ezgas.repository.UserRepository;
import it.polito.ezgas.service.GasStationService;
import it.polito.ezgas.service.UserService;
import it.polito.ezgas.service.impl.GasStationServiceimpl;
import it.polito.ezgas.service.impl.UserServiceimpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class UserServiceimplIntegrationTest {
	@TestConfiguration
    static class UserServiceimplIntegrationTestContextConfiguration {
		
		@Autowired
		private UserRepository userRepository;
	    
	    @Bean
	    public UserService userService() {
	    	return new UserServiceimpl(userRepository);
	    }
	   
        
    }
	
	@Autowired
	private UserService userService;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {
		
		
		
	}
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#getUserById(java.lang.Integer)}.
	 * @throws InvalidUserException 
	 */
	@Test
	public final void testGetUserById() throws InvalidUserException {
		User ur, aur;	
		UserDto urD, aurD, nonurD,result,result1;
		
		
		ur = new User("ciao", "password", "ciao@password", 3);
		urD = UserConverter.toUserDto(ur);
		aur = new User("ciao", "password", "ciao@password", 5);
		aur.setAdmin(true);
		aurD = UserConverter.toUserDto(aur);
		try {
		userService.getUserById(-12);
		fail("InvalidUserException not thrown");
		}
		catch (InvalidUserException  e){
		assertEquals(e.getMessage(),"Wrong userID");	
		}
		result=userService.saveUser(urD);
		result1=userService.getUserById(ur.getUserId());
		assertEquals(result,result1);	
			
		
  }
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#saveUser(it.polito.ezgas.dto.UserDto)}.
	 * @throws InvalidUserException 
	 */
	@Test
	public void testSaveUser() throws InvalidUserException {
		
		User ur, aur;	
		UserDto urD, result,result1;
		
		
		ur = new User("ciao", "password", "ciao@password", 3);
		urD = UserConverter.toUserDto(ur);
		result= userService.saveUser(urD);
		urD= userService.getUserById(result.getUserId());
		assertEquals(result,urD);
		
}
	
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#getAllUsers()}.
	 */
	@Test
	public void testGetAllUsers() {
		User ur, aur,nonur;	
		UserDto urD, aurD, nonurD;
		ur = new User("ciao", "password", "ciao@password", 3);
		urD = UserConverter.toUserDto(ur);
		nonurD= new UserDto();
		nonur =new User();
		aur = new User("ciao", "password", "ciao@password", 5);
		aur.setAdmin(true);
		aurD = UserConverter.toUserDto(aur);
		
		List<User> users= new ArrayList<User>();
		List<UserDto> users1 = new ArrayList<UserDto>();
		List <UserDto> users2= new ArrayList<UserDto>();
		users.add(aur);
		users.add(ur);
		users1.add(aurD);
		users1.add(urD);
		userService.saveUser(urD);
		userService.saveUser(aurD);
		
     	users2=userService.getAllUsers();
		Collection<UserDto> collection = new ArrayList<UserDto>(users1);
		Collection<User> collection2 = new ArrayList<User>(users);
		
		assert(users2.containsAll(collection));
		users2.removeAll(collection);
	
		
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#deleteUser(java.lang.Integer)}.
	 */
	@Test
	public void testDeleteUser() throws InvalidUserException {
		User ur = new User("ciao", "password", "ciao@password", 3);

		try {
		
			ur=UserConverter.toUser(userService.saveUser(UserConverter.toUserDto(ur)));
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
	IdPw id1=new IdPw("ciao","ciao@password"),id2= new IdPw("ciao@password Wrong","ciao");
    assertNotNull(id1);
    try {
	assertNotNull(userService.login(id1));
	assertEquals(userService.login(id1),id1);
	userService.login(id2);
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
		User ur, aur,nonur;	
		UserDto urD, aurD, nonurD;
		ur = new User("ciao", "password", "ciao@password", 3);
		urD = UserConverter.toUserDto(ur);
		nonurD= new UserDto();
		nonur =new User();
		aur = new User("ciao", "password", "ciao@password", 5);
		aur.setAdmin(true);
		aurD = UserConverter.toUserDto(aur);
		
		int a;
		ur=UserConverter.toUser(userService.saveUser(UserConverter.toUserDto(ur)));
		a = userService.increaseUserReputation( ur.getUserId() );
		assertEquals((Integer) a, (Integer) 4);
		
        try {
            userService.increaseUserReputation(-1);
            fail("Expected InvalidUserException for userId ");
        } catch (InvalidUserException e) {
            assertEquals(e.getMessage(), "Wrong userID");
        }
        
        ur.setReputation(5);
        ur=UserConverter.toUser(userService.saveUser(UserConverter.toUserDto(ur)));
		a = userService.increaseUserReputation( ur.getUserId() );
		assertEquals((Integer) a, (Integer) 5);
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#decreaseUserReputation(java.lang.Integer)}.
	 * @throws InvalidUserException 
	 */
	@Test
	public void testDecreaseUserReputation() throws InvalidUserException {
		User ur, aur,nonur;	
		UserDto urD, aurD, nonurD;
		ur = new User("ciao", "password", "ciao@password", 3);
		urD = UserConverter.toUserDto(ur);
		nonurD= new UserDto();
		nonur =new User();
		aur = new User("ciao", "password", "ciao@password", 5);
		aur.setAdmin(true);
		aurD = UserConverter.toUserDto(aur);
		
		int a,b;
		userService.saveUser(UserConverter.toUserDto(ur));
		a = userService.decreaseUserReputation( 1 );
		assertEquals((Integer) a, (Integer) 2);
	
        try {
            userService.decreaseUserReputation(-12);
            fail("Expected InvalidUserException for userId " + nonur.getUserId());
        } catch (InvalidUserException e) {
            assertEquals(e.getMessage(), "Wrong userID");
        }
        
        ur.setReputation(-5);
        userService.saveUser(UserConverter.toUserDto(ur));
		a = userService.decreaseUserReputation( 1);
		b = -5;
		assertEquals((Integer) a, (Integer) b);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
}
 

