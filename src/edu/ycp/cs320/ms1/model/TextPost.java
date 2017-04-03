package edu.ycp.cs320.ms1.model;

public class TextPost {
	private int postId;
	private int userId;
	private String title;
	private String contents;
	//private int    published;
	//post timestamp
	
	public TextPost() {
		
	}
	
	
	//may need more fields?
	public TextPost(int userId, String title, String contents) {
		this.userId = userId;
		this.title = title;
		this.contents = contents;
		//this.date = 
	}
	
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	public int getPostId() {
		return postId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public String getContents() {
		return contents;
	}
	
	/*public void setPublished(int published) {
		this.published = published;
	}
	
	public int getPublished() {
		return published;
	}*/
}
