package edu.ycp.cs320.ms1.model;

import java.util.List;
import java.util.ArrayList;


public class User {
	private int userId;
	private String username;
	private String password;
	private List<TextPost> posts;
	
	public User() {
		this.posts = new ArrayList<TextPost>();
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public List<TextPost> getPostList(){
		return this.posts;
	}
	
}
