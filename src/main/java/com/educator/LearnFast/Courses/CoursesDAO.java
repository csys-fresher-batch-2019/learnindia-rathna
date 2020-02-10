package com.educator.LearnFast.Courses;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface CoursesDAO {
	int getNoOfEnrollment(int courseId) throws Exception ;
	
	boolean saveCourse(CourseInfo course) throws Exception;
	
	int removeCourse(int courseId) throws Exception;
	
	ArrayList<CourseInfo> displayCourses(CourseInfo course) throws Exception;
	
	void addCourseRating(int rating,int courseId,int userId) throws Exception;
}
