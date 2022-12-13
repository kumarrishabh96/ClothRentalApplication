package com.ty.ClothRentalApplication_boot_service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.ClothRentalApplication_boot_dao.RentDao;
import com.ty.ClothRentalApplication_boot_dto.Rent;
import com.ty.ClothRentalApplication_boot_exception.NoSuchRentFoundException;
import com.ty.ClothRentalApplication_boot_exception.UnableToDeleteRentException;
import com.ty.ClothRentalApplication_boot_exception.UnableToUpdateRentException;
import com.ty.ClothRentalApplication_boot_util.ResponseStructure;

@Service
public class RentService {

	@Autowired
	private RentDao rentDao;
	
	public ResponseEntity<ResponseStructure<Rent>> saveRent(Rent rent) {
		ResponseStructure<Rent> responseStructure = new ResponseStructure<Rent>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Rent detail saved Successfully");
		responseStructure.setData(rentDao.saveRent(rent));
		ResponseEntity<ResponseStructure<Rent>> responseEntity = new ResponseEntity<ResponseStructure<Rent>>(
				responseStructure, HttpStatus.CREATED);
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Rent>> updateRent(Rent rent, int id) {
		Optional<Rent> rent2 = rentDao.getRentById(id);
		ResponseStructure<Rent> responseStructure = new ResponseStructure<Rent>();
		ResponseEntity<ResponseStructure<Rent>> responseEntity = new ResponseEntity<ResponseStructure<Rent>>(
				responseStructure, HttpStatus.OK);
		if (rent2.isPresent()) {
			rent.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Rent Updated Successfully");
			responseStructure.setData(rentDao.updateRent(rent));
			return responseEntity;
		}
		throw new UnableToUpdateRentException("Unable to update Rent as no Rent found");

	}

	public ResponseEntity<ResponseStructure<Rent>> getRentById(int id) {
		Optional<Rent> optional = rentDao.getRentById(id);
		ResponseStructure<Rent> responseStructure = new ResponseStructure<Rent>();
		ResponseEntity<ResponseStructure<Rent>> responseEntity = new ResponseEntity<ResponseStructure<Rent>>(
				responseStructure, HttpStatus.OK);
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Rent Found");
			responseStructure.setData(rentDao.getRentById(id).get());
			return responseEntity;
		}
		throw new NoSuchRentFoundException("No Rent found for given id");
	}

	public ResponseEntity<ResponseStructure<Rent>> deleteRent(int id) {
		Optional<Rent> optional = rentDao.getRentById(id);
		ResponseStructure<Rent> responseStructure = new ResponseStructure<Rent>();
		ResponseEntity<ResponseStructure<Rent>> responseEntity = new ResponseEntity<ResponseStructure<Rent>>(
				responseStructure, HttpStatus.OK);
		if (optional.isPresent()) {
			rentDao.deleteRent(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Rent Deleted as per Given Id");
			responseStructure.setData(optional.get());
			return responseEntity;
		}
		throw new UnableToDeleteRentException("No Rent found to delete for given id");
	}
}
