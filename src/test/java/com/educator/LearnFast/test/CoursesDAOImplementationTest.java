package com.educator.learnfast.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.educator.learnfast.dao.implementation.CoursesDAOImplementation;
import com.educator.learnfast.model.ContentInfo;
import com.educator.learnfast.model.CourseInfo;
import com.educator.learnfast.service.CoursesService;

public class CoursesDAOImplementationTest {

	CoursesService met = new CoursesService();

	@Test @Ignore
	public void testSaveCourse() throws Exception {
		CourseInfo obj = new CourseInfo();
		obj.setCourseName("Algebra2");
		obj.setCourseCategory("Maths");
		obj.setInstructorId(2);
		obj.setInstructorName("Salmankhan");
		obj.setDurationOfCourse(8);
		obj.setPrice(0);
		boolean expected = true;
		boolean actual = met.saveCourse(obj);
		assertEquals(expected, actual);
	}

	@Test @Ignore
	public void testRemoveCourse() throws Exception {
		int courseId = 20208;
		boolean expected = true;
		boolean actual = met.deleteCourse(courseId);
		assertEquals(expected, actual);
	}

	@Test @Ignore
	public void testgetNoOfEnrollment() throws Exception {
		int courseId = 20202;
		int expected = 3;
		CoursesDAOImplementation course = new CoursesDAOImplementation();
		int actual = course.countNoOfEnrollment(courseId);
		assertEquals(expected, actual);
	}

	@Test @Ignore
	public void testDisplayCourses() throws Exception {
		CourseInfo argu = new CourseInfo();
		String category = "Engineering";
		argu.setCourseCategory(category);
		argu.setCourseName("");
		argu.setPrice(100);
		argu.setInstructorName("");
		List<CourseInfo> expected = new ArrayList<>();
		CourseInfo alist = new CourseInfo();
		alist.setCourseId(20203);
		alist.setCourseName("Power Systems");
		alist.setDurationOfCourse(8);
		alist.setInstructorName("J.B.Gupta");
		alist.setCourseCategory("Engineering");
		alist.setPrice(1000);
		alist.setRating(2);
		expected.add(alist);
		List<CourseInfo> actual = new ArrayList<>();
		actual = met.findCourses(argu);
		assertEquals(expected, actual);
	}

	@Test @Ignore
	public void testCourseRating() throws Exception {
		int courseId = 20202;
		int userId = 53;
		int rating = 5;
		boolean expected = true;
		boolean actual = met.saveCourseRating(rating, courseId, userId);
		assertEquals(expected, actual);
	}

	@Test @Ignore
	public void testFetchCourseContent() throws Exception {
		ArrayList<ContentInfo> expected = new ArrayList<>();
		int courseId = 20204;
		ContentInfo c1 = new ContentInfo();
		c1.setChapterNo(1);
		c1.setCourseContent("Setting the Scene for Conversation");
		ContentInfo c2 = new ContentInfo();
		c2.setChapterNo(2);
		c2.setCourseContent("you are your Message");
		ContentInfo c3 = new ContentInfo();
		c3.setChapterNo(3);
		c3.setCourseContent("Telling people things they might not want to hear");
		ContentInfo c4 = new ContentInfo();
		c4.setChapterNo(4);
		c4.setCourseContent("Positive Communication");
		expected.add(c1);
		expected.add(c2);
		expected.add(c3);
		expected.add(c4);
		List<ContentInfo> actual = new ArrayList<>();
		actual = met.getCourseContent(courseId);
		assertEquals(expected, actual);
	}

	@Test @Ignore
	public void saveContent() {
		ContentInfo contentInfo = new ContentInfo();
		contentInfo.setChapterNo(8);
		contentInfo.setCourseId(20207);
		contentInfo.setCourseContent("Advanced differentiation");
		boolean expected = true;
		boolean actual = met.saveCourseContent(contentInfo);
		assertEquals(expected, actual);
	}

	@Test @Ignore
	public void deleteContent() {
		int courseId = 20206;
		int chapterNo = 8;
		boolean expected = true;
		boolean actual = met.deleteCourseContent(courseId, chapterNo);
		assertEquals(expected, actual);
	}

}
