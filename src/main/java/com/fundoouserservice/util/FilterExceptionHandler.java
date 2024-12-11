package com.fundoouserservice.util;

import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletResponse;

public class FilterExceptionHandler {

	
	public static void handleJwtExpire(HttpServletResponse response, int status, String message,String rootCause) throws StreamWriteException, DatabindException, IOException
	{
		response.setStatus(status);
		ErrorStructure<String > error = new ErrorStructure<>(status,message,rootCause);
		error.setMessage(message);
		error.setRootCause(rootCause);
		error.setStatus(status);
		
		ObjectMapper mapper =new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), error);
	
	
	}
	
}
