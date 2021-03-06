package com.educator.learnfast.validation;

import com.educator.learnfast.dao.UserDAO;
import com.educator.learnfast.dao.implementation.UserDAOImplementation;
import com.educator.learnfast.exception.ValidationException;
import com.educator.learnfast.model.UserInfo;

public class UserValidator {

	public static void validateLogin(String email, String password) throws ValidationException {
		if (email == null || "".equals(email.trim()))
			throw new ValidationException("Email Cannot be Null");
		if (password == null || "".equals(password.trim()))
			throw new ValidationException("Password Cannot be Null");
	}

	public static void validateRegister(UserInfo userInfo) throws ValidationException {
		if (userInfo.getUserName() == null || "".equals(userInfo.getUserName().trim()))
			throw new ValidationException("Username Cannot be Null");
		if (userInfo.getUserPassword() == null || "".equals(userInfo.getUserPassword().trim()))
			throw new ValidationException("Password Cannot be Null");
		if (userInfo.getEmailId() == null || "".equals(userInfo.getEmailId().trim()))
			throw new ValidationException("Email Cannot be Null");
		if (userInfo.getUserPassword().length() < 8)
			throw new ValidationException("Password must contain atleast 8 characters");
		UserDAO userDAO = new UserDAOImplementation();
		boolean exist = userDAO.findByUserEmail(userInfo.getEmailId());
		if (exist == false)
			throw new ValidationException("EmailId Already Exists");
	}

}
