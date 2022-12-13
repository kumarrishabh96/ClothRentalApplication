package com.ty.ClothRentalApplication_boot_exception;

public class NoSuchCustomerFoundException extends RuntimeException {

	private String message = "Unable To Find Location";

	public NoSuchCustomerFoundException(String message) {
		this.message = message;
	}

	public NoSuchCustomerFoundException() {

	}

	@Override
	public String getMessage() {
		return message;
	}
}
