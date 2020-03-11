package com.educator.learnfast.service;

import com.educator.learnfast.dao.EnrollmentDAO;
import com.educator.learnfast.dao.UserDAO;
import com.educator.learnfast.dao.implemenation.EnrollmentDAOImplementation;
import com.educator.learnfast.dao.implemenation.UserDAOImplementation;

public class EnrollmentService {
	private EnrollmentDAO enrollmentDAO = new EnrollmentDAOImplementation();
	private UserDAO userDAO = new UserDAOImplementation();

	public boolean saveEnrollment(int userId, int courseId) {
		boolean val = enrollmentDAO.saveEnrollment(userId, courseId);
		return val;
	}

	public boolean deleteEnrollment(int CourseId, int UserId) {
		boolean result = false;
		boolean val = enrollmentDAO.deleteEnrollment(CourseId, UserId);
		if (val == true)
			result = userDAO.updateNoOfCoursesEnrolled(UserId);
		return result;
	}

}
