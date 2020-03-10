package com.educator.learnfast.validation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.educator.learnfast.DAO.UserDAO;
import com.educator.learnfast.DAO.implementation.UserDAOImplementation;
import com.educator.learnfast.models.UserInfo;
import com.educator.learnfast.service.UserService;
import com.educator.learnfast.util.ConnectionUtil;
import com.educator.learnfast.util.Logger;

public class UserValidator {

	public static void validateLogin(String email, String password) throws Exception {
		if (email == null || "".equals(email.trim()))
			throw new Exception("Email Cannot be Null");
		if (password == null || "".equals(password.trim()))
			throw new Exception("Password Cannot be Null");
	}

	public static void validateRegister(UserInfo userInfo) throws Exception {
		if (userInfo.getUserName() == null || "".equals(userInfo.getUserName().trim()))
			throw new Exception("Username Cannot be Null");
		if (userInfo.getUserPassword() == null || "".equals(userInfo.getUserPassword().trim()))
			throw new Exception("Password Cannot be Null");
		if (userInfo.getEmailId() == null || "".equals(userInfo.getEmailId().trim()))
			throw new Exception("Email Cannot be Null");
		if (userInfo.getUserPassword().length() < 8)
			throw new Exception("Password must contain atleast 8 characters");
		UserDAO userDAO = new UserDAOImplementation();
		boolean exist = userDAO.getEmail(userInfo.getEmailId());
		if (exist == false)
			throw new Exception("EmailId Already Exists");
	}

}
