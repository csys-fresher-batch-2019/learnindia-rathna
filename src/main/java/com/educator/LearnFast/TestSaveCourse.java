package com.educator.LearnFast;

import com.educator.LearnFast.Courses.CourseInfo;
import com.educator.LearnFast.Courses.CoursesDAOImplementation;

public class TestSaveCourse {
	public static void main(String[] args) throws Exception {
		CourseInfo course1 = new CourseInfo();
		course1.setCourseName("Calculus");
		course1.setDurationOfCourse(18);
		course1.setInstructorName("Khan");
		course1.setCourseCategory("Maths");
		course1.setPrice(1000);
		CoursesDAOImplementation coursem = new CoursesDAOImplementation();
		coursem.saveCourse(course1);
	}

}
