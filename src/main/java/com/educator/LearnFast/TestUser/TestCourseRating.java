package com.educator.LearnFast.TestUser;

import java.util.Scanner;

import com.educator.LearnFast.Courses.CoursesDAOImplementation;
import com.educator.LearnFast.TestUser.TestCourseHistoryNew;
import com.educator.LearnFast.Users.UserDAOImplementation;

public class TestCourseRating {

	public static void main(int id) throws Exception {
		Scanner sc = new Scanner(System.in);
		//System.out.println("Enter user id");
		//int id = sc.nextInt();
		System.out.println("Your Course List");
		TestCourseHistoryNew.main(id, 1);
		System.out.println("course id");
		int courseId = sc.nextInt();
		System.out.println("Enter Rating (out of 5)");
		int rating = sc.nextInt();
		CoursesDAOImplementation met = new CoursesDAOImplementation();
		met.addCourseRating(rating, courseId,id);
	}

}
