package com.educator.learnfast.service;

import java.util.ArrayList;

import com.educator.learnfast.DAO.UserDAO;
import com.educator.learnfast.DAO.implementation.UserDAOImplementation;
import com.educator.learnfast.models.CourseHistory;
import com.educator.learnfast.models.UserInfo;
import com.educator.learnfast.util.Logger;
import com.educator.learnfast.validation.UserValidator;

public class UserService {

	private UserDAO userDAO = new UserDAOImplementation();
	Logger logger = Logger.getInstance();

	public UserInfo UserLogin(String email, String password) throws Exception {
		UserInfo ui = new UserInfo();
		UserValidator.validateLogin(email, password);
		ui = userDAO.UserLogin(email, password);
		return ui;
	}

	public boolean addUser(UserInfo user) throws Exception {
		UserValidator.validateRegister(user);
		boolean val = userDAO.addUser(user);
		return val;
	}

	public ArrayList<CourseHistory> getCourseHistory(int userId, int status) {
		ArrayList<CourseHistory> out = new ArrayList<CourseHistory>();
		out = userDAO.getCourseHistory(userId, status);
		return out;
	}

	public boolean deleteUser(int userId) {
		int count = userDAO.count(userId);
		boolean val = false;
		if (count == 0) {
			val = userDAO.deleteUser(userId);
		} else
			logger.info("You Cannot leave from this account");
		return val;
	}

	public boolean getEmail(String email) {
		boolean val = userDAO.getEmail(email);
		return val;
	}

}
