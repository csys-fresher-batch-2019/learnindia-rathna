package com.educator.learnfast.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educator.learnfast.models.ContentInfo;

public class ContentInfoRowMapper implements RowMapper<ContentInfo> {

	public ContentInfo mapRow(ResultSet rs, int row) throws SQLException {
		ContentInfo ci = new ContentInfo();
		ci.setChapterNo(rs.getInt("chapter_no"));
		ci.setCourseContent(rs.getString("course_content"));
		return ci;
	}

}
