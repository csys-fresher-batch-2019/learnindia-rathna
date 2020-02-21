package com.educator.learnfast.implementation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.educator.learnfast.DAO.EnrollmentDAO;
import com.educator.learnfast.Exception.DbException;
import com.educator.learnfast.Exception.InfoMessages;
import com.educator.learnfast.models.EnrollmentInfo;
import com.educator.learnfast.models.EnrollmentStatusEnum;
import com.educator.learnfast.util.Logger;
import com.educator.learnfast.util.TestConnection;

public class EnrollmentDAOImplementation implements EnrollmentDAO {
	Logger logger = Logger.getInstance();

	public boolean saveEnrollment(int userId, int courseId) throws DbException  {
		boolean row = false;
		String errorMessage = null;
		try(Connection con = TestConnection.getConnection();
				CallableStatement cstmt = con.prepareCall("{call PR_INSERT_ENROLLMENT(?,?,?)}");){
			cstmt.setInt(1, userId);
			cstmt.setInt(2, courseId);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt.execute();
			System.out.println("Row:" + row);
			errorMessage = cstmt.getString(3);
			if (errorMessage == null) {
				row = true;
			}
		}catch(SQLException e) {
			throw new DbException(InfoMessages.SAVEENROLLMENT);
		}catch(Exception e) {
			throw new DbException(InfoMessages.CONNECTION);
		}
		System.out.println(errorMessage);
		return row;

	}

	public boolean removeEnrollment(int CourseId, int UserId) {
		String sql = "delete from enrollment_info where course_id = " + CourseId + " and user_id = " + UserId + "";
		int row = 0, row1 = 0;
		boolean out = false;
		try (Connection con = TestConnection.getConnection(); Statement stmt = con.createStatement();) {
			row = stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("Cannot remove the course from your course list");
		}
		if (row == 1) {
			String sqlse = "update user_info set no_of_courses_enrolled = (no_of_courses_enrolled-1) where user_id = "
					+ UserId + "";
			try (Connection con1 = TestConnection.getConnection(); Statement stmt1 = con1.createStatement();) {
				row1 = stmt1.executeUpdate(sqlse);
			} catch (Exception e) {
				System.out.println("Cannot update no.of.courses enrolled by a user");
			}
		}
		logger.info("Course Removed from Your Course List");
		if (row == 1 && row1 == 1)
			out = true;
		System.out.println(out);
		return out;
	}

	public EnrollmentInfo fetchEnrollment(int EnrollmentId) {
		String sql = "select *from enrollment_info where enrollment_id = " + EnrollmentId + "";
		EnrollmentInfo ei = new EnrollmentInfo();
		try (Connection con = TestConnection.getConnection(); Statement stmt = con.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				if (rs.next()) {
					int enrollmentId = rs.getInt("enrollment_id");
					int CourseId = rs.getInt("course_id");
					ei.setEnrollmentId(enrollmentId);
					ei.setCourseId(CourseId);
					ei.setEnrolledDate(rs.getDate("enrolled_date").toLocalDate());
					ei.setEndingDate(rs.getDate("ending_date").toLocalDate());
					ei.setStatus(EnrollmentStatusEnum.valueOf(rs.getString("status")));
				}
			}
		} catch (Exception e) {
			System.out.println("There is no such Enrollment");
		}
		return ei;
	}

}
