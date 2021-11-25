package com.firstproject.collection.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude (JsonInclude.Include.NON_EMPTY)
public class ResponseDTO<T> {

	private Meta meta;
	private T data;
	private List<CustomErrors> errors;
}
