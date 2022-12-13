package com.ty.ClothRentalApplication_boot_exception;

public class NoSuchRentFoundException extends RuntimeException {

	private String message = "Unable To Find Rent";

	public NoSuchRentFoundException(String message) {
		this.message = message;
	}

	public NoSuchRentFoundException() {

	}

	@Override
	public String getMessage() {
		return message;
	}
}
