package edu.ycp.cs320.ms1.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.ms1.model.User;

public class TextPostTest {
	private TextPost testPost;
	private TextPost testPost2;
	private int userId;
	private String title;
	private String contents;
	
	//TODO: Update this file after time-stamp is implemented
	
	@Before
	public void setUp() {
		testPost = new TextPost();
		userId = 12;
		title = "Poem.txt";
		contents = "I dig, you dig, he digs, she digs, we dig, they dig.... This isn't a pretty poem, but it's very deep.";
		testPost2 = new TextPost(userId, title, contents);
	}
	
	@Test
	public void testSetGetUserID() {
		testPost.setUserId(42);
		assertEquals(42, testPost.getUserId());
	}
	
	@Test
	public void testSetGetTitle() {
		testPost.setTitle("Shopping list.txt");
		assertEquals("Shopping list.txt", testPost.getTitle());
	}
	
	@Test
	public void testSetGetContents() {
		testPost.setContents("Matt is funny");
		assertEquals("Matt is funny", testPost.getContents());
	}
	
	@Test
	public void testGettersOfFullConstructor() {
		assertEquals(12, testPost2.getUserId());
		assertEquals("Poem.txt", testPost2.getTitle());
		assertEquals("I dig, you dig, he digs, she digs, we dig, they dig.... This isn't a pretty poem, but it's very deep.", testPost2.getContents());
	}
	
	@Test
	public void testChangesToFullConstructor() {
		testPost2.setUserId(43);
		testPost2.setTitle("Status Update.txt");
		testPost2.setContents("Matt is getting tired");
		assertEquals(43, testPost2.getUserId());
		assertEquals("Matt is getting tired", testPost2.getContents());
		assertEquals("Status Update.txt", testPost2.getTitle());
	}
	
	
}
