package dev.rowand.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import dev.rowand.models.Form;
import dev.rowand.models.User;
import dev.rowand.services.FormService;
import dev.rowand.services.UserService;
import io.javalin.http.Context;

public class FormController {
	
	private FormService fs;
	
	private UserService us;
	
	private static org.apache.logging.log4j.Logger Log = LogManager.getLogger(UserController.class);

	
	public FormController(FormService fs, UserService us) {
		this.fs = fs;
		this.us = us;
	}
	
	public void reimburseRequest(Context ctx) {
		ctx.status(201);
		Log.info("POST request recieved at endpoint /employees/{empid}");
		int user_id = Integer.parseInt(ctx.pathParam("empid"));
		Form formFromRequestBody = ctx.bodyAsClass(Form.class);
		Form f = fs.reimburseRequest(formFromRequestBody, user_id);
		ctx.json(f);
	}
	
public void getAllRequests(Context ctx) {
	Log.info("GET request recieved at endpoint /employees or /financeManagers"); //put this into an if /else statement for the state
	ctx.status(200);
	List<Form> forms = fs.getAllRequests();
	ctx.json(forms);

}



public void updateStatus(Context ctx) {
	Log.info("PATCH request recieved at endpoint /financeManagers/{id}/{reimId}");
	int id = Integer.parseInt(ctx.pathParam("id"));
	int FormId = Integer.parseInt(ctx.pathParam("reimId"));
	String status = ctx.body();
	if(status.contains("approved")) {
		status = "approved";
	}
	else if(status.contains("rejected")) {
		status = "rejected";
	}
	
	System.out.println(status);
	fs.updateStatus(FormId, id, status);
}
public void AddGradeorPres(Context ctx) {
	Log.info("PATCH request recieved at endpoint /employees/{empid}/{reId}");
	int formId = Integer.parseInt(ctx.pathParam("reId"));
	String gradeOrPres = ctx.body();
	String[] split = gradeOrPres.split(":");
	String value = split[1];
	String cleansed = "";
	for(int x = 0; x < value.length(); x++) {
		if(Character.isLetter(value.charAt(x)) || value.charAt(x) == ' '){
				cleansed += value.charAt(x);
		}
	}
	System.out.println(cleansed);
	Form f;
	try {
		f = fs.getRequestbyId(formId);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	fs.AddGradeorPres(formId, cleansed);
}


//public void updateReimburseStat(Context ctx) {
	//also very unsure about this one...may move reimburse (total left) to the User table, and 
//unsure if I need a separate method for calculations for this
//}

//4 things: what should I do for my test cases, is my coverage ok, shouuld I keep addGradeorPres and what to do with the reimburse changes
}
