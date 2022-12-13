package com.ty.ClothRentalApplication_boot_exception;

public class UnableToDeleteRentException extends RuntimeException {

	private String message ="No rent found to delete";

	public UnableToDeleteRentException(String message) {
		
		this.message = message;
	}
	
	public UnableToDeleteRentException() {
	
	}

	@Override
	public String getMessage() {
		return message;
	}
}
