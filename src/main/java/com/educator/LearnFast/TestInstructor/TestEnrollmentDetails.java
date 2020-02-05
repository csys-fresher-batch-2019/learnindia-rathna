package com.educator.LearnFast.TestInstructor;

import java.util.ArrayList;
import java.util.Scanner;

import com.educator.LearnFast.Enrollments.EnrollmentDAO;
import com.educator.LearnFast.Enrollments.EnrollmentDetails;
import com.educator.LearnFast.Instructors.InstructorDAOImplementation;

public class TestEnrollmentDetails {

	public static void main(int id) throws Exception {

		Scanner sc = new Scanner(System.in);
		//System.out.println("Enter Instructor id:");
		//int id = sc.nextInt();
		InstructorDAOImplementation met = new InstructorDAOImplementation();
		ArrayList<EnrollmentDetails> in = new ArrayList<EnrollmentDetails>();
		in = met.getEnrollmentDetails(id);
		for(EnrollmentDetails print :in) {
			/*System.out.print("Course_Name:");
			System.out.print(print.courseName);
			System.out.print(", ");
			System.out.print("Duration:");
			System.out.print(print.duration);
			System.out.print(", ");
			System.out.print("No_of_Enrollments:");
			System.out.println(print.noOfEnrollments);*/
			System.out.println(print);
		}
	}

}
