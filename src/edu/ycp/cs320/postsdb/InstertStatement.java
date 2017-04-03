package edu.ycp.cs320.postsdb;

import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.postsdb.model.Author;
import edu.ycp.cs320.postsdb.model.Book;
import edu.ycp.cs320.postsdb.model.Pair;
import edu.ycp.cs320.postsdb.persist.DatabaseProvider;
import edu.ycp.cs320.postsdb.persist.IDatabase;

//TODO: copy class file, modify to insert
public class InstertStatement {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase.init(keyboard);
		
		//prompt user for first to enter
		System.out.print("Author's first name of book to add: ");
		String firstname = keyboard.nextLine();
		
		System.out.print("Enter an author's last name: ");
		String lastname = keyboard.nextLine();
		
		//prompt user for title to enter
		System.out.print("Title of book to add: ");
		String title = keyboard.nextLine();
		
		//prompt user for ISBN to enter
		System.out.print("ISBN of book to add: ");
		String isbn = keyboard.nextLine();
		
		//prompt user for year to enter
		System.out.print("Publishing year of book to add: ");
		int year = keyboard.nextInt();
		
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		//List<Pair<Author, Book>> authorBookList = 
		db.insertBookByInfo(firstname, lastname, title, isbn, year);
		
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
