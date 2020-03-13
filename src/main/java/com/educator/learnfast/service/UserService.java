package com.educator.learnfast.service;

import java.util.ArrayList;
import java.util.List;

import com.educator.learnfast.dao.UserDAO;
import com.educator.learnfast.dao.implementation.UserDAOImplementation;
import com.educator.learnfast.exception.InfoMessages;
import com.educator.learnfast.exception.ServiceException;
import com.educator.learnfast.exception.ValidationException;
import com.educator.learnfast.model.CourseHistory;
import com.educator.learnfast.model.UserInfo;
import com.educator.learnfast.util.Logger;
import com.educator.learnfast.validation.UserValidator;

public class UserService {

	private UserDAO userDAO = new UserDAOImplementation();
	Logger logger = Logger.getInstance();

	/**
	 * User login
	 * Rule: Email and password should not be null 
	 * Email and password should match with database
	 * @param email
	 * @param password
	 * @return
	 * @throws ValidationException
	 * @throws ServiceException
	 */
	public UserInfo userLogin(String email, String password) throws ValidationException, ServiceException {
		UserInfo ui = new UserInfo();
		UserValidator.validateLogin(email, password);
		ui = userDAO.userLogin(email, password);
		if (ui == null) {
			throw new ServiceException(InfoMessages.INVALIDLOGIN);
		} else
			return ui;
	}

	/**
	 * save a user in database
	 * Rule: username, email, password should not be null
	 * Email and
	 * @param user
	 * @return
	 * @throws ValidationException
	 */
	public boolean saveUser(UserInfo user) throws ValidationException {
		UserValidator.validateRegister(user);
		boolean val = userDAO.saveUser(user);
		return val;
	}

	/**
	 * Get course history of a particular user
	 * @param userId
	 * @param status
	 * @return
	 */
	public List<CourseHistory> getCourseHistory(int userId, String status) {
		List<CourseHistory> out = new ArrayList<CourseHistory>();
		out = userDAO.getCourseHistory(userId, status);
		return out;
	}
	
	/**
	 * delete a user in database
	 * Rule: Courses enrolled by that user must be 0
	 * @param userId
	 * @return
	 */
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
