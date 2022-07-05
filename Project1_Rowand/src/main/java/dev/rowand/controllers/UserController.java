package dev.rowand.controllers;

import org.apache.logging.log4j.LogManager;

import dev.rowand.models.User;
import dev.rowand.services.FormService;
import dev.rowand.services.UserService;
import io.javalin.http.Context;

public class UserController {
	
	private UserService us;
	
	private static org.apache.logging.log4j.Logger log = LogManager.getLogger(UserController.class);


	public UserController(UserService us) {
		// TODO Auto-generated constructor stub
		this.us = us;
	}
	
	public void loginUser(Context ctx) {
		User u = ctx.bodyAsClass(User.class);
		User loggedInUser = us.loginUser(u.getUsername(), u.getPassword());
		if(u != null) {
			//setting session attribute
			ctx.sessionAttribute("loggedInUser", loggedInUser);
			log.info("Session Attribute Set for User " + loggedInUser);
		}
		ctx.json(loggedInUser);
	}

}
