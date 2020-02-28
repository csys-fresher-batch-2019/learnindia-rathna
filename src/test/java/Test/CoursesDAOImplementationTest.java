package Test;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import com.educator.learnfast.Exception.DbException;
import com.educator.learnfast.implementation.CoursesDAOImplementation;
import com.educator.learnfast.models.CourseInfo;

import junit.framework.TestCase;

public class CoursesDAOImplementationTest extends TestCase {
	
	@Test 
	public void testSaveCourse() throws Exception {
		CourseInfo obj = new CourseInfo();
		obj.setCourseName("SpokenEnglish");
		obj.setCourseCategory("Personality Development");
		obj.setInstructorId(3);
		obj.setInstructorName("Vasudevan");
		obj.setDurationOfCourse(4);
		obj.setPrice(100);
		boolean expected = true;
		CoursesDAOImplementation met = new CoursesDAOImplementation();
		boolean actual = met.saveCourse(obj);
		assertEquals(expected,actual);
	}
	
	@Test 
	public void testRemoveCourse() throws DbException {
		int courseId  = 20227;
		boolean expected = true;
		CoursesDAOImplementation remove = new CoursesDAOImplementation();
		boolean actual = remove.removeCourse(courseId);
		assertEquals(expected,actual);
	}
	
	@Test 
	public void testgetNoOfEnrollment() throws Exception {
		int courseId = 20205;
		int expected = 1;
		CoursesDAOImplementation course = new CoursesDAOImplementation();
		int actual = course.getNoOfEnrollment(courseId);
		assertEquals(expected,actual);
	}

	@Test
	public void testDisplayCourses() throws DbException {
		CourseInfo argu = new CourseInfo();
		CoursesDAOImplementation check = new CoursesDAOImplementation();
		String category = "Arts";
		argu.setCourseCategory(category);
		ArrayList<CourseInfo> expected = new ArrayList();
		CourseInfo alist = new CourseInfo();
		alist.setCourseId(20203);
		alist.setCourseName("MusicTheory");
		alist.setDurationOfCourse(16);
		alist.setInstructorName("Robin");
		alist.setCourseCategory("Arts");
		alist.setPrice(2000);
		expected.add(alist);
		ArrayList<CourseInfo> actual = new ArrayList();
		actual = check.displayCourses(argu);
		assertEquals(expected,actual);
	}
	
	@Test 
	public void testCourseRating() throws DbException {
		int courseId = 20209;
		int userId = 53;
		int rating = 5;
		CoursesDAOImplementation check = new CoursesDAOImplementation();
		boolean expected = true;
		boolean actual = check.addCourseRating(rating, courseId, userId);
		assertEquals(expected,actual);
	}
	
	
}
