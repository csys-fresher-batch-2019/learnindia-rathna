package com.educator.learnfast.dao;

import java.util.List;

import com.educator.learnfast.model.CourseHistory;
import com.educator.learnfast.model.UserInfo;

public interface UserDAO {
	boolean saveUser(UserInfo user);

	boolean deleteUser(int userId);

	List<CourseHistory> getCourseHistory(int userId, String status);

	UserInfo userLogin(String email, String pass);

	int countNoOfEnrollment(int userId);

	boolean updateNoOfCoursesEnrolled(int userId);

	boolean findByUserEmail(String email);

}
