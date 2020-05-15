package it.polito.ezgas.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import it.polito.ezgas.entity.User;;

@RunWith(SpringRunner.class)
public class UserEntityTest {
 String userName="ciao";	
 String password="password";	
 String email ="ciao@password";
 Integer reputation = 3;
User user = new User(userName,password,email,reputation);

@Test
public void tgp() {
	assertEquals(user.getPassword(),password);


}
@Test
public void tgu() {
	assertEquals(user.getUserName(),userName);
}
@Test
public void tge() {
	assertEquals(user.getEmail(),email);
}
@Test
public void tgr() {
	assertEquals(user.getReputation(),reputation);
}
@Test
public void tga () {
	assertEquals(user.getAdmin(),false);
}
@Test 
public void tsp () {
	String passwd=password+"##";
	user.setPassword(passwd);
	assertEquals(user.getPassword(),passwd);
	
} 


@Test 
public void tsu () {
	String passwd=password+"##";
	user.setUserName(passwd);(passwd);
	assertEquals(user.getPassword(),passwd);
	
}
@Test 
public void tse () {
	String mail=email+"##";
	user.setEmail(mail);
	assertEquals(user.getEmail(),mail);
	
}
@Test 
public void tsr () {
	 reputation=reputation+1;
	user.setReputation(reputation);
	assertEquals(user.getReputation(),reputation);
	
}
}
