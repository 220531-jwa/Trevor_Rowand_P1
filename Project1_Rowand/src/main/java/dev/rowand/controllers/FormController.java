package dev.rowand.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import dev.rowand.models.Form;
import dev.rowand.services.FormService;
import io.javalin.http.Context;

public class FormController {
	
	private FormService fs;
	
	private static org.apache.logging.log4j.Logger Log = LogManager.getLogger(UserController.class);

	
	public FormController(FormService fs) {
		this.fs = fs;
	}
	
	public void reimburseRequest(Context ctx) {
		ctx.status(201);
		Form formFromRequestBody = ctx.bodyAsClass(Form.class);
		Form f = fs.reimburseRequest(formFromRequestBody);
		ctx.json(f);
	}
	
public void getAllRequests(Context ctx) {
	Log.info("GET request recieved at endpoint /users"); //put this into an if /else statement for the state
	ctx.status(200);
	List<Form> forms = fs.getAllRequests();
	ctx.json(forms);

}



public void updateStatus(Context ctx) {
	int id = Integer.parseInt(ctx.pathParam("id"));
	Form f = ctx.bodyAsClass(Form.class);
	System.out.println(f.getStatus());
	fs.updateStatus(id, f.getStatus());
}


//public void updateReimburseStat(Context ctx) {
	//also very unsure about this one...may move reimburse (total left) to the User table, and 
//unsure if I need a separate method for calculations for this
//}

//4 things: what should I do for my test cases, is my coverage ok, shouuld I keep addGradeorPres and what to do with the reimburse changes
}
