package com.ty.ClothRentalApplication_boot_dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.ClothRentalApplication_boot_dto.Rent;
import com.ty.ClothRentalApplication_boot_repository.RentRepository;

@Repository
public class RentDao {

	@Autowired
	private RentRepository repository;

	public Rent saveRent(Rent rent) {
		return repository.save(rent);
	}

	public Optional<Rent> getRentById(int id) {
		return repository.findById(id);
	}

	public Rent updateRent(Rent rent) {
		return repository.save(rent);
	}

	public void deleteRent(Rent rent) {
		repository.delete(rent);
	}
}
