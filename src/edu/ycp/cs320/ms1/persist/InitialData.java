package edu.ycp.cs320.ms1.persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ycp.cs320.ms1.model.User;
import edu.ycp.cs320.ms1.model.TextPost;

public class InitialData {
	public static List<User> getUsers() throws IOException {
		List<User> userList = new ArrayList<User>();
		ReadCSV readUsers = new ReadCSV("users.csv");
		try {
			// auto-generated primary key for users table
			Integer userId = 1;
			while (true) {
				List<String> tuple = readUsers.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				User user = new User();
				user.setUserId(userId++);				
				user.setPassword(i.next());
				user.setUsername(i.next());
				userList.add(user);
			}
			return userList;
		} finally {
			readUsers.close();
		}
	}
	
	public static List<TextPost> getTextPosts() throws IOException {
		List<TextPost> bookList = new ArrayList<TextPost>();
		ReadCSV readBooks = new ReadCSV("books.csv");
		try {
			// auto-generated primary key for books table
			Integer bookId = 1;
			while (true) {
				List<String> tuple = readBooks.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				TextPost book = new TextPost();
				book.setPostId(bookId++);
				book.setUserId(Integer.parseInt(i.next()));
				book.setTitle(i.next());
				book.setContents(i.next());
				//book.setPublished(Integer.parseInt(i.next()));
				bookList.add(book);
			}
			return bookList;
		} finally {
			readBooks.close();
		}
	}
}
