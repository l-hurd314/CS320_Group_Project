package edu.ycp.cs320.ms1.persist;
//copied from cs320 library example resource for structure,
// but then rewritten to fit our database
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.ms1.model.User;
import edu.ycp.cs320.ms1.model.TextPost;
//import edu.ycp.cs320.ms1.model.BookAuthor;
import edu.ycp.cs320.ms1.model.Pair;
import edu.ycp.cs320.ms1.model.TextPost;
import edu.ycp.cs320.ms1.model.User;

public class DerbyDatabase implements IDatabase {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}
	
	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;

//TODO not yet converted, commented out for later
/*	
	// transaction that retrieves a TextPost, and its User by Title
	@Override
	public List<Pair<User, TextPost>> findAuthorAndBookByTitle(final String title) {
		return executeTransaction(new Transaction<List<Pair<User,TextPost>>>() {
			@Override
			public List<Pair<User, TextPost>> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select authors.*, books.* " +
							"  from  authors, books, bookAuthors " +
							"  where books.title = ? " +
							"    and authors.author_id = bookAuthors.author_id " +
							"    and books.book_id     = bookAuthors.book_id"
					);
					stmt.setString(1, title);
					
					List<Pair<User, TextPost>> result = new ArrayList<Pair<User,TextPost>>();
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						User author = new User();
						loadAuthor(author, resultSet, 1);
						TextPost book = new TextPost();
						loadBook(book, resultSet, 4);
						
						result.add(new Pair<User, TextPost>(author, book));
					}
					
					// check if the title was found
					if (!found) {
						System.out.println("<" + title + "> was not found in the books table");
					}
					
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
*/	
//TODO not yet converted, commented out for later
	/*
	// transaction that retrieves a list of Books with their Authors, given User's last name
	@Override
	public List<Pair<User, TextPost>> findAuthorAndBookByAuthorLastName(final String lastName) {
		return executeTransaction(new Transaction<List<Pair<User,TextPost>>>() {
			@Override
			public List<Pair<User, TextPost>> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				// try to retrieve Authors and Books based on User's last name, passed into query
				try {
					stmt = conn.prepareStatement(
							"select authors.*, books.* " +
							"  from  authors, books, bookAuthors " +
							"  where authors.lastname = ? " +
							"    and authors.author_id = bookAuthors.author_id " +
							"    and books.book_id     = bookAuthors.book_id "   +
							"  order by books.title asc, books.published asc"
					);
					stmt.setString(1, lastName);
					
					// establish the list of (User, TextPost) Pairs to receive the result
					List<Pair<User, TextPost>> result = new ArrayList<Pair<User,TextPost>>();
					
					// execute the query, get the results, and assemble them in an ArrayLsit
					resultSet = stmt.executeQuery();
					while (resultSet.next()) {
						User author = new User();
						loadAuthor(author, resultSet, 1);
						TextPost book = new TextPost();
						loadBook(book, resultSet, 4);
						
						result.add(new Pair<User, TextPost>(author, book));
					}
					
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	*/
//TODO not yet converted, commented out for later
	/*
	// transaction that retrieves all Books in Library, with their respective Authors
	@Override
	public List<Pair<User, TextPost>> findAllBooksWithAuthors() {
		return executeTransaction(new Transaction<List<Pair<User,TextPost>>>() {
			@Override
			public List<Pair<User, TextPost>> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select authors.*, books.* " +
							"  from authors, books, bookAuthors " +
							"  where authors.author_id = bookAuthors.author_id " +
							"    and books.book_id     = bookAuthors.book_id "   +
							"  order by books.title asc"
					);
					
					List<Pair<User, TextPost>> result = new ArrayList<Pair<User,TextPost>>();
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						User author = new User();
						loadAuthor(author, resultSet, 1);
						TextPost book = new TextPost();
						loadBook(book, resultSet, 4);
						
						result.add(new Pair<User, TextPost>(author, book));
					}
					
					// check if any books were found
					if (!found) {
						System.out.println("No books were found in the database");
					}
					
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}	
	*/
	
	// transaction that inspects creds in Library
		@Override
		public int isGoodCreds(String username, String password) {
			return executeTransaction(new Transaction<Integer>() {
				@Override
				public Integer execute(Connection conn) throws SQLException {
					PreparedStatement stmt = null;
					ResultSet resultSet = null;
					
					try {
						stmt = conn.prepareStatement(
								"select * from USERS " 
							  + "where users.username = ?"
						);
						
						stmt.setString(1, username);
						
						List<String> resultlist = new ArrayList<String>();
						//result.get(0).intValue();
						resultSet = stmt.executeQuery();
						
						// for testing that a result was returned
						Boolean found = false;
						
						while (resultSet.next()) {
							found = true;
							
							User user = new User();
							loadUser(user, resultSet, 1);
							
							//System.out.println(user.getPassword());
							resultlist.add(user.getPassword());
						}
						
						int result;
						
						// check if any users were found
						if (!found) {
							result = -1;
							//System.out.println("No users were found in the database (derby)");
						}
						
				//check and return actual result
						//System.out.println(resultlist.get(0));
						//System.out.println(resultlist.get(1));
						else if(resultlist.size()>1){
							result = 2;
						}
						else {
							if(resultlist.get(0).equals(password)){
								result = 1;
							}
							else {
								result = 0;
							}
						}
						
						return result;
					} finally {
						DBUtil.closeQuietly(resultSet);
						DBUtil.closeQuietly(stmt);
					}
				}
			});
		}
	
	// transaction that retrieves all Authors in Library
	@Override
	public List<User> findAllUsers() {
		return executeTransaction(new Transaction<List<User>>() {
			@Override
			public List<User> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select * from USERS " 
						  //+ " order by username asc"
					);
					
					List<User> result = new ArrayList<User>();
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						User user = new User();
						loadUser(user, resultSet, 1);
						
						result.add(user);
					}
					
					// check if any users were found
					if (!found) {
						System.out.println("No users were found in the database");
					}
					
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	
	// transaction that inserts new TextPost into the Books table
	// also first inserts new User into Authors table, if necessary
	// and then inserts entry into BookAuthors junction table
	@Override
	public Integer insertPostIntoPostsTable(final String title, final String userName, final String content) {
		//Table setup: post id, user id, title, content
		return executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				PreparedStatement stmt4 = null;
				PreparedStatement stmt5 = null;
				PreparedStatement stmt6 = null;				
				
				ResultSet resultSet1 = null;
//	(unused)	ResultSet resultSet2 = null;
				ResultSet resultSet3 = null;
//	(unused)	ResultSet resultSet4 = null;
				ResultSet resultSet5 = null;				
//	(unused)	ResultSet resultSet6 = null;
				
				// for saving author ID and book ID
				Integer user_id = -1;
				Integer post_id   = -1;

				// try to retrieve author_id (if it exists) from DB, for User's full name, passed into query
				try {
					//TODO: check capitalization on variable name
					stmt1 = conn.prepareStatement(
							"select user_id from users " +
							"  where username = ?"
					);
					stmt1.setString(1, userName);
					//stmt1.setString(2, firstName);
					
					// execute the query, get the result
					resultSet1 = stmt1.executeQuery();

					
					// if User was found then save author_id					
					if (resultSet1.next())
					{
						user_id = resultSet1.getInt(1); //TODO: if bug, do rows match up? start at 0? 1?
						System.out.println("User <" + userName + "> found with ID: " + user_id);						
					}
					else
					{
						System.out.println("ERROR: user should always be in users list before being allowed to post.\n"
								+ "You should not be seeing this.");
						System.out.println("User <" + userName + "> not found");
						
						// if the User is new, insert new User into Users table
						if (user_id <= 0) {
							// prepare SQL insert statement to add User to Users table
							stmt2 = conn.prepareStatement(
									"insert into users (username) " +
									"  values(?) "
							);
							stmt2.setString(1, userName);
							//stmt2.setString(2, firstName);
							
							// execute the update
							stmt2.executeUpdate();
							
							System.out.println("New user <" + userName + "> inserted in Users table");						
						
							// try to retrieve author_id for new User - DB auto-generates author_id
							stmt3 = conn.prepareStatement(
									"select user_id from USERS " +
									"  where username = ?"
							);
							stmt3.setString(1, userName);
							//stmt3.setString(2, firstName);
							
							// execute the query							
							resultSet3 = stmt3.executeQuery();
							
							// get the result - there had better be one							
							if (resultSet3.next())
							{
								user_id = resultSet3.getInt(1);
								System.out.println("New user <" + userName + "> ID: " + user_id);						
							}
							else	// really should throw an exception here - the new author should have been inserted, but we didn't find them
							{
								System.out.println("New user <" + userName + "> not found in Users table (ID: " + user_id + ")");
							}
						}
					}
					
					// now insert new TextPost into Posts table
					// prepare SQL insert statement to add new TextPost to Books table
					//Table setup: post id, user id, title, content
					stmt4 = conn.prepareStatement(
							"insert into textPosts (user_id, title, contents) " +
							"  values(?, ?, ?) "
					);
					stmt4.setString(2, title);
					stmt4.setInt(1, user_id);
					stmt4.setString(3, content);
					
					// execute the update
					stmt4.executeUpdate();
					
					System.out.println("New post <" + title + "> inserted into Posts table");					

					// now retrieve book_id for new TextPost, so that we can set up BookAuthor entry
					// and return the book_id, which the DB auto-generates
					// prepare SQL statement to retrieve book_id for new TextPost
					stmt5 = conn.prepareStatement(
							"select post_id from textPosts " +
							"  where title = ? and user_id = ? and contents = ? "
									
					);
					stmt5.setString(1, title);
					stmt5.setString(3, content);
					stmt5.setInt(2, user_id);

					// execute the query
					resultSet5 = stmt5.executeQuery();
					
					// get the result - there had better be one
					if (resultSet5.next())
					{
						post_id = resultSet5.getInt(1);
						System.out.println("New post <" + title + "> ID: " + post_id);						
					}
					else	// really should throw an exception here - the new book should have been inserted, but we didn't find it
					{
						System.out.println("New post <" + title + "> not found in Posts table (ID: " + post_id);
					}
	//TODO: We only need the rest of this if we do a 3-table setup				
					/*
					// now that we have all the information, insert entry into BookAuthors table
					// which is the junction table for Books and Authors
					// prepare SQL insert statement to add new TextPost to Books table
					stmt6 = conn.prepareStatement(
							"insert into bookAuthors (book_id, author_id) " +
							"  values(?, ?) "
					);
					stmt6.setInt(1, book_id);
					stmt6.setInt(2, author_id);
					
					// execute the update
					stmt6.executeUpdate();
					
					System.out.println("New entry for book ID <" + book_id + "> and author ID <" + author_id + "> inserted into BookAuthors junction table");						
					
					System.out.println("New book <" + title + "> inserted into Books table");					
					*/
					return post_id;
				} finally {
					DBUtil.closeQuietly(resultSet1);
					DBUtil.closeQuietly(stmt1);
//	(unused)		DBUtil.closeQuietly(resultSet2);
					DBUtil.closeQuietly(stmt2);					
					DBUtil.closeQuietly(resultSet3);
					DBUtil.closeQuietly(stmt3);					
// (unused)			DBUtil.closeQuietly(resultSet4);
					DBUtil.closeQuietly(stmt4);
					DBUtil.closeQuietly(resultSet5);
					DBUtil.closeQuietly(stmt5);
// (unused)			DBUtil.closeQuietly(resultSet6);
					DBUtil.closeQuietly(stmt6);
				}
			}
		});
	}
	
