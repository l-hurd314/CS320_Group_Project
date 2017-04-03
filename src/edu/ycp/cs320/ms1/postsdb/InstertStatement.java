package edu.ycp.cs320.ms1.postsdb;

import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.ms1.model.User;
import edu.ycp.cs320.ms1.model.TextPost;
import edu.ycp.cs320.ms1.model.Pair;
import edu.ycp.cs320.ms1.persist.DatabaseProvider;
import edu.ycp.cs320.ms1.persist.IDatabase;

//TODO: copy class file, modify to insert
public class InstertStatement {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase.init(keyboard);
		
		//prompt user for first to enter
		System.out.print("Username for post to add: ");
		String username = keyboard.nextLine();
		
		//prompt user for title to enter
		System.out.print("Title of post to add: ");
		String title = keyboard.nextLine();
		
		//prompt user for ISBN to enter
		System.out.print("Content of post to add: ");
		String contents = keyboard.nextLine();
		
		//prompt user for year to enter
		//System.out.print("Publishing year of book to add: ");
		//int year = keyboard.nextInt();
		
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		//List<Pair<Author, Book>> authorBookList = 
		db.addTextPost(username, contents, title);
		
		// check if anything was returned and output the list
		/*if (authorBookList.isEmpty()) {
			System.out.println("Inserting book failed.");
		}
		else {
			for (Pair<Author, Book> authorBook : authorBookList) {
				Author author = authorBook.getLeft();
				Book book = authorBook.getRight();
				System.out.println(author.getLastname() + "," + author.getFirstname() + "," + book.getTitle() + "," + book.getIsbn() + "," + book.getPublished());
			}
		}*/
	}
}
