package edu.ycp.cs320.ms1.persist;

import java.util.List;

/*import edu.ycp.cs320.ms1.postsdb.model.User;
import edu.ycp.cs320.ms1.postsdb.model.TextPost;
import edu.ycp.cs320.ms1.postsdb.model.Pair;*/

//to shut it the hell up for now:
import edu.ycp.cs320.ms1.model.Pair;
import edu.ycp.cs320.ms1.model.User;
import edu.ycp.cs320.ms1.model.TextPost;


public interface IDatabase {
	
	public List<Pair<User, TextPost>> findUserAndTextPostByTitle(String title);
	
	public List<Pair<User, TextPost>> findUserAndTextPostByUsername(String username);
	
	/**
	 * must fetch user ID based on username, then create new entry 
	 * @param username
	 * @param contents
	 * @param title
	 */
	void addTextPost(String username, String contents, String title);
	//public List<Pair<User, TextPost>> findUserAndTextPostByUsername(username);

	Integer insertPostIntoPostsTable(String title, String username, String content);
	//Table setup: post id, user id, title, content

	public List<User> findAllUsers();
	
	public List<TextPost> findAllTextPosts();
	
	public TextPost findTextPostByTitle(String title);
}
