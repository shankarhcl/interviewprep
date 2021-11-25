package com.firstproject.collection.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.firstproject.collection.models.Course;

public interface MyService {

	public List<Course> getCourses();
	public Course getCourse(long courseId);
	public Course addCourse(Course newCourse);
	public Course updateCourse(Course updatedCourse);
	public void deleteCourse(long courseId);
	public Course getCourseByParam(long id,String title);
	public Course getCourseByIdAndTitle(long id,String title);

}
