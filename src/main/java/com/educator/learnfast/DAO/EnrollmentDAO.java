package com.educator.learnfast.DAO;

import com.educator.learnfast.models.EnrollmentInfo;

public interface EnrollmentDAO {

	boolean saveEnrollment(int userId, int courseId);

	boolean removeEnrollment(int CourseId, int UserId);

	boolean saveEnrollmentRating(int courseId, int userId, int rating);
}
