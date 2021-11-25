package com.firstproject.collection.service.impl;

import java.beans.JavaBean;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.firstproject.collection.dao.CourseDAO;
import com.firstproject.collection.entity.CourseDetails;
import com.firstproject.collection.models.Course;
import com.firstproject.collection.service.CourseService;

@Component
public class CourseServiceImpl implements CourseService {
	private static final Logger log = LoggerFactory.getLogger(CourseServiceImpl.class);

	@Autowired
	private CourseDAO courseDAO;

	@Override
	public CourseDetails getCourse(long courseId) {
		return courseDAO.getById(courseId);
	}

	@Override
	public List<CourseDetails> getCourses() {
		return courseDAO.findAll();
	}

	@Override
	public CourseDetails addCourse(CourseDetails newCourse) {
		courseDAO.save(newCourse);
		log.info("course added successfully");

		return newCourse;
	}

	@Override
	public CourseDetails updateCourse(CourseDetails updatedCourse) {
		courseDAO.save(updatedCourse);
		return updatedCourse;
	}

	@Override
	public void deleteCourse(long courseId) {
		CourseDetails entity = courseDAO.getById(courseId);
		courseDAO.delete(entity);
	}

}
