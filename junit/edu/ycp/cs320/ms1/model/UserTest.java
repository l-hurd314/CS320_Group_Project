package edu.ycp.cs320.ms1.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.ms1.model.User;

public class UserTest {
	private User testUser;
	
	@Before
	public void setUp() {
		testUser = new User();
	}
	
	@Test
	public void testSetGetFirstname() {
		testUser.setFirstname("Melissa");
		assertEquals("Melissa", testUser.getFirstname());
	}
	
	@Test
	public void testSetGetFirstname2() {
		testUser.setFirstname("Liam");
		assertEquals("Liam", testUser.getFirstname());
	}
	
	@Test
	public void testSetGetFirstname3() {
		testUser.setFirstname("Matt");
		assertEquals("Matt", testUser.getFirstname());
	}
	
	@Test
	public void testSetGetLastname() {
		testUser.setLastname("Ritchie");
		assertEquals("Ritchie", testUser.getLastname());
	}
	
	@Test
	public void testSetGetLastname2() {
		testUser.setLastname("Hurd");
		assertEquals("Hurd", testUser.getLastname());
	}
	
	@Test
	public void testSetGetLastname3() {
		testUser.setLastname("Morrison");
		assertEquals("Morrison", testUser.getLastname());
	}
	
	@Test
	public void testSetGetBoth() {
		testUser.setFirstname("Matt");
		testUser.setLastname("Ritchie");
		assertEquals("Matt", testUser.getFirstname());
		assertEquals("Ritchie", testUser.getLastname());
		testUser.setFirstname("Melissa");
		assertEquals("Melissa", testUser.getFirstname());
		testUser.setLastname("Morrison");
		assertEquals("Morrison", testUser.getLastname());
		testUser.setFirstname("Liam");
		testUser.setLastname("Hurd");
		assertEquals("Liam", testUser.getFirstname());
		assertEquals("Hurd", testUser.getLastname());
	}
}
