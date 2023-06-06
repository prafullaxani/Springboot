package com.ty.restapi.exception;

import org.springframework.data.jpa.repository.Query;

public class CustomerIdNotFoundException extends RuntimeException {

	
	public CustomerIdNotFoundException(String message)
	{
		super(message);
	}
}
