package edu.ycp.cs320.postsdb;

import java.util.Scanner;

import edu.ycp.cs320.postsdb.persist.DatabaseProvider;
import edu.ycp.cs320.postsdb.persist.DerbyDatabase;
import edu.ycp.cs320.postsdb.persist.FakeDatabase;

public class InitDatabase {
	
	//given code
	public static void init(Scanner keyboard) {
		System.out.print("Which database (0=fake, 1=derby): ");
		int which = Integer.parseInt(keyboard.nextLine());
		if (which == 0) {
			DatabaseProvider.setInstance(new FakeDatabase());
		} else if (which == 1) {
			DatabaseProvider.setInstance(new DerbyDatabase());
		} else {
			throw new IllegalArgumentException("Invalid choice: " + which);
		}
	}
	
	
}
