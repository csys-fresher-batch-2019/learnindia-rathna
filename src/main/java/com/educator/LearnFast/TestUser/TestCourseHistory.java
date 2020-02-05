package com.educator.LearnFast.TestUser;
import java.util.ArrayList;
import java.util.Scanner;

import com.educator.LearnFast.Courses.CourseHistory;
import com.educator.LearnFast.Users.UserDAOImplementation;

public class TestCourseHistory {

	public static void main(int userId) throws Exception {
		ArrayList<CourseHistory> cho = new ArrayList<CourseHistory>();
		UserDAOImplementation chtest = new UserDAOImplementation();
		Scanner sc = new Scanner(System.in);
		//System.out.println("Enter UserID:");
		//gint id = sc.nextInt();
		int stat;
		System.out.println("Enter Status (ONGOING/COMPLETED/ALL)");
		String status = sc.next();
	    if(status.equalsIgnoreCase("ONGOING"))
	    	stat = 1;
	    else
	    	stat =0;
		cho = chtest.getCourseHistory(userId,stat);
		if(cho.size()>0) {
		for(CourseHistory ch:cho) {
			/*System.out.print(ch.courseName);
			System.out.print(", ");
			System.out.print(ch.instructorName);
			System.out.print(", ");
			System.out.print(ch.enrolled_date);
			System.out.print(", ");
			System.out.print(ch.ending_date);
			System.out.println("");*/
			System.out.println(cho);
		}
		}
		else
			System.out.println("There is no Course to Found");
	}

}
