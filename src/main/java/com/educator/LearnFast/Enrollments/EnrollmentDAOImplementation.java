package com.educator.LearnFast.Enrollments;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.educator.LearnFast.Users.UserDAOImplementation;

public class EnrollmentDAOImplementation implements EnrollmentDAO{
	
	public void saveEnrollment(EnrollmentInfo enrollment) throws Exception {
		UserDAOImplementation check = new UserDAOImplementation();
		int ck = check.getNoOfCourses(enrollment.userId);
		if(ck<5) {
		String sqls = "insert into enrollment_info(enrollment_id,course_id,user_id,enrolled_date,ending_date,status) "
				+ "values(enrollment_id_seq.nextval,"+enrollment.courseId+","+enrollment.userId+",SYSDATE,(SYSDATE+((select duration_of_course from course_info where course_id="+enrollment.courseId+")*7)),'"+EnrollmentStatusEnum.ONGOING+"')";
		//System.out.println(sqls);
		Connection con2 = TestConnection.getConnection();
		Statement stmt2 = con2.createStatement();
		int row2 = stmt2.executeUpdate(sqls);
		if (row2 == 1) {
			String sqlse = "update user_info set no_of_courses_enrolled = (no_of_courses_enrolled+1)"
					+ " where user_id = "+enrollment.userId+"";
			Connection con1 = TestConnection.getConnection();
			Statement stmt1 = con1.createStatement();
			int row1 = stmt1.executeUpdate(sqlse);
		}
		//System.out.println(row2);
		//System.out.println(sqls);
		System.out.println("Course Enrolled");
		}
		else {
			System.out.println("you cannot enroll more than 5 course");
		}
	}
	
	public void removeEnrollment(int CourseId,int UserId) throws Exception {
		/*String sql1 = "select user_id from enrollment_info where enrollment_id = "+EnrollmentId+"";
		Connection con1 = TestConnection.getConnection();
		Statement stmt1 = con1.createStatement();
		ResultSet rs = stmt1.executeQuery(sql1);
		rs.next();
		int userId = rs.getInt(1);*/
		String sql = "delete from enrollment_info where course_id = "+CourseId+" and user_id = "+UserId+"";
		Connection con = TestConnection.getConnection();
		Statement stmt = con.createStatement();
		int row = stmt.executeUpdate(sql);
		if(row == 1)
		{
			String sqlse = "update user_info set no_of_courses_enrolled = (no_of_courses_enrolled-1) where user_id = "+UserId+"";
			Connection con2 = TestConnection.getConnection();
			Statement stmt2 = con2.createStatement();
			stmt2.executeQuery(sqlse);
		}
		//System.out.println(sql);
		//System.out.println(row);
		System.out.println("Course Removed from Your Course List");
	}
	public EnrollmentInfo fetchEnrollment(int EnrollmentId) throws Exception {
		String sql = "select *from enrollment_info where enrollment_id = "+EnrollmentId+"";
		System.out.println(sql);
		Connection con = TestConnection.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		EnrollmentInfo ei = new EnrollmentInfo();
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		if(rs.next()) {
			int enrollmentId = rs.getInt("enrollment_id");
			int CourseId = rs.getInt("course_id");
			 //String s = rs.getString("enrolled_date");
			 //System.out.println(s);
			ei.enrollmentId = enrollmentId;
			ei.courseId = CourseId;
			ei.enrolledDate = rs.getDate("enrolled_date");
			ei.endingDate = rs.getDate("ending_date");
			ei.status = EnrollmentStatusEnum.valueOf(rs.getString("status"));
		}
		return ei;
	}

}
