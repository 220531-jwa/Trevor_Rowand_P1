package dev.rowand.services;

import java.util.List;

import dev.rowand.models.Form;
import dev.rowand.models.User;
import dev.rowand.repositories.FormDAO;
import dev.rowand.repositories.UserDAO;

public class FormService {
	
	private static FormDAO formDao;
	private static UserDAO userDao;
	
	

	public FormService(FormDAO formDao, UserDAO userDao) {
		// TODO Auto-generated constructor stub
		this.formDao = formDao;
		this.userDao = userDao;
	}

	public Form reimburseRequest(Form formFromRequestBody, int user_id) {
		// TODO Auto-generated method stub
		Form createdForm = formDao.reimburseRequest(formFromRequestBody);
		User associatedUser = userDao.getUserByID(user_id); //change this
		return createdForm;
	}

	public List<Form> getAllRequests() {
		// TODO Auto-generated method stub
		return formDao.getAllRequests();
	}


	public Form updateStatus(int id, int userId, String status) {
		float remainder;
		Form currForm = formDao.GetRequestByID(id);
		User associatedUser = userDao.getUserByID(userId);

		
		if(status.equals("rejected")) {
			remainder = currForm.getCost();
			remainder += associatedUser.getReimburse();
			if(remainder > 1000) {
				remainder = 1000;
			}
			userDao.updateReimburse(remainder, userId);
		}
		else if(status.equals("approved")) {
			remainder = associatedUser.getReimburse() - currForm.getCost();
			if(remainder < 0) {
				remainder = 0;
			}
			userDao.updateReimburse(remainder, userId);
		}
		
		return formDao.updateStatus(id, status);
	}

	public Object AddGradeorPres(int id, String gradingFormat) {
		// TODO Auto-generated method stub
		
		return formDao.AddGradeorPres(id, gradingFormat);
		
	}

	public Form getRequestbyId(int formId) throws Exception{
		// TODO Auto-generated method stub
		Form f = formDao.GetRequestByID(formId);
		if(f == null) {
			throw new Exception("Form not found!");
		}
		return f;
	}

}
