package com.ty.ClothRentalApplication_boot_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.ClothRentalApplication_boot_dto.Customer;
import com.ty.ClothRentalApplication_boot_service.CustomerService;
import com.ty.ClothRentalApplication_boot_util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@ApiOperation(value = "Save Customer", notes = "It is used to save Customer")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal server Error"),
			@ApiResponse(code = 404, message = "Not found"), @ApiResponse(code = 200, message = "ok") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	@ApiOperation(value = "Get Customer", notes = "Get Customer by id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "Not found"), @ApiResponse(code = 200, message = "Ok") })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(@RequestParam int id) {
		return customerService.getCustomerById(id);
	}

	@ApiOperation(value = "Update Customer", notes = "Customer to update Customer")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "Not found") })
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE })
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestBody Customer customer,
			@RequestParam int id) {
		return customerService.updateCustomer(customer, id);
	}

	@ApiOperation(value = "Delete Customer", notes = "Use to delete Customer By given Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 404, message = "Not found"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(@RequestParam int id) {
		return customerService.deleteCustomer(id);
	}
}
