package com.firstproject.collection.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude (JsonInclude.Include.NON_EMPTY)
public class CustomErrors {
	private String field;
	private String description;
	private String code;

}
