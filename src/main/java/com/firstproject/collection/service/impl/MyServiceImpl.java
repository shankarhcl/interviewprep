package com.firstproject.collection.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.firstproject.collection.controller.MyController;
import com.firstproject.collection.models.Course;
import com.firstproject.collection.service.MyService;

@Service
public class MyServiceImpl implements MyService{
	private static final Logger log = LoggerFactory.getLogger(MyServiceImpl.class);

	List<Course> list;
	
	public MyServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(1,"java core course", "basics of java"));
		list.add(new Course(2,"Spring boot course", "basics of spring boot"));
	}

	@Override
	public List<Course> getCourses() {
		
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		Course c= null;
		for(Course course :list) {
			if(course.getId() == courseId) {
				c=course;
				break;
			}
		}
		
		return c;
	}

	@Override
	public Course addCourse(Course newCourse) {
		list.add(newCourse);
		log.info("course added successfully");
		return newCourse;
	}

	//using lambda expression and forEach()
	@Override
	public Course updateCourse(Course updatedCourse) {
		list.forEach(e -> {
			if(e.getId() == updatedCourse.getId()) {
				updatedCourse.setTitle("updated course");
				//break can't be used outside of loop or switch;
			}
		});
		return updatedCourse;
			
			 
		}

	@Override
	public void deleteCourse(long courseId) {
		//course with given id wont show when we Get list again.
		list = this.list.stream().filter(e-> e.getId() != courseId).collect(Collectors.toList());
		
		//second way
		/*
		 * for(Course course :list) { if(course.getId() == courseId) {
		 * list.remove(course); break; } }
		 */	
	}

	@Override
	public Course getCourseByParam(long id, String title) {
		Course c= null;
		for(Course course :list) {
			if(course.getId() == id) {
				c=course;
				break;
			}
		}
		
		return c;
	}

	@Override
	public Course getCourseByIdAndTitle(long id, String title) {
		Course c= null;
		for(Course course :list) {
			if(course.getId() == id) {
				c=course;
				break;
			}
		}
		
		return c;
	}
	}
