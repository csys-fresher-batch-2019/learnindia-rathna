package com.educator.learnfast.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.educator.learnfast.DAO.CoursesDAO;
import com.educator.learnfast.DAO.EnrollmentDAO;
import com.educator.learnfast.DAO.implementation.CoursesDAOImplementation;
import com.educator.learnfast.DAO.implementation.EnrollmentDAOImplementation;
import com.educator.learnfast.models.ContentInfo;
import com.educator.learnfast.models.CourseInfo;
import com.educator.learnfast.util.TestConnection;

public class CoursesService {
	private CoursesDAO coursesDAO = new CoursesDAOImplementation();
	private EnrollmentDAO enrollmentDAO = new EnrollmentDAOImplementation();

	public boolean saveCourse(CourseInfo course) {
		boolean val = coursesDAO.saveCourse(course);
		return val;
	}

	public int getNoOfEnrollment(int courseId) {
		int val = coursesDAO.getNoOfEnrollment(courseId);
		return val;
	}

	public boolean removeCourse(int courseId) {
		boolean val = coursesDAO.removeCourse(courseId);
		return val;
	}

	public ArrayList<ContentInfo> fetchCourseContent(int courseId) {
		ArrayList<ContentInfo> list = new ArrayList<>();
		list = coursesDAO.fetchCourseContent(courseId);
		return list;
	}

	public boolean addCourseRating(int rating, int courseId, int userId) {
		boolean result = false;
		boolean val = enrollmentDAO.saveEnrollmentRating(courseId, userId, rating);
		if (val == true)
			result = coursesDAO.addCourseRating(rating, courseId, userId);
		return result;
	}

	public boolean saveContent(ContentInfo ci) {
		boolean result = coursesDAO.saveContent(ci);
		return result;
	}

	public boolean deleteContent(int courseId, int chapterNo) {
		boolean result = coursesDAO.deleteContent(courseId, chapterNo);
		return result;
	}
}
