package com.firstproject.collection;

import java.security.PublicKey;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import com.firstproject.collection.dao.CourseDAO;
import com.firstproject.collection.entity.CourseDetails;
import com.firstproject.collection.service.CourseService;
import com.firstproject.collection.service.impl.CourseServiceImpl;

import lombok.Value;

@SpringBootApplication
@ComponentScan({ "com.firstproject.collection" })
@EntityScan("com.firstproject.collection")
public class InterviewPrepApplication {

	public static void main(String[] args) {

		SpringApplication.run(InterviewPrepApplication.class, args);

	}

}
