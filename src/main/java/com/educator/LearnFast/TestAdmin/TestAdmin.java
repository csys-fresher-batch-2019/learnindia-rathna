package com.educator.LearnFast.TestAdmin;

import java.util.Scanner;

public class TestAdmin {

	public static void main(String[] args) throws Exception {
		int key = 0;
		System.out.println("Welcome To Admin Page");
		System.out.println("Enter 1 to add courses");
		System.out.println("Enter 2 to remove course");
		Scanner sc = new Scanner(System.in);
		key = sc.nextInt();
		switch(key) {
			case 1:
				System.out.println("Importing Courses.....");
				ImportCourses.main();
				break;
			case 2:
				TestRemoveCourse.main();
				break;
			default:
				System.out.println("Invalid operation");
		}
	}

}
