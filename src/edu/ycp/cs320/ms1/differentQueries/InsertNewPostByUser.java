package edu.ycp.cs320.ms1.differentQueries;
//copied from cs320 library example resource for example,
//but then rewritten to fit our database.

import java.util.Scanner;

import edu.ycp.cs320.ms1.persist.DatabaseProvider;
import edu.ycp.cs320.ms1.persist.IDatabase;

public class InsertNewPostByUser {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase.init(keyboard);
		
		System.out.print("Enter the author's username: ");
		String userName = keyboard.nextLine();
		
		System.out.print("Enter the post's title: ");
		String title = keyboard.nextLine();
		
		System.out.print("Enter the post's content: ");
		String content = keyboard.nextLine();
		
		/*System.out.print("Enter the book's ISBN: ");
		String isbn = keyboard.nextLine();
		
		System.out.print("Enter the year the book was published: ");
		int published = keyboard.nextInt();
		*/
		
		// get the DB instance and execute the transaction
		IDatabase db = DatabaseProvider.getInstance();
		Integer post_id = db.insertPostIntoPostsTable(title, userName, content);
		//Table setup: post id, user id, title, content

		//TEST PURPOSES ONLY
		// check if the insertion succeeded
		if (post_id > 0)
		{
			System.out.println("New post (ID: " + post_id + ") successfully added to Posts table: <" + title + ">");
		}
		else
		{
			System.out.println("Failed to insert new post (ID: " + post_id + ") into Posts table: <" + title + ">");			
		}
	}
}
