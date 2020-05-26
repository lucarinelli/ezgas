package it.polito.ezgas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
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

import exception.InvalidUserException;
import it.polito.ezgas.converter.UserConverter;
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
		UserDto urD, aurD, nonurD,result;
		
		
		ur = new User("ciao", "password", "ciao@password", 3);
		ur.setUserId(1);
		urD = UserConverter.toUserDto(ur);
		aur = new User("ciao", "password", "ciao@password", 5);
		aur.setUserId(2);
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
		result=userService.getUserById(ur.getUserId());
		assertEquals(result,urD);	
			
		
  }
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#saveUser(it.polito.ezgas.dto.UserDto)}.
	 */
	@Test
	public void testSaveUser() {
		
}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
}
 

