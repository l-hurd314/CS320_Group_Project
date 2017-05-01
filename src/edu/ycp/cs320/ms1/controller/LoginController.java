package edu.ycp.cs320.ms1.controller;

import java.util.List;

import edu.ycp.cs320.ms1.model.User;
import edu.ycp.cs320.ms1.persist.DatabaseProvider;
import edu.ycp.cs320.ms1.persist.DerbyDatabase;
import edu.ycp.cs320.ms1.persist.IDatabase;

public class LoginController {

	DerbyDatabase db = new DerbyDatabase();
	
	public List<User> findAllUsers(){
		return db.findAllUsers();
	}
	
	public int isGoodCreds(String username, String password){
		return db.isGoodCreds(username, password);
	}
	
	//private User model = null;
	
	/*public LogicController(User model){
		this.model = model;
	}
	
	public boolean checkUserName(String name){
		return model.validateUserName(name);
	}
	
	public boolean validateCredentials(String name, String pw){
		return model.validatePW(name, pw);
	}*/
}
