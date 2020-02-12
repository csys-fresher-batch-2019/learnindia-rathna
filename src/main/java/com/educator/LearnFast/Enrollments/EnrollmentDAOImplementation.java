package com.educator.LearnFast.Enrollments;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.educator.LearnFast.Users.UserDAOImplementation;

public class EnrollmentDAOImplementation implements EnrollmentDAO{
	
	public void saveEnrollment(EnrollmentInfo enrollment)  {
		boolean row = false;
		String error = null;
	try(Connection con = TestConnection.getConnection();
		CallableStatement cstmt = con.prepareCall("{call PR_INSERT_ENROLLMENT(?,?,?)}");){
			cstmt.setInt(1, enrollment.getUserId());
			cstmt.setInt(2, enrollment.getCourseId());
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
				row = cstmt.execute();
				error = cstmt.getString(3);
			}catch ( Exception e) {
				// TODO Auto-generated catch block
				System.out.println("cannot enroll the course");
			}
			if(error!=null){
				System.out.println(error);
			}
		if(row == true)
			System.out.println("Course Enrolled");
	}
	
	public void removeEnrollment(int CourseId,int UserId) {
		/*String sql1 = "select user_id from enrollment_info where enrollment_id = "+EnrollmentId+"";
		Connection con1 = TestConnection.getConnection();
		Statement stmt1 = con1.createStatement();
		ResultSet rs = stmt1.executeQuery(sql1);
		rs.next();
		int userId = rs.getInt(1);*/
		String sql = "delete from enrollment_info where course_id = "+CourseId+" and user_id = "+UserId+"";
		int row = 0;
		try(Connection con = TestConnection.getConnection();
			Statement stmt = con.createStatement();){
			row = stmt.executeUpdate(sql);
			} catch (Exception e) {
				System.out.println("Cannot remove the course from your course list");
			}
		if(row == 1)
		{
			String sqlse = "update user_info set no_of_courses_enrolled = (no_of_courses_enrolled-1) where user_id = "+UserId+"";
			try (Connection con1 = TestConnection.getConnection();
				Statement stmt1 = con1.createStatement();){
				stmt1.executeQuery(sqlse);
			} catch ( Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Cannot update no.of.courses enrolled by a user");
			}
		}
		System.out.println("Course Removed from Your Course List");
	}
	public EnrollmentInfo fetchEnrollment(int EnrollmentId) {
		String sql = "select *from enrollment_info where enrollment_id = "+EnrollmentId+"";
		EnrollmentInfo ei = new EnrollmentInfo();
		try (Connection con = TestConnection.getConnection();
			Statement stmt = con.createStatement();){
			try(ResultSet rs = stmt.executeQuery(sql);){
				if(rs.next()) {
					int enrollmentId = rs.getInt("enrollment_id");
					int CourseId = rs.getInt("course_id");
					ei.setEnrollmentId(enrollmentId);
					ei.setCourseId(CourseId);
					ei.setEnrolledDate(rs.getDate("enrolled_date"));
					ei.setEndingDate(rs.getDate("ending_date"));
					ei.setStatus(EnrollmentStatusEnum.valueOf(rs.getString("status")));
				}
			}} catch ( Exception e) {
				// TODO Auto-generated catch block
				System.out.println("There is no such Enrollment");
			}
		return ei;
	}

}
