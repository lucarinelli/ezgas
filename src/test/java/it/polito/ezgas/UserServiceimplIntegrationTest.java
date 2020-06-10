package it.polito.ezgas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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

import exception.GPSDataException;
import exception.InvalidLoginDataException;
import exception.InvalidUserException;
import exception.PriceException;
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
		private UserRepository repositoryUser;
	    
	    @Bean
	    public UserService userService() {
	    	return new UserServiceimpl(repositoryUser);
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
		result1=userService.getUserById(result.getUserId());
		assertEquals(result.getAdmin(),result1.getAdmin());
		assertEquals(result.getEmail(),result1.getEmail());
		assertEquals(result.getPassword(),result1.getPassword());
		assertEquals(result.getReputation(),result1.getReputation());
		assertEquals(result.getUserId(),result1.getUserId());
		assertEquals(result.getUserName(),result1.getUserName());	
			
		
  }
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#saveUser(it.polito.ezgas.dto.UserDto)}.
	 * @throws InvalidUserException 
	 */
	@Test
	public void testSaveUser1() throws InvalidUserException {
		
		User ur, aur;	
		UserDto urD, result,result1;
		
		ur = new User("ciao", "password", "ciao@password", 3);
		urD = UserConverter.toUserDto(ur);
		result= userService.saveUser(urD);

		
		urD= userService.getUserById(result.getUserId());
		
		assertEquals(result.getAdmin(),urD.getAdmin());
		assertEquals(result.getEmail(),urD.getEmail());
		assertEquals(result.getPassword(),urD.getPassword());
		assertEquals(result.getReputation(),urD.getReputation());
		assertEquals(result.getUserId(),urD.getUserId());
		assertEquals(result.getUserName(),urD.getUserName());
		
}
	
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#saveUser(it.polito.ezgas.dto.UserDto)}.
	 * @throws InvalidUserException 
	 */
	@Test
	public void testSaveUser2() throws InvalidUserException {
		
		User ur, aur;	
		UserDto urD, result,result1;
		
		ur = new User("ciao", "password", "ciao@password", 3);
		urD = UserConverter.toUserDto(ur);
		result= userService.saveUser(urD);

		
		urD= userService.getUserById(result.getUserId());
		
		assertEquals(result.getAdmin(),urD.getAdmin());
		assertEquals(result.getEmail(),urD.getEmail());
		assertEquals(result.getPassword(),urD.getPassword());
		assertEquals(result.getReputation(),urD.getReputation());
		assertEquals(result.getUserId(),urD.getUserId());
		assertEquals(result.getUserName(),urD.getUserName());
		
		
}
	
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#getAllUsers()}.
	 */
	@Test
	public void testGetAllUsers1() {
		User ur, aur,nonur;	
		UserDto urD, aurD, nonurD;
		ur = new User("ciao", "password", "ciao@password", 3);
		urD = UserConverter.toUserDto(ur);
		nonurD= new UserDto();
		nonur =new User();
		aur = new User("ciao", "password", "ciao1@password", 5);
		aur.setAdmin(true);
		aurD = UserConverter.toUserDto(aur);
		
		List<User> users= new ArrayList<User>();
		List<UserDto> users1 = new ArrayList<UserDto>();
		List <UserDto> users2= new ArrayList<UserDto>();
		users.add(aur);
		users.add(ur);
		urD=userService.saveUser(urD);
		users1.add(urD);
		
		aurD=userService.saveUser(aurD);
		users1.add(aurD);
		
     	users2=userService.getAllUsers();
		Collection<UserDto> collection = new ArrayList<UserDto>(users1);
		
		assertEquals(users2.size(), collection.size());
		users2.removeAll(collection);
	
		
	}

	
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#getAllUsers()}.
	 * UserId is null, should throw an exception
	 */
	@Test
	public void testGetUserById2() {
		User ur;
		UserDto urD;
		ur = new User();
		
		try {
			urD = userService.getUserById(ur.getUserId());
		} catch (InvalidUserException e) {
			return;
		}
		fail();
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#getAllUsers()}.
	 * UserId is negative, should throw an exception
	 */
	@Test
	public void testGetUserById3() {
		User ur;
		UserDto urD;
		ur = new User();
		ur.setUserId(-1);
		
		try {
			urD = userService.getUserById(ur.getUserId());
		} catch (InvalidUserException e) {
			return;
		}
		fail();
	}
	
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#deleteUser(java.lang.Integer)}.
	 */
	@Test
	public void testDeleteUser() throws InvalidUserException {
		User ur = new User("ciao", "password", "ciao@password", 3);
		UserDto urDto;
		try {
		
			urDto = userService.saveUser(UserConverter.toUserDto(ur));
			
		assertTrue(	userService.deleteUser(urDto.getUserId()));
		
		
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
		ur = new User("ciao", "password", "ciao@password", 0);
		urD = UserConverter.toUserDto(ur);
		
		int a,b;
		
		urD=userService.saveUser(UserConverter.toUserDto(ur));
		b=urD.getReputation()+1;
		a = userService.increaseUserReputation( urD.getUserId() );
		assertEquals(a,b);
		
		a = userService.increaseUserReputation( urD.getUserId() );
		
        try {
            userService.decreaseUserReputation(-12);
            fail("Expected InvalidUserException for userId " );
        } catch (InvalidUserException e) {
            assertEquals(e.getMessage(), "Wrong userID");
        }
        
        ur.setReputation(5);
        urD=userService.saveUser(UserConverter.toUserDto(ur));

        userService.increaseUserReputation( urD.getUserId());
        userService.increaseUserReputation( urD.getUserId());
        userService.increaseUserReputation( urD.getUserId());
        userService.increaseUserReputation( urD.getUserId());
        userService.increaseUserReputation( urD.getUserId());
        userService.increaseUserReputation( urD.getUserId());
		a = userService.increaseUserReputation( urD.getUserId());
		b = 5;
		assertEquals( a, b);
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#decreaseUserReputation(java.lang.Integer)}.
	 * @throws InvalidUserException 
	 */
	@Test
	public void testDecreaseUserReputation() throws InvalidUserException {
		User ur, aur,nonur;	
		UserDto urD, aurD, nonurD;
		ur = new User("ciao", "password", "ciao@password", 0);
		urD = UserConverter.toUserDto(ur);
		
		int a,b,c,d;
		c = -1;
		d = -2;
		urD=userService.saveUser(UserConverter.toUserDto(ur));
		b=urD.getReputation()-1;
		a = userService.decreaseUserReputation( urD.getUserId() );
		assertEquals((Integer) a, (Integer) c);
		assertEquals(a,b);
		
		a = userService.decreaseUserReputation( urD.getUserId() );
		
        try {
            userService.decreaseUserReputation(-12);
            fail("Expected InvalidUserException for userId " );
        } catch (InvalidUserException e) {
            assertEquals(e.getMessage(), "Wrong userID");
        }
        
        ur.setReputation(-5);
        urD=userService.saveUser(UserConverter.toUserDto(ur));

        userService.decreaseUserReputation( urD.getUserId());
        userService.decreaseUserReputation( urD.getUserId());
        userService.decreaseUserReputation( urD.getUserId());
        userService.decreaseUserReputation( urD.getUserId());
        userService.decreaseUserReputation( urD.getUserId());
        userService.decreaseUserReputation( urD.getUserId());
		a = userService.decreaseUserReputation( urD.getUserId());
		b = -5;
		assertEquals( a, b);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
}
 

