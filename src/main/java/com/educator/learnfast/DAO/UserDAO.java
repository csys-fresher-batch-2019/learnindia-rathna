package com.educator.learnfast.dao;

import java.util.ArrayList;


import com.educator.learnfast.models.CourseHistory;
import com.educator.learnfast.models.UserInfo;

public interface UserDAO {
	boolean saveUser(UserInfo user);

	boolean deleteUser(int userId);

	ArrayList<CourseHistory> getCourseHistory(int userId, int status);

	UserInfo userLogin(String email, String pass);

	int countNoOfEnrollment(int userId);

	boolean updateNoOfCoursesEnrolled(int userId);

	boolean findByUserEmail(String email);

}
