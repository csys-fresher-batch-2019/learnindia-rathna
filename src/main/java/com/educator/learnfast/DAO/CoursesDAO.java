package com.educator.learnfast.DAO;

import java.util.ArrayList;

import com.educator.learnfast.exception.DbException;
import com.educator.learnfast.models.ContentInfo;
import com.educator.learnfast.models.CourseInfo;

public interface CoursesDAO {
	int getNoOfEnrollment(int courseId) throws DbException;

	boolean saveCourse(CourseInfo course);

	boolean deleteCourse(int courseId);

	ArrayList<CourseInfo> findCourses(CourseInfo course);

	boolean saveCourseRating(int rating, int courseId, int userId);

	ArrayList<ContentInfo> getCourseContent(int courseId);

	boolean saveCourseContent(ContentInfo ci);

	boolean deleteCourseContent(int courseId, int chapterNo);
}
