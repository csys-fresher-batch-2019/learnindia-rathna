package com.educator.LearnFast;

import com.educator.LearnFast.Courses.CourseInfo;
import com.educator.LearnFast.Courses.CoursesDAOImplementation;

public class TestSaveCourse {
	public static void main(String[] args) throws Exception {
		CourseInfo course1 = new CourseInfo();
		course1.courseName = "Calculus";
		course1.durationOfCourse = 18;
		course1.instructorName = "Khan";
		course1.courseCategory = "Maths";
		course1.price = 1000;
		CoursesDAOImplementation coursem = new CoursesDAOImplementation();
		coursem.saveCourse(course1);
	}

}
