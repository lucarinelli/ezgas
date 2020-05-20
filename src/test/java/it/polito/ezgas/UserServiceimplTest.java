/**
 * 
 */
package it.polito.ezgas;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

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
import it.polito.ezgas.converter.UserConverter;
import it.polito.ezgas.service.impl.UserServiceimpl;
import it.polito.ezgas.dto.UserDto;


public class UserServiceimplTest {
//	// DB managment
	static Connection db;
	static Statement st;
    static String sqlCreateUserTable = "CREATE TABLE USER " +
            "(user_id INTEGER AUTO_INCREMENT PRIMARY KEY, " +
            "admin BOOLEAN, " +
            "email VARCHAR(255), " +
            "password VARCHAR(255), " +
            "reputation INTEGER, " +
            "user_name VARCHAR(255))";
	//Repository
	UserRepository userRepository;
	//User, Admin, NotUser
	private User ur, aur, nonur;
	private UserDto urD, aurD, nonurD;
	// UserService interface
	private UserService userService;
	

    @PostConstruct
    @BeforeClass  // run only once
    public static void setUpDatabase() throws SQLException {
        db = DriverManager.getConnection("jdbc:h2:./data/test", "sa", "password");
        st = db.createStatement();
        st.executeUpdate("DROP TABLE IF EXISTS USER");
        st.executeUpdate(sqlCreateUserTable);
    }
	
	@Before
	public void setUp() {
		userRepository.deleteAll();
		
		ur = new User("ciao", "password", "ciao@password", 3);
		ur.setUserId(1);
		urD = UserConverter.toUserDto(ur);
		
		aur = new User("ciao", "password", "ciao@password", 5);
		aur.setUserId(2);
		aur.setAdmin(true);
		aurD = UserConverter.toUserDto(aur);
		
		userRepository.save(ur);
		userRepository.save(aur);
	}
	
    @AfterClass  // run only once
    public static void tearDown() throws SQLException {
        st.close();
        db.close();
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
		UserDto user;
		setUp();
		
		urD.setUserName("Pollo");
		user=userService.saveUser(urD);
		assertEquals(user.getUserName(), "Pollo");
		
		userRepository.deleteAll();
		urD = new UserDto(1, "ciao", "password", "ciao@password", 3, false);
		user=userService.saveUser(urD);
		assertEquals(user, urD);
		
		userRepository.deleteAll();
		user=userService.saveUser(nonurD);
		assertNull(user.getUserName());
	}

	/**
	 * Test method for {@link it.polito.ezgas.service.impl.UserServiceimpl#getAllUsers()}.
	 */
	@Test
	public void testGetAllUsers() {
		setUp();
		List<UserDto> users= new ArrayList<UserDto>();
		
		users=userService.getAllUsers();
		assertEquals(users.get(0), urD);
		assertEquals(users.get(1), aurD);
		
		userRepository.deleteAll();
		users=userService.getAllUsers();
		assertNull(users);
		
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
	 * @throws InvalidUserException 
	 */
	@Test
	public void testIncreaseUserReputation() throws InvalidUserException {
		setUp();
		int a;
		
		a = userService.increaseUserReputation( ur.getUserId() );
		assertEquals((Integer) a, (Integer) 4);
		
        try {
            userService.increaseUserReputation(nonur.getUserId());
            fail("Expected InvalidUserException for userId " + nonur.getUserId());
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
