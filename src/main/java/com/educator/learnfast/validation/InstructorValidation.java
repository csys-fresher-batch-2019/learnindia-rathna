package com.educator.learnfast.validation;

import com.educator.learnfast.DAO.InstructorDAO;
import com.educator.learnfast.DAO.implementation.InstructorDAOImplementation;
import com.educator.learnfast.models.InstructorInfo;
import com.educator.learnfast.models.UserInfo;
import com.educator.learnfast.service.UserService;

public class InstructorValidation {
	
	public static void validateLogin(String email, String password) throws Exception {
		if(email == null || "".equals(email.trim()))
			throw new Exception ("Email Cannot be Null");
		if(password == null || "".equals(password.trim()))
			throw new Exception ("Password Cannot be Null");
	}
	
	public static void validateRegister(InstructorInfo instructorInfo) throws Exception {
		if(instructorInfo.getInstructorName() == null || "".equals(instructorInfo.getInstructorName().trim()))
			throw new Exception ("Username Cannot be Null");
		if(instructorInfo.getInstructorPassword() == null || "".equals(instructorInfo.getInstructorPassword().trim()))
			throw new Exception ("Password Cannot be Null");
		if(instructorInfo.getInstructorEmail() == null || "".equals(instructorInfo.getInstructorEmail().trim()))
			throw new Exception ("Email Cannot be Null");
		if(instructorInfo.getInstructorPassword().length()<8)
			throw new Exception ("Password must contain atleast 8 characters");
		InstructorDAO instructorDAO = new InstructorDAOImplementation();
		boolean exist = instructorDAO.getEmail(instructorInfo.getInstructorEmail());
		if(exist == false)
			throw new Exception("EmailId Already Exists");
		}

}
