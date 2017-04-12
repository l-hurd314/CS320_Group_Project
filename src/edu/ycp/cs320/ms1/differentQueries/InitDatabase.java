package edu.ycp.cs320.ms1.differentQueries;
//copied from cs320 library example resource for example,
//but then rewritten to fit our database.
import java.util.Scanner;

import edu.ycp.cs320.ms1.persist.DatabaseProvider;
import edu.ycp.cs320.ms1.persist.FakeDatabase;
import edu.ycp.cs320.ms1.persist.DerbyDatabase;

public class InitDatabase {
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
