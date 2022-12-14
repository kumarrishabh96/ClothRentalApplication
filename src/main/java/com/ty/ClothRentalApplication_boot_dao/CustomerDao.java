package com.ty.ClothRentalApplication_boot_dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.ClothRentalApplication_boot_dto.Customer;
import com.ty.ClothRentalApplication_boot_repository.CustomerRepository;


@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepository repository;

	public Customer saveCustomer(Customer customer) {
		return repository.save(customer);
	}

	public Optional<Customer> getCustomerById(int id) {
		return repository.findById(id);
	}

	public Customer updateCustomer(Customer customer) {
		return repository.save(customer);
	}

	public void deleteCustomer(Customer customer) {
		repository.delete(customer);
	}
}
