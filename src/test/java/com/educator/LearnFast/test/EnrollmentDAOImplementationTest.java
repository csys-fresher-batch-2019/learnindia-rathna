package com.educator.LearnFast.test;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import com.educator.learnfast.service.EnrollmentService;;

public class EnrollmentDAOImplementationTest {
	EnrollmentService check = new EnrollmentService();

	@Test
	public void testSaveEnrollment() throws Exception {
		int userId = 77;
		int courseId = 20203;
		boolean expected = true;
		boolean actual = check.saveEnrollment(userId, courseId);
		assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void testRemoveEnrollment() throws Exception {
		int userId = 69;
		int courseId = 20202;
		boolean expected = true;
		boolean actual = check.deleteEnrollment(courseId, userId);
		assertEquals(expected, actual);
	}

}
