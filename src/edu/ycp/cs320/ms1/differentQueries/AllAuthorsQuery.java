package edu.ycp.cs320.ms1.differentQueries;
//copied from cs320 library example resource for example,
//but then rewritten to fit our database. don't envision using in final product
import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.ms1.model.User;
import edu.ycp.cs320.ms1.persist.DatabaseProvider;
import edu.ycp.cs320.ms1.persist.IDatabase;

public class AllAuthorsQuery {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase.init(keyboard);
		
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		List<User> authorList = db.findAllUsers();
		
		// check if anything was returned and output the list
		if (authorList.isEmpty()) {
			System.out.println("There are no authors in the database");
		}
		else {
			for (User user : authorList) {
				System.out.println(user.getUsername());
			}
		}
	}
}
