package Test;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Ignore;
import org.junit.Test;

import com.educator.learnfast.implementation.EnrollmentDAOImplementation;
import com.educator.learnfast.models.EnrollmentInfo;
import com.educator.learnfast.models.EnrollmentStatusEnum;;

public class EnrollmentDAOImplementationTest {

	@Test
	public void testSaveEnrollment() throws Exception {
		int userId = 76;
		int courseId = 20210;
		EnrollmentDAOImplementation check = new EnrollmentDAOImplementation();
		boolean expected = true;
		boolean actual = check.saveEnrollment(userId, courseId);
		assertEquals(expected,actual);
	}
	
	
	@Test @Ignore
	public void testRemoveEnrollment() {
		int userId =53;
		int courseId = 20209;
		EnrollmentDAOImplementation check = new EnrollmentDAOImplementation();
		boolean expected = true;
		boolean actual = check.removeEnrollment(courseId,userId);
		assertEquals(expected,actual);
	}
	
	
	@Test @Ignore
	public void testFetchEnrollment() {
		EnrollmentDAOImplementation check = new EnrollmentDAOImplementation();
		int EnrollmentId = 313;
		EnrollmentInfo expected = new EnrollmentInfo();
		expected.setEnrollmentId(EnrollmentId);
		expected.setCourseId(20205);
		Date dat = Date.valueOf("2020-02-14");
		LocalDate date = dat.toLocalDate();
		expected.setEnrolledDate(date);
		Date enddat = Date.valueOf("2020-05-20");
		LocalDate enddate = enddat.toLocalDate();
		expected.setEndingDate(enddate);
		String stat = "ONGOING";
		expected.setStatus(EnrollmentStatusEnum.valueOf(stat));
		EnrollmentInfo actual = new EnrollmentInfo();
		actual = check.fetchEnrollment(EnrollmentId);
		assertEquals(expected,actual);	
	}

	}
