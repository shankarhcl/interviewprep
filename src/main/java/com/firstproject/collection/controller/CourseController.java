package com.firstproject.collection.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.firstproject.collection.entity.CourseDetails;
import com.firstproject.collection.models.Course;
import com.firstproject.collection.service.CourseService;
import com.firstproject.collection.service.MyService;

@RestController
@RequestMapping("/${api.version}")
public class CourseController {

	@Autowired
	private CourseService courseService;

	private static final Logger log = LoggerFactory.getLogger(MyController.class);

	@RequestMapping(path = "/courses/{courseId}", method = RequestMethod.GET)
	public CourseDetails getCourse(@PathVariable String courseId) {
		log.info("courseId is {}:" + courseId);
		return this.courseService.getCourse(Long.parseLong(courseId));

	}

	@RequestMapping(value = "/courses")
	public List<CourseDetails> getCourses() {
		return this.courseService.getCourses();
	}

	@RequestMapping(path = "/courses", consumes = "application/json", method = RequestMethod.POST)
	public CourseDetails addCourse(@RequestBody CourseDetails newCourse) {
		log.info("newCourse is {}:" + newCourse);
		return this.courseService.addCourse(newCourse);
	}

	@RequestMapping(path = "/courses", consumes = "application/json", method = RequestMethod.PUT)
	public CourseDetails updateCourse(@RequestBody CourseDetails updatedCourse) {
		log.info("newCourse is {}:" + updatedCourse);
		return this.courseService.updateCourse(updatedCourse);
	}

	@RequestMapping(value = "/courses/{courseId}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		try {
			log.info("courseId is {}:" + courseId);
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
