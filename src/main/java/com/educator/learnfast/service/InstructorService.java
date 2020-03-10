package com.educator.learnfast.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.educator.learnfast.DAO.InstructorDAO;
import com.educator.learnfast.DAO.implementation.InstructorDAOImplementation;
import com.educator.learnfast.models.EnrollmentDetails;
import com.educator.learnfast.models.InstructorInfo;
import com.educator.learnfast.util.ConnectionUtil;
import com.educator.learnfast.util.TestConnection;
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
		return instructorDAO.instructorLogin(email, pass);
	}

}
