package com.ty.ClothRentalApplication_boot_service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.ClothRentalApplication_boot_dao.DressDao;
import com.ty.ClothRentalApplication_boot_dto.Dress;
import com.ty.ClothRentalApplication_boot_exception.NoSuchDressFoundException;
import com.ty.ClothRentalApplication_boot_exception.UnableToDeleteDressException;
import com.ty.ClothRentalApplication_boot_exception.UnableToUpdateDressException;
import com.ty.ClothRentalApplication_boot_util.ResponseStructure;

@Service
public class DressService {

	@Autowired
	private DressDao dressDao;
	
	public ResponseEntity<ResponseStructure<Dress>> saveDress(Dress dress) {
		ResponseStructure<Dress> responseStructure = new ResponseStructure<Dress>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Dress detail saved Successfully");
		responseStructure.setData(dressDao.saveDress(dress));
		ResponseEntity<ResponseStructure<Dress>> responseEntity = new ResponseEntity<ResponseStructure<Dress>>(
				responseStructure, HttpStatus.CREATED);
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Dress>> updateDress(Dress dress, int id) {
		Optional<Dress> dress2 = dressDao.getDressById(id);
		ResponseStructure<Dress> responseStructure = new ResponseStructure<Dress>();
		ResponseEntity<ResponseStructure<Dress>> responseEntity = new ResponseEntity<ResponseStructure<Dress>>(
				responseStructure, HttpStatus.OK);
		if (dress2.isPresent()) {
			dress.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Dress Updated Successfully");
			responseStructure.setData(dressDao.updateDress(dress));
			return responseEntity;
		}
		throw new UnableToUpdateDressException("Unable to update Dress as no Dress found");

	}

	public ResponseEntity<ResponseStructure<Dress>> getDressById(int id) {
		Optional<Dress> optional = dressDao.getDressById(id);
		ResponseStructure<Dress> responseStructure = new ResponseStructure<Dress>();
		ResponseEntity<ResponseStructure<Dress>> responseEntity = new ResponseEntity<ResponseStructure<Dress>>(
				responseStructure, HttpStatus.OK);
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Dress Found");
			responseStructure.setData(dressDao.getDressById(id).get());
			return responseEntity;
		}
		throw new NoSuchDressFoundException("No Dress found for given id");
	}

	public ResponseEntity<ResponseStructure<Dress>> deleteDress(int id) {
		Optional<Dress> optional = dressDao.getDressById(id);
		ResponseStructure<Dress> responseStructure = new ResponseStructure<Dress>();
		ResponseEntity<ResponseStructure<Dress>> responseEntity = new ResponseEntity<ResponseStructure<Dress>>(
				responseStructure, HttpStatus.OK);
		if (optional.isPresent()) {
			dressDao.deleteDress(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Dress Deleted as per given id");
			responseStructure.setData(optional.get());
			return responseEntity;
		}
		throw new UnableToDeleteDressException("No Dress found to delete for given id");
	}
}
