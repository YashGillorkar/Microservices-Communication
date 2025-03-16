package com.yash.employee_service_using_webclient.exception;

import java.util.function.Supplier;

public class InvalidIdException extends RuntimeException {

	public InvalidIdException(String message) {
		super(message);
	}
}
