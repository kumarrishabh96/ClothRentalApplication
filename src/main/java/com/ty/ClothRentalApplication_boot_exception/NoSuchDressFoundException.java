package com.ty.ClothRentalApplication_boot_exception;

public class NoSuchDressFoundException extends RuntimeException {

	private String message = "Unable To Find Dress";

	public NoSuchDressFoundException(String message) {
		this.message = message;
	}

	public NoSuchDressFoundException() {

	}

	@Override
	public String getMessage() {
		return message;
	}
}
