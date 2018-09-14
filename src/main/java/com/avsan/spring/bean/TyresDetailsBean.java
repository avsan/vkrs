package com.avsan.spring.bean;

import lombok.Data;

@Data
public class TyresDetailsBean {
	
	private int tyreId;
	private String tyreModel;
	private String tyreCompany;
	private String tyresPurchasedFrom;
	private String purchaseDate;
	private String odometerReadingAtTyreChange;
	private String costPerTyre;
	private String noOfTyresChanged;
	private String purchaseBillNo;
	private String housingType;
	private String description;
	
}
