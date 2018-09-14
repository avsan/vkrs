package com.avsan.spring.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class VehicleAuditBean {
	
	private int vehicleId;
	@NotNull
	@Size(min=1)
	private String vehiclePrNumber;
	@NotNull
	@Size(min=1)
	private String nameOfOwner;
	@NotNull
	@Size(min=1)
	private String registratioNo;
	@NotNull
	@Size(min=1)
	private String dateOfPurchase;
	@NotNull
	//@Size()
	private int totalCostOfVehicle;
	@NotNull
	@Size(min=1)
	private int downPayment;
	@NotNull
	@Size(min=1)
	private int totalLoan;
	@NotNull
	@Size(min=1)
	private int emiAmount;
	@NotNull
	@Size(min=1)
	private String loanFinancedBy;
	@NotNull
	@Size(min=1)
	private String contactPersonName;
	@NotNull
	@Size(min=1)
	private String contactNo;
	@NotNull
	//@Size(min=10)
	private int noOfEmi;
	@NotNull
	@Size(min=1)
	private String emiDate ;
}
