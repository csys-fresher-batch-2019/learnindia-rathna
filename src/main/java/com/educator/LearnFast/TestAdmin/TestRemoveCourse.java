package com.educator.LearnFast.TestAdmin;

import java.util.Scanner;

import com.educator.LearnFast.Courses.CoursesDAOImplementation;

public class TestRemoveCourse {
	public static void main() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Course Id:");
		int id = sc.nextInt();
		CoursesDAOImplementation courser = new CoursesDAOImplementation();
		int returned = courser.removeCourse(id);
		if(returned == 1)
			System.out.println("Course Successfully Removed");
		
	}

}
