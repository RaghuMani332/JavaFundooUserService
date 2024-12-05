package com.fundoouserservice.util;

import lombok.Data;

@Data
public class ResponceStructure<T> {

	private int status;
	private T data;
	private String message;
}
