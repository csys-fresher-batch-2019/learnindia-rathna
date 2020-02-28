package com.educator.learnfast.test;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;


import com.educator.learnfast.implementation.InstructorDAOImplementation;
import com.educator.learnfast.models.InstructorInfo;

public class InstructorDAOImplementationTest {

	@Test 
	public void test() {
		boolean expected = true;
		InstructorInfo arg = new InstructorInfo();
		arg.setInstructorName("shanss");
		arg.setInstructorEmail("shanss@gmail.com");
		arg.setInstructorPassword("shans123");
		arg.setAreaOfInterest("Power Electronics");
		InstructorDAOImplementation check = new InstructorDAOImplementation();
		boolean actual = check.saveInstructor(arg);
		assertEquals(expected,actual);
	}
	
	@Test @Ignore
	public void testInstructorLogin() {
		InstructorInfo expected = new InstructorInfo();
		String email = "sanjay@gmail.com";
		String pass = "sanjay0510";
		expected.setInstructorId(8);
		expected.setInstructorName("sanjay");
		expected.setInstructorEmail("sanjay@gmail.com");
		expected.setInstructorPassword("sanjay0510");
		expected.setAreaOfInterest("QuantumGravity");
		InstructorDAOImplementation check = new InstructorDAOImplementation();
		InstructorInfo actual = new InstructorInfo();
		actual = check.instructorLogin(email, pass);
		assertEquals(expected,actual);
	}

}
