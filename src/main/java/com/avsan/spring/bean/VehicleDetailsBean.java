package com.avsan.spring.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Service;

import lombok.Data;

@Data
public class VehicleDetailsBean {
	
	private int vehicleId;
	@NotNull
	@Size(min=1)
	private String vehiclePrNumber;
	@NotNull
	@Size(min=1)
	private String nameOfOwner;
	@NotNull
	@Size(min=1)
	private String chesisNumber;
	@NotNull
	@Size(min=1)
	private String engineNumber;

	private int cubicCapacity;

	private int fullWeightCapacity;

	private int unloadedWeight;

	private int oilTankCapacity;
	@NotNull
	@Size(min=1)
	private String vehicleColor;
	@NotNull
	@Size(min=1)
	private String dateOfRegistration;
	@NotNull
	@Size(min=1)
	private String registrationValidupto;
	private double payedTax;
	@NotNull
	@Size(min=1)
	private String companyWarrantyDetails ;
	@NotNull
	@Size(min=1)
	private String warrantyValidUpTo ;
	@NotNull
	@Size(min=1)
	private String description;
	
}
