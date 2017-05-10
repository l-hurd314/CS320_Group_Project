package edu.ycp.cs320.ms1.controller;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.ms1.model.TextPost;
import edu.ycp.cs320.ms1.persist.DatabaseProvider;
import edu.ycp.cs320.ms1.persist.DerbyDatabase;
import edu.ycp.cs320.ms1.persist.IDatabase;

public class deletePostController {
	int post_id;
	int user_id;
	
	DerbyDatabase db = new DerbyDatabase();
	
	public Integer deletePost(int postTitle)
	{
		
		return db.deletePost(post_id);
	}

}
