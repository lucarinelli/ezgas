package it.polito.ezgas;

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
	    @Autowired
		private UserService userService;
	    public UserService userService() {
	    	return new UserServiceimpl(userRepository);
	    }
        
    }
	@Autowired
	private UserService userService;
	private User ur, aur, nonur;
	private UserDto urD, aurD, nonurD;
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
		List<UserDto> inserted = new ArrayList<UserDto>();	
		ur = new User("ciao", "password", "ciao@password", 3);
		ur.setUserId(1);
		urD = UserConverter.toUserDto(ur);
		aur = new User("ciao", "password", "ciao@password", 5);
		aur.setUserId(2);
		aur.setAdmin(true);
		aurD = UserConverter.toUserDto(aur);
		
		
	}
	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#getUserById(java.lang.Integer)}.
	 */
	@Test
	public final void testGetUserById(Integer userId) {
		setUp();
	userService.saveUser(urD);
	userService.saveUser(aurD);
	
		
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
 

