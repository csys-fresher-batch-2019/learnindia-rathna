package com.educator.learnfast.DAO;

import java.util.ArrayList;

import com.educator.learnfast.Exception.DbException;
import com.educator.learnfast.models.ContentInfo;
import com.educator.learnfast.models.CourseInfo;

public interface CoursesDAO {
	int getNoOfEnrollment(int courseId) throws Exception ;
	
	boolean saveCourse(CourseInfo course) throws Exception;
	
	boolean removeCourse(int courseId) throws Exception;
	
	ArrayList<CourseInfo> displayCourses(CourseInfo course) throws Exception;
	
	boolean addCourseRating(int rating,int courseId,int userId) throws Exception;
	
	ArrayList<ContentInfo> fetchCourseContent(int courseId) throws Exception;
}
