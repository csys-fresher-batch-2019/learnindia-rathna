package com.educator.learnfast.DAO.implementation;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.educator.learnfast.DAO.CoursesDAO;
import com.educator.learnfast.exception.DbException;
import com.educator.learnfast.exception.InfoMessages;
import com.educator.learnfast.mapper.ContentInfoRowMapper;
import com.educator.learnfast.mapper.CourseInfoRowMapper;
import com.educator.learnfast.models.ContentInfo;
import com.educator.learnfast.models.CourseInfo;
import com.educator.learnfast.util.ConnectionUtil;
import com.educator.learnfast.util.Logger;

public class CoursesDAOImplementation implements CoursesDAO {

	Logger logger = Logger.getInstance();
	DriverManagerDataSource dataSource = ConnectionUtil.getDataSource();
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	public boolean saveCourse(CourseInfo course) {
		String sql = "insert into course_info(course_id,course_name,duration_of_course,instructor_name,instructor_id,course_category,price) "
				+ "values(course_id_seq.nextval,?,?,?,?,?,?)";
		int row = jdbcTemplate.update(sql, course.getCourseName(), course.getDurationOfCourse(),
				course.getInstructorName(), course.getInstructorId(), course.getCourseCategory(), course.getPrice());
		if (row == 1)
			return true;
		else
			return false;
	}

	public boolean deleteCourse(int courseId) {
		String sql = "delete course_info where course_id = ?";
		int row = jdbcTemplate.update(sql, courseId);
		if (row == 1)
			return true;
		else
			return false;
	}

	public int getNoOfEnrollment(int courseId) {
		int count = 0;
		String sql = "select count(enrollment_id) from enrollment_info where status='ONGOING' and course_id=?";
		count = jdbcTemplate.queryForObject(sql, Integer.class, courseId);
		return count;
	}

	public ArrayList<CourseInfo> findCourses(CourseInfo course) {
		StringBuilder sb1 = new StringBuilder("select *from course_info ");
		if (course.getCourseName().length() != 0) {
			sb1.append("where course_name like '%" + course.getCourseName() + "%'");
			if (course.getInstructorName().length() != 0)
				sb1.append("and instructor_name like '%" + course.getInstructorName() + "%'");
			else if (course.getPrice() == 0)
				sb1.append("and price = 0");
		} else if (course.getCourseCategory().length() != 0)
			sb1.append("where course_category = '" + course.getCourseCategory() + "'");
		else if (course.getPrice() == 0)
			sb1.append("where price = 0");
		else if (course.getCourseCategory().length() != 0 && course.getInstructorName().length() != 0)
			sb1.append("where course_category = '" + course.getCourseCategory() + "' and instructor_name like '%"
					+ course.getInstructorName() + "%'");
		String sql = sb1.toString();
		ArrayList<CourseInfo> out = new ArrayList<CourseInfo>();
		CourseInfoRowMapper rowMapper = new CourseInfoRowMapper();
		out = (ArrayList<CourseInfo>) jdbcTemplate.query(sql, rowMapper);
		return out;
	}

	public boolean saveCourseRating(int rating, int courseId, int userId) {
		String sql = "update course_info set rating = (select avg(rating) from enrollment_info where course_id = ?) where course_id = ?";
		int row = jdbcTemplate.update(sql, courseId, courseId);
		if (row == 1)
			return true;
		else
			return false;
	}

	public ArrayList<ContentInfo> getCourseContent(int courseId) {
		String sql = "select course_content,chapter_no from content_info where course_id = ?";
		ArrayList<ContentInfo> list = new ArrayList<ContentInfo>();
		ContentInfoRowMapper rowMapper = new ContentInfoRowMapper();
		list = (ArrayList<ContentInfo>) jdbcTemplate.query(sql, rowMapper, courseId);
		return list;
	}

	public boolean saveCourseContent(ContentInfo ci) {
		String sql = "insert into content_info(course_id,course_content,chapter_no) values(?,?,?)";
		int row = jdbcTemplate.update(sql, ci.getCourseId(), ci.getCourseContent(), ci.getChapterNo());
		if (row == 1)
			return true;
		else
			return false;
	}

	public boolean deleteCourseContent(int courseId, int chapterNo) {
		String sql = "delete content_info where course_id = ? and chapter_no = ?";
		int row = jdbcTemplate.update(sql, courseId, chapterNo);
		if (row == 1)
			return true;
		else
			return false;
	}
}
