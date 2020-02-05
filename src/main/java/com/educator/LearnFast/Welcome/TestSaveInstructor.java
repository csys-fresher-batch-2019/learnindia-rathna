package com.educator.LearnFast.Welcome;

import java.util.Scanner;

import com.educator.LearnFast.Instructors.InstructorDAOImplementation;
import com.educator.LearnFast.Instructors.InstructorInfo;

public class TestSaveInstructor {

	public static void main() throws Exception {
		Scanner sc = new Scanner(System.in);
		InstructorDAOImplementation imp = new InstructorDAOImplementation();
		InstructorInfo info = new InstructorInfo();
		System.out.println("Enter instructor name:");
		info.instructorName = sc.next();
		System.out.println("Enter instructor email:");
		info.instructorEmail = sc.next();
		System.out.println("Enter instructor password:");
		info.instructorPassword = sc.next();
		System.out.println("Enter area of interest:");
		info.areaOfInterest = sc.next();
		imp.saveInstructor(info);
	}

}
