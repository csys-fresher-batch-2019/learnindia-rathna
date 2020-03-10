package com.educator.learnfast.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.educator.learnfast.DAO.EnrollmentDAO;
import com.educator.learnfast.DAO.UserDAO;
import com.educator.learnfast.DAO.implementation.EnrollmentDAOImplementation;
import com.educator.learnfast.DAO.implementation.UserDAOImplementation;

public class EnrollmentService {
	private EnrollmentDAO enrollmentDAO = new EnrollmentDAOImplementation();
	private UserDAO userDAO = new UserDAOImplementation();

	public boolean saveEnrollment(int userId, int courseId) {
		boolean val = enrollmentDAO.saveEnrollment(userId, courseId);
		return val;
	}

	public boolean removeEnrollment(int CourseId, int UserId) {
		boolean result = false;
		boolean val = enrollmentDAO.removeEnrollment(CourseId, UserId);
		if (val == true)
			result = userDAO.updateNoOfCoursesEnrolled(UserId);
		return result;
	}

}
