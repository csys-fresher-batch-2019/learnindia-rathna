package com.educator.learnfast.service;

import java.util.ArrayList;
import java.util.List;

import com.educator.learnfast.dao.CoursesDAO;
import com.educator.learnfast.dao.EnrollmentDAO;
import com.educator.learnfast.dao.implementation.CoursesDAOImplementation;
import com.educator.learnfast.dao.implementation.EnrollmentDAOImplementation;
import com.educator.learnfast.model.ContentInfo;
import com.educator.learnfast.model.CourseInfo;

public class CoursesService {

	private CoursesDAO coursesDAO = new CoursesDAOImplementation();
	private EnrollmentDAO enrollmentDAO = new EnrollmentDAOImplementation();

	/**
	 * save a new course in database
	 * @param course
	 * @return
	 */
	public boolean saveCourse(CourseInfo course) {
		boolean val = coursesDAO.saveCourse(course);
		return val;
	}

	/**
	 * Get No.of.Enrollments are active for a particular course
	 * @param courseId
	 * @return
	 */
	public int getNoOfEnrollment(int courseId) {
		int val = coursesDAO.countNoOfEnrollment(courseId);
		return val;
	}

	
	/**
	 * Delete a course from database
	 * Rule: No.of.Enrollmets for that particular course must be 0
	 * @param courseId
	 * @return
	 */
	public boolean deleteCourse(int courseId) {
		boolean result = false;
		int count = coursesDAO.countNoOfEnrollment(courseId);
		if (count == 0) {
			result = coursesDAO.deleteCourse(courseId);
		}
		return result;
	}

	/**
	 * Get content of a particular course
	 * @param courseId
	 * @return
	 */
	public List<ContentInfo> getCourseContent(int courseId) {
		List<ContentInfo> list = new ArrayList<>();
		list = coursesDAO.getCourseContent(courseId);
		return list;
	}

	/**
	 *save rating for a course
	 *Rating for a particular enrollment must be saved first 
	 *followed by that average of enrollment rating saved to the course rating
	 * @param rating
	 * @param courseId
	 * @param userId
	 * @return
	 */
	public boolean saveCourseRating(int rating, int courseId, int userId) {
		boolean result = false;
		boolean val = enrollmentDAO.saveEnrollmentRating(courseId, userId, rating);
		if (val)
			result = coursesDAO.saveCourseRating(rating, courseId, userId);
		return result;
	}
	
	/**
	 * save course content for a particular course
	 * @param ci
	 * @return
	 */
	public boolean saveCourseContent(ContentInfo ci) {
		boolean result = coursesDAO.saveCourseContent(ci);
		return result;
	}

	/**
	 * delete content of a course
	 * @param courseId
	 * @param chapterNo
	 * @return
	 */
	public boolean deleteCourseContent(int courseId, int chapterNo) {
		boolean result = coursesDAO.deleteCourseContent(courseId, chapterNo);
		return result;
	}
	
	/**
	 * search courses based on the inputs given
	 * @param courseInfo
	 * @return
	 */
	public List<CourseInfo> findCourses (CourseInfo courseInfo){
		List<CourseInfo> list = new ArrayList<>();
		list = coursesDAO.findCourses(courseInfo);
		return list;
	}
}
