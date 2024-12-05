package com.fundoouserservice.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fundoouserservice.exception.DuplicateEntryException;
import com.fundoouserservice.exception.UserNotFoundException;



@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{

	 private ResponseEntity<ErrorStructure<String>> errorResponse(HttpStatus status, String errorMessage, String rootCause) {
	        return ResponseEntity.status(status).body(ErrorStructure.<String>builder().status(status.value())
	                .message(errorMessage).rootCause(rootCause).build());
	    }

	    @ExceptionHandler(UserNotFoundException.class)
	    public ResponseEntity<ErrorStructure<String>> handleUserNotFound(UserNotFoundException ex) {
	        return errorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), "User is not registered");
	    }
	    
	    @ExceptionHandler
	    public ResponseEntity<ErrorStructure<String>> handleDuplicateEntry(DuplicateEntryException ex)
	    {
	    	return errorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), "Duplicate entry is detected please provide valid data");
	    }
	
}
