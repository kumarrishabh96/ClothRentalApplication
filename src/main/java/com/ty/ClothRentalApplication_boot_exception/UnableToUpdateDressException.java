package com.ty.ClothRentalApplication_boot_exception;

public class UnableToUpdateDressException extends RuntimeException {

	private String message = "Unable to update dress";

	public UnableToUpdateDressException(String message) {
		this.message = message;
	}

	public UnableToUpdateDressException() {
		super();
	}

	@Override
	public String getMessage() {
		return message;
	}
}
