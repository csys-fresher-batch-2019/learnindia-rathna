package com.educator.learnfast.service;

import com.educator.learnfast.exception.InfoMessages;
import com.educator.learnfast.exception.ValidationException;
import com.educator.learnfast.model.InstructorInfo;
import com.educator.learnfast.exception.ServiceException;
import com.educator.learnfast.dao.InstructorDAO;
import com.educator.learnfast.dao.implementation.InstructorDAOImplementation;
import com.educator.learnfast.validation.InstructorValidation;

public class InstructorService {

	private InstructorDAO instructorDAO = new InstructorDAOImplementation();
	
	/**
	 * save a instructor in database
	 * Rule: instructor name, email, password should not be null and email should be unique
	 * @param in
	 * @return
	 * @throws Exception
	 */
	public boolean saveInstructor(InstructorInfo in) throws Exception {
		InstructorValidation.validateRegister(in);
		boolean val = instructorDAO.saveInstructor(in);
		return val;
	}

	/**
	 * instructor login
	 * Rule: Email and password should not be null
	 * Email and password should match with database
	 * @param email
	 * @param pass
	 * @return
	 * @throws ValidationException
	 * @throws ServiceException
	 */
	public InstructorInfo instructorLogin(String email, String pass) throws ValidationException, ServiceException {
		InstructorValidation.validateLogin(email, pass);
		InstructorInfo instructorInfo = new InstructorInfo();
		instructorInfo = instructorDAO.instructorLogin(email, pass);
		if (instructorInfo == null)
			throw new ServiceException(InfoMessages.INVALIDLOGIN);
		else
			return instructorInfo;
	}

}
