package com.firstproject.collection.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude (JsonInclude.Include.NON_EMPTY)
public class Meta implements Serializable{

private String code;
private String description;
private String status;
private String httpCode;

public Meta(String code, String description, String status, String httpCode) {
	super();
	this.code = code;
	this.description = description;
	this.status = status;
	this.httpCode = httpCode;
}

}

