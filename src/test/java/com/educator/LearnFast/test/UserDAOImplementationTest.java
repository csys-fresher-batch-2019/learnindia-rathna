package com.educator.LearnFast.test;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import com.educator.learnfast.dao.implementation.UserDAOImplementation;
import com.educator.learnfast.model.CourseHistory;
import com.educator.learnfast.model.EnrollmentStatusEnum;
import com.educator.learnfast.model.UserInfo;
import com.educator.learnfast.service.UserService;

public class UserDAOImplementationTest {

	UserService check = new UserService();

	@Test
	@Ignore
	public void testAddUser() throws Exception {
		UserInfo arg = new UserInfo();
		arg.setUserName("Seenivasan");
		arg.setEmailId("seenii@gmail.com");
		arg.setUserPassword("seenivasan123");
		boolean expected = true;
		boolean actual = check.saveUser(arg);
		assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void testDeleteUser() throws Exception {
		int userId = 89;
		boolean expected = true;
		boolean actual = check.deleteUser(userId);
		assertEquals(expected, actual);
	}

	@Test @Ignore
	public void testUserLogin() throws Exception {
		String email = "gokul@gmail.com";
		String pass = "gokul1";
		UserInfo expected = new UserInfo();
		UserInfo actual = new UserInfo();
		expected.setUserId(53);
		expected.setUserName("gokul");
		expected.setEmailId("gokul@gmail.com");
		expected.setUserPassword("gokul12345");
		expected.setNoOfCoursesEnrolled(9);
		actual = check.userLogin(email, pass);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetCourseHistory() {
		int userId = 60;
		String status = "ONGOING";
		//UserDAOImplementation check = new UserDAOImplementation();
		ArrayList<CourseHistory> expected = new ArrayList<CourseHistory>();
		CourseHistory in1 = new CourseHistory();
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
		assertEquals(expected, actual);

	}

}
