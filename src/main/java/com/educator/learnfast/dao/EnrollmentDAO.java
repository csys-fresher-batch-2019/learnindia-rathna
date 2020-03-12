package com.educator.learnfast.dao;

public interface EnrollmentDAO {

	boolean saveEnrollment(int userId, int courseId);

	boolean deleteEnrollment(int courseId, int userId);

	boolean saveEnrollmentRating(int courseId, int userId, int rating);
}
