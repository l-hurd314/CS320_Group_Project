package edu.ycp.cs320.ms1.controller;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.ms1.model.TextPost;
import edu.ycp.cs320.ms1.persist.DerbyDatabase;

public class deletePostController {
	int post_id;
	int user_id;
	DerbyDatabase db = new DerbyDatabase();
	public Integer deletePost(){
		return db.deletePost(post_id, user_id);
	}

}
