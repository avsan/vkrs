package com.avsan.spring.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class DriverDetailsBean {
	
	private String driveryLicanceNumber;
	
	private String driverName;
	
	private String address;
	
	private String contactNumber;

	private String alternateContactNumber;
		
	private String voterIdNumber;
	
	private String adharNumber;
	
	private String dlScanedCopy;
	
	private String voterScanedCopy;
	
	private String adharScanedCopy;
	
	private String driverPhotoCopy;
	
	private String yearsOfExperience;
	
	private String previouslyWorkedAt;
	
	private String description;
	
		
}
