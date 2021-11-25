package com.firstproject.collection.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.firstproject.collection.entity.CourseDetails;

//Course is entity with which we will perform operations and Long is type of PK
//JpaRepository is interface
public interface CourseDAO extends JpaRepository<CourseDetails, Long> {

}
