package edu.ycp.cs320.ms1.controller;

import edu.ycp.cs320.ms1.persist.DatabaseProvider;
import edu.ycp.cs320.ms1.persist.DerbyDatabase;
import edu.ycp.cs320.ms1.persist.IDatabase;

public class InsertPostController {

	private IDatabase db = null;

	public InsertPostController() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();		
	}

	public boolean insertPostIntoPostsTable(String title, String username, String content) {
		
		// insert new book (and possibly new author) into DB
		Integer post_id = db.insertPostIntoPostsTable(title, username, content);

		// check if the insertion succeeded
		if (post_id > 0)
		{
			System.out.println("New post (ID: " + post_id + ") successfully added to Posts table: <" + title + ">");
			
			return true;
		}
		else
		{
			System.out.println("Failed to insert new post (ID: " + post_id + ") into Posts table: <" + title + ">");
			
			return false;
		}
	}
}

