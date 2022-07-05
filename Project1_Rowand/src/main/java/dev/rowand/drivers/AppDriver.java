package dev.rowand.drivers;

import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.patch;
import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.put;

import dev.rowand.controllers.FormController;
import dev.rowand.controllers.UserController;
import dev.rowand.models.User;
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
		FormController fc = new FormController(new FormService(new FormDAO(), new UserDAO()), new UserService(new UserDAO()));
		UserController uc = new UserController(new UserService(new UserDAO()));
		boolean tf;
		Javalin app = Javalin.create(config ->{
			config.addStaticFiles("/public/html", Location.CLASSPATH);
			
		});
		
		app.start(8080);
		
		app.routes(() ->{
			path("/login", () ->{
				post(uc::loginUser);
			});
			path("/getSession", () ->{
				get(ctx -> {
					User loggedInUser = ctx.sessionAttribute("loggedInUser");
					System.out.println(loggedInUser);
					String storType = loggedInUser.getType();

				});
			});
			path("/logout", () -> {
				delete(ctx -> {
					// invalidating session so loggedInUser is null
					ctx.req.getSession(false).invalidate();
				});
			});
		path("/employees", () ->{
				get(fc::getAllRequests);
				path("/{empid}", () ->{
				//patch(fc::addGradeOrPres);
				post(fc::reimburseRequest);
				path("/{reId}", () ->{
					patch(fc::AddGradeorPres);
				});

				});
			}); 
			path("/financeManagers", () ->{
				get(fc::getAllRequests);
				//patch(fc::updateReimburseStat); //also should add some ids for these paths
				path("/{id}", () ->{
					
					path("/{reimId}", () -> {
						patch(fc::updateStatus); //guessing about approve or rejsct requests
						 //maybe add a boolean to the forms? 
					});
					
				});
			}); 
		});
	}
}
