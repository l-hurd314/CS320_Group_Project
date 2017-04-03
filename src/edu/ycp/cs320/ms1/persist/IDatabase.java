package edu.ycp.cs320.ms1.persist;

import java.util.List;

/*import edu.ycp.cs320.postsdb.model.User;
import edu.ycp.cs320.postsdb.model.TextPost;
import edu.ycp.cs320.postsdb.model.Pair;*/

//to shut it the hell up for now:
import edu.ycp.cs320.ms1.model.Pair;
import edu.ycp.cs320.ms1.model.User;
import edu.ycp.cs320.ms1.model.TextPost;



public interface IDatabase {
	public List<Pair<User, TextPost>> findUserAndTextPostByTitle(String title);
	public List<Pair<User, TextPost>> findUserAndTextPostByUserLastName(String lastname);
	public void addTextPost(String lastname, String firstname, String isbn, String title, int year);
}
