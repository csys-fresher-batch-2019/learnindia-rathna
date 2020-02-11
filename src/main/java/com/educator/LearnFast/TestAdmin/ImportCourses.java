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
		int count = 0;
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
			courses.setCourseName(courseName);
			courses.setDurationOfCourse(durationOfCourse);
			courses.setInstructorName(instructorName);
			courses.setCourseCategory(courseCategory);
			courses.setPrice(price);
			courses.setInstructorId(instructorId);
			CoursesDAOImplementation method = new CoursesDAOImplementation();
			boolean returned = method.saveCourse(courses);
			if(returned == true)
				count++;
		}
		System.out.println(+count+ "Courses Imported");
	}
}
