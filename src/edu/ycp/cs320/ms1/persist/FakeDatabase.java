package edu.ycp.cs320.ms1.persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ycp.cs320.ms1.model.User;
import edu.ycp.cs320.ms1.model.Book;
import edu.ycp.cs320.booksdb.model.Pair;

public class FakeDatabase implements IDatabase {
	
	private List<User> authorList;
	private List<Book> bookList;
	
	public FakeDatabase() {
		authorList = new ArrayList<Author>();
		bookList = new ArrayList<Book>();
		
		// Add initial data
		readInitialData();
		
		System.out.println(authorList.size() + " authors");
		System.out.println(bookList.size() + " books");
	}

	public void readInitialData() {
		try {
			authorList.addAll(InitialData.getAuthors());
			bookList.addAll(InitialData.getBooks());
		} catch (IOException e) {
			throw new IllegalStateException("Couldn't read initial data", e);
		}
	}
	
	@Override
	public List<Pair<Author, Book>> findAuthorAndBookByTitle(String title) {
		List<Pair<Author, Book>> result = new ArrayList<Pair<Author,Book>>();
		for (Book book : bookList) {
			if (book.getTitle().equals(title)) {
				Author author = findAuthorByAuthorId(book.getAuthorId());
				result.add(new Pair<Author, Book>(author, book));
			}
		}
		return result;
	}
	public List<Pair<Author, Book>> findAuthorAndBookByAuthorLastName(String lastname){
		List<Pair<Author, Book>> result = new ArrayList<Pair<Author,Book>>();
		for(Author author : authorList){
			if(author.getLastname().equals(lastname)){
				for (Book book : bookList) {
					if (book.getAuthorId() == author.getAuthorId()) {
						result.add(new Pair<Author, Book>(author, book));
					}
				}
			}
		}
		return result;
	}
	
	public void addBook(String lastname, String firstname, String isbn, String title, int year){
		boolean authorFound = false;
		Author bookAuthor = new Author();
		for(Author author : authorList){
			if(author.getLastname().equals(lastname) && author.getFirstname().equals(firstname)){
				authorFound = true;
				bookAuthor = author;
				break;
			}
		}
		if(!authorFound){
			bookAuthor.setFirstname(firstname);
			bookAuthor.setLastname(lastname);
			bookAuthor.setAuthorId(authorList.size() + 1);
			authorList.add(bookAuthor);
		}
		
		Book book = new Book();
		book.setAuthorId(bookAuthor.getAuthorId());
		book.setIsbn(isbn);
		book.setPublished(year);
		book.setTitle(title);
		book.setBookId(bookList.size() + 1);
		bookList.add(book);
		
		System.out.println(authorList.size() + " authors");
		System.out.println(bookList.size() + " books");
	}

	private Author findAuthorByAuthorId(int authorId) {
		for (Author author : authorList) {
			if (author.getAuthorId() == authorId) {
				return author;
			}
		}
		return null;
	}
}
