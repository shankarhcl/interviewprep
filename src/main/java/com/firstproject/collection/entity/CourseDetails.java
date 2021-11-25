package com.firstproject.collection.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="COURSE")
public class CourseDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID",nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="TITLE")
	private String title;
	@Column(name="Description")
	private String description;

	public CourseDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseDetails(long id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "CourseDetails [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
}
