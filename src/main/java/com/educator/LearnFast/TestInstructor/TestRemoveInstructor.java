package com.educator.LearnFast.TestInstructor;

import java.util.Scanner;

import com.educator.LearnFast.Instructors.InstructorDAOImplementation;

public class TestRemoveInstructor {

	public static void main(int id) throws Exception {
		//Scanner sc = new Scanner(System.in);
		InstructorDAOImplementation imp = new InstructorDAOImplementation();
		//System.out.println("Enter instructor id:");
		//int instructorId = sc.nextInt();
		imp.removeInstructor(id);
	}

}