/*	
	// transaction that deletes TextPost (and possibly its User) from Library
	@Override
	public List<User> removeBookByTitle(final String title) {
		return executeTransaction(new Transaction<List<User>>() {
			@Override
			public List<User> execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				PreparedStatement stmt4 = null;
				PreparedStatement stmt5 = null;
				PreparedStatement stmt6 = null;							
				
				ResultSet resultSet1    = null;			
				ResultSet resultSet2    = null;
//				ResultSet resultSet3    = null;
//				ResultSet resultSet4    = null;
				ResultSet resultSet5    = null;
//				ResultSet resultSet6    = null;				
				
				try {
					// first get the User(s) of the TextPost to be deleted
					// just in case it's the only TextPost by this User
					// in which case, we should also remove the User(s)
					stmt1 = conn.prepareStatement(
							"select authors.* " +
							"  from  authors, books, bookAuthors " +
							"  where books.title = ? " +
							"    and authors.author_id = bookAuthors.author_id " +
							"    and books.book_id     = bookAuthors.book_id"
					);
					
					// get the TextPost's User(s)
					stmt1.setString(1, title);
					resultSet1 = stmt1.executeQuery();
					
					// assemble list of Authors from query
					List<User> authors = new ArrayList<User>();					
				
					while (resultSet1.next()) {
						User author = new User();
						loadAuthor(author, resultSet1, 1);
						authors.add(author);
					}
					
					// check if any Authors were found
					// this shouldn't be necessary, there should not be a TextPost in the DB without an User
					if (authors.size() == 0) {
						System.out.println("No author was found for title <" + title + "> in the database");
					}
										
					// now get the TextPost(s) to be deleted
					// we will need the book_id to remove associated entries in BookAuthors (junction table)
				
					stmt2 = conn.prepareStatement(
							"select books.* " +
							"  from  books " +
							"  where books.title = ? "
					);
					
					// get the TextPost(s)
					stmt2.setString(1, title);
					resultSet2 = stmt2.executeQuery();
					
					// assemble list of Books from query
					List<TextPost> books = new ArrayList<TextPost>();					
				
					while (resultSet2.next()) {
						TextPost book = new TextPost();
						loadBook(book, resultSet2, 1);
						books.add(book);
					}
					
					// first delete entries in BookAuthors junction table
					// can't delete entries in Books or Authors tables while they have foreign keys in junction table
					// prepare to delete the junction table entries (bookAuthors)
					stmt3 = conn.prepareStatement(
							"delete from bookAuthors " +
							"  where book_id = ? "
					);
					
					// delete the junction table entries from the DB for this title
					// this works if there are not multiple books with the same name
					stmt3.setInt(1, books.get(0).getBookId());
					stmt3.executeUpdate();
					
					System.out.println("Deleted junction table entries for book(s) <" + title + "> from DB");									
					
					// now delete entries in Books table for this title
					stmt4 = conn.prepareStatement(
							"delete from books " +
							"  where title = ? "
					);
					
					// delete the TextPost entries from the DB for this title
					stmt4.setString(1, title);
					stmt4.executeUpdate();
					
					System.out.println("Deleted book(s) with title <" + title + "> from DB");									
					
					// now check if the User(s) have any Books remaining in the DB
					// only need to check if there are any entries in junction table that have this author ID
					for (int i = 0; i < authors.size(); i++) {
						// prepare to find Books for this User
						stmt5 = conn.prepareStatement(
								"select books.book_id from books, bookAuthors " +
								"  where bookAuthors.author_id = ? "
						);
						
						// retrieve any remaining books for this User
						stmt5.setInt(1, books.get(i).getAuthorId());
						resultSet5 = stmt5.executeQuery();						

						// if nothing returned, then delete User
						if (!resultSet5.next()) {
							stmt6 = conn.prepareStatement(
								"delete from authors " +
								"  where author_id = ?"
							);
							
							// delete the User from DB
							stmt6.setInt(1, authors.get(i).getAuthorId());
							stmt6.executeUpdate();
							
							System.out.println("Deleted author <" + authors.get(i).getLastname() + ", " + authors.get(i).getFirstname() + "> from DB");
							
							// we're done with this, so close it, since we might have more to do
							DBUtil.closeQuietly(stmt6);
						}
						
						// we're done with this, so close it since we might have more to do
						DBUtil.closeQuietly(resultSet5);
						DBUtil.closeQuietly(stmt5);
					}
					return authors;
				} finally {
					DBUtil.closeQuietly(resultSet1);
					DBUtil.closeQuietly(resultSet2);
//					DBUtil.closeQuietly(resultSet3);
//					DBUtil.closeQuietly(resultSet4);
					
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(stmt3);					
					DBUtil.closeQuietly(stmt4);					
				}
			}
		});
	}
	
	*/
	// wrapper SQL transaction function that calls actual transaction function (which has retries)
	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}
	
	// SQL transaction function which retries the transaction MAX_ATTEMPTS times before failing
	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();
		
		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;
			
			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}
			
			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}
			
			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}

	// TODO: Here is where you specify the location of your Derby SQL database
	// TODO: You will need to change this location to the same path as your workspace for this example
	// TODO: Change it here and in SQLDemo under CS320_Lab06->edu.ycp.cs320.sqldemo	
	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:C:/CS320/library.db;create=true");		
		
		// Set autocommit() to false to allow the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}
	
	// retrieves User information from query result set
		private void loadUser(User user, ResultSet resultSet, int index) throws SQLException {
			user.setUserId(resultSet.getInt(index++));
			user.setUsername(resultSet.getString(index++));
			user.setPassword(resultSet.getString(index++));
		}
	
