package Test;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import com.educator.learnfast.implementation.UserDAOImplementation;
import com.educator.learnfast.models.CourseHistory;
import com.educator.learnfast.models.UserInfo;

public class UserDAOImplementationTest {

	@Test @Ignore
	public void testAddUser() throws Exception {
		UserInfo arg = new UserInfo();
		arg.setUserName("jeyaram");
		arg.setEmailId("jeyaram@gmail.com");
		arg.setUserPassword("jeyaram12345");
		UserDAOImplementation check = new UserDAOImplementation();
		boolean expected = true;
		boolean actual = check.addUser(arg);
		assertEquals(expected,actual);
	}
	
	@Test  @Ignore
	public void testDeleteUser() throws Exception {
		int userId = 52;
		UserDAOImplementation check = new UserDAOImplementation();
		boolean expected = true;
		boolean actual = check.deleteUser(userId);
		assertEquals(expected,actual);
	}
	
	@Test @Ignore
	public void testUserLogin() throws Exception {
		String email = "gokul@gmail.com";
		String pass = "gokul12345";
		UserInfo expected = new UserInfo();
		UserInfo actual = new UserInfo();
		expected.setUserId(53);
		expected.setUserName("gokul");
		expected.setEmailId("gokul@gmail.com");
		expected.setUserPassword("gokul12345");
		expected.setNoOfCoursesEnrolled(3);
		UserDAOImplementation check = new UserDAOImplementation();
		actual = check.UserLogin(email, pass);
		assertEquals(expected,actual);
	}
	
	@Test @Ignore
	public void testGetCourseHistory() {
		int userId = 44;
		int status = 1;
		UserDAOImplementation check = new UserDAOImplementation();
		ArrayList<CourseHistory> expected = new ArrayList<CourseHistory>();
		CourseHistory in1  = new CourseHistory();
		in1.setCourseName("VectorCalculus");
		in1.setCourseId(20206);
		in1.setInstructorName("SsalmanKhan");
		Date enrolldate = Date.valueOf("2020-02-13");
		in1.setEnrolled_date(enrolldate.toLocalDate());
		Date enddate = Date.valueOf("2020-04-09");
		in1.setEnding_date(enddate.toLocalDate());
		expected.add(in1);
		ArrayList<CourseHistory> actual = new ArrayList<CourseHistory>();
		actual = check.getCourseHistory(userId, status);
		assertEquals(expected,actual);
		
	}

}
