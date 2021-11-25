package com.firstproject.collection.service;

import java.util.List;

import com.firstproject.collection.entity.CourseDetails;
import com.firstproject.collection.models.Course;

public interface CourseService {
	public CourseDetails getCourse(long courseId);

	public List<CourseDetails> getCourses();

	public CourseDetails addCourse(CourseDetails newCourse);

	public CourseDetails updateCourse(CourseDetails updatedCourse);

	public void deleteCourse(long courseId);

}
