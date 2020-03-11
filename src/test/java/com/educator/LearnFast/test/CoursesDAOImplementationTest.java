package com.educator.LearnFast.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import com.educator.learnfast.Exception.DbException;
import com.educator.learnfast.dao.implemenation.CoursesDAOImplementation;
import com.educator.learnfast.models.ContentInfo;
import com.educator.learnfast.models.CourseInfo;
import com.educator.learnfast.service.CoursesService;

public class CoursesDAOImplementationTest {

	CoursesService met = new CoursesService();

	@Ignore
	@Test
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

	@Test
	@Ignore
	public void testRemoveCourse() throws Exception {
		int courseId = 20211;
		boolean expected = true;
		boolean actual = met.deleteCourse(courseId);
		assertEquals(expected, actual);
	}

	@Test @Ignore
	public void testgetNoOfEnrollment() throws Exception {
		int courseId = 20;
		int expected = 5;
		CoursesDAOImplementation course = new CoursesDAOImplementation();
		int actual = course.getNoOfEnrollment(courseId);
		assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void testDisplayCourses() throws Exception {
		CourseInfo argu = new CourseInfo();
		CoursesDAOImplementation check = new CoursesDAOImplementation();
		String category = "Arts";
		argu.setCourseCategory(category);
		ArrayList<CourseInfo> expected = new ArrayList<>();
		CourseInfo alist = new CourseInfo();
		alist.setCourseId(20203);
		alist.setCourseName("MusicTheory");
		alist.setDurationOfCourse(16);
		alist.setInstructorName("Robin");
		alist.setCourseCategory("Arts");
		alist.setPrice(2000);
		expected.add(alist);
		ArrayList<CourseInfo> actual = new ArrayList<>();
		actual = check.findCourses(argu);
		assertEquals(expected, actual);
	}

	@Test @Ignore
	public void testCourseRating() throws Exception {
		int courseId = 20202;
		int userId = 64;
		int rating = 3;
		boolean expected = true;
		boolean actual = met.saveCourseRating(rating, courseId, userId);
		assertEquals(expected, actual);
	}

	@Test
	public void testFetchCourseContent() throws Exception {
		ArrayList<ContentInfo> expected = new ArrayList<>();
		int courseId = 20;
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
		ArrayList<ContentInfo> actual = new ArrayList<>();
		actual = met.getCourseContent(courseId);
		assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void saveContent() {
		ContentInfo contentInfo = new ContentInfo();
		contentInfo.setChapterNo(5);
		contentInfo.setCourseId(20205);
		contentInfo.setCourseContent("Improve Your Communication Skills");
		boolean expected = true;
		boolean actual = met.saveCourseContent(contentInfo);
		assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void deleteContent() {
		int courseId = 20205;
		int chapterNo = 5;
		boolean expected = true;
		boolean actual = met.deleteCourseContent(courseId, chapterNo);
		assertEquals(expected, actual);
	}

}
