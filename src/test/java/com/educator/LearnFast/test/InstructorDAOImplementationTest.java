package com.educator.LearnFast.test;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import com.educator.learnfast.DAO.InstructorDAO;
import com.educator.learnfast.DAO.implementation.InstructorDAOImplementation;
import com.educator.learnfast.models.InstructorInfo;
import com.educator.learnfast.service.InstructorService;

public class InstructorDAOImplementationTest {

	InstructorService check = new InstructorService();

	@Test
	@Ignore
	public void testAddInstructor() throws Exception {
		boolean expected = true;
		InstructorInfo arg = new InstructorInfo();
		arg.setInstructorName("vimal");
		arg.setInstructorEmail("vimal@gmail.com");
		arg.setInstructorPassword("vimal12345");
		arg.setAreaOfInterest("Power Electronics");
		boolean actual = check.saveInstructor(arg);
		assertEquals(expected, actual);
	}

	@Test
	public void testInstructorLogin() throws Exception {
		InstructorInfo expected = new InstructorInfo();
		String email = "gokul@gmail.com";
		String pass = "gokul1234";
		expected.setInstructorId(13);
		expected.setInstructorName("gokul");
		expected.setInstructorEmail("gokul@gmail.com");
		expected.setInstructorPassword("gokul12345");
		expected.setAreaOfInterest("Power Electroincs");
		InstructorInfo actual = new InstructorInfo();
		actual = check.instructorLogin(email, pass);
		assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void getEmail() throws Exception {
		String email = "robert@gmail.com";
		boolean expected = true;
		InstructorDAO instructorDAO = new InstructorDAOImplementation();
		boolean actual = instructorDAO.getInstructorEmail(email);
		assertEquals(expected, actual);
	}

}
