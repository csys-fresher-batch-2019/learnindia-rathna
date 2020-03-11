package com.educator.learnfast.service;

import com.educator.learnfast.DAO.InstructorDAO;
import com.educator.learnfast.DAO.implementation.InstructorDAOImplementation;
import com.educator.learnfast.exception.DbException;
import com.educator.learnfast.exception.InfoMessages;
import com.educator.learnfast.models.InstructorInfo;
import com.educator.learnfast.validation.InstructorValidation;

public class InstructorService {

	private InstructorDAO instructorDAO = new InstructorDAOImplementation();

	public boolean saveInstructor(InstructorInfo in) throws Exception {
		InstructorValidation.validateRegister(in);
		boolean val = instructorDAO.saveInstructor(in);
		return val;
	}

	public InstructorInfo instructorLogin(String email, String pass) throws Exception {
		InstructorValidation.validateLogin(email, pass);
		InstructorInfo instructorInfo = new InstructorInfo();
		instructorInfo = instructorDAO.instructorLogin(email, pass);
		if(instructorInfo == null)
			throw new DbException(InfoMessages.INVALIDLOGIN);
		else
			return instructorInfo;
	}

}
