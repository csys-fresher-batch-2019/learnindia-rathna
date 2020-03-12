package com.educator.learnfast.dao;

import java.util.ArrayList;

import com.educator.learnfast.model.ContentInfo;
import com.educator.learnfast.model.CourseInfo;

public interface CoursesDAO {

	int countNoOfEnrollment(int courseId);

	boolean saveCourse(CourseInfo course);

	boolean deleteCourse(int courseId);

	ArrayList<CourseInfo> findCourses(CourseInfo course);

	boolean saveCourseRating(int rating, int courseId, int userId);

	ArrayList<ContentInfo> getCourseContent(int courseId);

	boolean saveCourseContent(ContentInfo ci);

	boolean deleteCourseContent(int courseId, int chapterNo);
}