//TODO Dunno if we need this stuff
/*
	// retrieves User information from query result set
	private void loadAuthor(User author, ResultSet resultSet, int index) throws SQLException {
		author.setAuthorId(resultSet.getInt(index++));
		author.setLastname(resultSet.getString(index++));
		author.setFirstname(resultSet.getString(index++));
	}
	
	// retrieves TextPost information from query result set
	private void loadBook(TextPost book, ResultSet resultSet, int index) throws SQLException {
		book.setBookId(resultSet.getInt(index++));
//		book.setAuthorId(resultSet.getInt(index++));  // no longer used
		book.setTitle(resultSet.getString(index++));
		book.setIsbn(resultSet.getString(index++));
		book.setPublished(resultSet.getInt(index++));
	}
	
	// retrieves WrittenBy information from query result set
	private void loadBookAuthors(BookAuthor bookAuthor, ResultSet resultSet, int index) throws SQLException {
		bookAuthor.setBookId(resultSet.getInt(index++));
		bookAuthor.setAuthorId(resultSet.getInt(index++));
	}
*/
	//  creates the Authors and Books tables
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;				
			
				try {
					stmt1 = conn.prepareStatement(
						"create table users (" +
						"	user_id integer primary key " +
						"		generated always as identity (start with 1, increment by 1), " +									
						"	username varchar(40)," +
						"	password varchar(40)" +
						")"
					);	
					stmt1.executeUpdate();
					
					System.out.println("Users table created");
					
					stmt2 = conn.prepareStatement(
							"create table textposts (" +
							"	post_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
//							"	author_id integer constraint author_id references authors, " +
							"	user_id integer, " +
							"	title varchar(70)," +
							"	contents varchar(70)" +
							//" ,  published integer" +
							")"
					);
					stmt2.executeUpdate();
					
					System.out.println("TextPosts table created");					
					
/*
					stmt3 = conn.prepareStatement(
							"create table bookAuthors (" +
							"	book_id   integer constraint book_id references books, " +
							"	author_id integer constraint author_id references authors " +
							")"
					);
					stmt3.executeUpdate();
					
					System.out.println("BookAuthors table created");					
*/				
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
				}
			}
		});
	}
	
	// loads data retrieved from CSV files into DB tables in batch mode
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<User> userList;
				List<TextPost> postList;
				//List<BookAuthor> bookAuthorList;
				
				try {
					userList     = InitialData.getUsers();
					postList       = InitialData.getTextPosts();
					//bookAuthorList = InitialData.getBookAuthors();					
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertUser     = null;
				PreparedStatement insertTextPost       = null;
				//PreparedStatement insertBookAuthor = null;

				try {
					// must completely populate Authors table before populating BookAuthors table because of primary keys
					insertUser = conn.prepareStatement("insert into users (username, password) values (?, ?)");
					for (User user : userList) {
//						insertAuthor.setInt(1, author.getAuthorId());	// auto-generated primary key, don't insert this
						insertUser.setString(1, user.getUsername());
						insertUser.setString(2, user.getPassword());
						insertUser.addBatch();
					}
					insertUser.executeBatch();
					
					System.out.println("Users table populated");
					//Table setup: post id, user id, title, content
					// must completely populate Books table before populating BookAuthors table because of primary keys
					insertTextPost = conn.prepareStatement("insert into textPosts (user_id, title, contents) values (?, ?, ?)");
					for (TextPost post : postList) {
//						insertTextPost.setInt(1, book.getBookId());		// auto-generated primary key, don't insert this
//						insertTextPost.setInt(1, book.getAuthorId());	// this is now in the BookAuthors table
						insertTextPost.setInt(1, post.getUserId());
						insertTextPost.setString(2, post.getTitle());
						insertTextPost.setString(3, post.getContents());
						insertTextPost.addBatch();
					}
					insertTextPost.executeBatch();
					
					System.out.println("TextPosts table populated");					
					/*
					// must wait until all Books and all Authors are inserted into tables before creating BookAuthor table
					// since this table consists entirely of foreign keys, with constraints applied
					insertBookAuthor = conn.prepareStatement("insert into bookAuthors (book_id, author_id) values (?, ?)");
					for (BookAuthor bookAuthor : bookAuthorList) {
						insertBookAuthor.setInt(1, bookAuthor.getBookId());
						insertBookAuthor.setInt(2, bookAuthor.getAuthorId());
						insertBookAuthor.addBatch();
					}
					insertBookAuthor.executeBatch();	
					
					System.out.println("BookAuthors table populated");					
					*/
					return true;
				} finally {
					DBUtil.closeQuietly(insertTextPost);
					DBUtil.closeQuietly(insertUser);
					//DBUtil.closeQuietly(insertBookAuthor);					
				}
			}
		});
	}
	
	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		DerbyDatabase db = new DerbyDatabase();
		db.createTables();
		
		System.out.println("Loading initial data...");
		db.loadInitialData();
		
		System.out.println("Library DB successfully initialized!");
	}


	@Override
	public List<edu.ycp.cs320.ms1.model.Pair<User, TextPost>> findUserAndTextPostByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<edu.ycp.cs320.ms1.model.Pair<User, TextPost>> findUserAndTextPostByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addTextPost(String username, String contents, String title) {
		// TODO Auto-generated method stub
		
		
	}

	public List<TextPost> findAllTextPosts() {
		// TODO Auto-generated method stub
		
		return executeTransaction(new Transaction<List<TextPost>>() {
			@Override
			public List<TextPost> execute(Connection conn) throws SQLException {
				
				//List<BookAuthor> bookAuthorList;
				List<TextPost> postList = new ArrayList<TextPost>();
				PreparedStatement stmt1 = null;
				ResultSet resultSet;
				//PreparedStatement insertBookAuthor = null;

				try {
					stmt1 = conn.prepareStatement(
						"select * from textPosts"
					);
					resultSet = stmt1.executeQuery();
					while(resultSet.next()){
						
						postList.add(new TextPost(resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4)));
					}
					return postList;
				} finally {
					
					DBUtil.closeQuietly(stmt1);
					//DBUtil.closeQuietly(insertBookAuthor);					
				}
			}
		});
		//return postList;
	}

	@Override
	public List<TextPost> findMyTextPosts(String username) {
		/**
		 * Version 2.0 located in find_by_user_class.txt on Matt's laptop.
		 * Implemented as findMyTextPosts(User user) below;
		 */
		
		return executeTransaction(new Transaction<List<TextPost>>() {
			@Override
			public List<TextPost> execute(Connection conn) throws SQLException {
				
				//List<BookAuthor> bookAuthorList;
				List<TextPost> postList = new ArrayList<TextPost>();
				PreparedStatement stmt1 = null;
				ResultSet resultSet;
				PreparedStatement stmt = null;				
				ResultSet resultSet1;
				int user_id;

				try {
					stmt = conn.prepareStatement(
							"select user_id from users " +
							"  where username = ?"
					);
					stmt.setString(1, username);
					//stmt1.setString(2, firstName);
					
					// execute the query, get the result
					resultSet1 = stmt.executeQuery();

					
					// if User was found then save author_id					
					if (resultSet1.next()){
						user_id = resultSet1.getInt(1); //TODO: if bug, do rows match up? start at 1, not 0
					}
					else{
						System.out.println("User does not exist");
						return null;
					}
					stmt1 = conn.prepareStatement(
						"select * from textPosts"
					);
					resultSet = stmt1.executeQuery();
					while(resultSet.next()){
						TextPost post = new TextPost(resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4));
						if(post.getUserId() == user_id){
							postList.add(post);
						}
						
					}
					return postList;
				} finally {
					
					DBUtil.closeQuietly(stmt1);
					//DBUtil.closeQuietly(insertBookAuthor);					
				}
			}
		});
		//return postList;
	}

	public List<TextPost> findMyTextPosts(User user) {		
		return executeTransaction(new Transaction<List<TextPost>>() {
			@Override
			public List<TextPost> execute(Connection conn) throws SQLException {
				
				//List<BookAuthor> bookAuthorList;
				List<TextPost> postList = new ArrayList<TextPost>();
				PreparedStatement stmt1 = null;
				ResultSet resultSet;

				try {
					stmt1 = conn.prepareStatement(
						"select * from textPosts"
					  + "where user_id = ?"
					);
					
					stmt1.setInt(1, user.getUserId());
					
					resultSet = stmt1.executeQuery();
					while(resultSet.next()){
						
						postList.add(new TextPost(resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4)));
						
					}
					return postList;
				} finally {
					
					DBUtil.closeQuietly(stmt1);				
				}
			}
		});
		//return postList;
	}


	@Override
	public TextPost findTextPostByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}
}
