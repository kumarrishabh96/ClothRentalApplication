package com.ty.ClothRentalApplication_boot_dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.ClothRentalApplication_boot_dto.Dress;
import com.ty.ClothRentalApplication_boot_repository.DressRepository;

@Repository
public class DressDao {

	@Autowired
	private DressRepository repository;

	public Dress saveDress(Dress dress) {
		return repository.save(dress);
	}

	public Optional<Dress> getDressById(int id) {
		return repository.findById(id);
	}

	public Dress updateDress(Dress dress) {
		return repository.save(dress);
	}

	public void deleteDress(Dress dress) {
		repository.delete(dress);
	}
}
