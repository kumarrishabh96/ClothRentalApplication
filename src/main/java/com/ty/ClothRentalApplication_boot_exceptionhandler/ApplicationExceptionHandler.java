package com.ty.ClothRentalApplication_boot_exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.ClothRentalApplication_boot_exception.NoSuchCustomerFoundException;
import com.ty.ClothRentalApplication_boot_exception.NoSuchDressFoundException;
import com.ty.ClothRentalApplication_boot_exception.NoSuchIdFoundException;
import com.ty.ClothRentalApplication_boot_exception.UnableToDeleteCustomerException;
import com.ty.ClothRentalApplication_boot_exception.UnableToDeleteDressException;
import com.ty.ClothRentalApplication_boot_exception.UnableToUpdateCustomerException;
import com.ty.ClothRentalApplication_boot_exception.UnableToUpdateDressException;
import com.ty.ClothRentalApplication_boot_util.ResponseStructure;
@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoSuchIdFoundException.class)
	public ResponseEntity<ResponseStructure<?>> noSuchIdFoundException(NoSuchIdFoundException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No such id found");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<?>>(responseStructure, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(NoSuchDressFoundException.class)
	public ResponseEntity<ResponseStructure<?>> noSuchDressFoundException(NoSuchDressFoundException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No such dress found");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<?>>(responseStructure, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(NoSuchCustomerFoundException.class)
	public ResponseEntity<ResponseStructure<?>> noSuchCustomerFoundException(NoSuchCustomerFoundException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No such customer found");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<?>>(responseStructure, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(UnableToUpdateCustomerException.class)
	public ResponseEntity<ResponseStructure<?>> unableToUpdateCustomerException(UnableToUpdateCustomerException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Unable to update customer");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<?>>(responseStructure, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(UnableToUpdateDressException.class)
	public ResponseEntity<ResponseStructure<?>> unableToUpdateDressException(UnableToUpdateDressException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Unable to update dress");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<?>>(responseStructure, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(UnableToDeleteCustomerException.class)
	public ResponseEntity<ResponseStructure<?>> unableToDeleteCustomerException(UnableToDeleteCustomerException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Unable to delete customer");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<?>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UnableToDeleteDressException.class)
	public ResponseEntity<ResponseStructure<?>> unableToDeleteDressException(UnableToDeleteDressException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Unable to delete dress");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<?>>(responseStructure, HttpStatus.NOT_FOUND);
	}

}
