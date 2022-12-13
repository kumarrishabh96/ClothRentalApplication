package com.ty.ClothRentalApplication_boot_service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.ClothRentalApplication_boot_dao.CustomerDao;
import com.ty.ClothRentalApplication_boot_dto.Customer;
import com.ty.ClothRentalApplication_boot_exception.NoSuchCustomerFoundException;
import com.ty.ClothRentalApplication_boot_exception.UnableToDeleteCustomerException;
import com.ty.ClothRentalApplication_boot_exception.UnableToUpdateCustomerException;
import com.ty.ClothRentalApplication_boot_util.ResponseStructure;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer) {
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Customer detail saved Successfully");
		responseStructure.setData(customerDao.saveCustomer(customer));
		ResponseEntity<ResponseStructure<Customer>> responseEntity = new ResponseEntity<ResponseStructure<Customer>>(
				responseStructure, HttpStatus.CREATED);
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(Customer customer, int id) {
		Optional<Customer> customer2 = customerDao.getCustomerById(id);
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		ResponseEntity<ResponseStructure<Customer>> responseEntity = new ResponseEntity<ResponseStructure<Customer>>(
				responseStructure, HttpStatus.OK);
		if (customer2.isPresent()) {
			customer.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Customer Updated Successfully");
			responseStructure.setData(customerDao.updateCustomer(customer));
			return responseEntity;
		}
		throw new UnableToUpdateCustomerException("Unable to update Customer as no Customer found");

	}

	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(int id) {
		Optional<Customer> optional = customerDao.getCustomerById(id);
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		ResponseEntity<ResponseStructure<Customer>> responseEntity = new ResponseEntity<ResponseStructure<Customer>>(
				responseStructure, HttpStatus.OK);
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Customer Found");
			responseStructure.setData(customerDao.getCustomerById(id).get());
			return responseEntity;
		}
		throw new NoSuchCustomerFoundException("No Customer found for given id");
	}

	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(int id) {
		Optional<Customer> optional = customerDao.getCustomerById(id);
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		ResponseEntity<ResponseStructure<Customer>> responseEntity = new ResponseEntity<ResponseStructure<Customer>>(
				responseStructure, HttpStatus.OK);
		if (optional.isPresent()) {
			customerDao.deleteCustomer(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Customer Deleted as per Given Id");
			responseStructure.setData(optional.get());
			return responseEntity;
		}
		throw new UnableToDeleteCustomerException("No Customer found to delete for given id");
	}
}
