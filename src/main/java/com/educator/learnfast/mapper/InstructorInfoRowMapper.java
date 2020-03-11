package com.educator.learnfast.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educator.learnfast.models.InstructorInfo;

public class InstructorInfoRowMapper implements RowMapper<InstructorInfo> {

	public InstructorInfo mapRow(ResultSet rs, int row) throws SQLException {
		InstructorInfo insInfo = new InstructorInfo();
		insInfo.setInstructorId(rs.getInt("instructor_id"));
		insInfo.setInstructorName(rs.getString("instructor_name"));
		insInfo.setInstructorEmail(rs.getString("instructor_email"));
		insInfo.setInstructorPassword(rs.getString("instructor_password"));
		insInfo.setAreaOfInterest(rs.getString("area_of_interest"));
		return insInfo;
	}

}
