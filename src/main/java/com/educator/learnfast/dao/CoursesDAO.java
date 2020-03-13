package com.educator.learnfast.dao;

import java.util.List;

import com.educator.learnfast.model.ContentInfo;
import com.educator.learnfast.model.CourseInfo;

public interface CoursesDAO {

	int countNoOfEnrollment(int courseId);

	boolean saveCourse(CourseInfo course);

	boolean deleteCourse(int courseId);

	List<CourseInfo> findCourses(CourseInfo course);

	boolean saveCourseRating(int rating, int courseId, int userId);

	List<ContentInfo> getCourseContent(int courseId);

	boolean saveCourseContent(ContentInfo ci);

	boolean deleteCourseContent(int courseId, int chapterNo);
}
