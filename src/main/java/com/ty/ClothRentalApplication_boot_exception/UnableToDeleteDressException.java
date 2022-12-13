package com.ty.ClothRentalApplication_boot_exception;

public class UnableToDeleteDressException extends RuntimeException {

	private String message = "No dress found to delete";

	public UnableToDeleteDressException(String message) {

		this.message = message;
	}

	public UnableToDeleteDressException() {

	}

	@Override
	public String getMessage() {
		return message;
	}
}
