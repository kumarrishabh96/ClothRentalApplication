package com.ty.ClothRentalApplication_boot_exception;

public class UnableToUpdateCustomerException extends RuntimeException {

	private String message = "Unable to update Customer";

	public UnableToUpdateCustomerException(String message) {
		this.message = message;
	}

	public UnableToUpdateCustomerException() {
		super();
	}

	@Override
	public String getMessage() {
		return message;
	}
}
