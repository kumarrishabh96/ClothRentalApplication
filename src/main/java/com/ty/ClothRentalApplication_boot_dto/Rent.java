package com.ty.ClothRentalApplication_boot_dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Rent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String rentDate;
	private double totalRentPrice;
	@ManyToOne
	@JoinColumn
	private Customer customer;
	@OneToMany(mappedBy = "rent")
	List<Dress> dresses;
}
