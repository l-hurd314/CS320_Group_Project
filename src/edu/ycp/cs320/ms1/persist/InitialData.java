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
		List<TextPost> postList = new ArrayList<TextPost>();
		ReadCSV readPosts = new ReadCSV("textPosts.csv");
		try {
			// auto-generated primary key for posts table
			Integer postId = 1;
			while (true) {
				List<String> tuple = readPosts.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				TextPost post = new TextPost();
				post.setPostId(postId++);
				post.setUserId(Integer.parseInt(i.next()));
				post.setTitle(i.next());
				post.setContents(i.next());
				//post.setPublished(Integer.parseInt(i.next()));
				postList.add(post);
			}
			return postList;
		} finally {
			readPosts.close();
		}
	}
}
