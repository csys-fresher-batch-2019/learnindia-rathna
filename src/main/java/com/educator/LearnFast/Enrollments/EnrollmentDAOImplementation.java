package com.educator.LearnFast.Enrollments;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.educator.LearnFast.Users.UserDAOImplementation;

public class EnrollmentDAOImplementation implements EnrollmentDAO{
	
	public void saveEnrollment(EnrollmentInfo enrollment) {
		UserDAOImplementation check = new UserDAOImplementation();
		int ck = check.getNoOfCourses(enrollment.userId);
		if(ck<5) {
		String sqls = "insert into enrollment_info(enrollment_id,course_id,user_id,enrolled_date,ending_date,status) "
				+ "values(enrollment_id_seq.nextval,"+enrollment.courseId+","+enrollment.userId+",SYSDATE,(SYSDATE+((select duration_of_course from course_info where course_id="+enrollment.courseId+")*7)),'"+EnrollmentStatusEnum.ONGOING+"')";
		Connection con2 = null;
		Statement stmt2 = null;
		int row2 = 0;
		try {
			con2 = TestConnection.getConnection();
			stmt2 = con2.createStatement();
			try {
				row2 = stmt2.executeUpdate(sqls);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("CourseId you have entered is Invalid");
			}
			con2.close();
			stmt2.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Could not Establish Connection with DataBase");
		}
		if (row2 == 1) {
			String sqlse = "update user_info set no_of_courses_enrolled = (no_of_courses_enrolled+1)"
					+ " where user_id = "+enrollment.userId+"";
			Connection con1 = null;
			Statement stmt1 = null;
			try {
				con1 = TestConnection.getConnection();
				stmt1 = con1.createStatement();
				try {
				int row1 = stmt1.executeUpdate(sqlse);
				if(row1 == 1)
				System.out.println("Course Enrolled");
				}catch(SQLException e) {
					System.out.println("Cannot update no_of_courses enrolled in user database");
				}
				con1.close();
				stmt1.close();
			} catch ( Exception e) {
				System.out.println("Could not Establish Connection with DataBase");
			}
		}
		}
		else {
			System.out.println("you cannot enroll more than 5 course");
		}
	}
	
	public void removeEnrollment(int CourseId,int UserId) {
		/*String sql1 = "select user_id from enrollment_info where enrollment_id = "+EnrollmentId+"";
		Connection con1 = TestConnection.getConnection();
		Statement stmt1 = con1.createStatement();
		ResultSet rs = stmt1.executeQuery(sql1);
		rs.next();
		int userId = rs.getInt(1);*/
		String sql = "delete from enrollment_info where course_id = "+CourseId+" and user_id = "+UserId+"";
		Connection con = null;
		Statement stmt = null;
		int row = 0;
		try {
			con = TestConnection.getConnection();
			stmt = con.createStatement();
			try {
				row = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				System.out.println("Cannot remove the course from your course list");
			}
			con.close();
			stmt.close();
		} catch (Exception e) {
		System.out.println("Could not establish connection with database");
		}
		if(row == 1)
		{
			Connection con1 = null;
			Statement stmt1= null;
			String sqlse = "update user_info set no_of_courses_enrolled = (no_of_courses_enrolled-1) where user_id = "+UserId+"";
			try {
				con1 = TestConnection.getConnection();
				stmt1 = con1.createStatement();
			try {
				stmt1.executeQuery(sqlse);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Cannot update no.of.courses enrolled by a user");
			}
			con1.close();
			stmt1.close();
			}catch(Exception e) {
				System.out.println("Could not Establish the Connection with DataBase");
			}
		}
		System.out.println("Course Removed from Your Course List");
	}
	public EnrollmentInfo fetchEnrollment(int EnrollmentId) {
		String sql = "select *from enrollment_info where enrollment_id = "+EnrollmentId+"";
		Connection con;
		Statement stmt;
		ResultSet rs;
		EnrollmentInfo ei = new EnrollmentInfo();
		try {
			con = TestConnection.getConnection();
			stmt = con.createStatement();
			try {
				rs = stmt.executeQuery(sql);
				if(rs.next()) {
					int enrollmentId = rs.getInt("enrollment_id");
					int CourseId = rs.getInt("course_id");
					ei.enrollmentId = enrollmentId;
					ei.courseId = CourseId;
					ei.enrolledDate = rs.getDate("enrolled_date");
					ei.endingDate = rs.getDate("ending_date");
					ei.status = EnrollmentStatusEnum.valueOf(rs.getString("status"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("There is no such Enrollment");
			}
			con.close();
			stmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Could not establish connection with DataBase");
		}
		return ei;
	}

}
