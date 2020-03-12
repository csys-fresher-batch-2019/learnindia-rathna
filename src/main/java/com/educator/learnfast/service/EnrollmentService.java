package com.educator.learnfast.service;

import com.educator.learnfast.dao.EnrollmentDAO;
import com.educator.learnfast.dao.UserDAO;
import com.educator.learnfast.dao.implementation.EnrollmentDAOImplementation;
import com.educator.learnfast.dao.implementation.UserDAOImplementation;

public class EnrollmentService {

	private EnrollmentDAO enrollmentDAO = new EnrollmentDAOImplementation();
	private UserDAO userDAO = new UserDAOImplementation();

	public boolean saveEnrollment(int userId, int courseId) {
		boolean val = enrollmentDAO.saveEnrollment(userId, courseId);
		return val;
	}

	public boolean deleteEnrollment(int courseId, int userId) {
		boolean result = false;
		boolean val = enrollmentDAO.deleteEnrollment(courseId, userId);
		if (val == true)
			result = userDAO.updateNoOfCoursesEnrolled(userId);
		return result;
	}

}
