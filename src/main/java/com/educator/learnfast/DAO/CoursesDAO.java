package com.educator.learnfast.DAO;

import java.util.ArrayList;

import com.educator.learnfast.Exception.DbException;
import com.educator.learnfast.models.ContentInfo;
import com.educator.learnfast.models.CourseInfo;

public interface CoursesDAO {
	int getNoOfEnrollment(int courseId);

	boolean saveCourse(CourseInfo course);

	boolean removeCourse(int courseId);

	ArrayList<CourseInfo> displayCourses(CourseInfo course);

	boolean addCourseRating(int rating, int courseId, int userId);

	ArrayList<ContentInfo> fetchCourseContent(int courseId);

	boolean saveContent(ContentInfo ci);

	boolean deleteContent(int courseId, int chapterNo);
}
