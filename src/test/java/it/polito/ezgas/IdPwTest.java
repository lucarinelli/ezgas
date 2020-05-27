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

import it.polito.ezgas.dto.IdPw;

/**
 * @author LosPollosHermanos
 *
 */
public class IdPwTest {
    IdPw pw;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		pw= new IdPw("pollo","pollo");
	}


	/**
	 * Test method for {@link it.polito.ezgas.dto.IdPw#IdPw(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testIdPwStringString() {
		pw= new IdPw("pollo","pollo");
		assertEquals(pw.getUser(), "pollo");
		assertEquals(pw.getPw(), "pollo");
	}

	/**
	 * Test method for {@link it.polito.ezgas.dto.IdPw#IdPw()}.
	 */
	@Test
	public final void testIdPw() {
		pw= new IdPw();
		assertEquals(pw.getUser(), null);
		assertEquals(pw.getPw(), null);
	}

	/**
	 * Test method for {@link it.polito.ezgas.dto.IdPw#getUser()}.
	 * Test method for {@link it.polito.ezgas.dto.IdPw#setUser(java.lang.String)}.
	 */
	@Test
	public final void testSetGetUser() {
		pw.setUser("poll");
		assertEquals(pw.getUser(), "poll");
	}


	/**
	 * Test method for {@link it.polito.ezgas.dto.IdPw#getPw()}.
	 * Test method for {@link it.polito.ezgas.dto.IdPw#setPw(java.lang.String)}.
	 */
	@Test
	public final void testSetGetPw() {
		pw.setPw("poll");
		assertEquals(pw.getPw(), "poll");
	}

}
