package com.educator.LearnFast.TestAdmin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.educator.LearnFast.Courses.CourseInfo;
import com.educator.LearnFast.Courses.CoursesDAOImplementation;


public class ImportCourses {
	public static void main() throws Exception {
		Path path = Paths.get("D:\\courses.txt");
		List<String> l1 = Files.readAllLines(path);
		for(String line : l1) {
			String[] row = line.split(",");
			String courseName = row[0];
			int durationOfCourse = Integer.parseInt(row[1]);
			String instructorName = row[2];
			String courseCategory = row[3];
			int price = Integer.parseInt(row[4]);
			int instructorId = Integer.parseInt(row[5]);
			CourseInfo courses = new CourseInfo();
			courses.courseName = courseName;
			courses.durationOfCourse = durationOfCourse;
			courses.instructorName = instructorName;
			courses.courseCategory = courseCategory;
			courses.price = price;
			courses.instructorId = instructorId;
			CoursesDAOImplementation method = new CoursesDAOImplementation();
			method.saveCourse(courses);
		}
		System.out.println("Courses Imported");
		
		
	}

}
