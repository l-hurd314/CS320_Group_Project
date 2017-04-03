package edu.ycp.cs320.ms1.postsdb;

import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.ms1.model.User;
import edu.ycp.cs320.ms1.model.TextPost;
import edu.ycp.cs320.ms1.model.Pair;
import edu.ycp.cs320.ms1.persist.DatabaseProvider;
import edu.ycp.cs320.ms1.persist.IDatabase;

public class TitleQuery {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase.init(keyboard);
		
		System.out.print("Enter a title: ");
		String title = keyboard.nextLine();
		
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		List<Pair<User, TextPost>> authorBookList = db.findUserAndTextPostByTitle(title);
		
		// check if anything was returned and output the list
		if (authorBookList.isEmpty()) {
			System.out.println("No books found with title <" + title + ">");
		}
		else {
			for (Pair<User, TextPost> authorBook : authorBookList) {
				User user = authorBook.getLeft();
				TextPost post = authorBook.getRight();
				System.out.println(user.getPassword() + "," + user.getUsername() + "," + post.getTitle() + "," + post.getContents());
			}
		}
	}
}
