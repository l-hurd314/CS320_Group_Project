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
	public void testSetGetUsername() {
		testUser.setUsername("Melissa");
		assertEquals("Melissa", testUser.getUsername());
	}
	
	@Test
	public void testSetGetUsername2() {
		testUser.setUsername("Liam");
		assertEquals("Liam", testUser.getUsername());
	}
	
	@Test
	public void testSetGetUsername3() {
		testUser.setUsername("Matt");
		assertEquals("Matt", testUser.getUsername());
	}
	
	@Test
	public void testSetGetLastname() {
		testUser.setPassword("Ritchie");
		assertEquals("Ritchie", testUser.getPassword());
	}
	
	@Test
	public void testSetGetLastname2() {
		testUser.setPassword("Hurd");
		assertEquals("Hurd", testUser.getPassword());
	}
	
	@Test
	public void testSetGetLastname3() {
		testUser.setPassword("Morrison");
		assertEquals("Morrison", testUser.getPassword());
	}
	
	@Test
	public void testSetGetBoth() {
		testUser.setUsername("Matt");
		testUser.setPassword("Ritchie");
		assertEquals("Matt", testUser.getUsername());
		assertEquals("Ritchie", testUser.getPassword());
		testUser.setUsername("Melissa");
		assertEquals("Melissa", testUser.getUsername());
		testUser.setPassword("Morrison");
		assertEquals("Morrison", testUser.getPassword());
		testUser.setUsername("Liam");
		testUser.setPassword("Hurd");
		assertEquals("Liam", testUser.getUsername());
		assertEquals("Hurd", testUser.getPassword());
	}
}
