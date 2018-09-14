package com.avsan.spring.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.avsan.spring.pojo.BunkDetailsPojo;
import com.avsan.spring.pojo.CategoriesTypePojo;
import com.avsan.spring.pojo.DriverDetailsPojo;
import com.avsan.spring.pojo.VehicleDetailsPojo;

import lombok.Data;


@Data
public class FuelDetailsBean {
	
	private int slno;
	@NotNull
	@Size(min=1)
	private String cardNumber;
	@NotNull
	@Size(min=1)
	private  String vehicleId;
	@NotNull
	@Size(min=1)
	private String driverId;
	@NotNull
	@Size(min=1)
	private String incharge;
	@NotNull
	@Size(min=1)
	private String oilFillingDateAndTime;
	@NotNull
	@Size(min=1)
	private String metreReading;
	@NotNull
	@Size(min=1)
	private String ltr;
	@NotNull
	@Size(min=1)
	private String rate;
	@NotNull
	//@Size(min=1)
	private int fuelType;
	@NotNull
	//@Size(min=1)
	private int bunkId;
	@NotNull
	@Size(min=1)
	private String billNumber;
	@NotNull
	@Size(min=1)
	private String verifiedBy;
}
