package com.ty.ClothRentalApplication_boot_exception;

public class UnableToDeleteCustomerException extends RuntimeException {

	private String message ="No customer found to delete";

	public UnableToDeleteCustomerException(String message) {
		
		this.message = message;
	}
	
	public UnableToDeleteCustomerException() {
	
	}

	@Override
	public String getMessage() {
		return message;
	}
}
