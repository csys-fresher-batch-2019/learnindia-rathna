package com.educator.learnfast.test;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import com.educator.learnfast.DAO.UserDAO;
import com.educator.learnfast.DAO.implementation.UserDAOImplementation;
import com.educator.learnfast.models.CourseHistory;
import com.educator.learnfast.models.UserInfo;
import com.educator.learnfast.service.UserService;

public class UserDAOImplementationTest {
	
	UserService check = new UserService();
	
	@Test 
	public void testAddUser() throws Exception {
		UserInfo arg = new UserInfo();
		arg.setUserName("Seenivasan");
		arg.setEmailId("seenii@gmail.com");
		arg.setUserPassword("seenivasan123");
		boolean expected = true;
		boolean actual = check.addUser(arg);
		assertEquals(expected,actual);
	}
	
	@Test @Ignore
	public void testDeleteUser() throws Exception {
		int userId = 80;
		boolean expected = true;
		boolean actual = check.deleteUser(userId);
		assertEquals(expected,actual);
	}
	
	@Test @Ignore
	public void testUserLogin() throws Exception {
		String email = "abc@gmail.com";
		String pass = "1234579000";
		UserInfo expected = new UserInfo();
		UserInfo actual = new UserInfo();
		expected.setUserId(53);
		expected.setUserName("gokul");
		expected.setEmailId("gokul@gmail.com");
		expected.setUserPassword("gokul12345");
		expected.setNoOfCoursesEnrolled(10);
		//UserDAOImplementation check = new UserDAOImplementation();
		actual = check.UserLogin(email, pass);
		assertEquals(expected,actual);
	}
	
	@Test @Ignore
	public void testGetCourseHistory() {
		int userId = 60;
		int status = 2;
		UserDAOImplementation check = new UserDAOImplementation();
		ArrayList<CourseHistory> expected = new ArrayList<CourseHistory>();
		CourseHistory in1  = new CourseHistory();
		in1.setCourseName("Introduction to Digital Photography");
		in1.setCourseId(20202);
		in1.setInstructorName("Hari");
		Date enrolldate = Date.valueOf("2020-03-04");
		in1.setEnrolledDate(enrolldate.toLocalDate());
		Date enddate = Date.valueOf("2020-04-15");
		in1.setEndingDate(enddate.toLocalDate());
		in1.setEnrollmentId(221);
		expected.add(in1);
		ArrayList<CourseHistory> actual = new ArrayList<CourseHistory>();
		actual = check.getCourseHistory(userId, status);
		assertEquals(expected,actual);
		
	}
	
	@Test @Ignore
	public void getEmail() throws Exception {
		String email = "abc@gmail.com";
		boolean expected = true;
		boolean actual = check.getEmail(email);
		assertEquals(expected, actual);
	}

}
