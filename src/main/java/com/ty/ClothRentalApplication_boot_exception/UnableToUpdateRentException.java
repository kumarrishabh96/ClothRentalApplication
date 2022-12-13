package com.ty.ClothRentalApplication_boot_exception;

public class UnableToUpdateRentException extends RuntimeException {

	private String message = "Unable to update Rent";

	public UnableToUpdateRentException(String message) {
		this.message = message;
	}

	public UnableToUpdateRentException() {
		super();
	}

	@Override
	public String getMessage() {
		return message;
	}
}
