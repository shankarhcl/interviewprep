package com.firstproject.collection.controller;

import java.util.List;
import java.util.Optional;

import javax.print.CancelablePrintJob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.RequestHeaderMapMethodArgumentResolver;

import com.firstproject.collection.models.Course;
import com.firstproject.collection.service.MyService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/${api.version}/interviewprep")
public class MyController {
	/*
	 * we are requesting Spring to create object of impl class of MyService
	 * Interface with the help of Autowired. Spring will auto inject the object by
	 * the rule of dependency injection.
	 */
	@Autowired
	private MyService myService;

	private static final Logger log = LoggerFactory.getLogger(MyController.class);

	@GetMapping("/home")
	public String home() {
		return "Welcome to course Application";
	}

    //Get the courses
	@RequestMapping(value="/courses")
	public List<Course> getCourses() {
		return this.myService.getCourses();
	}

   //Get one course
	@RequestMapping(path="/courses/{courseId}",method = RequestMethod.GET)
	public Course getCourse(@PathVariable String courseId) {
		log.info("courseId is {}:"+courseId);
		return this.myService.getCourse(Long.parseLong(courseId));
	}
	
	   //Get one course based on two path variables proves that we can't change order for Path variables
		@RequestMapping(path="/courses/{courseId}/{title}",method = RequestMethod.GET)
		public Course getCourseByIdAndTitle(@PathVariable String courseId, @PathVariable String title) {
			return this.myService.getCourseByIdAndTitle(Long.parseLong(courseId), title);
		}
		
	//Post a course with duplicacy and destroyed when we stop application. consumes is optional
	//consumes work for POST and PUT ie if we have body in a format.
	@RequestMapping(path="/courses",consumes = "application/json",method = RequestMethod.POST)
	public Course addCourse(@RequestBody Course newCourse) {
		log.info("newCourse is {}:"+newCourse);
		return this.myService.addCourse(newCourse);		
	}
	
	    //Update a course
		@RequestMapping(path="/courses",consumes = "application/json",method = RequestMethod.PUT)
		public Course updateCourse(@RequestBody Course updatedCourse) {
			log.info("newCourse is {}:"+updatedCourse);
			return this.myService.updateCourse(updatedCourse);		
		}

		/*
		 * delete a course can't put consumes="application/json" otherwiese RE:
		 * unsupported media type
		 */	
		@RequestMapping(value="/courses/{courseId}",method = RequestMethod.DELETE)
			public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		try {
			log.info("courseId is {}:"+courseId);
			this.myService.deleteCourse(Long.parseLong(courseId));	
			return new ResponseEntity<> (HttpStatus.OK);
			
		} catch (Exception e) {
			//if we pass letters as courseId then exception will occur while parsing
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	//Query params
	@RequestMapping(path="/mycourses",method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE},name="",headers = "",params = "")
	//order doesn't matter for Request params
	public Course getCourseByParam(@RequestParam("id") String id, @RequestParam("title") String title, @RequestHeader(value="token") String valOfToken, 
			@CookieValue(value="JSESSIONID") String cookie) {	
		return myService.getCourseByParam(Long.parseLong(id),title);
	}
	
	//headers--hardcoded but have to pass same from postman
	//params = {"id","title"} doesnt making any impact
	//name doesn't making any impact
		@RequestMapping(value="/mapcourses",name="myMappings",headers = { "key1=val1", "key2=val2" }, params = {"id","title"})
		public Course getCourseMap(@RequestParam("id") String id, @RequestParam("title") String title) {	
			return myService.getCourseByParam(Long.parseLong(id),title);
		}
	
		//path variable with optional since spring 4.1 but not in our project
		@GetMapping("/user/{id}/{name}")
		public String getUserByIdAndName(
		          @PathVariable Optional<String> id,
		          @PathVariable String name
		          ) 
		{
		      if (id.isPresent()) {
		               return "ID: " + id.get();
		      } else {
		              return "ID not present";
		      }
		}

	//multipart
	@RequestMapping(path="/partcourses",method = RequestMethod.GET)
	public List<Course> getCourseByReqPart(@RequestPart("name") String name) {	
		return myService.getCourses();
	}
	
        //multipart requires @modelAttribute otherwiese RE unsupported media type
		@RequestMapping(path="/partcourses",consumes = { MediaType.MULTIPART_FORM_DATA_VALUE },method = RequestMethod.POST)
		public Course addCoursePart(@ModelAttribute Course newCourse) {
			return this.myService.addCourse(newCourse);		
		}
}
