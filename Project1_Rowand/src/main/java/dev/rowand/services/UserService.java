package dev.rowand.services;

import dev.rowand.models.User;
import dev.rowand.repositories.UserDAO;

public class UserService {
	
	private static UserDAO userDao;
	

	//the form page will look like the login page, but with way more inputs
	//we can have the page with the status of all sent requests be a separate html page
	//try logging in with postman and the post request with a username and pass before adding the != null here
	

	public UserService(UserDAO userDao) {
		this.userDao = userDao;
	}

	public User loginUser(String username, String password) {
		// TODO Auto-generated method stub

		User u = userDao.getUserByUsername(username);
		if(u != null) {
		if (u.getPassword().equals(password)) {
			return u;
		}
		}
		return null;
	}
	
	public User getUserById(int id) throws Exception {
		User u = userDao.getUserByID(id);
		if (u == null) {
			throw new Exception ("Account not found!");

		}
		return u;
	}

}
