package com.firstproject.collection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.firstproject.collection.exception.ResourceNotFoundException;
import com.firstproject.collection.models.Course;
import com.firstproject.collection.models.ErrorMessage;
import com.firstproject.collection.service.MyService;

@RestControllerAdvice
@RequestMapping("/${api.version}")
public class ExchandlerControllerAdviceController {
	@Autowired
	private MyService myService;
	
	@ExceptionHandler(value = {ResourceNotFoundException.class})
	  @ResponseStatus(value = HttpStatus.NOT_FOUND)
	@RequestMapping(value="/resources/{courseId}",method = RequestMethod.GET)
	public Course getCourse(@PathVariable String courseId) {
		return this.myService.getCourse(Long.parseLong(courseId));
	}
	}

