package com.ty.restapi.exception;

public class FindCustomerByIdNotFound extends RuntimeException {

	public FindCustomerByIdNotFound(String message) {
		super(message);
	}

}
