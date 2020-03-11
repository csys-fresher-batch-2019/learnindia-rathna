package com.educator.learnfast.validation;

import com.educator.learnfast.DAO.InstructorDAO;
import com.educator.learnfast.DAO.implementation.InstructorDAOImplementation;
import com.educator.learnfast.exception.ValidationException;
import com.educator.learnfast.models.InstructorInfo;

public class InstructorValidation {

	public static void validateLogin(String email, String password) throws ValidationException {
		if (email == null || "".equals(email.trim()))
			throw new ValidationException("Email Cannot be Null");
		if (password == null || "".equals(password.trim()))
			throw new ValidationException("Password Cannot be Null");
	}

	public static void validateRegister(InstructorInfo instructorInfo) throws ValidationException {
		if (instructorInfo.getInstructorName() == null || "".equals(instructorInfo.getInstructorName().trim()))
			throw new ValidationException("Username Cannot be Null");
		if (instructorInfo.getInstructorPassword() == null || "".equals(instructorInfo.getInstructorPassword().trim()))
			throw new ValidationException("Password Cannot be Null");
		if (instructorInfo.getInstructorEmail() == null || "".equals(instructorInfo.getInstructorEmail().trim()))
			throw new ValidationException("Email Cannot be Null");
		if (instructorInfo.getInstructorPassword().length() < 8)
			throw new ValidationException("Password must contain atleast 8 characters");
		InstructorDAO instructorDAO = new InstructorDAOImplementation();
		boolean exist = instructorDAO.getInstructorEmail(instructorInfo.getInstructorEmail());
		if (exist == false)
			throw new ValidationException("EmailId Already Exists");
	}

}
