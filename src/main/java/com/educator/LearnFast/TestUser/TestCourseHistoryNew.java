package com.educator.LearnFast.TestUser;

import java.util.ArrayList;

import com.educator.LearnFast.Courses.CourseHistory;
import com.educator.LearnFast.Users.UserDAOImplementation;

public class TestCourseHistoryNew {

	public static void main(int id,int stat) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<CourseHistory> cho = new ArrayList<CourseHistory>();
		UserDAOImplementation chtest = new UserDAOImplementation();
		cho = chtest.getCourseHistory(id,stat);
		for(CourseHistory ch:cho) {
			/*System.out.print(ch.courseName);
			System.out.print(", ");
			System.out.print(ch.instructorName);
			System.out.print(", ");
			System.out.print(ch.enrolled_date);
			System.out.print(", ");
			System.out.print(ch.ending_date);
			System.out.print(", ");
			System.out.print(ch.courseId);
			System.out.println("");*/
			System.out.println(ch);
		}
	}

}
