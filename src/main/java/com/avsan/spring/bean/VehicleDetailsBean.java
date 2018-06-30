package com.avsan.spring.bean;

import java.util.Date;

import lombok.Data;

@Data
public class VehicleDetailsBean {
	
	private int vehicleId;

	private String vehiclePrNumber;
	
	private String nameOfOwner;

	private String chesisNumber;
	
	private String engineNumber;
	
	private int cubicCapacity;
	
	private int fullWeightCapacity;
	
	private int unloadedWeight;

	private int oilTankCapacity;

	private String vehicleColor;
	
	private String dateOfRegistration;
	
	private String registrationValidupto;
	
	private double payedTax;
	
	private String companyWarrantyDetails ;
	
	private String warrantyValidUpTo ;
	
	private double description;
	
}
