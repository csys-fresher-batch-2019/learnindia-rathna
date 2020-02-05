package com.educator.LearnFast;
import java.util.Scanner;

import com.educator.LearnFast.Courses.CoursesDAOImplementation;

public class TestGetNoOfEnrollment {

	public static void main(String[] args) throws Exception {
		CoursesDAOImplementation en = new CoursesDAOImplementation();
		//System.out.println("hello");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Course ID:");
		int val = sc.nextInt();
		int result = en.getNoOfEnrollment(val);
		System.out.println(result);
	}

}
