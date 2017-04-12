package edu.ycp.cs320.ms1.differentQueries;
//copied from cs320 library example resource for example,
//but then rewritten to fit our database. don't envision using in final product
import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.ms1.model.User;
import edu.ycp.cs320.ms1.model.TextPost;
import edu.ycp.cs320.ms1.model.Pair;
import edu.ycp.cs320.ms1.persist.DatabaseProvider;
import edu.ycp.cs320.ms1.persist.IDatabase;

public class AllBooksQuery {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase.init(keyboard);
		
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		List<Pair<Author, Book>> authorBookList = db.findAllBooksWithAuthors();
		
		// check if anything was returned and output the list
		if (authorBookList.isEmpty()) {
			System.out.println("There are no books in the database");
		}
		else {
			for (Pair<Author, Book> authorBook : authorBookList) {
				Author author = authorBook.getLeft();
				Book book = authorBook.getRight();
				System.out.println(book.getTitle() + ", " + book.getIsbn() + ", " + author.getLastname() + ", " + author.getFirstname());
			}
		}
	}
}
