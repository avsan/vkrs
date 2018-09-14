package com.avsan.spring.bean;

import org.springframework.stereotype.Service;

import lombok.Data;

@Data
public class InsuranceBean {
	private int ssno;
	
	private String insuranceId;
	
	private String insuranceCompany;
	
	private String validFrom;
	
	private String validTo;
	
	private String premiumPaid;
	
	private String renewalDate;
	
	private String certificateNumber;
	
	private String certificateType;
	
	
}
