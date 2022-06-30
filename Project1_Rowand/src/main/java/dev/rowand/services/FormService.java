package dev.rowand.services;

import java.util.List;

import dev.rowand.models.Form;
import dev.rowand.models.User;
import dev.rowand.repositories.FormDAO;
import dev.rowand.repositories.UserDAO;

public class FormService {
	
	private static FormDAO formDao;
	private static UserDAO userDao;
	float remainder;
	
	

	public FormService(FormDAO formDao) {
		// TODO Auto-generated constructor stub
		this.formDao = formDao;
	}

	public Form reimburseRequest(Form formFromRequestBody) {
		// TODO Auto-generated method stub
		Form createdForm = formDao.reimburseRequest(formFromRequestBody);
		User associatedUser = userDao.getUserByReimburseID(createdForm.getId());
		remainder = associatedUser.getReimburse() - formFromRequestBody.getCost();
		if(remainder < 0) {
			remainder = 0;
		}
		associatedUser.setReimburse(remainder);
		remainder = 0;
		return createdForm;
	}

	public List<Form> getAllRequests() {
		// TODO Auto-generated method stub
		return formDao.getAllRequests();
	}


	public Form updateStatus(int id, String status) {
		float remainder;
		Form currForm = formDao.GetRequestByID(id);
		User associatedUser = userDao.getUserByReimburseID(currForm.getId());

		
		if(status.equals("rejected")) {
			remainder = currForm.getCost();
			remainder += associatedUser.getReimburse();
			associatedUser.setReimburse(remainder);
		}
		
		return formDao.updateStatus(id, status);
	}

}
