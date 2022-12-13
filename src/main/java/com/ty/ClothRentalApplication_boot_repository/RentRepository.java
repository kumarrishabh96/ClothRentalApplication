package com.ty.ClothRentalApplication_boot_repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.ClothRentalApplication_boot_dto.Rent;

public interface RentRepository extends JpaRepository<Rent, Integer>{

}
