package com.ty.ClothRentalApplication_boot_repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.ClothRentalApplication_boot_dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
