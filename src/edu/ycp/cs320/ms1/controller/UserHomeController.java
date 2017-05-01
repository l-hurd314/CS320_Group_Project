package edu.ycp.cs320.ms1.controller;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.ms1.model.TextPost;
import edu.ycp.cs320.ms1.persist.DerbyDatabase;

public class UserHomeController {
	DerbyDatabase db = new DerbyDatabase();
	public List<TextPost> findAllTextPosts(){
		return db.findAllTextPosts();
	}
	public List<TextPost> findPostID(){
		return db.findPostID();
	}
	/*public TextPost findTextPostByTitle(String title){
		/*stmt = conn.prepareStatement(
				"select authors.*, books.* " +
				"  from authors, books, bookAuthors " +
				"  where authors.author_id = bookAuthors.author_id " +
				"    and books.book_id     = bookAuthors.book_id "   +
				"  order by books.title asc"
		);
	};*/
}
