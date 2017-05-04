package edu.ycp.cs320.ms1.postsdb;

import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.ms1.model.User;
import edu.ycp.cs320.ms1.model.TextPost;
import edu.ycp.cs320.ms1.model.Pair;
import edu.ycp.cs320.ms1.persist.DatabaseProvider;
import edu.ycp.cs320.ms1.persist.IDatabase;

//TODO: copy class file, modify to insert
public class UserQuery {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase.init(keyboard);
		
		System.out.print("Enter a user's name: ");
		String username = keyboard.nextLine();
		
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		List<Pair<User, TextPost>> userPostList = db.findUserAndTextPostByUsername(username);
		
		// check if anything was returned and output the list
		if (userPostList.isEmpty()) {
			System.out.println("No books found with username <" + username + ">");
		}
		else {
			for (Pair<User, TextPost> userPost : userPostList) {
				User user = userPost.getLeft();
				TextPost post = userPost.getRight();
				System.out.println(user.getUsername() + "," + post.getTitle() + "," + post.getContents() /*+ "," + post.getPublished()*/);
			}
		}
	}
}
