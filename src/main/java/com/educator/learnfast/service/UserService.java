package com.educator.learnfast.service;

import java.util.ArrayList;

import com.educator.learnfast.exception.InfoMessages;
import com.educator.learnfast.exception.ValidationException;
import com.educator.learnfast.exception.ServiceException;
import com.educator.learnfast.dao.UserDAO;
import com.educator.learnfast.dao.implementation.UserDAOImplementation;
import com.educator.learnfast.models.CourseHistory;
import com.educator.learnfast.models.EnrollmentStatusEnum;
import com.educator.learnfast.models.UserInfo;
import com.educator.learnfast.util.Logger;
import com.educator.learnfast.validation.UserValidator;

public class UserService {

	private UserDAO userDAO = new UserDAOImplementation();
	Logger logger = Logger.getInstance();

	public UserInfo userLogin(String email, String password) throws ValidationException, ServiceException {
		UserInfo ui = new UserInfo();
		UserValidator.validateLogin(email, password);
		ui = userDAO.userLogin(email, password);
		if (ui == null) {
			throw new ServiceException(InfoMessages.INVALIDLOGIN);
		} else
			return ui;
	}

	public boolean saveUser(UserInfo user) throws ValidationException {
		UserValidator.validateRegister(user);
		boolean val = userDAO.saveUser(user);
		return val;
	}

	public ArrayList<CourseHistory> getCourseHistory(int userId, String status) {
		ArrayList<CourseHistory> out = new ArrayList<CourseHistory>();
		out = userDAO.getCourseHistory(userId, status);
		return out;
	}

	public boolean deleteUser(int userId) {
		int count = userDAO.countNoOfEnrollment(userId);
		boolean val = false;
		if (count == 0) {
			val = userDAO.deleteUser(userId);
		} else
			logger.info("You Cannot leave from this account");
		return val;
	}

}
