package com.ty.ClothRentalApplication_boot_dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Dress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private double priceMRP;
	private double rentPrice;
	private double depositPrice;
	private String brandName;
	private String dressSize;
	@ManyToOne
	@JoinColumn
	private Rent rent;
}
