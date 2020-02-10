package com.educator.LearnFast.TestUser;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.educator.LearnFast.Courses.CourseInfo;
import com.educator.LearnFast.Courses.CoursesDAOImplementation;

public class TestDisplayCourse {

	public static void main() throws Exception {
		// TODO Auto-generated method stub
		CourseInfo in = new CourseInfo();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter course name:");
		in.courseName = sc.nextLine();
		System.out.println("Enter instructor name:");
		in.instructorName = sc.nextLine();
		System.out.println("Enter course category:");
		in.courseCategory = sc.nextLine();
		System.out.println("Enter price:");
		in.price = sc.nextInt();
		CoursesDAOImplementation method = new CoursesDAOImplementation();
		ArrayList<CourseInfo> result = new ArrayList<CourseInfo>();
		result = method.displayCourses(in);
		//ResultSet rso = method.displayCourses(in);
		/*for(CourseInfo pass : result) {
			System.out.print("Course_Name:");
			System.out.print(pass.courseName);
			System.out.print(", ");
			System.out.print("Duration_of_Course:");
			System.out.print(pass.durationOfCourse);
			System.out.print(", ");
			System.out.print("Instructor_name:");
			System.out.print(pass.instructorName);
			System.out.print(", ");
			System.out.print("Price:");
			System.out.print(pass.price);
			System.out.print(", ");
			System.out.print("Course_Category:");
			System.out.print(pass.courseCategory);
			System.out.println(", ");
			System.out.print("Course_Id:");
			System.out.println(pass.courseId);
			System.out.println(pass);
		}
		while(rso.next()) {
			System.out.print("Course_name");
			System.out.print(rso.getString("course_name"));
			System.out.print(", ");
			System.out.print("Course_duration");
			System.out.print(rso.getInt("duration_of_course"));
			System.out.print(", ");
			System.out.print("Course_category");
			System.out.print(rso.getString("course_Category"));
			System.out.print(", ");
			System.out.print("Instructor_name");
			System.out.print(rso.getString("instructor_name"));
			System.out.print(", ");
			System.out.print("Price");
			System.out.println(rso.getInt("price"));
		}*/
		if(result!=null)
		for(CourseInfo lo : result) {
			System.out.println(lo);
		}
	}

}
