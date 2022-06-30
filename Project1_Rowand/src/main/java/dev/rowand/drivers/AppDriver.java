package dev.rowand.drivers;

import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.patch;
import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.put;

import dev.rowand.controllers.FormController;
import dev.rowand.controllers.UserController;
import dev.rowand.repositories.FormDAO;
import dev.rowand.repositories.UserDAO;
import dev.rowand.services.FormService;
import dev.rowand.services.UserService;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class AppDriver {
//add in logger about here 
	
	public static void main(String[] args) {
		
		//switch out the finance manager and employee tables for a single user talbe; we'll use paths and something else to get it all later
		FormController fc = new FormController(new FormService(new FormDAO()));
		UserController uc = new UserController(new UserService(new UserDAO()));
		Javalin app = Javalin.create(config ->{
			config.addStaticFiles("/public", Location.CLASSPATH);
			
		});
		
		app.start(8080);
		
		app.routes(() ->{
			path("/login", () ->{
				post(uc::loginUser);
			});
			path("/employees", () ->{
				post(fc::reimburseRequest);
				get(fc::getAllRequests);
				//patch(fc::addGradeOrPres);
			});
			path("/financeManagers", () ->{
				get(fc::getAllRequests);
				//patch(fc::updateReimburseStat); //also should add some ids for these paths
				path("/{id}", () ->{
					patch(fc::updateStatus); //guessing about approve or rejsct requests
					 //maybe add a boolean to the forms? 
				});
			});
		});
	}
}
