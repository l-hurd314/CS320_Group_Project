package edu.ycp.cs320.ms1.persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ycp.cs320.ms1.model.User;
import edu.ycp.cs320.ms1.model.Pair;
import edu.ycp.cs320.ms1.model.TextPost;

public class FakeDatabase implements IDatabase{
	
	private List<User> userList;
	private List<TextPost> postList;
	
	public FakeDatabase() {
		userList = new ArrayList<User>();
		postList = new ArrayList<TextPost>();
		
		// Add initial data
		readInitialData();
		
		System.out.println(userList.size() + " users");
		System.out.println(postList.size() + " textTextPosts");
	}

	public void readInitialData() {
		try {
			userList.addAll(InitialData.getUsers());
			postList.addAll(InitialData.getTextPosts());
		} catch (IOException e) {
			throw new IllegalStateException("Couldn't read initial data", e);
		}
	}
	
	public List<Pair<User, TextPost>> findUserAndTextPostByTitle(String title) {
		List<Pair<User, TextPost>> result = new ArrayList<Pair<User,TextPost>>();
		for (TextPost post : postList) {
			if (post.getTitle().equals(title)) {
				User user = findUserByUserId(post.getUserId());
				result.add(new Pair<User, TextPost>(user, post));
			}
		}
		return result;
	}
	public List<Pair<User, TextPost>> findUserAndTextPostByUserLastName(String lastname){
		List<Pair<User, TextPost>> result = new ArrayList<Pair<User,TextPost>>();
		for(User user : userList){
			if(user.getPassword().equals(lastname)){
				for (TextPost post : postList) {
					if (post.getUserId() == user.getUserId()) {
						result.add(new Pair<User, TextPost>(user, post));
					}
				}
			}
		}
		return result;
	}
	
	public void addTextPost(String lastname, String firstname, String isbn, String title, int year){
		boolean userFound = false;
		User postUser = new User();
		for(User user : userList){
			if(user.getPassword().equals(lastname) && user.getUsername().equals(firstname)){
				userFound = true;
				postUser = user;
				break;
			}
		}
		if(!userFound){
			postUser.setUsername(firstname);
			postUser.setPassword(lastname);
			postUser.setUserId(userList.size() + 1);
			userList.add(postUser);
		}
		
		TextPost post = new TextPost();
		post.setUserId(postUser.getUserId());
		post.setContents(isbn);
		//post.setPublished(year);
		post.setTitle(title);
		post.setPostId(postList.size() + 1);
		postList.add(post);
		
		System.out.println(userList.size() + " users");
		System.out.println(postList.size() + " posts");
	}

	private User findUserByUserId(int userId) {
		for (User user : userList) {
			if (user.getUserId() == userId) {
				return user;
			}
		}
		return null;
	}

	
	//auto-generated stuff
	@Override
	public List<Pair<User, TextPost>> findUserAndTextPostByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTextPost(String username, String contents, String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer insertPostIntoPostsTable(String title, String username, String content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
}
