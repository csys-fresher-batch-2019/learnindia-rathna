package com.educator.learnfast.service;

import java.util.ArrayList;

import com.educator.learnfast.DAO.CoursesDAO;
import com.educator.learnfast.DAO.EnrollmentDAO;
import com.educator.learnfast.DAO.implementation.CoursesDAOImplementation;
import com.educator.learnfast.DAO.implementation.EnrollmentDAOImplementation;
import com.educator.learnfast.exception.DbException;
import com.educator.learnfast.models.ContentInfo;
import com.educator.learnfast.models.CourseInfo;

public class CoursesService {
	private CoursesDAO coursesDAO = new CoursesDAOImplementation();
	private EnrollmentDAO enrollmentDAO = new EnrollmentDAOImplementation();

	public boolean saveCourse(CourseInfo course) {
		boolean val = coursesDAO.saveCourse(course);
		return val;
	}

	public int getNoOfEnrollment(int courseId) throws DbException {
		int val = coursesDAO.getNoOfEnrollment(courseId);
		return val;
	}

	public boolean deleteCourse(int courseId) {
		boolean val = coursesDAO.deleteCourse(courseId);
		return val;
	}

	public ArrayList<ContentInfo> getCourseContent(int courseId) {
		ArrayList<ContentInfo> list = new ArrayList<>();
		list = coursesDAO.getCourseContent(courseId);
		return list;
	}

	public boolean saveCourseRating(int rating, int courseId, int userId) {
		boolean result = false;
		boolean val = enrollmentDAO.saveEnrollmentRating(courseId, userId, rating);
		if (val)
			result = coursesDAO.saveCourseRating(rating, courseId, userId);
		return result;
	}

	public boolean saveCourseContent(ContentInfo ci) {
		boolean result = coursesDAO.saveCourseContent(ci);
		return result;
	}

	public boolean deleteCourseContent(int courseId, int chapterNo) {
		boolean result = coursesDAO.deleteCourseContent(courseId, chapterNo);
		return result;
	}
}
