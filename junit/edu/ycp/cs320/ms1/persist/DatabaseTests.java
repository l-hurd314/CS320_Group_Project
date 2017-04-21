package edu.ycp.cs320.ms1.persist;
//copied from cs320 library example resource for structure,
//but then rewritten to fit our database
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.ycp.cs320.ms1.model.Pair;
import edu.ycp.cs320.ms1.model.User;
import edu.ycp.cs320.ms1.persist.DerbyDatabase;

public class DatabaseTests {
private IDatabase db = null;
	
	/*ArrayList<Author> authors = null;
	ArrayList<Book>   books   = null;
	List<Pair<Author, Book>> bookAuthorList = null;
	List<Pair<Author, Book>> authorBookList = null;	
	*/
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	/*@Test
	public void testFindAuthorAndBookByTitle() {
		System.out.println("\n*** Testing findAuthorAndBookByTitle ***");
		
		String title = "A Briefer History of Time";

		// get the list of (Author, Book) pairs from DB
		authorBookList = db.findAuthorAndBookByTitle(title);
		
		// NOTE: this is a simple test to check if no results were found in the DB
		if (authorBookList.isEmpty()) {
			System.out.println("No book found in library with title <" + title + ">");
			fail("No book with title <" + title + "> returned from Library DB");
		}
		// NOTE: assembling the results into Author and Book lists so that they could be
		//       inspected for correct content - well-formed objects with correct content
		else {			
			authors = new ArrayList<Author>();
			for (Pair<Author, Book> authorBook : authorBookList) {
				Author author = authorBook.getLeft();
				Book   book   = authorBook.getRight();
				authors.add(author);
				System.out.println(author.getLastname() + "," + author.getFirstname() + ", " + book.getTitle() + "," + book.getIsbn());
			}			
		}
	}*/

	/*@Test
	public void testFindAuthorAndBookByAuthorLastName() {
		System.out.println("\n*** Testing findAuthorAndBooksByAuthorLastName ***");

		String lastName = "Hawking";
		
		// get the list of (Author, Book) pairs from DB
		authorBookList = db.findAuthorAndBookByAuthorLastName(lastName);
		
		// NOTE: this is a simple test to check if no results were found in the DB
		if (authorBookList.isEmpty()) {
			System.out.println("No books found for author <" + lastName + ">");
			fail("No books for author <" + lastName + "> returned from Library DB");
		}
		// NOTE: assembling the results into Author and Book lists so that they could be
		//       inspected for correct content - well-formed objects with correct content
		else {
			books = new ArrayList<Book>();
			for (Pair<Author, Book> authorBook : authorBookList) {
				Author author = authorBook.getLeft();
				Book book = authorBook.getRight();
				books.add(book);
				System.out.println(author.getLastname() + "," + author.getFirstname() + "," + book.getTitle() + "," + book.getIsbn());
			}			
		}
	}*/

	/*@Test
	public void testFindAllBooksWithAuthors() {
		System.out.println("\n*** Testing findAllBooksWithAuthors ***");

		// get the list of (Author, Book) pairs from DB
		bookAuthorList = db.findAllBooksWithAuthors();
		
		// NOTE: this is a simple test to check if no results were found in the DB
		if (bookAuthorList.isEmpty()) {
			System.out.println("No books in database");
			fail("No books returned from Library DB");
		}
		// NOTE: assembling the results into Author and Book lists so that they could be
		//       inspected for correct content - well-formed objects with correct content
		else {
			books = new ArrayList<Book>();
			for (Pair<Author, Book> authorBook : bookAuthorList) {
				Author author = authorBook.getLeft();
				Book book = authorBook.getRight();
				books.add(book);
				System.out.println(book.getTitle() + ", " + book.getIsbn() + ", " + author.getLastname() + ", " + author.getFirstname());
			}			
		}
	}*/

	@Test
	public void testFindAllAuthors() {

		System.out.println("\n*** Testing findAllAuthors ***");

		// get the list of (Author, Book) pairs from DB
		List<User> users = db.findAllUsers();
		
		if (users.isEmpty()) {
			System.out.println("Failed to find user from DB.");
			fail("No users found from DB.");
		}
		else {
			System.out.println("User <" + users.get(users.size()-1).getUsername() + "> added to Library DB");
		}	
	}

	@Test
	public void testInsertTextPostIntoTextPostsTable() {
		System.out.println("\n*** Testing insertTextPostIntoTextPostsTable ***");

		String title     = "trialpost";
		String contents      = "Blah blah blah";
		//int   published = 2010;		
		String userName  = "Testman2";
		String password = "openup";
				
		// insert new book (and new author) into DB
		Integer post_id = db.insertPostIntoPostsTable(title, userName, contents);
		
		// check to see that insertion was successful before proceeding
		if (post_id > 0) {
			// now delete Book (and its Author) from DB
			List<User> users = db.findAllUsers();
			
			if (users.isEmpty()) {
				System.out.println("Failed to add user for post with title <" + title + ">");
				fail("No users created from DB for post with title <" + title + ">");
			}
			else {
				System.out.println("User <" + users.get(users.size()-1).getUsername() + "> added to Library DB");
			}					
			
			// get the list of (Author, Book) pairs from DB
			//authorBookList = db.findAuthorAndBookByTitle(title);
			
			/*if (authorBookList.isEmpty()) {
				System.out.println("All Books with title <" + title + "> were removed from the Library DB");
			}
			else {
				fail("Book with title <" + title + "> remains in Library DB after delete");			
			}*/
		}
		else {
			System.out.println("Failed to insert new post (ID: " + post_id + ") into TextPosts table: <" + title + ">");
			fail("Failed to insert new post <" + title + "> into Library DB");			
		}
	}
	

	/*@Test
	public void testRemoveBookByTitle() {
		System.out.println("\n*** Testing removeBookByTitle ***");
		
		String title     = "trialpost";
		String contents      = "Blah blah blah";
		//int   published = 2010;		
		String userName  = "Testman";
		String password = "openup";
				
		// insert new book (and new author) into DB
		Integer post_id = db.insertPostIntoPostsTable(title, userName, contents);
		
		// check to see that insertion was successful before proceeding
		if (post_id > 0) {
			// now delete Book (and its Author) from DB
			List<User> users = db.findAllUsers();
			
			if (users.isEmpty()) {
				System.out.println("Failed to add user for post with title <" + title + ">");
				fail("No users created from DB for post with title <" + title + ">");
			}
			else {
				System.out.println("User <" + users.get(2).getUsername() + "> added to Library DB");
			}					
			
			// get the list of (Author, Book) pairs from DB
			//authorBookList = db.findAuthorAndBookByTitle(title);
			
			if (authorBookList.isEmpty()) {
				System.out.println("All Books with title <" + title + "> were removed from the Library DB");
			}
			else {
				fail("Book with title <" + title + "> remains in Library DB after delete");			
			}
		}
		else {
			System.out.println("Failed to insert new post (ID: " + post_id + ") into TextPosts table: <" + title + ">");
			fail("Failed to insert new post <" + title + "> into Library DB");			
		}
	}*/
}
