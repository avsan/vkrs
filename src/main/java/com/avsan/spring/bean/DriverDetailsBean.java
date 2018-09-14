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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class DriverDetailsBean {
	
	private int driverId;
	@NotNull
	@Size(min=1)
	private String driveryLicanceNumber;
	@NotNull
	@Size(min=1)
	private String driverName;
	@NotNull
	@Size(min=1)
	private String address;
	@NotNull
	@Size(min=1)
	private String contactNumber;
	@NotNull
	@Size(min=1)
	private String alternateContactNumber;
	@NotNull
	@Size(min=1)
	private String voterIdNumber;
	@NotNull
	@Size(min=1)
	private String adharNumber;
	@NotNull
	@Size(min=1)
	private String dlScanedCopy;
	@NotNull
	@Size(min=1)
	private String voterScanedCopy;
	@NotNull
	@Size(min=1)
	private String adharScanedCopy;
	@NotNull
	@Size(min=1)
	private String driverPhotoCopy;
	@NotNull
	@Size(min=1)
	private String yearsOfExperience;
	@NotNull
	@Size(min=1)
	private String previouslyWorkedAt;
	@NotNull
	@Size(min=1)
	private String description;
	
		
}
