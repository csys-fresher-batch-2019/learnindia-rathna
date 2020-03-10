package com.educator.learnfast.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.educator.learnfast.models.CourseHistory;
import com.educator.learnfast.models.UserInfo;

public interface UserDAO {
	boolean addUser(UserInfo user);

	boolean deleteUser(int userId);

	ArrayList<CourseHistory> getCourseHistory(int userId, int status);

	UserInfo UserLogin(String email, String pass);

	int count(int userId);

	boolean updateNoOfCoursesEnrolled(int userId);

	boolean getEmail(String email);

}
