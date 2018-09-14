package com.avsan.spring.bean;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class VehicleIInfoBean extends VehicleDetailsBean {
	private int ssno;
	
	private String insuranceId;
	
	private String insuranceCompany;
	
	private String validFrom;
	
	private String validTo;
	
	private String premiumPaid;
	
	private String renewalDate;
	
	private String certificateNumber;
	
	private String certificateType;
	
	
	@NotNull
	@Size(min=1)
	private String dateOfPurchase;
	@NotNull
	@Size(min=1)
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
	@Size(min=1)
	private int noOfEmi;
	@NotNull
	@Size(min=1)
	private String emiDate ;
	

}
