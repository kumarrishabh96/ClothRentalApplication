package com.ty.ClothRentalApplication_boot_repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.ClothRentalApplication_boot_dto.Dress;

public interface DressRepository extends JpaRepository<Dress, Integer> {

}
