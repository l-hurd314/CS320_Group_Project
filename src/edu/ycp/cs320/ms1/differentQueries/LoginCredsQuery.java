package edu.ycp.cs320.ms1.differentQueries;
import java.util.Scanner;

import edu.ycp.cs320.ms1.persist.DatabaseProvider;
import edu.ycp.cs320.ms1.persist.IDatabase;

public class LoginCredsQuery {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase.init(keyboard);
		
		System.out.print("Enter username: ");
		String username = keyboard.nextLine();
		
		System.out.print("Enter password: ");
		String password = keyboard.nextLine();
		
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		int result = db.isGoodCreds(username, password);
		
		// check if anything was returned and output the list
		if (result==-1) {
			System.out.println("There are no users by that username in the database.");
		}
		else if (result==0) {
			System.out.println("There was one username found, but the password didn't match.");
		}
		else if (result==1) {
			System.out.println("Login Successful.");
		}
		else if (result==2) {
			System.out.println("ERROR: Multiple matching usernames found. Passwords not checked.");
		}
		else {
			System.out.println("Something has gone very wrong. Run.");
		}
	}
}
