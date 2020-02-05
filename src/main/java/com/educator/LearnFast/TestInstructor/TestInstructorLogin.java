package com.educator.LearnFast.TestInstructor;

import java.util.Scanner;

import com.educator.LearnFast.Instructors.InstructorDAOImplementation;

public class TestInstructorLogin {

	public static void main() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Instructor Email:");
		String email = sc.next();
		System.out.println("Enter Password:");
		String pass = sc.next();
		InstructorDAOImplementation met = new InstructorDAOImplementation();
		met.instructorLogin(email, pass);

	}

}
